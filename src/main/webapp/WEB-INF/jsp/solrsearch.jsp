<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Solr Search</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="is-loading">

	<!-- Wrapper -->
	<div id="wrapper" class="fade-in">

		<!-- Header -->
		<header id="header">
			<a href="http://localhost:8080/solrsearch" class="logo">Solr Search</a>
		</header>

		<nav id="nav">
			<ul class="links">
				<li><a href="index.html">This is Massively</a></li>
				<li><a href="generic.html">Generic Page</a></li>
				<li class="active"><a href="elements.html">Elements
						Reference</a></li>
				<li><a href="http://localhost:8080/solrsearch">Solr Search</a></li>
			</ul>
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
			</ul>
		</nav>

		<div id="main">
			<section class="post">
				<form method="post" action="" class="alt">
					<div class="row uniform">
						<div class="10u 12u$(xsmall)">
							<input type="text" name="search_query" id="search_query" value=""
								placeholder="Search" />
						</div>

						<div class="2u 12u$(xsmall)">
							<input type="button" id="searchBtn" value="Search"
								class="special" />
						</div>
					</div>
					<br>
					<div class="table-wrapper">
						<table>
							<thead>
								<tr>
									<th>코드</th>
									<th>이름</th>
									<th>금액</th>
								</tr>
							</thead>
							<tbody id="searchTab">
								<%-- <c:forEach var="listview" items="${listview}" varStatus="status">
									<c:url var="link" value="board4Read">
										<c:param name="brdno" value="${listview.id}" />
									</c:url>
									<tr>
										<td><c:out value="${listview.id}" /></td>
										<td
											style="max-width: 100px; border: 1px solid black; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
											<a href="${link}"><c:out value="${listview.title}" /></a>
										</td>
										<td><c:out value="${listview.writer}" /></td>
										<td><c:out value="${listview.date}" /></td>
									</tr>
								</c:forEach> --%>

							</tbody>
							<!-- <tfoot>
								<tr>
									<td colspan="2"></td>
									<td>100.00</td>
								</tr>
							</tfoot> -->
						</table>
					</div>
				</form>
			</section>
		</div>
	</div>
	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

	<script type="text/javascript">
		$("#searchBtn").click(
				function() {
					$("#searchTab").empty();
					
					var search_query = $("#search_query").val();
					if (search_query == "") {
						search_query = "*:*";
					}

					console.log(search_query);

					$.ajax({
						//url:'http://13.124.168.194:8983/solr/solr_test/select?',
						url : 'http://localhost:8080/solrSearchBtnClick',
						method : 'post',
						data : {
							"q" : search_query
						},
						dataType : 'json',
						success : function(data) {
							console.log(data.listview);
							console.log(data.listview.length);
							var str = "";
							$.each(data.listview, function(key, value) {
								str += "<tr>" 
										+ "<td>" + value.id + "</td>" 
										+ "<td>" + value.prod_nm + "</td>" 
										+ "<td>" + value.fix_amt + "</td>" 
									+ "</tr>";
							});
							
							$("#searchTab").append(str);
						},
						error : function(request, status, error) {
							console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
						}
					});
				});
		/*
		http://localhost:8983/solr/techproducts/select?q=id:SP2514N
		$('#execute').click(function(){
		    $.ajax({
		        url:'./time3.php',
		        dataType:'json',
		        success:function(data){
		            var str = '';
		            for(var name in data){
		                str += '<li>'+data[name]+'</li>';
		            }
		            $('#timezones').html('<ul>'+str+'</ul>');
		        }
		    })
		})
		 */
	</script>
</body>
</html>