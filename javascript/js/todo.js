const addBtn = document.querySelector(".add-btn");
const input = document.querySelector("[name=input]");
addBtn.addEventListener("click",function(){
    addList();
});
input.addEventListener("keyup",function(e){
    if(e.keyCode == 13){
        addList();
    }
});

function addList(){
    
    const inputValue = input.value;
    
    if(inputValue == ""){
        return;
    }
    const ul = document.createElement("ul");
    ul.classList.add("todolist");

    const likeLi = document.createElement("li");
    likeLi.classList.add("like");

    const likeSpan = document.createElement("span");
    likeSpan.classList.add("material-symbols-outlined");
    likeSpan.classList.add("like-icon");
    const likeSpanText = document.createTextNode("favorite");

    likeSpan.addEventListener("click",function(){
        likeSpan.classList.toggle("check-like");
    })

    likeSpan.appendChild(likeSpanText);
    likeLi.appendChild(likeSpan);
    ul.appendChild(likeLi);
    
    const todoTextLi = document.createElement("li");
    todoTextLi.classList.add("todo-text");
    const todoText = document.createTextNode(inputValue);
    todoTextLi.appendChild(todoText);
    ul.appendChild(todoTextLi);

    const checkZoneLi = document.createElement("li");
    checkZoneLi.classList.add("check-zone");
    const checkZoneSpan1 = document.createElement("span");
    const checkZoneSpan2 = document.createElement("span");
    checkZoneSpan1.classList.add("material-symbols-outlined");
    checkZoneSpan1.classList.add("check");
    checkZoneSpan2.classList.add("material-symbols-outlined");
    checkZoneSpan2.classList.add("close");
    const zoneSpan1Text = document.createTextNode("check");
    const zoneSpan2Text = document.createTextNode("close");

    checkZoneSpan1.addEventListener("click",function(){
        todoTextLi.style.textDecoration = "line-through";
        checkZoneSpan1.remove();
    });

    checkZoneSpan2.addEventListener("click",function(){
        ul.remove();
    })

    checkZoneSpan1.appendChild(zoneSpan1Text);
    checkZoneSpan2.appendChild(zoneSpan2Text);
    checkZoneLi.appendChild(checkZoneSpan1);
    checkZoneLi.appendChild(checkZoneSpan2);
    ul.appendChild(checkZoneLi);

    const listBox = document.querySelector(".list-box");
    listBox.appendChild(ul);
    input.value = "";
}



// const likeIcon = document.querySelector(".like-icon");
// likeIcon.addEventListener("click", function(){
//     likeIcon.classList.toggle("check-like");
// });

// const close = document.querySelector(".close");
// close.addEventListener("click", function(){
//     const listBox = document.querySelector(".list-box");
//     listBox.remove();
// });

// const check = document.querySelector(".check");
// check.addEventListener("click", function(){
//     const todoText = document.querySelector(".todo-text");
//     todoText.classList.toggle("todo-text-add");
//     check.remove();
// });





