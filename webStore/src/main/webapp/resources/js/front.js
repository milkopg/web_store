function submitter(btn) {
    var param = btn.id;
    var rowId;
    var myForm = document.forms["cartForm"];
    myForm.elements["productId"].value = param;
    
    
//    $('#cartTable').find('tr').click( function(){
//    	rowId = ($(this).index()-1);
//  	  	alert('You clicked row '+  rowId);
//  	});
    
    if (myForm.elements["rowIndex"] != undefined) {
    	myForm.elements["rowIndex"].value = $('#cartTable').find('tr').index();
    }
    
//    $('#cartTable').find('tr').click( function(){
//    	  var row = $(this).find('td:first').text();
//    	  alert('You clicked ' + row);
//    	});
    myForm.submit();
}

function getRowIndex (btn) {
	  var rowId =  ($(this).index()+1);
	  var myForm = document.forms["cartForm"];
	  $('#cartTable').find('tr')	  
	  alert('You clicked row '+ rowId );
	  myForm.elements["rowId"].value =  rowId;
	  myForm.submit();
}


