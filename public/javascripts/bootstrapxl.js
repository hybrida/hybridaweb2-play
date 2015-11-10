$(document).ready(function() {
    $("[class*='col-xl-']").each(function(){
        var elem = $(this);
        var classes = elem.attr("class");
        if(classes.search(/\bcol-(xs|sm|md|lg)-(1[0-2]|[1-9])\b/) == -1) elem.addClass("col-xs-12");
    });
});