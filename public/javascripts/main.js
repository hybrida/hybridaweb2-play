OpenOptions = function(){
    x = document.getElementById("event");
    if(document.getElementById("isEvent").checked == true) {
    x.innerHTML = '<input type="text" value="Antall" name="Mengde">'
    }
    else{x.innerHTML = ""}
}