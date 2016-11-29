$(function() {
	$("#dateOfOnset").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfOnsetFrom").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfOnsetTo").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfAdmission").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfAdmissionFrom").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfAdmissionTo").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#footer").load("/communicable-disease/page/footer");
});

$(function() {
	$("#banner").load("/communicable-disease/page/banner");
});

$(function() {
	$("#navigation").load("/communicable-disease/page/navigation");
});

frmOpen = "";

$(document).ready(function() {
	var frm = $('#form544FilterTbl');
	var nic = $("#name").val();

	$('#form544List').DataTable({
		serverSide : true,
		ajax : {
			type : frm.attr('method'),
			url : frm.attr('action'),
			data : {
				nic : '6576',
				institute : 'hghghg'
			}
		}
	});

	frmOpen = frm;
});

function setPageName(pageName) {
	document.getElementById('pageName').innerHTML = pageName;
}