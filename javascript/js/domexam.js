
const addBtnn = document.querySelectorAll(".btn");

addBtnn[0].onclick = function(){
    let name =prompt("당신의 이름은?");
    let age = prompt("당신의 나이는?");
    let addr = prompt("당신의 주소는?");
    const addName = document.createTextNode(name);
    const addAge = document.createTextNode(age);
    const addAddr = document.createTextNode(addr);
    const th1 = document.createElement("th");
    const th2 = document.createElement("th");
    const th3 = document.createElement("th");
    const tr = document.createElement("tr");
    const exam1 = document.querySelector("#exam1>tbody");
    th1.appendChild(addName);
    th2.appendChild(addAge);
    th3.appendChild(addAddr);
    tr.appendChild(th1); 
    tr.appendChild(th2);
    tr.appendChild(th3);
    exam1.appendChild(tr);
}

let i = 0;
addBtnn[1].onclick = function(){
    let name =prompt("당신의 이름은?");
    let age = prompt("당신의 나이는?");
    let addr = prompt("당신의 주소는?");
    const addName = document.createTextNode(name);
    const addAge = document.createTextNode(age);
    const addAddr = document.createTextNode(addr);
    const th1 = document.createElement("th");
    const th2 = document.createElement("th");
    const th3 = document.createElement("th");
    const th4 = document.createElement("th");
    const tr = document.createElement("tr");
    const exam2 = document.querySelector("#exam2>tbody");
    const but = document.createElement("button");
    const butText = document.createTextNode("삭제");
    but.appendChild(butText);
    th1.appendChild(addName);
    th2.appendChild(addAge);
    th3.appendChild(addAddr);
    th4.appendChild(but);
    tr.appendChild(th1);
    tr.appendChild(th2);
    tr.appendChild(th3);
    tr.appendChild(th4);
    exam2.appendChild(tr);
    but.onclick = function(){
        tr.remove();
    }
}
