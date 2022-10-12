let bookratingDOM = document.getElementById("bookrating")
let bookratingStar = document.getElementsByClassName("fav-star")
let rating = bookratingDOM.getAttribute("value")
for(let i = 0; i < rating ; i++){
    bookratingStar[i].setAttribute("src" , "../../resources/star.png")
}
