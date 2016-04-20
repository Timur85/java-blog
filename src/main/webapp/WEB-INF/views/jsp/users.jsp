<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>		
</head>

<script type="text/javascript">
	$( document ).ready(function() {
		$('.tiggerRemove').click(function (e) {
			e.preventDefault();
			$("#modalRemove.removeBtn").attr("href", $(this).attr("href"));
			$("#modalRemove").modal();
		});
	});
</script>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Username</th>
			<th>operation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}"> 
			<tr>
				<td>
					<a href="<spring:url value="/users/${user.id}" />">
						<c:out value="${user.name}" />
					</a>
				</td>
				<td>
					<a href="<spring:url value="/users/remove/${user.id}" />" class="btn btn-danger">
						remove
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove blog</h4>
      </div>
      <div class="modal-body">
        Realy remove?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class="btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>

