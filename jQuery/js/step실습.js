const tabs = $(".tabs>li");
let nowIndex = 0;
tabs.on("click",function(){
    const index = tabs.index(this);

    if(index <= nowIndex+1){
        tabs.css("color","#0464bb").css("background-color","#ebebeb");
        $(this).css("color","#fff").css("background-color","#ea8511");
        for(let i=0;i<index;i++){
            tabs.eq(i).css("color","#fff").css("background-color","#0464bb");
        }
        $(".tabcontent").hide();
        $(".tabcontent").eq(index).show();

        nowIndex = index;
        if(index==0){
            $("button").eq(0).hide();
        }else{
            $("button").eq(0).show();
        }
        if(index==3){
            $("button").eq(1).hide();
            $("button").eq(2).show();
        }else{
            $("button").eq(1).show();
            $("button").eq(2).hide();
        }
    }

});

tabs.eq(0).click();

$("button").eq(1).on("click",function(){
    if(nowIndex < 3){
        tabs.css("color","#0464bb").css("background-color","#ebebeb");
        tabs.eq(nowIndex+1).css("color","#fff").css("background-color","#ea8511");
        $(".tabcontent").hide();
        $(".tabcontent").eq(nowIndex+1).show();
        nowIndex = nowIndex+1;
        for(let i=0;i<nowIndex;i++){
            tabs.eq(i).css("color","#fff").css("background-color","#0464bb");
        }
    }
    if(nowIndex==0){
        $("button").eq(0).hide();
    }else{
        $("button").eq(0).show();
    }
    if(nowIndex==3){
        $("button").eq(1).hide();
        $("button").eq(2).show();
    }else{
        $("button").eq(1).show();
        $("button").eq(2).hide();
    }
});

$("button").eq(0).on("click",function(){
    if(nowIndex >= 1){
        tabs.css("color","#0464bb").css("background-color","#ebebeb");
        tabs.eq(nowIndex-1).css("color","#fff").css("background-color","#ea8511");
        $(".tabcontent").hide();
        $(".tabcontent").eq(nowIndex-1).show();
        nowIndex = nowIndex-1;
        for(let i=0;i<nowIndex;i++){
            tabs.eq(i).css("color","#fff").css("background-color","#0464bb");
        }
    }
    if(nowIndex==0){
        $("button").eq(0).hide();
    }else{
        $("button").eq(0).show();
    }
    if(nowIndex==3){
        $("button").eq(1).hide();
        $("button").eq(2).show();
    }else{
        $("button").eq(1).show();
        $("button").eq(2).hide();
    }
});

