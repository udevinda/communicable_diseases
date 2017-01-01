$(function() {
	$("#diseaseNotifiedDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#diseaseNotifiedDateFrom").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#diseaseNotifiedDateFromTo").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

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
	$("#diseaseConfirmedDateTo").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

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
	$("#dateOfHospitalization").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfHospitalizationFrom").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfHospitalizationTo").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfDischarged").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfDischargedFrom").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#dateOfDischargedTo").datepicker({
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

function doSearch(pageGenerationOn) {
	var offset = 0;

	if ($("#pageNo").val() != undefined && parseInt($("#pageNo").val()) != 1) {
		offset = parseInt($("#pageNo").val()) * parseInt($("#limit").val())
				- parseInt($("#limit").val());
	}
	$
			.ajax({
				url : "/communicable-disease/Form411/filterBy/",
				method : "post",
				data : {
					"name" : $("#patientName").val(),
					"ageTo" : $("#ageTo").val(),
					"ageFrom" : $("#ageFrom").val(),
					"sex" : $("#sex").val(),
					"ethnicGroup" : $("#ethnicGroup").val(),
					"notifiedDiseaseId" : $("#notifiedDiseaseId").val(),
					"notifiedDateFrom" : $("#diseaseNotifiedDateFrom").val(),
					"notifiedDateTo" : $("#diseaseNotifiedDateTo").val(),
					"confirmedDiseaseId" : $("#confirmedDiseaseId").val(),
					"confirmedDateFrom" : $("#diseaseConfirmedDateFrom").val(),
					"confirmedDateTo" : $("#diseaseConfirmedDateTo").val(),
					"dateOnsetFrom" : $("#dateOfOnsetFrom").val(),
					"dateOnsetTo" : $("#dateOfOnsetTo").val(),
					"hospitalizedFrom" : $("#dateOfHospitalizationFrom").val(),
					"hospitalizedTo" : $("#dateOfHospitalizationTo").val(),
					"dischargedFrom" : $("#dateOfDischargedFrom").val(),
					"dischargedTo" : $("#dateOfDischargedTo").val(),
					"hospital" : $("#hospital").val(),
					"isolated" : $("#isolated").val(),
					"outcome" : $("#outcome").val(),
					"isolated" : $("#isolated").val(),
					"phiRange" : $("#phiRange").val(),
					"mohRange" : $("#mohArea").val(),
					"offset" : offset,
					"limit" : $("#limit").val(),
				},
				success : function(result) {
					$("#form411FilterTblBody").empty();
					for (i = 0; i < result.form411List.length; i++) {
						$("#form411FilterTblBody")
								.append(
										'<tr>' + '<td>'
												+ result.form411List[i].id
												+ '</td>'
												+ '<td>'
												+ result.form411List[i].patientName
												+ '</td>'
												+ '<td>'
												+ result.form411List[i].age
												+ '</td>'
												+ '<td>'
												+ result.form411List[i].patientAddress
												+ '</td>'
												+ '<td>'
												+ result.form411List[i].diseaseAsNotified.diseaseName
												+ '</td>'
												+ '<td>'
												+ result.form411List[i].diseaseConfirmed.diseaseName
												+ '</td>'
												+ '<td>'
												+ result.form411List[i].outcome
												+ '</td>'
												+ '<td>'
												+ result.form411List[i].phiRange
												+ '</td>'
												+ '<td>'
												+ '<a href="'
												+ generateView411Url(result.form411List[i].id)
												+ '">View 411</a> | <a href="'
												+ generateUpdate411Url(result.form411List[i].id)
												+ '">Update 411</a> | '
												+ generateForm411Link(result.form411List[i])
												+ '</td>' + '</tr>');
					}

					totalRowCount = result.totalRowCount;

					if (pageGenerationOn == true) {
						$("#pages").empty();
						generatePages();
					}

				}
			});
}

function generatePages() {

	console.log("Method called");

	var pageCount = Math.ceil(totalRowCount / parseInt($("#limit").val()));
	var sel = $('<select id="pageNo" onchange="doSearch(false)">').appendTo(
			'#pages');

	console.log(pageCount);

	for (i = 0; i < pageCount; i++) {
		sel.append($("<option>").attr('value', i + 1).text(i + 1));
	}
}

function setPageName(pageName) {
	document.getElementById('pageName').innerHTML = pageName;
}

// TODO Need to implement JS function to form contacted person detail set JSON
function formContactedJson() {

}

function generateView411Url(form411Id) {
	return "/communicable-disease/Form544/view?form544Id=" + form411Id;
}

function generateUpdate411Url(form411Id) {
	return "/communicable-disease/Form544/update_view?id=" + form411Id;
}

function generateForm411Link(form411) {
	if (form411.workflow != null) {

		return '<a href="/communicable-disease/Form544/view?form544Id='
				+ form411.workflow.form544.id + '">View 544</a>';
	} else {
		return null;
	}
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
