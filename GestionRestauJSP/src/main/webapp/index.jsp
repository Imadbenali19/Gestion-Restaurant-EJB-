<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="ma.metier.RestaurantEJBImpl"%>
<%@page import="ma.entites.Restaurant"%>
<%@page import="ma.metier.RestaurantLocal"%>
<%@page import="javax.ejb.EJB"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion restaurants</title>
<%@ include file="/include/head.jsp"%>

</head>
<body id="page-top">

	<div id="wrapper">
		<%@ include file="/include/sidebar.jsp"%>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<%@ include file="/include/header.jsp"%>

				<!-- ---------------------------------------------------------------------------------------------- -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Gestion des restaurants</h1>

					</div>

					<div class="p-5">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">Add an restaurant!</h1>
						</div>
						<form id="form1" class="user" enctype="multipart/form-data">
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label>nom</label> <input type="text"
										class="form-control form-control-user" id="nom" name="nom"
										placeholder="Nom" onchange="" required="required"> <span
										id="s1"></span>
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label>Description</label> <input type="text"
										class="form-control form-control-user" id="description"
										name="description" placeholder="Description" onchange=""
										required="required"> <span id="s2"></span>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 mb-3 mb-sm-0">
									<label for="adresse">Adresse</label> <input type="text"
										class="form-control form-control-user" id="adresse"
										name="adresse" placeholder="Adresse" onchange=""
										required="required">
								</div>

							</div>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label>Latitude</label> <input type="number"
										class="form-control form-control-user" id="lat" name="lat"
										placeholder="Longitude" onchange="" required="required">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label>Longitude</label> <input type="number"
										class="form-control form-control-user" id="lon" name="lon"
										placeholder="Longitude" onchange="" required="required">
								</div>
							</div>

							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label>Date d'ouverture</label> <input type="time"
										class="form-control form-control-user" id="dateOpen"
										name="dateOpen">
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label>Date de fermeture</label> <input type="time"
										class="form-control form-control-user" id="dateClose"
										name="dateClose">
								</div>

							</div>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="weekend">Weekend</label> <select id="weekend"
										name="weekend" class=" custom-select"
										style="border-radius: 10rem; height: calc(1.5em + .75rem + 13px);">
										<option value="true">TRUE</option>
										<option value="false">FALSE</option>
									</select>
								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="rank">Rank</label> <input type="number"
										class="form-control form-control-user" placeholder="Rank"
										id="rank" name="rank">
								</div>

							</div>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="serie">Serie(Nom)</label> <select id="serie"
										name="serie" class=" custom-select"
										style="border-radius: 10rem; height: calc(1.5em + .75rem + 13px);">

									</select>

								</div>
								<div class="col-sm-6 mb-3 mb-sm-0">
									<label for="zone">Zone(Nom)</label> <select id="zone"
										name="zone" class="custom-select"
										style="border-radius: 10rem; height: calc(1.5em + .75rem + 13px);">

									</select>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-12 mb-3 mb-sm-0">
									<label for="specialite">Specialite(Nom)</label> <select
										id="specialite" name="specialite" class="custom-select"
										style="border-radius: 2rem; height: calc(4.5em + .75rem + 29px);"
										multiple>


									</select>
								</div>

							</div>
							<!-- <div class="form-group row">
								<div class="col-sm-12 mb-3 mb-sm-0">
									
									<input type="file"
										class="form-control form-control-user" 
										id="image" name="image">
								</div>

							</div> -->


							<!-- <input type="submit" class="btn btn-info btn-user btn-block" value="Add" id="add" onclick="valid()">-->
							<!-- <input type="submit" class="btn btn-info btn-user btn-block" value="Update" id="edit" onclick="valid()" hidden>-->
							<a href="" class="btn btn-info btn-user btn-block" id="add"
								onclick="valid()">Add</a> <a href=""
								class="btn btn-info btn-user btn-block" id="edit"
								onclick="valid()" hidden>Update</a>
						</form>

						<hr>




					</div>

					<!-- ---------------------------------------------------------------------------------------------- -->

					<h1 class="h3 mb-2 text-gray-800">Table</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Restaurants
								Table</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Id</th>
											<th>Nom</th>
											<th>Adresse</th>
											<th>Latitude</th>
											<th>Longitude</th>
											<th>Description</th>
											<th>Date d'ouverture</th>
											<th>Date de fermeture</th>
											<th>Weekend</th>
											<th>Rank</th>
											<th>Serie</th>
											<th>Zone</th>
											<th>Specialites</th>
											<th>Action 1</th>
											<th>Action 2</th>
											<th>Action 3</th>


										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>Id</th>
											<th>Nom</th>
											<th>Adresse</th>
											<th>Latitude</th>
											<th>Longitude</th>
											<th>Description</th>
											<th>Date d'ouverture</th>
											<th>Date de fermeture</th>
											<th>Weekend</th>
											<th>Rank</th>
											<th>Serie</th>
											<th>Zone</th>
											<th>Specialites</th>
											<th>Action 1</th>
											<th>Action 2</th>
											<th>Action 3</th>


										</tr>
									</tfoot>
									<tbody id="yes">


									</tbody>
								</table>



							</div>
						</div>
					</div>



					<fieldset>
						<legend align="center">Informations sur le restau:</legend>
						<div id="aff" class="card shadow"></div>
					</fieldset>


				</div>
				<%@ include file="/include/footer.jsp"%>
			</div>
		</div>
		<%@ include file="/include/scriptsPath.jsp"%>
		<%-- <script
			src="<%=request.getContextPath()%>/validationsJS/validation3.js"></script>--%>
		<script src="<%=request.getContextPath()%>/Scripts/getZones.js"></script>
		<script src="<%=request.getContextPath()%>/Scripts/getSeries.js"></script>
		<script src="<%=request.getContextPath()%>/Scripts/getSpecialites.js"></script>
		<script src="<%=request.getContextPath()%>/Scripts/Restau.js"></script>

		
</body>
<script type="text/javascript">
	document.getElementsByClassName('nav-item')[0].className += " active";
</script>
<!-- <script type="text/javascript">
	document.getElementsByClassName('nav-item')[3].className += " active";

	document.getElementById("dateAchat").value = formatDate(new Date());
	function formatDate(date) {
		var d = new Date(date), month = '' + (d.getMonth() + 1), day = ''
				+ d.getDate(), year = d.getFullYear();

		if (month.length < 2)
			month = '0' + month;
		if (day.length < 2)
			day = '0' + day;

		return [ year, month, day ].join('-');
	}
</script> -->


</html>