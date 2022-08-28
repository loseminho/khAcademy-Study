const inputClick = $(".join-body-input");

inputClick.on("click",function(){
    const title =$(".join-body-title label");
    const img = $(".join-body-input img");
    const index = inputClick.index(this);
    title.eq(index).css("margin","0").css("position","");
    img.eq(index).css("color","blueviolet");
})

const id = $("#id");
const pw = $("#pw");
const pwRe = $("#pwRe");
const name = $("#name");
const phone = $("#phone");
const idReg = /^[a-z0-9]{4,12}$/;
const pwReg = /^[a-z0-9]{4,12}$/;
const nameReg = /^[가-힣]{2,4}$/;
const phoneReg = /^\d{3}-\d{4}-\d{4}$/;
const idComment = $("#idComment");
const pwComment = $("#pwComment");
const pwReComment = $("#pwReComment");
const nameComment = $("#nameComment");
const phoneComment = $("#phoneComment");


