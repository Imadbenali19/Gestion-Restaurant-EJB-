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
			var ville=$("#ville").val();
			$.ajax({
				url: 'ZoneController',
				data: { nom: nom,ville: ville},
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


});


function remplir(data) {
	var ligne = "";
	data.forEach(e => {
		ligne += "<tr><td>" + e.id + "</td><td>" + e.nom + "</td><td>" + e.ville.nom + "</td><td><bouton class='btn btn-warning btn-icon-split' id='update' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-exclamation-triangle'></i></span><span class='text'>Modifier</span></bouton></td><td><bouton class='btn btn-danger btn-icon-split' id='delete' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-trash'></i></span><span class='text'>Supprimer</span></bouton></td></tr>";
	});
	//alert(ligne);		
	//swal("Good job!", "User added successfully!", "success");																														
	$("#yes").html(ligne);
}
