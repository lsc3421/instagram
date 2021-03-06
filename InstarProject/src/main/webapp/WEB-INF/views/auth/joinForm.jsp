<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/insta.svg">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>
<body>
    <div class="container">
        <main class="loginMain">
           <!--회원가입섹션-->
            <section class="login">
                <article class="login__form__container">
                  
                   <!--회원가입 폼-->
                    <div class="login__form">
                        <!--로고-->
                        <h1><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt=""></h1>
                         <!--로고end-->
                         
                         <!--회원가입 인풋-->
                        <form class="login__input" action="/auth/joinForm" method="post"id="signFrm"name="signFrm">
                            <input type="text" name="userID" placeholder="유저네임" required="required"id="userID">
                            <input type = "button" id="check" value = "중복체크">
                            <input type="password" name="password" placeholder="패스워드" required="required"id="password">
                            <input type="email" name="email" placeholder="이메일" required="required"id="email">
                            <input type="text" name="userName" placeholder="이름" required="required"id="userName">
                            <input type = "button" id = "signUp"value = "회원가입">
                            <input hidden="">
                        </form>
                        <!--회원가입 인풋end-->
                    </div>
                    <!--회원가입 폼end-->
                    
                    <!--계정이 있으신가요?-->
                    <div class="login__register">
                        <span>계정이 있으신가요?</span>
                        <a href="/auth/loginForm">로그인</a>
                    </div>
                    <!--계정이 있으신가요?end-->
                    
                </article>
            </section>
        </main>
    </div>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		
		var idx = false;
		
		$('#signUp').click(function(){
			if($.trim($('#userID').val()) == ''){
				alert("아이디 입력.");
				$('#userID').focus();
				return;
			}else if($.trim($('#password').val()) == ''){
				alert("패스워드 입력.");
				$('#password').focus();
				return;
			}else if($.trim($('#email').val()) == ''){
				alert("이메일 입력.");
				$('#email').focus();
				return;
			}else if($.trim($('#userName').val()) == ''){
				alert("이름 입력.");
				$('#userName').focus();
				return;
			}
			if(idx==false){
				alert("아이디 중복체크를 해주세요.");
				return;
			}else{
				$('#signFrm').submit();
			}
		});
		
		$('#check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/idCheck",
				type: "GET",
				data:{
					"userID":$('#userID').val()
				},
				success: function(data){
					if(data == 0 && $.trim($('#userID').val()) != '' ){
						idx=true;
						alert("사용 가능한 아이디 입니다.")
					}else{
						alert("사용 불가능한 아이디 입니다.")
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
		});
	});
</script>
</html>