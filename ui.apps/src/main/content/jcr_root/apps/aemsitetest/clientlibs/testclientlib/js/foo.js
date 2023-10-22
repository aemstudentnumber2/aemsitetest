function changeTitleIfImageIsBig() {
    var img = document.getElementById('image');
    if(img.width > 800 || img.height > 800) {
        var h1 = document.querySelector('h1');
   	    h1.innerHTML = h1.innerHTML + " big image";
    }
}
