_=function(o){return function(){return o;}};

clearSelf = function(obj) {
    obj.innerHTML="";
};
clearSelfValue = function(obj) {
    obj.value="";
};
hideMessage = function(obj) {
    obj.style.animation = obj.style.WebkitAnimation = "message-hide 1s";
    obj.style.animationFillMode = obj.style.WebkitAnimationFillMode = "forwards";
};

uploadFile = function(file, success, uploadFolder) {
    var formData = new FormData();
    formData.append("file", file);
    $.ajax({
        url: "/api/upload" + (uploadFolder != null ? "/" + uploadFolder : ""),
        type: "POST",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: success
    });
};

calculateSuperCenter = function(){
    $(".super-center").each(function(i){
        var elem = $(this);
        elem.css({"position": "relative", "transform": "translate(-50%, -50%)"});
        var parent = elem.parent();
        elem.css("left", parent.width()/2);
        var wait = 0;
        if(parent.height() == 0) wait = 200;
        setInterval(function(){
            elem.css("top", parent.height()/2);
        }, wait);
    });
};

$(function() {
    calculateSuperCenter();
});

$(document).ready(function() {
    calculateSuperCenter();
    $(window).resize(calculateSuperCenter);
});

function toggleSuggestionBox() {
    var $sb = $('#suggestionBox');
    console.log($sb.css('right'));
    $sb.css('right', $sb.css('right') == '16px' ? '-100%' : 16);
}

function submitSuggestion() {
    var title = window.location.href;
    var $button = $('#suggestionBox #suggestionButton');
    var $pretext = $('#suggestionBox #suggestionPretext');
    var $suggestion = $('#suggestionBox #suggestionContent');
    $button.prop('disabled', true);
    $.post("https://hooks.slack.com/services/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", 'payload={"attachments":[{\
        "fallback":     "Nytt forslag til forbedring!",\
        "pretext":      "'+$pretext.val()+'",\
        "color":        "good",\
        "fields":[{\
            "title":    "'+title+'",\
            "value":    "'+$suggestion.val()+'",\
            "short":    false\
    }]}]}').fail(function() {
        alert("Noe gikk galt og forslaget ble ikke sent.");
        $button.prop('disabled', false);
    }).done(function() {
        $suggestion.val('');
        toggleSuggestionBox();
        $button.prop('disabled', false);
    });
}