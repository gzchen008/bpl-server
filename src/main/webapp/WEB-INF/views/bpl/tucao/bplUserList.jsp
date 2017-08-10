<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/tucao/bplUser/">用户列表</a></li>
		<shiro:hasPermission name="tucao:bplUser:edit"><li><a href="${ctx}/tucao/bplUser/form">用户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bplUser" action="${ctx}/tucao/bplUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>openid：</label>
				<form:input path="openid" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>nick_name：</label>
				<form:input path="nickName" htmlEscape="false" maxlength="127" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>openid</th>
				<th>nick_name</th>
				<th>avatar_url</th>
				<th>gender</th>
				<th>country</th>
				<th>province</th>
				<th>city</th>
				<th>create_time</th>
				<shiro:hasPermission name="tucao:bplUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bplUser">
			<tr>
				<td><a href="${ctx}/tucao/bplUser/form?id=${bplUser.id}">
					${bplUser.openid}
				</a></td>
				<td>
					${bplUser.nickName}
				</td>
				<td>
					${bplUser.avatarUrl}
				</td>
				<td>
					${bplUser.gender}
				</td>
				<td>
					${bplUser.country}
				</td>
				<td>
					${bplUser.province}
				</td>
				<td>
					${bplUser.city}
				</td>
				<td>
					<fmt:formatDate value="${bplUser.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="tucao:bplUser:edit"><td>
    				<a href="${ctx}/tucao/bplUser/form?id=${bplUser.id}">修改</a>
					<a href="${ctx}/tucao/bplUser/delete?id=${bplUser.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>