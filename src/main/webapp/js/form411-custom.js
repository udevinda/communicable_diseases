$(function() {
	$("#diseaseNotifiedDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#diseaseConfirmedDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfOnset").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfHospitalization").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfDischarged").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$(".contactedDateSeen").datepicker({
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

//TODO Need to implement JS function to form contacted person detail set JSON
function formContactedJson(){
	
}

$(document)
		.ready(
				function() {
					var rowCount = 1;
					$("#add_row")
							.click(
									function() {
										$('#addr' + rowCount)
												.html(
														"<td>"
																+ (rowCount + 1)
																+ "</td><td><input name='contactedName' onchange='formContactedJson()' type='text' placeholder='Name' class='form-control input-md'  /> </td>"
																+ "<td><input  name='contactedAge' onchange='formContactedJson()' type='text' placeholder='Age'  class='form-control input-md'></td>"
																+ "<td><input  name='contactedDateSeen' onchange='formContactedJson()' class='contactedDateSeen' type='text' placeholder='Date Seen'></td>"
																+ "<td><input  name='contactedObservation' onchange='formContactedJson()' type='text' placeholder='Observation'  class='form-control input-md'></td>");

										$('#tab_logic').append(
												'<tr id="addr' + (rowCount + 1)
														+ '"></tr>');
										rowCount++;
									});

					$("#delete_row").click(function() {
						if (rowCount > 1) {
							$("#addr" + (rowCount - 1)).html('');
							rowCount--;
						}
					});

				});
