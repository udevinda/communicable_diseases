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