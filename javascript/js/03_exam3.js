const divs = document.querySelectorAll(".divs");
const divWrap = document.querySelector("#divWrap");

let x = 0;
for(let i=0; i<divs.length; i++){
    divs[i].onclick = function(){
        divWrap.appendChild(divs[i]);
        // divWrap.innerHTML = divs[i];
        divs[i].style.display = "none";
        x++;
        if(x==5){
            for(let j=0;j<divs.length;j++){
                divs[j].style.display = "block";
            }
            x = 0;
        }
    }
}

// 아이디 속성 꺼내오기 const 변수A = 변수B.id;, attribute("id");