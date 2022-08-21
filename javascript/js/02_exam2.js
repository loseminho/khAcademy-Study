const search = document.querySelectorAll("[name=search]");

for(let i=0; i<search.length; i++){
    const searchBox = document.querySelectorAll(".searchBox");   
    search[i].onclick = function(){
        for(let i=0; i<search.length; i++){
            searchBox[i].style.display = "none";
        }
        searchBox[i].style.display = "block";
    }
}
