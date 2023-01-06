$(document).ready(function() {
	$.ajax({
		url: 'PhotoController',
		data: { op: "load" },
		type: 'POST',
		success: function(data) {
			remplir(data);
		}
	});





	function remplir(data) {
		var ligne = "";
		data.forEach(e => {
			ligne += "ahh";

		});
		//alert(ligne);		
		//swal("Good job!", "User added successfully!", "success");																														
		$("#oh").html(ligne);
	}
});
