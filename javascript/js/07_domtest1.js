// 1. 텍스트 노드를 갖는 요소를 생성
// p 태그 생성
const p = document.createElement("p");// <p> </p>
console.log(p);
// p 태그 내부에 작성할 글씨 생성
const text1 = document.createTextNode("p태그 내부에 들어갈 글씨");
// 생성된 글씨를 p 태그 내부에 삽입
p.appendChild(text1);

// html 문서 중 id가 div1인 요소를 가져옴
// 가져온 div 태그 내부에 생성한 p 태그를 자식으로 추가
// const div1 = document.getElementById("div1");
// div1.appendChild(p);

// const divs = document.getElementsByClassName("test2");
// console.log(divs);
// divs[0].appendChild(p);

// const div1 = document.querySelector("#div4");
// div1.appendChild(p);

// const div2 = document.querySelectorAll(".test2");
// div2[1].appendChild(p);

// 2. 텍스트 노드가 없는 요소 생성
// img 태그를 생성
const img = document.createElement("img"); //<img>까지 작성한것.
// src 속성에 값을 대입
img.src = "img/dora.png"; // <img src="img/dora.png">
const div = document.querySelector("#div1");
div.appendChild(img);

// 3. 요소의 css 변경
// css를 변경할 요소를 선택
const div3 = document.getElementById("div3");
// 일반 css style로 줄 때보다 우선순위가 더 높게 잡힘.
div3.style.color = "red";


const h3 = document.createElement("h3");
const text2 = document.createTextNode("h3 태그 내부 글씨");
h3.appendChild(text2);
h3.style.color = "#ffffff";
h3.style.background = "#000000";
h3.setAttribute("id","h");// id="h", 아이디 부여
h3.setAttribute("class","c1 c2"); // 클래스 부여

const div2 = document.querySelector("#div2");
div2.appendChild(h3);

/*
        <ul>
            <li><a href="#">메뉴1</a></li>
            <li><a href="#">메뉴2</a></li>
            <li><a href="#">메뉴3</a></li>
            <li><a href="#">메뉴4</a></li>
        </ul>
        만들기
*/
const menuName = new Array();
menuName.push("Home");
menuName.push("About");
menuName.push("Mypage");
const menuLink = new Array();
menuName.push("/home.html");
menuName.push("/about.html");
menuName.push("/mypage.html");

const menus = new Array();
const menu1 = {name:"Home", link:"/home.html"};
menus.push(menu1);
const menu2 = {name:"About", link:"/about.html"};
menus.push(menu2);
const menu3 = {name:"Mypage", link:"/mypage.html"};
menus.push(menu3);
console.log(menus);
const ul = document.createElement("ul");

for(let i = 0; i<menus.length; i++){
    const li = document.createElement("li");
    const a = document.createElement("a");
    const menuText = document.createTextNode(menus[i].name);
    a.href=menus[i].link;
    a.appendChild(menuText);
    li.appendChild(a);
    ul.appendChild(li);
}

/*

// 메뉴1 만들기
const li1 = document.createElement("li");
const a1 = document.createElement("a");
const menu1 = document.createTextNode("메뉴1");
a1.appendChild(menu1); // <a>메뉴1</a>
a1.href="#"; // <a href="#">메뉴1</a>
li1.appendChild(a1); // <li><a href="#">메뉴1</a></li>
ul.appendChild(li1);// <ul><li><a href="#">메뉴1</a></li></ul>
// 메뉴2 만들기
const li2 = document.createElement("li");
const a2 = document.createElement("a");
const menu2 = document.createTextNode("메뉴2");
a2.appendChild(menu2); // <a>메뉴2</a>
a2.href="#"; // <a href="#">메뉴2</a>
li2.appendChild(a2); // <li><a href="#">메뉴2</a></li>
ul.appendChild(li2);// <ul><li><a href="#">메뉴2</a></li></ul>
// 메뉴3 만들기
const li3 = document.createElement("li");
const a3 = document.createElement("a");
const menu3 = document.createTextNode("메뉴3");
a3.appendChild(menu3); // <a>메뉴3</a>
a3.href="#"; // <a href="#">메뉴3</a>
li3.appendChild(a3); // <li><a href="#">메뉴3</a></li>
ul.appendChild(li3);// <ul><li><a href="#">메뉴3</a></li></ul>
// 메뉴4 만들기
const li4 = document.createElement("li");
const a4 = document.createElement("a");
const menu4 = document.createTextNode("메뉴4");
a4.appendChild(menu4); // <a>메뉴4</a>
a4.href="#"; // <a href="#">메뉴4</a>
li4.appendChild(a4); // <li><a href="#">메뉴4</a></li>
ul.appendChild(li4);// <ul><li><a href="#">메뉴4</a></li></ul>

*/


//만들어진 ul을 .navi안에 자식으로 추가
const navi = document.querySelector(".navi");
navi.appendChild(ul);


const btn = document.querySelector("#btn");
console.dir(btn);


function btnClick(){
    console.log("버튼을 클릭하면 동작하는 함수");
}
btn.onclick = function(){
    console.log("onclick 속성을 이용한 함수 추가");
}

const addBtn = document.querySelector("#add");
addBtn.onclick = function(){
    //p태그 생성,
    //추가! 라는 글씨 노드 생성
    //p 태그에 추가!라는 글씨 노드 자식으로 추가
    //add-zone의 자식으로 p 태그 추가
    const p = document.createElement("p");
    const text = document.createTextNode("추가!");
    p.appendChild(text);
    const addZone = document.querySelector("#add-zone");
    addZone.appendChild(p);
}

const delBtn1 = document.querySelector("#del-btn1");
delBtn1.onclick = function(){
    const delElement = document.querySelector("#i-div3");
    delElement.remove();
}

const delBtn2 = document.querySelector("#del-btn2");
delBtn2.onclick = function(){
    const delDivs = document.querySelectorAll(".i-c1");
    console.log(delDivs);
    delDivs[0].remove();
}

const delBtn3 = document.querySelector("#del-btn3");
delBtn3.onclick = function(){
    const delDivs = document.querySelectorAll(".del-zone>div");
    console.log(delDivs);
    delDivs[0].remove();
    delDivs[1].remove();
    delDivs[2].remove();
    delDivs[3].remove();
    delDivs[4].remove();
}

const testBtn = document.querySelector("#testBtn");
testBtn.onclick  = function(){
    const div = document.querySelector("#divdiv");
    console.dir(div);
    // div.href="test";
    //강제로 div에 href를 삽입.
    div.setAttribute("href","test");
    div.setAttribute("class","test-div");
    console.log(div.id);
    //태그가 가지고 있지 않은 속성의 값을 가져오는 방법.
    console.log(div.getAttribute("href"));
}
