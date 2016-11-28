$(function() {
	$("#dateOfOnset").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfAdmission").datepicker({
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

function setPageName(pageName) {
	document.getElementById('pageName').innerHTML = pageName;
}