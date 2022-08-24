
/** 새로 들어온 값이 생겨도 .d1의 조건이 충족 되게 만들고 싶은 경우 document에 조건을 걸어준다. */
$(document).on("click",".d1",function(){
    const divs = $(".d1");
    const index = divs.index(this);
    console.log(index);
    console.log($(this).text());
});


const d1 = $(".d1");
d1.click(function(){
    const divs = $(".d1");
    const index = divs.index(this);
    console.log(index);
    console.log($(this).text());
});

// 선택된요소들.index(this);
// 이벤트를 발생시킨 객체가 선택된 요소 중 몇번쨰 요소인지 리턴
for(let i=0; i<d1.length;i++){
    d1.eq(i).click(function(){
        console.log($(this).text());
    });
}

const btn1 = $("#btn1");
$("#btn1").on("click",function(){
    const div = $("<div>test-4</div>");
    div.addClass("d1");
    $("#test1").append(div);
});

const levelupBtn = $(".levelupBtn");
levelupBtn.click(function(){
    const levelupBtn = $(".levelupBtn");
    const index = levelupBtn.index(this);
    const text = levelupBtn.eq(index).next().next().text();
    const result = Number(text)+1;
    levelupBtn.eq(index).next().next().empty();
    levelupBtn.eq(index).next().next().append(result);

    /*
    const level = $(".level");
    const currentLevel = level.eq(i).text();
    const nextLevel = Number(currentLevel)+1;
    level.eq(i).text(nextLevel);
    */
})

$("#allLevelup").on("click",function(){
    const levelupBtn = $(".levelupBtn");
    const nowSet = new Array();
    for(let i=0; i<levelupBtn.length;i++){
            nowSet[i] = Number(levelupBtn.eq(i).next().next().text())+1;
            levelupBtn.eq(i).next().next().empty();
            levelupBtn.eq(i).next().next().append(nowSet[i]);
        }
});
// $("#allLevelup").on("click",function(){
//     // levelupBtn.trigger("click");
//     levelupBtn.click();
// })

$("#click").on("click",function(){
    $(this).css("color","red");
});
$("#dblclick").on("dblclick",function(){
    $(this).css("color","blue");
});
$("#mousedown").on("mousedown",function(){
    $(this).css("color","red");
});
$("#mousedown").on("mouseup",function(){
    $(this).css("color","blue");
});
$(document).on("mousemove",function(event){
    const html = event.pageX+" , "+event.pageY;
    $("#mousemove").text(html);
});
$("#input1").on("focusin",function(){
    $(this).css("background-color","skyblue");
});
$("#input1").on("focusout",function(){
    $(this).css("background-color","white");
});
$("#input2").on("change",function(){
    console.log("input2 변경 값 : "+$(this).val());
});
$("#submit").on("click",function(event){
    const input1 = $("#input1");
    if(input1.val()==""){
        // 기본 이벤트 제거 코드
        event.preventDefault();
        input1.focus();
    }
});