$(document).ready(function() {
	$.ajax({
		url: 'VilleController',
		data: { op: "load" },
		type: 'POST',
		success: function(data) {
			alert("yes")
			remplir(data);
		}
	});


});


function remplir(data) {
	var ligne = "";
	data.forEach(e => {
		
		ligne += "e.nom";
	});
	//alert(ligne);		
	//swal("Good job!", "User added successfully!", "success");																														
	$("#hoo").html(ligne);
}
