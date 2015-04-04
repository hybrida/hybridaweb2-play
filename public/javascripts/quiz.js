(function () {
    var app = angular.module('quiz', []);
    var apiBaseUrl = '/api/quiz/';
    var assetsBaseUrl = '/assets/html/quiz/';

    app.controller('tabController', function() {
        this.currentTab = 'hybQuizSeason';

        this.setCurrentTab = function (tabName) {
            this.currentTab = tabName;
        };
    });

    app.directive('hybQuizViewer', function () {
        return {
            restrict: 'E',
            templateUrl: assetsBaseUrl + 'quiz.html'
        };
    });

    app.directive('hybQuizSeason', function () {
        return {
            restrict: 'E',
            templateUrl: assetsBaseUrl + 'quiz-season.html',
            controller: function () {
                this.seasons = [
                    {season: 1, description: "It begins."},
                    {season: 2, description: "It CONTINUES!"}
                ];

                var latestSeason = function (seasons) {
                    if (seasons.length == 0)
                        return null;
                    var latestSeason = seasons[0];
                    angular.forEach(seasons, function (s, key) {
                        if (s.season > latestSeason.season)
                            latestSeason = s;
                        console.log(s);
                    });
                    return latestSeason;
                };

                this.currentSeason = latestSeason(this.seasons);

                this.formatSeason = function (season) {
                    return season.description;
                };


            },
            controllerAs: 'seasonCtrl'
        };
    });


    app.directive('hybQuizTeams', function () {
        return {
            restrict: 'E',
            templateUrl: assetsBaseUrl + 'quiz-teams.html',
            controller: function($http){
                var teams = this;
                teams.saved = [];
                teams.temporary = [];

                $http.get(apiBaseUrl + 'teams')
                    .success(function (data) {
                        teams.saved = data;
                    });

                teams.putTeam = function (team) {
                    $http.put(apiBaseUrl + 'team', team)
                        .success(function (data) {
                            var persistentTeam = data;
                            deleteElement(teams.temporary, team);
                            teams.saved.push(persistentTeam);
                            //console.log(res);
                        });
                };

                teams.modifyTeam = function (team) {
                    var index = teams.saved.indexOf(team);
                    if (index > -1) {
                        teams.saved.splice(index, 1);
                        teams.temporary.unshift(team);
                        return true;
                    } else {
                        return false;
                    }
                };

                teams.deleteTeamById = function(team) {
                    $http.delete(apiBaseUrl + 'team/' + team.id)
                        .then(function (res) {
                            //console.log(res);
                            if (res.status == 200) {
                                deleteElement(teams.saved, team);
                            }
                        });
                };

                teams.createNewTeam = function () {
                    teams.temporary.push({});
                };

                teams.deleteNewTeam = function(team) {
                    deleteElement(teams.temporary, team);
                };

                teams.debug = function () {
                    console.log("Saved teams:")
                    console.log(teams.saved);
                    console.log("Temporary teams:")
                    console.log(teams.temporary);
                }
            },
            controllerAs: 'teams'
        };
    });

    app.controller('ScoreboardController', function () {
        var quizes = [
            {
                timeStamp: 1288323623006
                , quizMaster: "SuperTeam"
                , scores: [
                {name: "SuperTeam", score: 13},
                {name: "HorribleTeam", score: 3}
            ]
            },
            {
                timeStamp: 1288324623006
                , quizMaster: "HorribleTeam"
                , scores: [
                {name: "SuperTeam", score: 2},
                {name: "HorribleTeam", score: 4}
            ]
            }
        ];

        this.teamScores = {};
        var that = this;

        var updateTeamScores = function() {
            angular.forEach(quizes, function (quiz, quizIndex) {
                angular.forEach(quiz.scores, function (quizTeamScore, teamIndex) {
                    teamName = quizTeamScore.name;
                    oldScore = that.teamScores[teamName] || 0;
                    that.teamScores[teamName] = oldScore + quizTeamScore.score;
                });
            });
            //console.log(that.teamScores);
        };

        updateTeamScores();
    });

    var moveElement = function(source, target, element) {
        var index = source.indexOf(element);
        if (index > -1) {
            source.splice(index, 1);
            target.push(element);
            return true;
        } else {
            return false;
        }
    };

    var deleteElement = function(list, element) {
        return moveElement(list, [], element);
    }
})();