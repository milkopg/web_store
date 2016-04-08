function submitter(btn) {
    var param = btn.id;
    var rowId;
    var myForm = document.forms["cartForm"];
    myForm.elements["productId"].value = param;
    
    if (myForm.elements["rowIndex"] != undefined) {
    	myForm.elements["rowIndex"].value = $(btn).closest('tr').index()-1;
    }
    
    myForm.submit();
}

function getRowIndex (td) {
	 var row_index = $(this).parent().index();
	 var col_index = $(this).index();
	 submitter();
}

function initMap() {
    var mapDiv = document.getElementById('map');
    var map = new google.maps.Map(mapDiv, {
      center: {lat: 44.540, lng: -78.546},
      zoom: 8
   });
}