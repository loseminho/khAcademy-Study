function func1(){
    // const p1 = document.querySelector("#p1");
    // console.log(p1.innerHTML);
    // console.log(p1.innerText);
    // p1.innerText = "변경!!!";
    // p1.style.backgroundColor = "blue";
    // p1.style.color = "white";

    const p1 = $("#p1");
    console.log(p1.html());
    console.log(p1.text());
    p1.text("변경!!!");
    
    // 1. css 변경 방법
    // p1.css("background-color","blue");
    // p1.css("color","white");
    // 2. css 변경 방법
    // p1.css("background-color","blue").css("color","white");
    // 3.css 변경 방법
    p1.css({
        "background-color" : "blue",
        "color" : "white" 
    });
}

function func2(){
    // const p = document.querySelectorAll(".p");
    // // 글씨 색 빨강, 배경색 노란색으로 
    // for(let i = 0;i<p.length; i ++){
    //     p[i].style.backgroundColor = "yellow";
    //     p[i].style.color = "red";
    // }

    const p = $(".p");
    // 제이쿼리는 for문을 사용하지 않아도 일괄적으로 css 적용 가능
    p.css("background-color","yellow").css("color","red");
    // for(let i = 0;i<p.length; i ++){
    //     p.eq(i).css("background-color","yellow").css("color","red");
    // }
}

function func3(){
    const filter = $(".filter>p");
    console.log("선택된 엘리먼트 수 : "+filter.length);
    const first = filter.first(); // 선택된 요소 중 첫번째 요소
    console.log("first : "+first.text());
    const last = filter.last(); // 선택된 요소 중 첫번째 요소
    console.log("last : "+last.text());
    const eq = filter.eq(2); // 0~length-1까지 입력 가능
    console.log("eq : "+eq.text());
    // first() -> eq(0), last() -> eq(filter.length-1)
    const filter2 = filter.filter(".pp1"); // 선택된 요소 중 클래스가 pp1인 요소
    for(let i =0; i<filter2.length; i++){
        console.log("filter : "+filter2.eq(i).text());
    }

    const filter3 = filter.not(".pp3"); // 선택된 요소 중 클래스가 pp3인 요소를 제외한 나머지 요소
    filter3.css("color","blue");
}

function func4(){
    // parent() : 선택된 요소의 바로 위 상위 요소
    const span = $(".ancestors span");
    const select = span.parent();
    select.css("border","2px solid red");
}

function func5(){
    // parents([인자]) : (인자는 생략 가능)
    const span = $(".ancestors span");
    // 매개변수가 없는 경우 : 선택된 요소의 모든 상위 요소
    // const select = span.parents();
    // select.css("border","2px solid red");
    // 매개변수가 있는 경우 : 선택된 요소의 모든 상위 요소 중 매개변수에 해당하는 상위 요소만
    const select = span.parents("div");
    select.css("border","2px solid red");
}

function func6(){
    // parentsUntil(인자) : 선택된 요소부터 인자의 요소 까지 범위에 포함되는 요소 리턴(선택된 요소, 인자 제외한 사이의 요소 값만)
    const span = $(".ancestors span");
    const select = span.parentsUntil("div"); // span태그부터 div 태그 전까지의 사이만
    select.css("border","2px solid red");
}
function func7(){
    // children()
    // 매개변수 없는 경우 : 모든 직계 자식
    const div = $(".descendants");
    // const select = div.children();
    //매개 변수가 있는 경우 : 직계 자식 중에 매개변수에 선택자에 해당되는 요소만
    const select = div.children(".child2");
    select.css("border", "2px solid red");
}

function func8(){
    // find(인자) : 모든 후손 요소 중 인자로 전달한 요소만
    const div = $(".descendants");
    const select = div.find(".child1");
    select.css("border","2px solid blue");
}

function func9(){
    // siblings([인자])
    // 매개변수 없는 경우 : 형제 관계에 있는 모든 요소(본인 제외한 나머지 요소)
    const h3 = $(".siblings h3");
    // const select = h3.siblings();
    // 매개 변수가 있는 경우 : 형제 관계에 있는 요소 중 매개변수에 해당되는 요소만
    const select = h3.siblings("p");
    select.css("border", "2px solid red");
}

function func10(){
    // next() : 선택된 요소의 바로 다음 요소
    const h3 = $(".siblings h3");

    const select = h3.next();

    const h5 = h3.next().next();
    h5.css("border", "2px solid red");
}
function func11(){
    // nextAll([인자])
    // 매개변수가 없는 경우 : 선택된 요소의 형제들 중 선택된 요소 이후의 모든 요소
    const h3 = $(".siblings h3");
    // const select = h3.nextAll();
    // 매개변수가 있는 경우 : 선택된 요소의 형제들 중 선택된 요소 이후에 있는 요소 중 매개변수로 전달한 선택자에 해당하는 요소만
    const select = h3.nextAll("h5"); //h3 이후의 요소 중 h5 요소만
    select.css("border", "2px solid red");
}
function func12(){
    // nextUntil(인자) : 선택된 요소부터 매개변수로 전달한 요소 사이에 있는 모든 요소
    const h3 = $(".siblings h3");
    const select = h3.nextUntil("p"); // h3사이 p 사이의 값만
    select.css("border", "2px solid red");
}
function func13(){
    // prev() : 선택된 요소 바로 이전 요소
    const h3 = $(".siblings h3");
    const select = h3.prev();
    select.css("border", "2px solid red");
}
function func14(){
    // prevAll([인자]) 
    const h3 = $(".siblings h3");
    const select = h3.prevAll();
    // 매개변수 없는 경우 : 선택된 요소의 형제들 중 이전에 있는 모든 요소
    // 매개변수 있는 경우 : 이전 요소 중 해당하는 요소만
    select.css("border", "2px solid red");
}
function func15(){
    // prevUntil([인자]) : 선택된 요소 이전의 형제들 중 선택된 요소와 매개변수로 받은 선택자 사이에 있는 요소 
    const h3 = $(".siblings h3");
    const select = h3.prevUntil("p");
    select.css("border", "2px solid red");
    console.log(select.first().text());
}