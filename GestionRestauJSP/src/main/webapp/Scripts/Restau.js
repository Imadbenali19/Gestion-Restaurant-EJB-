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
		if (($("#nom").val() != "" && $("#description").val() != "" && $("#latitude").val() != "")) {
			var nom = $("#nom").val();
			var description = $("#description").val();
			var lat = $("#lat").val();
			var lon = $("#lon").val();
			var dateOpen = $("#dateOpen").val();
			var dateClose = $("#dateClose").val();
			var weekend = $("#weekend").val();
			var rank = $("#rank").val();
			$.ajax({
				url: 'RestauController',
				data: { nom: nom, description: description, lat: lat, lon: lon, dateOpen: dateOpen,dateClose: dateClose, weekend: weekend, rank: rank },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					swal("Restaurant added successfully !", {
						icon: "success",
					});
					remplir(data);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					alert(textStatus);
					console.log(textStatus);
				}
			});
		}
	});


});


function remplir(data) {
	var ligne = "";
	data.forEach(e => {
		ligne += "<tr><td>" + e.id + "</td><td>" + e.nom + "</td><td>" + e.lat + "</td><td>" + e.lon + "</td><td>" + e.description + "</td><td>" + e.date_open + "</td><td>" + e.date_close + "</td><td>" + e.weekend + "</td><td>" + e.rank + "</td><td><bouton class='btn btn-warning btn-icon-split' id='update' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-exclamation-triangle'></i></span><span class='text'>Modifier</span></bouton></td><td><bouton class='btn btn-danger btn-icon-split' id='delete' val=" + e.id + "><span class='icon text-white-50'><i class='fas fa-trash'></i></span><span class='text'>Supprimer</span></bouton></td></tr>";
	});
	//alert(ligne);		
	//swal("Good job!", "User added successfully!", "success");																														
	$("#yes").html(ligne);
}


function formatDate(date) {
	var d = new Date(date),
		month = '' + (d.getMonth() + 1),
		day = '' + d.getDate(),
		year = d.getFullYear();

	if (month.length < 2)
		month = '0' + month;
	if (day.length < 2)
		day = '0' + day;

	return [year, month, day].join('-');
}
