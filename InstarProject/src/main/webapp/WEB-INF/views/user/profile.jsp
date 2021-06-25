<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <!-- Style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/profile.css">
    <!-- Fontawesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700&display=swap"
        rel="stylesheet">
</head>

<body>

<%@ include file="../layout/header.jsp"%>

    <section class="profile">
        <div class="container">
            <div class="profile-left">
                <div class="profile-img-wrap story-border" onclick="popup('.modal-image')">
                    <img src="${pageContext.request.contextPath}/resources/images/profile.jpeg" alt="">
                    <svg viewbox="0 0 110 110">
                        <circle cx="55" cy="55" r="53" />
                    </svg>
                </div>
            </div>
            <div class="profile-right">
                <div class="name-group">
                    <h2>There Programing</h2>
                    <button class="cta blue" onclick="location.href='/upload/imageUpload'" >사진업로드</button>
                    <button class="cta">援щ����湲�</button>
                    <button class="modi" onclick="popup('.modal-info')"><i class="fas fa-cog"></i></button>
                </div>
                <div class="follow">
                    <ul>
                        <li><a href="">게시글<span>6</span></a> </li>
                        <li><a href="" id="subscribeBtn">구독정보<span>106</span></a> </li>
                    </ul>
                </div>
                <div class="state">
                    <h4>寃��몃�곗��</h4>
                </div>
            </div>
        </div>
    </section>

    <div class="gallery">
        <div class="container">
            <div class="controller">      
            </div>
        </div>
    </div>

    <section id="tab-content">
        <div class="container">
            <div id="tab-1-content" class="tab-content-item show">
                <div class="tab-1-content-inner">
                    <div class="img-box">
                        <a href=""><img src="images/profile.jpeg" alt=""></a>
                        <div class="comment">
                            <a href="#a" class=""><i class="fas fa-heart"></i><span>36</span></a>
                        </div>
                    </div>
                    <div class="img-box">
                        <a href=""><img src="images/profile.jpeg" alt=""></a>
                        <div class="comment">
                            <a href="#a" class=""><i class="fas fa-heart"></i><span>36</span></a>
                        </div>
                    </div>
                    <div class="img-box">
                        <a href=""><img src="images/profile.jpeg" alt=""></a>
                        <div class="comment">
                            <a href="#a" class=""><i class="fas fa-heart"></i><span>36</span></a>
                        </div>
                    </div>
                    <div class="img-box">
                        <a href=""><img src="images/profile.jpeg" alt=""></a>
                        <div class="comment">
                            <a href="#a" class=""><i class="fas fa-heart"></i><span>36</span></a>
                        </div>
                    </div>
                    <div class="img-box">
                        <a href=""><img src="images/profile.jpeg" alt=""></a>
                        <div class="comment">
                            <a href="#a" class=""><i class="fas fa-heart"></i><span>36</span></a>
                        </div>
                    </div>
                    <div class="img-box">
                        <a href=""><img src="images/profile.jpeg" alt=""></a>
                        <div class="comment">
                            <a href="#a" class=""><i class="fas fa-heart"></i><span>36</span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>



    <div class="modal-info">
        <div class="modal">
            <button onclick="location.href='profileSetting.html'">������蹂� 蹂�寃�</button>
            <button>濡�洹몄����</button>
            <button onclick="closePopup('.modal-info')">痍⑥��</button>
        </div>
    </div>

    <div class="modal-image">
        <div class="modal">
            <p>��濡��� �ъ� 諛�袁멸린</p>
            <button>�ъ� ��濡���</button>
            <button onclick="closePopup('.modal-image')">痍⑥��</button>
        </div>
    </div>

    <div class="modal-follow">
        <div class="follower">
            <div class="follower-header">
                <span>援щ����蹂�</span>
                <button onclick="closeFollow()"><i class="fas fa-times"></i></button>
            </div>
            <div class="follower-list">
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>
                <div class="follower__item">
                    <div class="follower__img"><img src="images/profile.jpeg" alt=""></div>
                    <div class="follower__text">
                        <h2>���대��</h2>
                    </div>
                    <div class="follower__btn"><button onclick="clickFollow(this)">援щ��痍⑥��</button></div>
                </div>

            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/resources/js/profile.js">
    /* $(document).ready(function() {
    	  var operForm = $("#operForm"); 
    	  $("button [data-oper= 'list']").on("click", function(e){
    	    operForm.attr("action","/upload/imageUpload")
    	   ); 
    } */

    </script>
</body>

<%@ include file="../layout/footer.jsp"%>
</html>