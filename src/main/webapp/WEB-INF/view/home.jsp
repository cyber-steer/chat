<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.UserDto"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <style>
        /* 네비게이션 바 스타일 */
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: black;
  color: white;
  padding: 10px;
}

.nav-section {
  font-size: 20px;
}

/* 나눠진 섹션 스타일 */
.container {
  display: flex;
  height: 100vh;
}

.left-section,
.right-section,
.mid-section {
  flex: 1;
  display: flex;
  justify-content: center;
  /* align-items: center; */
}

.left-section {
    background-color: #333; /* 진한 회색으로 변경 */
    color: white; /* 텍스트 색상 변경 */
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
}

.left-section .upper-left {
    display: flex;
    align-items: center;
    margin-bottom: 10px; /* 요소들 사이에 여백 추가 */
}

.lower-left{
    flex:1;
}
.left-section input {
    padding: 8px;
    margin-right: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
}

.left-section button {
    padding: 8px 15px;
    background-color: #4682B4;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
}

.mid-section {
  flex: 2;
  display: flex;
  flex-direction: column;
}
.chat-content {
  padding: 10px;
  background-color: #666; /* 중간 회색으로 변경 */
  flex: 1; /* 채팅 내용 영역이 최대한 확장되도록 설정 */
}

.left-section {
    background-color: #333; /* 진한 회색으로 변경 */
    color: white; /* 텍스트 색상 변경 */
}

.right-section {
    background-color: #333; /* 진한 회색으로 변경 */
}

.mid-section {
    background-color: #f5f5f5; /* 연한 회색으로 변경 */
}

.mid-section {
  position: relative; /* mid-section을 상대적으로 설정 */
}

/* 입력창 스타일 */
.chat-input-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  background-color: #f1f1f1;
  position: fixed; /* 화면 아래에 고정 */
  bottom: 0; /* 화면 하단에 위치 */
  /* width: 100%; */
}

.chat-input-section input {
  flex: 1;
  padding: 8px;
  margin-right: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
}

.chat-input-section button {
  padding: 8px 15px;
  background-color: #4682B4;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
}

.chat-input-section button:hover {
  background-color: #6495ED;
}

/* 반응형 - 모바일 화면에서 세로로 배열 */
@media screen and (max-width: 768px) {
  .container {
    flex-direction: column;
  }
}

    </style>
<body>
    
    <div class="navbar">
        <div class="nav-section">
            <%out.println("네비게이션 바"); %>
            <a href="logout.do">로그아웃</a>
        </div>
    </div>
    <div class="container">
        <div class="left-section">
            <div class="upper-left">
                <form action="friendInsert.do" method="post">
                <input type="text" name="friendID" placeholder="새로운 친구 추가">
                <button>추가</button>
                </form>
            </div>
            <div class="lower-left">
                <%out.println("친구목록"); %>
                <c:forEach var='dto' items='${friendsDtos}'>
					<div>
				        <form action="roomSelect.do" method="post">
				            <input type="hidden" name="friendID" value="${dto.id}">
				            <button type="submit">${dto.name}</button>
				        </form>
					</div>
				</c:forEach>
            </div>
        </div>
        
        <div class="mid-section">
            <!-- 채팅 내용을 표시하는 부분 -->
            <div class="chat-content">
                <%out.println("채팅 내용 표시 영역"); %>
            </div>
            
            <!-- 메시지 입력창 -->
            <div class="chat-input-section">
                <input type="text" placeholder="메시지 입력">
                <button>전송</button>
            </div>
        </div>
    
        <div class="right-section">
            <%out.println("채팅방목록"); %>
        </div>
    </div>
    </div>
</div>
</body>
</html>