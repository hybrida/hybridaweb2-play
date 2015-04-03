(function () {
    var app = angular.module('quiz', []);

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

    app.controller('ScoreboardController', function () {
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

    app.controller('QuizTeamController', function($http){
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

        teams.createNewTeam = function () {
            teams.temporary.push({});
        };

        teams.deleteNewTeam = function(team) {
            deleteElement(teams.temporary, team);
        };

        teams.debug = function () {
            console.log(teams.saved);
            console.log(teams.temporary);
        }
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