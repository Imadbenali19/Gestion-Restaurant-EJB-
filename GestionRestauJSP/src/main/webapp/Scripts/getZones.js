$(document).ready(function() {
	$.ajax({
		url: 'ZoneController',
		data: { op: "load" },
		type: 'POST',
		success: function(data) {
			remplir(data);
		}
	});





	function remplir(data) {
		var ligne = "";
		data.forEach(e => {
			$("#zone").append("<option value='" + e.nom + "'>" + e.nom + "</option>");
			//$("#zone").append('<option value=' + e.nom + '>' + e.nom + '</option>');
			//ligne +=`<option value=`+e.nom+`>`+e.nom+`</option>`;
		});
		//alert(ligne);		
		//swal("Good job!", "User added successfully!", "success");																														
		//$("#zone").html(ligne);
	}
});
