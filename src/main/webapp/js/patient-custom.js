$(function() {
	$("#footer").load("/communicable-disease/page/footer");
});

$(function() {
	$("#banner").load("/communicable-disease/page/banner");
});

$(function() {
	$("#navigation").load("/communicable-disease/page/navigation");
});

function viewConfirmationDialog(title, message, frmId, func) {

	var isForm = true;

	if (frmId == null || frmId == undefined) {
		isForm = false;
	}

	if (!isForm || $("#" + frmId)[0].checkValidity()) {

		$("#confirmDialog")
				.append(
						"<div class='modal fade' tabindex='-1' role='dialog' aria-labelledby='mySmallModalLabel' aria-hidden='true' id='mi-modal'>"
								+ "<div class='modal-dialog modal-md'>"
								+ "<div class='modal-content'>"
								+ "<div class='modal-header'>"
								+ "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>"
								+ "<h4 class='modal-title' id='myModalLabel'>"
								+ title
								+ "</h4>"
								+ "</div>"
								+ "<div class='modal-body'>"
								+ message
								+ "</div>"
								+ "<div class='modal-footer'>"
								+ "<button type='button' class='btn btn-default' id='modal-btn-cancel'>Cancel</button>"
								+ "<button type='button' class='btn btn-primary' id='modal-btn-ok' onclick="
								+ func
								+ ">OK</button>"
								+ "</div>"
								+ "</div>"
								+ "</div>" + "</div>");

		$("#mi-modal").modal('show');

		$("#modal-btn-cancel").on("click", function() {
			$("#mi-modal").modal('hide');
		});
	} else {
		$("#" + frmId)[0].querySelector('input[type="submit"]').click();
	}
}

function submitPatient(frmId) {
	$("#" + frmId)[0].submit();
}

function viewAlert() {
	if (typeof alertObj !== 'undefined' && alertObj !== null) {
		generateAlert(alertObj.type, alertObj.msg);
	}
}

function doSearch(pageGenerationOn) {
	var offset = 0;
	var limit = parseInt($("#limit").val());

	if ($("#pageNo").val() != undefined && parseInt($("#pageNo").val()) != 1) {
		offset = parseInt($("#pageNo").val()) * limit
				- parseInt($("#limit").val());
	}
	$
			.ajax({
				url : "/communicable-disease/Patient/filterBy/",
				method : "post",
				data : {
					"patientId" : $("#patientId").val(),
					"nic" : $("#nic").val(),
					"patientName" : $("#patientName").val(),
					"contactNo" : $("#contactNo").val(),
					"sex" : $("#sex").val(),
					"status" : $("#status").val(),
					"dateOfRegisteredFrom" : $("#dateOfRegisteredFrom").val(),
					"dateOfRegisteredTo" : $("#dateOfRegisteredTo").val(),
					"_csrf" : $("#csrfToken").val(),
					"offset" : offset,
					"limit" : limit,
				},
				success : function(result) {
					$("#patientFilterTblBody").empty();
					for (i = 0; i < result.patientList.length; i++) {
						$("#patientFilterTblBody")
								.append(
										'<tr>' + '<td>'
												+ result.patientList[i].patientId
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].nic
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].name
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].contactNo
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].address
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].sex
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].status
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].registeredDate
												+ '</td>'
												+ '<td>'
												+ result.patientList[i].lastUpdatedTime
												+ '</td>'
												+ '<td>'
												+ '<a href="'
												+ generateViewPatientUrl(result.patientList[i].id)
												+ '">View</a> | <a href="'
												+ generateUpdatePatientUrl(result.patientList[i].id)
												+ '">Update</a> | <a style="cursor:pointer" onclick="'
												+ generateDeletePatientUrl(result.patientList[i].id)
												+ '">Delete</a> | '
												+ '</td>' + '</tr>');
					}

					var totalRows = result.totalRowCount;
					generateTblSummaryStatement(limit, offset, totalRows);

					if (pageGenerationOn == true) {
						$("#pages").empty();
						generatePages(totalRows);
					}

				}
			});

}

function generateViewPatientUrl(patientId) {
	return "/communicable-disease/Patient/view?patientId=" + patientId;
}

function generateUpdatePatientUrl(patientId) {
	return "/communicable-disease/Patient/update_view?id=" + patientId;
}

function generateDeletePatientUrl(patientId) {
	return "viewConfirmationDialog('Delete Form 544', 'Are you sure you need to delete Form 544 ID "
			+ patientId + " ?', null, 'deleteForm544(" + patientId + ")')";
}

function generateTblSummaryStatement(limit, offset, totalRows) {
	var tblSummaryStatement = "Showing " + limit + " records (" + (offset + 1)
			+ "-" + (offset + limit) + ") from total " + totalRows
			+ " records."
	document.getElementById("tblSummary").innerHTML = tblSummaryStatement;
}

function generatePages(totalRowCount) {
	var pageCount = Math.ceil(totalRowCount / parseInt($("#limit").val()));
	var sel = $(
			'<select id="pageNo" onchange="doSearch(false)" class="form-control">')
			.appendTo('#pages');

	for (i = 0; i < pageCount; i++) {
		sel.append($("<option>").attr('value', i + 1).text(i + 1));
	}
}
