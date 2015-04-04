(function () {
    var app = angular.module('quiz', []);

    app.controller('tabController', function() {
        this.currentTab = 'quizTeams';

        this.setCurrentTab = function (tabName) {
            this.currentTab = tabName;
        }
    });

    app.directive('quizTeams', function () {
        return {
            restrict: 'E',
            templateUrl: '/assets/html/quiz/quiz-teams.html',
            controller: function($http){
                var teams = this;
                teams.saved = [];
                teams.temporary = [];

                $http.get('/api/quizTeams')
                    .then(function (res) {
                        teams.saved = res.data;
                    });

                teams.saveTeam = function (team) {
                    $http.post('/api/quizTeam', team)
                        .then(function (res) {
                            if(res && res.status == 200) {
                                var persistantTeam = res.data;
                                deleteElement(teams.temporary, team);
                                teams.saved.push(persistantTeam);
                            }
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
                }

                teams.deleteTeamById = function(team) {
                    $http.delete('/api/quizTeam/' + team.id)
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