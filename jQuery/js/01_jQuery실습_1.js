function func1(){
    const text1 = $("#text");
    console.log(text1.text());
}
function func2(){
    const text2 = $(".text");
    console.log(text2.text());
}
function func3(){
    const text3 = $("[name=text]");
    console.log(text3.text());
}

function func4(){
    console.log($("input:checkbox[name=stydy]:checked").length);
}

function exam1(){
    const p = $(".test #pp");
    const prev = p.prev();
    const children = prev.children();
    const select = children.first();
    select.css("border", "2px solid red");
}
function exam2(){
    const ul = $("ul");
    const next = ul.next();
    const children = next.children();
    const select = children.eq(1);
    select.css("border", "2px solid blue");
}

function exam3(){
    const pica = $("#pica");
    const parent = pica.parent();
    const grandparent = parent.parent();
    grandparent.css("border", "2px solid coral");

    const div = pica.parents("div");
    div.eq(0).css("border", "2px solid coral");
}
function exam4(){
    const test = $(".test");
    const ul = test.find("ul");
    const select = ul.children();
    select.css("border", "2px solid pink");
}