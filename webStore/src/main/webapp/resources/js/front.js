function submitter(btn) {
    var param = btn.id;
    var myForm = document.forms["cartForm"];
    myForm.elements["productId"].value = param;
    myForm.submit();
}