clearSelf = function(obj) {
    obj.innerHTML="";
}
clearSelfValue = function(obj) {
    obj.value="";
}
hideMessage = function(obj) {
    obj.style.animation = obj.style.WebkitAnimation = "message-hide 1s";
    obj.style.animationFillMode = obj.style.WebkitAnimationFillMode = "forwards";
}