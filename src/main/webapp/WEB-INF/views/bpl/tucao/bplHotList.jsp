<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吐槽热点模块管理</title>
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
		<li class="active"><a href="${ctx}/tucao/bplHot/">吐槽热点模块列表</a></li>
		<shiro:hasPermission name="tucao:bplHot:edit"><li><a href="${ctx}/tucao/bplHot/form">吐槽热点模块添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bplHot" action="${ctx}/tucao/bplHot/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>id</th>
				<th>支持次数</th>
				<th>内容</th>
				<th>状态</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="tucao:bplHot:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bplHot">
			<tr>
				<td><a href="${ctx}/tucao/bplHot/form?id=${bplHot.id}">
					${bplHot.id}
				</a></td>
				<td>
					${bplHot.tucaoCount}
				</td>
				<td>
					${bplHot.content}
				</td>
				<td>
					${bplHot.status}
				</td>
				<td>
					<fmt:formatDate value="${bplHot.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${bplHot.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="tucao:bplHot:edit"><td>
    				<a href="${ctx}/tucao/bplHot/form?id=${bplHot.id}">修改</a>
					<a href="${ctx}/tucao/bplHot/delete?id=${bplHot.id}" onclick="return confirmx('确认要删除该吐槽热点模块吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>