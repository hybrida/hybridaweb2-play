(function () {
    var app = angular.module('quiz', []);

    var teamTotalScores = [
        {name: "SuperTeam", score: 13},
        {name: "HorribleTeam", score: 3}
    ];

    app.controller('ScoreboardController', function () {
        this.teamScores = teamTotalScores;
    });
})();