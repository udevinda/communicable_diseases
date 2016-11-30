var totalRowCount = 0;

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

function doSearch(pageGenerationOn) {
	var offset = 0;

	if ($("#pageNo").val() != undefined && parseInt($("#pageNo").val()) != 1) {
		offset = parseInt($("#pageNo").val()) * parseInt($("#limit").val())
				- parseInt($("#limit").val());
	}
	$.ajax({
		url : "/communicable-disease/Form544/filterBy/",
		method : "post",
		data : {
			"nic" : $("#nic").val(),
			"institute" : $("#institute").val(),
			"disease" : $("#disease").val(),
			"patientName" : $("#patientName").val(),
			"bhtNo" : $("#bhtNo").val(),
			"ward" : $("#ward").val(),
			"sex" : $("#sex").val(),
			"notifierName" : $("#notifierName").val(),
			"dateOfOnsetFrom" : $("#dateOfOnsetFrom").val(),
			"dateOfOnsetTo" : $("#dateOfOnsetTo").val(),
			"dateOfAdmissionFrom" : $("#dateOfAdmissionFrom").val(),
			"dateOfAdmissionTo" : $("#dateOfAdmissionTo").val(),
			"ageFrom" : $("#ageFrom").val(),
			"ageTo" : $("#ageTo").val(),
			"offset" : offset,
			"limit" : $("#limit").val(),
		},
		success : function(result) {
			$("#form544FilterTblBody").empty();
			for (i = 0; i < result.form544List.length; i++) {
				$("#form544FilterTblBody").append(
						'<tr>' + '<td>' + result.form544List[i].id + '</td>'
								+ '<td>' + result.form544List[i].nic + '</td>'
								+ '<td>' + result.form544List[i].patientName
								+ '</td>' + '<td>' + result.form544List[i].age
								+ '</td>' + '<td>' + result.form544List[i].sex
								+ '</td>' + '<td>'
								+ result.form544List[i].patientsHomePhoneNo
								+ '</td>' + '<td>'
								+ result.form544List[i].bhtNo + '</td>'
								+ '<td>' + result.form544List[i].ward + '</td>'
								+ '<td>'
								+ result.form544List[i].disease.diseaseName
								+ '</td>' + '<td>'
								+ result.form544List[i].dateOfAdmission
								+ '</td>' + '<td>'
								+ result.form544List[i].dateOfOnset + '</td>'
								+ '<td>' + result.form544List[i].institute
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