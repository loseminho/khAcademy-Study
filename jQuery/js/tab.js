const tabs = $(".tabs>li");
tabs.on("click",function(){
    tabs.css("color","#fffbe9").css("background-color","#ad8b73");
    $(this).css("color","#ad8b73").css("background-color","#fffbe9");
    const index = tabs.index(this);
    // const text = $(this).text();
    $(".tabcontent").hide();
    // const showContent = $("#"+text);
    // showContent.show();
    $(".tabcontent").eq(index).show();
});
tabs.eq(0).click();