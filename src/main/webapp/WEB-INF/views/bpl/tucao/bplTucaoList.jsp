<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吐槽流水记录管理</title>
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
		<li class="active"><a href="${ctx}/tucao/bplTucao/">吐槽流水记录列表</a></li>
		<shiro:hasPermission name="tucao:bplTucao:edit"><li><a href="${ctx}/tucao/bplTucao/form">吐槽流水记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bplTucao" action="${ctx}/tucao/bplTucao/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
				<form:input path="userid" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>内容</th>
				<th>昵称</th>
				<th>性别</th>
				<th>热点ID</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="tucao:bplTucao:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bplTucao">
			<tr>
				<td><a href="${ctx}/tucao/bplTucao/form?id=${bplTucao.id}">
					${bplTucao.content}
				</a></td>
				<td>
					${bplTucao.nickName}
				</td>
				<td>
					${bplTucao.gender}
				</td>
				<td>
					${bplTucao.hotid}
				</td>
				<td>
					<fmt:formatDate value="${bplTucao.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${bplTucao.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="tucao:bplTucao:edit"><td>
    				<a href="${ctx}/tucao/bplTucao/form?id=${bplTucao.id}">修改</a>
					<a href="${ctx}/tucao/bplTucao/delete?id=${bplTucao.id}" onclick="return confirmx('确认要删除该吐槽流水记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>