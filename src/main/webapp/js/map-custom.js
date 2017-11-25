$(function() {
	$("#diseaseConfirmedDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#diseaseConfirmedDateFrom").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#fromPeriod").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#toPeriod").datepicker({
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

$(document).ready(function(){
	// Following default set should be removed or changed according to target
	// release setup.
	$("#district").val("16");
	getMohAreaByDistrictId($("#district").val());

	$("#district").change(function() {
		getMohAreaByDistrictId($("#district").val());
	});
});

function getMohAreaByDistrictId(districtId) {
	$.ajax({
		url : "/communicable-disease/Form544/moh_area?district_id="
				+ districtId,
		method : "get",
		success : function(result) {
			$("#mohArea").empty();
			var defaultOption = "<option value=''>All</option>";
			$("#mohArea").append(defaultOption);
			result.forEach(function(item, i) {
				var option = "<option value = " + item.id + ">"
						+ item.mohAreaName + "</option>";
				$("#mohArea").append(option);
			});
		}
	});
}