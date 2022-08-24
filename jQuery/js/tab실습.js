const tabs = $(".tabs>li");
let tabIndex = 0;
const btns = $(".tabcontent-btn button");



tabs.on("click",function(){
    const index = tabs.index(this);
    if(index ==tabIndex+1 || index ==tabIndex-1 || index ==tabIndex){
        tabs.css("color","#0464bb").css("background-color","#e0e0e0");
        $(this).css("color","#ffffff").css("background-color","#ea8511");
        $(".tabcontent").hide();
        $(".tabcontent").eq(index).show();
        tabIndex = index;
        for(let i=0;i<=index;i++){
            if(i!=0){
                tabs.eq(i-1).css("color","#ffffff").css("background-color","#0464bb");
            }
        }
    }else{
        return;
    }
});

btns.on("click",function(){
    const index = btns.index(this);


    if(index==1){
        tabs.eq(tabIndex+1).click();
    }else{
        tabs.eq(tabIndex-1).click();
    }

    if(tabIndex==3){
        $(".btnNext").hide();
    }else{
        $(".btnNext").show();
    }
    if(tabIndex !=0){
        $(".btnBack").show();
    }else{
        $(".btnBack").hide();
    }

    console.log(tabIndex);
})


$(".btnBack").hide();
tabs.eq(0).click();
