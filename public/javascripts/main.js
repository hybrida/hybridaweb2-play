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

uploadFile = function(fileUpload, success) {
    var formData = new FormData();
    formData.append("file", fileUpload.files[0]);
    $.ajax({
        url: "/api/upload",
        type: "POST",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        success: success
    });
}