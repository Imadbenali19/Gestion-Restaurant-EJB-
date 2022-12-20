$(document).ready(function() {
	$.ajax({
		url: 'ZoneController',
		data: { op: "load" },
		type: 'POST',
		success: function(data) {
			remplir(data);
		}
	});


	$("#add").click(function() {
		if (($("#nom").val() != "")) {
			var nom = $("#nom").val();
			var ville = $("#ville").val();
			$.ajax({
				url: 'ZoneController',
				data: { nom: nom, ville: ville },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					swal("Zone added successfully !", {
						icon: "success",
					});
					remplir(data);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					alert(textStatus);
					alert(ville)
					console.log(textStatus);
				}
			});
		}
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
						url: "ZoneController",
						data: { op: "delete", id: id },
						type: 'POST',
						success: function(data) {
							swal("Zone deleted successfully !", {
								icon: "success",
							});
							remplir(data);
						},
						error: function(jqXHR, textStatus, errorThrown) {
							console.log(textStatus);
							swal("Error!", "Zone not deleted", "error");
						}
					});


				}
			});
	});

	$("#yes").on("click", "#update", function() {
		console.log("yy")
		$("#nom").val("");
		

		var id = $(this).closest('tr').find('td').eq(0).text();
		var nom2 = $(this).closest('tr').find('td').eq(1).text();
		var ville2 = $(this).closest('tr').find('td').eq(2).text();


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
					$("#ville").val(ville2);
					

					$("#edit").removeAttr("hidden");
					$("#add").hide();

					$("#edit").click(function() {
						if (($("#nom").val() != "")) {

							var nom = $("#nom").val();
							var ville = $("#ville").val();

							$.ajax({

								url: "ZoneController",
								data: { op: "update", id: id, nom: nom, ville: ville },
								type: 'POST',
								success: function(data) {
									swal("Zone updated successfully !", {
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
		ligne += "<tr><td>" + e.id + "</td><td>" + e.nom + "</td><td>" + e?.ville?.nom + "</td><td><bouton class='btn btn-warning btn-icon-split' id='update' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-exclamation-triangle'></i></span><span class='text'>Modifier</span></bouton></td><td><bouton class='btn btn-danger btn-icon-split' id='delete' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-trash'></i></span><span class='text'>Supprimer</span></bouton></td></tr>";
	});
	//alert(ligne);		
	//swal("Good job!", "User added successfully!", "success");																														
	$("#yes").html(ligne);
}
