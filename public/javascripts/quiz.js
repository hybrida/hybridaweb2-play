(function () {
    var app = angular.module('quiz', []);

    //var teamTotalScoresAlt = [
    //    {name: "SuperTeam", score: 13},
    //    {name: "HorribleTeam", score: 3}
    //];
    //var teamTotalScores = {
    //    SuperTeam: 13,
    //    HorribleTeam: 3
    // }

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
    ]

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
            console.log(that.teamScores);
        };

        updateTeamScores();
    });
})();