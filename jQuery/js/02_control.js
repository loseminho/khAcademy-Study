function func1(){
    const divs = $("#test1>div");
    // each 사용법
    /*
    divs.each(function(index,item){

    });
    */
    $.each(divs,function(index,item){
        // index는 배열 순회 번호(for문에서 i 역할)
        // item은 자바스크립트 DOM 객체
        // item을 jQuery 메소드로 사용하고 싶은 경우 -?$(item)
        console.log(item.innerText);
        const div1 = document.querySelector("#test1");
        const div11 = $("#test1");
        console.log($(item).text());

        // d1이라는 클래스가 있는지 boolean
        const div = $(item);
        if($(item).is(".d1")){
            $(item).css("color","red");
        }else if($(item).is(".d2")){
            div.css("color","green");
        }else{
            div.css("color","blue");
        }
    });
}

function func2(){
    const checkbox = $("[name=study]");
    console.log(checkbox.length);
    let count = 0;
    checkbox.each(function(index,item){
        if($(item).is(":checked")){
            count++;
        }
    });
    // for(let i =0;i<checkbox.length;i++){
    //     if(checkbox.eq(i).is(":checked")){
    //         count++;
    //     }
    // }
    console.log(count);
}
function func3(){
    const divs = $("#test2>div");
    divs.eq(1).addClass("t-red");

    //id의 css 적용 순위가 더 높기 떄문에 id에 선언해준 blue가 계속 적용됨.
    divs.first().addClass("t-red");
    divs.eq(2).addClass("t-red");
    divs.eq(2).addClass("bg-yellow");

    divs.eq(3).addClass("t-red").addClass("bg-yellow");
    divs.last().addClass("t-red bg-yellow");
}

function func4(){
    const divs = $("#test2").children();
    divs.eq(1).removeClass("bg-yellow");
    divs.eq(2).removeClass("bg-yellow").removeClass("t-red");
    divs.eq(3).removeClass("bg-yellow t-red");
}

function func5(){
    const divs = $("#test2>div");
    // hasClass("클래스이름") : 매개변수로 전달한 클래스 이름을 가지고 있으면 true/ 없으면 false
    console.log(divs.eq(2).hasClass("t-red"));

    if(divs.eq(2).hasClass("t-red")){
        divs.eq(2).addClass("bg-yellow");
    }else{
        divs.eq(2).removeClass("bg-yellow");
    }
}

function func6(){
    const divs = $("#test2>div");
    divs.eq(3).toggleClass("t-red");
}

function func7(){
    const label = $("#test3>label");
    label.each(function(index,item){
        const input  = $(item).prev();
        // attr에 매개변수 1개면 해당 속성값 리턴
        const id = input.attr("id"); 
        // attr에 매개변수가 2개면 속성값 수정
        $(item).attr("for",id);
    });
}
function func8(){
    const label = $("#test3>label");
    label.removeAttr("for");
    // for(let i=0; i<label.length; i++){
    //     label.eq(i).removeAttr("for");
    // }
}

function func9(){
    const input = $("#test3>input");
    const status = input.eq(0).prop("checked");
    console.log(status);
    input.prop("checked",true);
}
function func10(){
    const input = $("#test3>input");
    input.prop("checked",false);
}

function func11(){
    const divs = $("#test4>div");
    // css 메소드에 매개변수 1개만 작성하면 속성값을 가져옴
    console.log(divs.eq(0).css("background-color"));
    console.log(divs.eq(1).css("background-color"));
    // css 메소드에 매개변수 2개 작성 시 
    // 첫번째 매개 변수 : css 속성 명
    // 두번째 매개 변수 : css 속성에 들어갈 값
    divs.eq(0).css("background-color","green");

    // css 속성을 한번에 여러개 변경하는 경우
    // 1)
    // divs.eq(1).css("background-color","yellow").css("float","none").css("clear","left");
    // 2)css 메소드에 변경할 항목을 모두 객체 형태로 전달
    divs.eq(1).css({"background-color" : "yellow",
                    "float" : "none",
                    "clear" : "left"})
}

function func12(){
    const h1 = $("#test5>h1");
    console.log(h1.html());
    h1.html("<a href='#'>html 변경</a>");
}
function func13(){
    const h1 = $("#test5>h1");
    console.log(h1.text());
    h1.text("<a href='#'>text 변경</a>");
}
function func14(){
    const input = $("[name=str]");
    const inputValue = input.val();
    console.log(inputValue);
    input.val("변경 값");
}

function func15(){
    const  div = $("#test6");
    const p = $("<p>");
    p.text("text-5");
    
    // 방법 1
    // 객체1.append(객체2) : 객체1의 마지막 자식으로 객체 2를 추가
    div.append(p);
    // 방법2
    // 객체1.appendTo(객체2) : 객체1를 객체2의 마지막 자식으로 추가
    p.appendTo(div);
}
function func16(){
    const  div = $("#test6");
    const p = $("<p>test-0</p>");
    // 객체1.prepend(객체2) : 객체1의 첫번째 자식으로 객체2 추가
    div.prepend(p);
    // 객체1.prependTo(객체2) : 객체1을 객체2의 첫번째 자식으로 추가
}
function func17(){
    const div = $("#test6>p");
    const p = $("<p>test-000</p>");
    // 객체1.after(객체2) : 객체 1의 바로 다음 요소(동위요소)로 객체 2 추가
    // 객체1.insertAfter(객체2) : 객체1을 개체2의 바로 다음 요소로 추가
    div.eq(1).after(p);
}
function func18(){
    const div = $("#test6>p");
    const p = $("<p>test-000</p>");
    // 객체1.before(객체2) : 객체 1의 바로 이전 요소(동위요소)로 객체 2 추가
    // 객체1.insertBefore(객체2) : 객체1을 객체2의 바로 이전 요소로 추가
    div.eq(1).before(p);
}

function func19(){
    const div = $("#test7");
    const h = div.children();
    h.eq(1).remove();
}
function func20(){
    const div = $("#test7");
    div.empty();
}
function func21(){
    const div = $("#test8");
    const h2 = $("#test7>h2");
    div.append(h2);
}
function func22(){
    const div = $("#test8");
    const h2 = $("#test7>h2").clone();
    div.append(h2);
}
