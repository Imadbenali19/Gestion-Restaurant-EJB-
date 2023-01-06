$(document).ready(function() {
	$.ajax({
		url: 'SerieController',
		data: { op: "load" },
		type: 'POST',
		success: function(data) {
			remplir(data);
		}
	});





	function remplir(data) {
		var ligne = "";
		data.forEach(e => {
			$("#serie").append("<option value='" + e.nom + "'>" + e.nom + "</option>");
		});
		
		//alert(ligne);		
		//swal("Good job!", "User added successfully!", "success");																														
		//$("#serie").html(ligne);
	}
});
