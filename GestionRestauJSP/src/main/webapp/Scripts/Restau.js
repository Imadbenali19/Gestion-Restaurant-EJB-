$(document).ready(function() {
	$.ajax({
		url: 'RestauController',
		data: { op: "load" },
		type: 'POST',
		success: function(data) {
			remplir(data);
		}
	});


	$("#add").click(function() {
		if (($("#nom").val() != "" && $("#description").val() != "" && $("#lat").val() != "")) {
			var nom = $("#nom").val();
			var description = $("#description").val();
			var adresse = $("#adresse").val();
			var lat = $("#lat").val();
			var lon = $("#lon").val();
			var dateOpen = $("#dateOpen").val();
			var dateClose = $("#dateClose").val();
			var weekend = $("#weekend").val();
			var rank = $("#rank").val();
			var serie = $("#serie").val();
			var zone = $("#zone").val();
			var specialite = $("#specialite").val().toString();
			$.ajax({
				url: 'RestauController',
				data: { nom: nom, description: description, adresse: adresse, lat: lat, lon: lon, dateOpen: dateOpen, dateClose: dateClose, weekend: weekend, rank: rank, serie: serie, zone: zone, specialite: specialite },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					swal("Restaurant added successfully !", {
						icon: "success",
					});
					alert(textStatus);
					remplir(data);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					//alert(textStatus);
					alert(zone)
					console.log(textStatus);
				}
			});
		}
	});

	$("#yes").on("click", "#row", function() {
		var id = $(this).closest('tr').find('td').eq(0).text();
		var x = $(this).closest('tr').find('td').eq(12).text();
		$.ajax({
			url: 'RestauController',
			data: { op: "info", id: id },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {


				/*console.log(data.specialites)
				
				console.log(JSON.parse(x))
				x=JSON.parse(x);
				console.log(Array.isArray(x))
				var arr=x
				arr.forEach(element => {
					console.log(element.nom);
				});*/

				afficher(data);


			},
			error: function(jqXHR, textStatus, errorThrown) {
				//alert(textStatus);
				console.log(textStatus);
			}
		});

	});
	
	$("#yes").on("click", "#delete", function() {
		var id = $(this).closest('tr').find('td').eq(0).text();

		swal({
			title: "Are you sure?",
			text: "Do you want to delete this record !",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		})
			.then((willDelete) => {
				if (willDelete) {

					$.ajax({
						url: "RestauController",
						data: { op: "delete", id: id },
						type: 'POST',
						success: function(data) {
							swal("Restau deleted successfully !", {
								icon: "success",
							});
							remplir(data);
						},
						error: function(jqXHR, textStatus, errorThrown) {
							console.log(textStatus);
							swal("Error!", "Restau not deleted", "error");
						}
					});


				}
			});
	});

	$("#yes").on("click", "#update", function() {

		$("#nom").val("");
		$("#adresse").val("");
		$("#description").val("");
		$("#lat").val("");
		$("#lon").val("");
		$("#rank").val("");

		var id = $(this).closest('tr').find('td').eq(0).text();
		var nom2 = $(this).closest('tr').find('td').eq(1).text();
		var adresse2 = $(this).closest('tr').find('td').eq(2).text();
		var lat2 = $(this).closest('tr').find('td').eq(3).text();
		var lon2 = $(this).closest('tr').find('td').eq(4).text();
		var description2 = $(this).closest('tr').find('td').eq(5).text();
		var date_open2 = $(this).closest('tr').find('td').eq(6).text();
		var date_close2 = $(this).closest('tr').find('td').eq(7).text();
		var weekend2 = $(this).closest('tr').find('td').eq(8).text();
		var rank2 = $(this).closest('tr').find('td').eq(9).text();
		var serie2 = $(this).closest('tr').find('td').eq(10).text();
		var zone2 = $(this).closest('tr').find('td').eq(11).text();
		var spec2 = $(this).closest('tr').find('td').eq(12).text();

		spec2 = JSON.parse(spec2);
		//console.log(Array.isArray(x))
		var arr = spec2


		console.log("serie : " + serie2)
		console.log("zone : " + zone2)
		swal({
			title: "Are you sure?",
			text: "Do you want to update this record !",
			icon: "warning",
			buttons: true,
			dangerMode: true,
		})


			.then((willDelete) => {
				if (willDelete) {
					$("#nom").val(nom2);
					$("#adresse").val(adresse2);
					$("#description").val(description2);
					$("#lat").val(lat2);
					$("#lon").val(lon2);
					$("#rank").val(rank2);
					$("#zone").val(zone2);
					$("#weekend").val(weekend2);
					$("#serie").val(serie2);
					$("#dateOpen").val(date_open2);
					$("#dateClose").val(date_close2);
					const e = [];
					arr.forEach(element => {
						console.log("element sel 1 : " + element.nom);
						e.push(element.nom);

					});
					$("#specialite").val(e);

					$("#edit").removeAttr("hidden");
					$("#add").hide();

					$("#edit").click(function() {
						if (($("#nom").val() != "" && $("#description").val() != "" && $("#lat").val() != "" && $("#lon").val() != "")) {

							var nom = $("#nom").val();
							var description = $("#description").val();
							var adresse = $("#adresse").val();
							var lat = $("#lat").val();
							var lon = $("#lon").val();
							var dateOpen = $("#dateOpen").val();
							var dateClose = $("#dateClose").val();
							var weekend = $("#weekend").val();
							var rank = $("#rank").val();
							var serie = $("#serie").val();
							var zone = $("#zone").val();
							var specialite = $("#specialite").val().toString();

							$.ajax({

								url: "RestauController",
								data: { op: "update", id: id,nom: nom, description: description, adresse: adresse, lat: lat, lon: lon, dateOpen: dateOpen, dateClose: dateClose, weekend: weekend, rank: rank, serie: serie, zone: zone, specialite: specialite },
								type: 'POST',
								success: function(data) {
									swal("Restau updated successfully !", {
										icon: "success",
									});
									remplir(data);
								},
								error: function(jqXHR, textStatus, errorThrown) {
									console.log(textStatus);
									swal("Error!", "Machine not added", "error");
								}
							});
						}
					});
				}
			});
	});



});


function remplir(data) {
	var ligne = "";
	data.forEach(e => {
		ligne += "<tr id='row'><td>" + e.id + "</td><td>" + e.nom + "</td><td>" + e.adresse + "</td><td>" + e.lat + "</td><td>" + e.lon + "</td><td>" + e.description + "</td><td>" + e.date_open + "</td><td>" + e.date_close + "</td><td>" + e.weekend + "</td><td>" + e.rank + "</td><td>" + e.serie?.nom + "</td><td>" + e.zone?.nom + "</td><td>" + JSON.stringify(e.specialites) + "</td><td><bouton class='btn btn-warning btn-icon-split' id='update' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-exclamation-triangle'></i></span><span class='text'>Modifier</span></bouton></td><td><button class='btn btn-danger btn-icon-split' id='delete' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-trash'></i></span><span class='text'>Supprimer</span></button></td><td><form action='upload' method='post' enctype='multipart/form-data'><input type='text' name='Nom' value=" + e.id + " ><input type='text' name='webUrl' placeholder='Coller un web url image' /><input type='file' name='file'><input type='submit' value='upload' /></form></td></tr>";
	});
	//alert(ligne);		
	//swal("Good job!", "User added successfully!", "success");																														
	$("#yes").html(ligne);
}

function afficher(data) {
	var ligne = data.specialites;

	$("#aff").html(JSON.stringify(ligne));
}