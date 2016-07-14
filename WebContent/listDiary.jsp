<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="pagination" class="com.wxyseu.tools.MyPagination" scope="session"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>浏览seu-lab日记</title>
	<style>	@import url("css/list_style.css");</style>
	
</head>
<body>			
	<div id="container">
		<div id="my-header">
			<table>
			<tr>
			<td><ul>
				<li><c:if test="${!empty sessionScope.userName}">		
						<b>${sessionScope.userName} 欢迎使用Lab日记本</b>
					</c:if>
					<c:if test="${empty sessionScope.userName}">		
						<b> &nbsp; 欢迎光临Lab日记网！</b>
					</c:if>
				</li>
				<li>写心情 | 我的日记 | <a href="UserServlet?action=exit">[退出登录]</a></li>
			</ul></td>
			<td><iframe style="padding-left: 50px;" width="280" scrolling="no" height="25" frameborder="0" allowtransparency="true" 
			src="http://i.tianqi.com/index.php?c=code&id=34&icon=1&num=3"></iframe></td>
			</tr>
			</table>
		</div>
		<div id="leftbox">
			<ul>
				<li style="height: 2em;background-color: rgba(255,250,250,0.8);border: 1px solid #000000;"><p>个人中心</p></li>
				<li><p>日记管理</p></li>
				<li><p>账号管理</p></li>
				<li><p>装扮管理</p></li>
				<li><p>用户设置</p></li>
			</ul>
		</div>
		<div id="rightbox">
			<div id="write">
				<p>今天有什么新鲜事(｡◕‿◕｡)</p>
				<form id="form-write" name="write" method="post" action="DiaryServlet?action=publish">
				<textarea id="writearea" placeholder="一次只能写200个字喲" required="required" name="note" rows="6" wrap="soft"></textarea>
				<br><input id="submitNote" type="submit" value="发布"/></form>
			</div>
			<div id="showdiary">
				<c:if test="${empty requestScope.diaryList}"><div id="nodiary">快写下第一个心情吧</div></c:if> 				
				<c:if test="${!empty requestScope.diaryList}">
				<c:forEach items="${requestScope.diaryList}" var="diaryList" varStatus="id">
				<br>
					<div class="diary">
						<div class="diary-title"><span class="title-name">${diaryList.username}</span>&nbsp;发表于：${diaryList.timeString}&nbsp;
						<a href="DiaryServlet?action=delDiary&id=${diaryList.id}&url=${requestScope.url}">[删除]</a>
						</div>
						<div class="diary-text">${diaryList.text}</div>
					</div>
				</c:forEach>
				</c:if>
				<c:if test="${!empty requestScope.diaryList}">
					<div id="page-nav">
						 <%=pagination.printCtrl(Integer.parseInt(request.getAttribute("Page").toString()),"DiaryServlet?action="+request.getAttribute("url"),"")%> 
					</div>
				</c:if>
			</div>
		</div>
		<div id="my-footer">
			<ul>
				<li>技术服务邮箱：txyluowxy@163.com</li>
				<li>Copyright &copy;2016 东南大学 复杂数据实验室</li>
				<li><audio controls="controls" loop="loop">
					<source src="sources/skycity.mp3" type="audio/mpeg"/>	
				</audio></li>
			</ul>
		</div>
	</div>	
</body>
</html>