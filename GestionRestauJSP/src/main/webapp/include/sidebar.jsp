<%-- <%


if(session.getAttribute("login")!=null){

%> --%>
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="index.jsp">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fa fa-cogs"></i>
		</div>
		<div class="sidebar-brand-text mx-3">Gestion Restaurants</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item"><a class="nav-link" href="index.jsp"> <i
			class="fa fa-beer"></i> <span>Restaurants</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Gestion</div>


	<!-- Nav Item  -->
	<li class="nav-item ">
		<%-- <% if(session.getAttribute("login").equals("admin")){ %>
				<a class="nav-link" href="userAdmin.jsp">
		
				<i class="fas fa-fw fa-user-alt"></i> <span>Utilisateur</span>
				<% } %>
		</a> --%>
	</li>

	<!-- Nav Item  -->
	<li class="nav-item "><a class="nav-link"
		href="serieManagement.jsp"> <i class="fa fa-server"></i> <span>Serie</span>
	</a></li>

	<!-- Nav Item  -->
	<li class="nav-item "><a class="nav-link"
		href="specialiteManagement.jsp"> <i class="fas fa-hamburger"></i>
			<span>Specialite</span>
	</a></li>
	
	<!-- Nav Item  -->
	<li class="nav-item "><a class="nav-link"
		href="villeManagement.jsp"> <i class="fas fa-city"></i>
			<span>Ville</span>
	</a></li>
	
	<!-- Nav Item  -->
	<li class="nav-item "><a class="nav-link"
		href="zoneManagement.jsp"> <i class="fa fa-map-marker"></i>
			<span>Zone</span>
	</a></li>


	<!-- Divider -->
	<hr class="sidebar-divider">

	<!-- Heading -->
	<!-- <div class="sidebar-heading">Opérations supplémentaires</div> -->

	<!-- Nav Item - Pages Collapse Menu -->
	<!-- Nav Item  -->


	<!-- <li class="nav-item"><a class="nav-link" href="#"
		data-toggle="collapse" data-target="#collapseTwo"
		aria-expanded="false" aria-controls="collapseTwo"> <i
			class="fas fa-search"></i> <span>Chercher</span>
	</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar" style="">
			<div class="bg-white py-2 collapse-inner rounded">
				<h6 class="collapse-header">Search options:</h6>
				<a class="collapse-item" href="searchAdmin.jsp">Machines par
					dates</a> <a class="collapse-item" href="searchAdmin2.jsp">Machines
					par salle</a>
			</div>
		</div></li> -->


	<!-- Nav Item - Charts -->
	<!-- <li class="nav-item"><a class="nav-link" href="chartsAdmin.jsp">
			<i class="fas fa-fw fa-chart-bar"></i> <span>Statistiques</span>
	</a></li> -->

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>


</ul>


