(function () {
    var app = angular.module('quiz', []);
    var apiBaseUrl = '/api/quiz/';
    var assetsBaseUrl = '/assets/html/quiz/';

    app.factory('Data', function () {
        return {
            savedSeasons: [],
            savedTeams: [],
            message: "Hello"
        };
    });

    app.controller('tabController', function() {
        this.currentTab = 'hybQuizOverview';

        this.setCurrentTab = function (tabName) {
            this.currentTab = tabName;
        };
    });

    app.directive('hybQuizOverview', function () {
        return {
            restrict: 'E',
            templateUrl: assetsBaseUrl + 'quiz-overview.html',
            controller: function (Data, $http) {
                var that = this;
                that.seasons = [];

                $http.get(apiBaseUrl + 'seasons')
                    .success(function (data) {
                        that.seasons = data;
                    });

            },
            controllerAs: 'overviewCtrl'

        };
    });

    app.directive('hybQuizSeason', function () {
        return {
            restrict: 'E',
            templateUrl: assetsBaseUrl + 'quiz-season.html',
            controller: function($http, Data){
                var seasons = this;
                //this.sharedData = Data;
                seasons.saved = [];
                seasons.temporary = [];

                $http.get(apiBaseUrl + 'seasons')
                    .success(function (data) {
                        seasons.saved = data;
                    });

                seasons.putSeason = function (season) {
                    $http.put(apiBaseUrl + 'season', season)
                        .success(function (data) {
                            var persistentTeam = data;
                            deleteElement(seasons.temporary, season);
                            seasons.saved.push(persistentTeam);
                            //console.log(res);
                        });
                };

                seasons.modifySeason = function (season) {
                    var index = seasons.saved.indexOf(season);
                    if (index > -1) {
                        seasons.saved.splice(index, 1);
                        seasons.temporary.unshift(season);
                        return true;
                    } else {
                        return false;
                    }
                };

                seasons.deleteSeasonById = function(season) {
                    $http.delete(apiBaseUrl + 'season/' + season.id)
                        .then(function (res) {
                            //console.log(res);
                            if (res.status == 200) {
                                deleteElement(seasons.saved, season);
                            }
                        });
                };

                seasons.createNewSeason = function () {
                    seasons.temporary.push({});
                };

                seasons.deleteNewSeason = function(season) {
                    deleteElement(seasons.temporary, season);
                };

                seasons.debug = function () {
                    console.log("Saved seasons:")
                    console.log(seasons.saved);
                    console.log("Temporary seasons:")
                    console.log(seasons.temporary);
                }
            },
            controllerAs: 'seasonCtrl'
        };
    });

    app.directive('hybQuizViewer', function () {
        return {
            restrict: 'E',
            templateUrl: assetsBaseUrl + 'quiz.html'
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