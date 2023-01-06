$(document).ready(function() {
	$.ajax({
		url: 'RestauController',
		data: { op: "load" },
		type: 'POST',
		success: function(data) {
			alert("ho"+data.id)
			remplir(data)
		}
	});


	function remplir(data) {
		var ligne = "";
		data.forEach(e => {
			ligne += "<tr><td>" + e.id + "</td><td>" + e.nom + "</td><td>" + e.lat + "</td><td>" + e.lon + "</td><td>" + e.description + "</td><td>" + e.date_open  + "</td><td>" + e.date_close  + "</td><td>" + e.weekend  + "</td><td>" + e.rank + "</td><td><bouton class='btn btn-warning btn-icon-split' id='update' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-exclamation-triangle'></i></span><span class='text'>Modifier</span></bouton></td><td><bouton class='btn btn-danger btn-icon-split' id='delete' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-trash'></i></span><span class='text'>Supprimer</span></bouton></td></tr>";
		});
		//alert(ligne);		
		//swal("Good job!", "User added successfully!", "success");																														
		$("#yes").html(ligne);
	}
});