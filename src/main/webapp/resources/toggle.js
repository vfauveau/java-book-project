console.log("i")
let checkboxPictures = document.getElementById("togglePictureOptions");
checkboxPictures.addEventListener('change', function () {
    let pictureUrlBlock = document.getElementById("pictureUrlBlock");
    let pictureFileBlock = document.getElementById("pictureFileBlock");
    if (this.checked) {
        pictureUrlBlock.classList.add('d-none');
        pictureFileBlock.classList.remove('d-none');
    } else {
        pictureUrlBlock.classList.remove('d-none');
        pictureFileBlock.classList.add('d-none');
    }
});