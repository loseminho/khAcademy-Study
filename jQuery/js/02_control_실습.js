function func1(){
    const tr = $("#tbl1 tr");
    const result1 = $("#result1");
    result1.empty();
    tr.each(function(index,item){
        if(index != 0){
            const td = $(item).children();
            const name = td.eq(0).text();
            const age = td.eq(1).text();
            const addr = td.eq(2).text();
            const text = name+"/"+age+"/"+addr+"<br>";
            console.log(text);
            result1.append(text);
        }
    });
}
function func2(){
    const tr = $("#tbl1 tr");
    tr.eq(0).addClass("title");
    for(let i=1; i<tr.length;i++){
        tr.eq(i).children("td").first().addClass("name");
        tr.eq(i).children("td").eq(1).addClass("age");
        tr.eq(i).children("td").last().addClass("addr");
    }
}
function func3(){
    const tr = $("#tbl1 tr");
    tr.eq(0).removeClass("title");
    tr.children().removeClass("name").removeClass("age").removeClass("addr");
}

const div = document.querySelectorAll("#exam3 div");
let color;
for(let i=0;i<div.length;i++){
    const copy = $("#exam3 div");
    if(i<2){
        div[i].addEventListener("click", function(){
            color = copy.eq(i).css("background-color");
        })
    }else{
        div[i].addEventListener("click",function(){
            copy.eq(i).css("background-color",color);
        })
    }
}

function func4(){
    const clear = $("#exam3 div");
    for(let i=2;i<clear.length;i++){
        clear.eq(i).css("background-color","");
        color = "";
    }
}

function func5(){
    const input = $("#tbl2 input:checkbox:checked");
    // const length = input.length;
    const p = $("#result2");
    p.empty();
    // for(let i =0; i<length*3; i++){
    //     if(i%3 == 0 && i != 0){
    //         p.append("<br>");
    //     }
    //     p.append(input.parent().siblings().eq(i).text()+"/");
    // }
    input.each(function(index,item){
            const parent = $(item).parent();
            const name = parent.siblings().eq(0).text();
            const age = parent.siblings().eq(1).text();
            const addr = parent.siblings().eq(2).text();
            const text = name+"/"+age+"/"+addr+"<br>";
            p.append(text);
    });
}

/*
function func1(){
    const result1 = $("#result1");
    result1.empty(); // 결과값 누적x
    const td = $("#tbl1 td");
    td.each(function(index,item){
        result1.append($(item).text());
        if(index%3==2){
            result1.append("<br>");
        }else{
            result1.append("/");
        }
    });
}

function func2(){
    const th = $("#tbl1 th");
    th.addClass("title");
    $("#tbl1 tr>td:first-child").addClass("name");
    $("#tbl1 tr>td:nth-child(2)").addClass("age");
    $("#tbl1 tr>td:last-child").addClass("addr");

}

function func3(){
    const th = $("#tbl1 th");
    th.removeClass("title");

    $("#tbl1 tr>td").removeClass("name age addr"); // remove 한줄로
}

let color = "transparent";
const colorDivs = document.querySelectorAll(".copy");
for(let i=0;i<colorDivs.length;i++){
    colorDivs[i].addEventListener("click",function(){
        color = $(this).css("background-color");
        console.log(color);
    });
}

const divs = document.querySelectorAll("#exam3 div:not(.copy)");
for(let i=0;i<divs.length;i++){
    divs[i].addEventListener("click",function(){
        $(this).css("background-color",color);
    });
}

function func4(){
    color = "transparent";
    const divs2 = $("#exam3 div:not(.copy)");
    divs2.css("background-color",color);
}

function func5(){
    
}
*/