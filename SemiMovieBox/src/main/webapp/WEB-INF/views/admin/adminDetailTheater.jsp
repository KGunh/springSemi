<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div{
    /* border : 1px solid red;  */
     box-sizing : border-box;
	 }
	
	 /* 전체를 감싸는 #wrap div */
	 #wrap{
	     /*width: 1200px;*/
	     margin: 0 auto;
	     /*border : 1px solid red;*/
	 }
	
	 #top_wrap{
	     width: 1200px;
	     height : 150px;
	     margin: 0 auto;
	     background-color: #212121;
	 }
	
	 .top_1{
	     display: inline-block;
	     width: 200px;
	     height: 150px;
	     background-color: #212121;
	 }
	
	
	
	 #content{
	     width: 1200px;
	     height : 800px;
	     margin: 0 auto;
	
	
	 }
	
	 .content_1{
	     display: inline-block;
	     vertical-align: top;
	     width : 200px;
	     height : 800px;
	     padding-top: 20px;
	     background-color: #323232;
	
	
	 }
	
	 .content_2{
	     display: inline-block;
	     vertical-align: top;
	     width : 880px;
	     height : 800px;
	     padding:20px 20px 40px 20px;
	
	 }
	
	
	
	 .menu {
	     width: 200px;
	     overflow: hidden;
	     margin: 20px auto;
	     padding: 0%;
	     
	 }
	
	 .menu > li {
	     width: 198px;
	     text-align: center; /*텍스트 중앙에 배치*/
	     line-height: 40px;
	     background-color: #323232;
	     list-style: none;
	
	 }
	
	
	 .menu a {
	     color: #fff;
	     text-decoration: none;
	     font-weight: bold;
	     display : block; /* 인라인 요소를 블럭요소로 바꿔줌 */
	 }
	
	 .menu a:hover {
	     color: #1a1a1a;
	     text-decoration: none;
	     
	 }
	
	
	 .submenu > li { /*게시글관리 - 공지관리/문의 게시글 관리*/
	     line-height: 50px;
	     background-color: #FFC145;
	     list-style: none;
	     
	 }
	
	 .submenu {
	     height: 0; /*ul의 높이를 안보이게 처리*/
	     overflow: hidden;
	     
	 }
	
	 .menu > li:hover {
	     background-color: #FFC145;
	     transition-duration: 0.5s;
	 }
	
	
	 .menu > li.post:hover .submenu {
	     height: 100px; /*서브메뉴 li한개의 높이 50*5*/
	     transition-duration: 1s;
	 }
	
	
	
	
	 .top_1 > h1{
	     color: #FFC145;
	     text-align: center;
	     line-height: 150px;
	 }
	
	
	
	 .menu .submenu{
	     padding-left: 0;
	 } 
	
	
	 /*-----------------------여기까지는 테두리------*/
	
	
	 /* -------------------------------------------*/
	
	 #content_2_box { /*컨텐트2 전체 div*/
	     width: 770px;
	     height: 690px;
	 }
	
	
	
	
	 /* -------------------------------------------*/
	 .date-area{
	     width: 100%;
	     height: 10%;
	     text-align: center;
	     padding: 20px;
	     color: white;
	 }
	 .date-area input{
	     width: 30%;
	 }
	
	 .screenList-area{
	     width: 100%;
	     height: 90%;
	 }
	 .screenList-area > div{
	     width: 100%;
	     height: 50%;
	     padding: 5% 5% 0 5%;
	     display:flex;
	     justify-content: space-between;
	     
	 }
	 .screenList-area > div > div{
	     width: 50%;
	     height: 100%;
	     position: relative;
	 }
	 .screenList-title{
	     position: absolute;
	     color: white;
	     font-size: 25px;
	     top: -40px;
	     left: 50%;
	     transform: translate(-50%, 0%);
	 }
	 .screenList input{
	     float: left;
	     display: block;
	     width: 50%;
	 }
	 .screenList select{
	     float: left;
	     display: block;
	     width: 50%;
	 }
	 #insertScreen-area{
	     text-align:center;
	     
	 }
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div id="wrap">

        <div id="top_wrap">
            <div class="top_1">
                <h1>관리자</h1>
            </div>

        </div>
        <div id="content">
            <div class="content_1">
                <ul class="menu">
                    <li>
                        <a href="${ path }/selectAdmin.mb">회원 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li>
                    <li>
                        <a href="${ path }/adminScreenList.admin">상영관 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="${ path }/adminMovieCheck.admin?currentPage=1">영화 관리</a>
                        <ul class="submenu" >

                        </ul>
                    </li>
                    <li>
                        <a href="${ path }/checkAdmin.cm">영화관 관리</a>
                        <ul class="submenu">

                        </ul>
                    </li> 
                    <li class="post">
                        <a href="#">게시글 관리</a>
                        <ul class="submenu">
                        <li><a href="${ path }/adminBoardCheck.admin?currentPage=1">공지 관리</a></li>
                        <li><a href="${ path }/adminQnACheck.admin?currentPage=1">문의 게시글 관리</a></li>
                        </ul>
                    </li>
                </ul>    
            </div>

            <!------------------------------------------------------------>

            <div class="content_2"><!--content_2 시작-->
                <div class="date-area">
                    <input type="date" id="today">
                </div>

                <div id="screenList-top">
                <c:choose>
                	<c:when test="${!empty list }">
                	<div class="row" id="screenList">
                		<c:forEach var="i" begin="1" end="4">
						    <div class="screenList col-sm-6" style="height: 250px; margin-top: 40px">
						        <c:set var="screenTitle" value="${i}관" />
						        <c:forEach var="s" items="${list}" >
						            <c:if test="${s.screenName == i}">
						                <div class="screenList-title">${screenTitle}</div>
						                <div>
						                    <select name="movie" id="${movieList[j].screenNo}">
						                        <option value="${s.movieNo}">${s.movieTitle}</option>
						                    </select>
						                </div>
						                <input type="time" value="${s.watchDate}">
						            </c:if>
						        </c:forEach>
						    </div>
						</c:forEach>

                	</div>
                	</c:when>
                	<c:otherwise>
                	<div class="row" id="screenList">
                		<c:forEach var="i" begin="1" end="4">
                			<div class="screenList col-sm-6" style="height: 250px; margin-top: 40px">
                			<div class="screenList-title">${ i }관</div>
                			
                			</div>
                		</c:forEach>
                	</div>
                	</c:otherwise>
                </c:choose>
                </div>
				<div id="insertScreen-area">
					<select id="screenName">
						<c:forEach var="i" begin="1" end="4">
							<option value="${ i }">${ i }관</option>
						</c:forEach>
						
					</select>
					<select id="selectMovie" >
						
					</select>
					<select id="watchTime">
						<option>01:00</option>
						<option>07:00</option>
						<option>10:00</option>
						<option>13:00</option>
						<option>16:00</option>
						<option>19:00</option>
						<option>21:00</option>
					</select>
					<button id="insertScreen">추가</button>
				</div>
            </div><!--content_2끝-->
        </div>

    </div>
	<script>
	const theaterNo = ${screen.theaterNo};
	let movieList = [];
	document.addEventListener('DOMContentLoaded', function() {
        var todayInput = document.getElementById('today');
        todayInput.value = '${screen.watchDate}';
    });
	window.onload = function() {
	    
	    $.ajax({
	    	url : 'movieList',
	    	type : 'get',
	    	success : function(result) {
	    		$('#selectMovie').empty();
	    		result.forEach(function(movie) {
	    	        $('#selectMovie').append('<option value="' + movie.movieNo + '">' + movie.movieTitle + '</option>');
	    	    });
	    	}
	    })
	    
	}

	$('#insertScreen').on('click',function(){
	    let $screenName = $('#screenName');
	    let $selectMovie = $('#selectMovie');
	    let $watchTime = $('#watchTime');
	    let $today = $('#today');
	     $.ajax({
	            url : 'insertScreen',
	            type : 'get',
	            data : {
	                screenName : $screenName.val(),
	                theaterNo : theaterNo,
	                movieNo : $selectMovie.val(),
	                watchTime : $watchTime.val(),
	                watchDate : $today.val()
	            },
	            success : function(result){
	                
	                if(result == 1){
	                    view($today);	
	                }else{
	                    alert('실패');
	                }
	                
	            }
	         });
	});
	
	$('#today').on('change' , function(){
	    let $today = $(this);
	    
	    view($today);
	              
	});


		function view(today) {
			console.log(today.val())
			$.ajax({
				url : 'selectDate',
				type : 'get',
				data : {
					watchDate : today.val(),
					theaterNo : theaterNo
				},
				success : function(result) {
					resultStr = '';
					for(let i=1;i<=4;i++){
						resultStr += '<div class="screenList col-sm-6" style="height: 250px; margin-top: 40px">';
							for(let j=0; j< result.length; j++){
								if(result[j].screenName == i){
									resultStr += '<div class="screenList-title">'+ i +'관</div>' +
												 '<div>' +
												 	'<select name="movie" >' + 
												 		'<option value="' + result[j].movideNo + '">' + result[j].movieTitle + '</option>'+
												 	'</select>' +
												 '</div>' +
												 '<input type="time" value="' + result[j].watchDate + '">';
								}
							}
					   resultStr += '</div>';
					}
					$('#screenList').html(resultStr);
				}

			});
		}
		
	</script>
	
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>