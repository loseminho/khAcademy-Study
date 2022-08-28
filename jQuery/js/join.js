const members = ["user01","user02","user03"];

$("input[type=submit]").on("click",function(){
    // 아이디, 비밀번호, 비밀번호확인, 이름, 전화번호, 이메일 유효성 검사

    // 아이디 유효성 검사
    // 영어소문자/대문자+숫자 6~20글자
    const idReg = /^[a-zA-Z0-9]{6,20}$/;
    const id = $("#id");
    const idComment = id.next();
    
    const idValue = id.val();
    if(idReg.test(idValue)){
        // 유효성을 만족했으므로 중복체크 진행
        const searchIndex = members.indexOf(idValue);
        if(searchIndex == -1){
            // 사용 가능한 아이디
            idComment.text("사용 가능한 아이디 입니다.");
            idComment.css("color","blue");
        }else{
            // 아이디 중복 됨.
            idComment.text("이미 사용중인 아이디 입니다.");
            idComment.css("color","red");
            event.preventDefault();
        }
    }else{
        // 유효성 만족 못함
        idComment.text("아이디는 영어/숫자 조합으로 6~20글자 입니다.");
        idComment.css("color","red");
        event.preventDefault();
    }

    // 비밀번호 유효성 검사
    // 비밀번호 유효성 조건 소문자/대문자/숫자로 8~12글자
    const pwReg = /^[a-zA0-9]{8,12}$/;
    const pw = $("#pw");
    const pwComment = pw.next();
    
    const pwValue = pw.val();
    if(pwReg.test(pwValue)){
        pwComment.text("사용 가능한 비밀번호입니다.");
        pwComment.css("color","blue");
    }else{
        pwComment.text("비밀번호는는 영어/숫자 조합으로 8~12글자 입니다.");
        pwComment.css("color","red");
        event.preventDefault();
    }

    //비밀번호 확인 (비밀번호와 같은가)
    const pwRe = $("#pwRe");
    const pwReComment = pwRe.next();
    const pwReValue = pwRe.val();
    if(pwValue ==pwReValue){
        pwReComment.text("비밀번호와 동일합니다.");
        pwReComment.css("color","blue");
        event.preventDefault();
    }else{
        pwReComment.text("비밀번호와 동일하지 않습니다. 다시 확인해주세요.");
        pwReComment.css("color","red");
        event.preventDefault();
    }
    
    const name = $("#name");
    const phone1 = $("#phone1");
    const phone2 = $("#phone2");
    const phone3 = $("#phone3");
    const email = $("#email");
    const nameReg = /^[가-힣]{2,7}$/;
    const phoneReg1 = /^[0-9]{3}$/;
    const phoneReg2 = /^[0-9]{4}$/;
    const emailReg = /^[a-zA-Z0-9]{4,12}@/;
    const nameComment = name.next();
    const phoneComment = phone3.next();
    const emailComment = email.next();
    const nameValue = name.val();
    const phone1Value = phone1.val();
    const phone2Value = phone2.val();
    const phone3Value = phone3.val();
    const emailValue = email.val();
    if(nameReg.test(nameValue)){
        nameComment.text("올바른 형식의 이름입니다.");
        nameComment.css("color","blue");
    }else{
        nameComment.text("형식이 틀렸습니다");
        nameComment.css("color","red");
        event.preventDefault();
    }

    if(phoneReg1.test(phone1Value) && phoneReg1.test(phone3Value) && phoneReg2.test(phone2Value)){
            phoneComment.text("전화번호 형식이 맞았습니다");
            phoneComment.css("color","blue");
    }else{
        phoneComment.text("전화번호의 형식이 틀렸습니다. 확인해주세요.");
        phoneComment.css("color","red");
        event.preventDefault();
    }

    if(emailReg.test(emailValue)){
        emailComment.text("올바른 형식의 이메일입니다.");
        emailComment.css("color","blue");
    }else{
        emailComment.text("이메일 형식이 틀렸습니다 확인해주세요.");
        emailComment.css("color","red");
        event.preventDefault();
    }



    

    // 이름 한글 2~7글자

    // 전화번호 숫자3자리-숫자3~4자리-숫자3자리

    //이메일 영어+숫자(4~12글자)@

});
