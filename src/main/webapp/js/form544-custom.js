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
	$("#notifyByUnitDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#notifyToMohDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#notifyByUnitFromDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#notifyByUnitToDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#notifyToMohFromDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#notifyToMohToDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#smpleCollectionDate").datepicker({
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
	var limit = parseInt($("#limit").val());

	if ($("#pageNo").val() != undefined && parseInt($("#pageNo").val()) != 1) {
		offset = parseInt($("#pageNo").val()) * limit
				- parseInt($("#limit").val());
	}
	$
			.ajax({
				url : "/communicable-disease/Form544/filterBy/",
				method : "post",
				data : {
					"serialNo" : $("#serialNo").val(),
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
					"mohArea" : $("#mohArea").val(),
					"notifyByUnitFromDate" : $("#notifyByUnitFromDate").val(),
					"notifyByUnitToDate" : $("#notifyByUnitToDate").val(),
					"notifyToMohFromDate" : $("#notifyToMohFromDate").val(),
					"notifyToMohToDate" : $("#notifyToMohToDate").val(),
					"_csrf" : $("#csrfToken").val(),
					"offset" : offset,
					"limit" : limit,
				},
				success : function(result) {
					$("#form544FilterTblBody").empty();
					for (i = 0; i < result.form544List.length; i++) {
						$("#form544FilterTblBody")
								.append(
										'<tr>' + '<td>'
												+ result.form544List[i].id
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].serialNo
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].patientName
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].patientsHomePhoneNo
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].bhtNo
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].ward.name
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].disease.diseaseName
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].dateOfAdmission
												+ '</td>'
												+ '<td>'
												+ result.form544List[i].institute.name
												+ '</td>'
												+ '<td>'
												+ '<a href="'
												+ generateView544Url(result.form544List[i].id)
												+ '">View</a> | <a href="'
												+ generateUpdate544Url(result.form544List[i].id)
												+ '">Update</a> | <a onclick="'
												+ generateDelete544Url(result.form544List[i].id)
												+ '">Delete</a> | '
												+ generateForm411Link(result.form544List[i])
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

function setPageName(pageName) {
	document.getElementById('pageName').innerHTML = pageName;
}

function generateView544Url(form544Id) {
	return "/communicable-disease/Form544/view?form544Id=" + form544Id;
}

function generateUpdate544Url(form544Id) {
	return "/communicable-disease/Form544/update_view?id=" + form544Id;
}

function generateDelete544Url(form544Id) {
	return "viewConfirmationDialog('Delete Form 544', 'Are you sure you need to delete Form 544 ID " +form544Id+ " ?', null, 'deleteForm544("+form544Id+")')";
}

function generateForm411Link(form544) {
	if (form544.workflow != null) {
		if (form544.workflow.form411 == null) {
			return '<a href="/communicable-disease/Form411/create?form544Id='
					+ form544.id + '">Create 411</a>';
		} else {
			return '<a href="/communicable-disease/Form411/view?form411Id='
					+ form544.workflow.form411.id + '">View 411</a>';
		}
	}
}

function getMohAreaByDistrictId(districtId) {
	$.ajax({
		url : "/communicable-disease/Form544/moh_area?district_id="
				+ districtId,
		method : "get",
		success : function(result) {
			$("#mohArea").empty();
			if (typeof pge !== 'undefined') {
				if (pge == "form544Search") {
					var defaultOption = "<option value=''>All</option>";
					$("#mohArea").append(defaultOption);
				}
			}
			result.forEach(function(item, i) {
				var option = "<option value = " + item.id + ">"
						+ item.mohAreaName + "</option>";
				$("#mohArea").append(option);
			});

			if (typeof form544Obj !== 'undefined') {
				setMohAreaIfAlreadtSet(form544Obj);
			}
		}
	});
}

function getInstitutesByDistrictId(districtId) {
	$.ajax({
		url : "/communicable-disease/Form544/institute?district_id="
				+ districtId,
		method : "get",
		success : function(result) {
			$("#institute").empty();
			if (typeof pge !== 'undefined') {
				if (pge == "form544Search") {
					var defaultOption = "<option value=''>All</option>";
					$("#institute").append(defaultOption);
				}
			}
			result.forEach(function(item, i) {
				var option = "<option value = " + item.id + ">" + item.name
						+ "</option>";
				$("#institute").append(option);
			});

			if (typeof form544Obj !== 'undefined') {
				setInstituteIfAlreadtSet(form544Obj);
			}

			getWardByInstituteId($("#institute").val());
		}
	});
}

function getWardByInstituteId(instituteId) {
	$.ajax({
		url : "/communicable-disease/Form544/ward?institute_id=" + instituteId,
		method : "get",
		success : function(result) {
			$("#ward").empty();
			if (typeof pge !== 'undefined') {
				if (pge == "form544Search") {
					var defaultOption = "<option value=''>All</option>";
					$("#ward").append(defaultOption);
				}
			}
			result.forEach(function(item, i) {
				var option = "<option value = " + item.id + ">" + item.name
						+ "</option>";
				$("#ward").append(option);
			});

			if (typeof form544Obj !== 'undefined') {
				setWardIfAlreadtSet(form544Obj);
			}
		}
	});
}

function composeAge() {
	var age = $("#ageYear").val() * 365 + $("#ageMonth").val() * 30
			+ $("#ageDay").val() * 1;

	$("#age").val(age);

	if ($("#age").val() == 0) {
		$("#age").val("");
	}

}

function initMap() {
	var map = new google.maps.Map(document.getElementById('map_canvas'), {
		zoom : defaultZoom,
		center : new google.maps.LatLng(defaultLat, defaultLng),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});

	var diseaseLocation = new google.maps.Marker({
		position : new google.maps.LatLng(defaultLat, defaultLng),
		draggable : true
	});

	google.maps.event.addListener(diseaseLocation, 'dragend', function(evt) {
		setMapCoordinatesToTxtBoxes(evt.latLng);
	});

	google.maps.event.addListener(diseaseLocation, 'dragstart', function(evt) {

	});

	google.maps.event.addListener(map, 'click', function(evt) {
		setMapCoordinatesToTxtBoxes(evt.latLng);
		diseaseLocation.setPosition(evt.latLng);
	});

	map.setCenter(diseaseLocation.position);
	diseaseLocation.setMap(map);

	var input = document.getElementById('pac-input');
	var searchBox = new google.maps.places.SearchBox(input);
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

	map.addListener('bounds_changed', function() {
		searchBox.setBounds(map.getBounds());
	});

	var markers = [];

	searchBox.addListener('places_changed', function() {
		var places = searchBox.getPlaces();

		if (places.length == 0) {
			return;
		}

		markers.forEach(function(marker) {
			marker.setMap(null);
		});
		markers = [];

		var bounds = new google.maps.LatLngBounds();
		places.forEach(function(place) {
			if (!place.geometry) {
				console.log("Returned place contains no geometry");
				return;
			}
			var icon = {
				url : place.icon,
				size : new google.maps.Size(71, 71),
				origin : new google.maps.Point(0, 0),
				anchor : new google.maps.Point(17, 34),
				scaledSize : new google.maps.Size(25, 25)
			};

			diseaseLocation.setPosition(place.geometry.location);
			diseaseLocation.setMap(map);

			setMapCoordinatesToTxtBoxes(place.geometry.location);

			if (place.geometry.viewport) {
				bounds.union(place.geometry.viewport);
			} else {
				bounds.extend(place.geometry.location);
			}
		});
		map.fitBounds(bounds);

	});

}

var isCorrdinationMapLoaded = false;
var defaultLng = 80.623641;
var defaultLat = 7.467399;
var defaultZoom = 0;

function popupCoordinateMap(inDefaultLat, inDefaultLng, inDefaultZoom) {
	defaultZoom = inDefaultZoom;
	var longitude = document.getElementById("longitudeTxt").value;
	var latitude = document.getElementById("latitudeTxt").value;

	if (inDefaultLat != "" && inDefaultLng != "") {
		defaultLng = inDefaultLng;
		defaultLat = inDefaultLat;
		if (longitude != "" && latitude != "") {
			setMapCoordinatesInMapModel(latitude, longitude);
		} else {
			setMapCoordinatesInMapModel(defaultLat, defaultLng);
		}
	} else {
		setMapCoordinatesInMapModel(latitude, longitude);

		if (longitude != "" && latitude != "") {
			defaultLng = longitude;
			defaultLat = latitude;
		}
	}

	if (!isCorrdinationMapLoaded) {
		$
				.getScript(
						'https://maps.googleapis.com/maps/api/js?key=AIzaSyDN2cxxcRtxmmIu_9uwYJ7gjD5r7djFtGk&libraries=places&callback=initMap',
						function(data, textStatus, jqxhr) {
						});

		isCorrdinationMapLoaded = true;
	}

}

function mapSearchByAddress() {
	var mapSearchInput = document.getElementById('pac-input');
	mapSearchInput.value = document.getElementById('patientHomeAddress').value;

	google.maps.event.trigger(mapSearchInput, 'focus')
	google.maps.event.trigger(mapSearchInput, 'keydown', {
		keyCode : 13
	});
}

function popupViewMap(inDefaultZoom) {
	defaultZoom = inDefaultZoom;

	var longitude = document.getElementById('longitudeVal').innerHTML;
	var latitude = document.getElementById('latitudeVal').innerHTML;

	if (longitude != "" && latitude != "") {
		defaultLng = longitude;
		defaultLat = latitude;
	}

	if (!isCorrdinationMapLoaded) {
		$
				.getScript(
						'https://maps.googleapis.com/maps/api/js?key=AIzaSyDN2cxxcRtxmmIu_9uwYJ7gjD5r7djFtGk&callback=initViewMap',
						function(data, textStatus, jqxhr) {

						});

		isCorrdinationMapLoaded = true;
	}
}

function initViewMap() {
	var map = new google.maps.Map(document.getElementById('map_canvas'), {
		zoom : defaultZoom,
		center : new google.maps.LatLng(defaultLat, defaultLng),
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});

	var diseaseLocation = new google.maps.Marker({
		position : new google.maps.LatLng(defaultLat, defaultLng),
	});

	map.setCenter(diseaseLocation.position);
	diseaseLocation.setMap(map);
}

function setMapCoordinatesToTxtBoxes(locationCoordinates) {
	document.getElementById('latitude').innerHTML = locationCoordinates.lat()
			.toFixed(6);
	document.getElementById('longitude').innerHTML = locationCoordinates.lng()
			.toFixed(6);

	document.getElementById('latitudeTxt').value = locationCoordinates.lat()
			.toFixed(6);
	document.getElementById('longitudeTxt').value = locationCoordinates.lng()
			.toFixed(6);
}

function setMapCoordinatesInMapModel(defaultLat, defaultLng) {
	document.getElementById('latitude').innerHTML = defaultLat;
	document.getElementById('longitude').innerHTML = defaultLng;
}

function setMohAreaIfAlreadtSet(form544Obj) {
	var selectedVal = form544Obj.mohArea.id;
	$("#mohArea").val(selectedVal);
}

function setInstituteIfAlreadtSet(form544Obj) {
	var selectedVal = form544Obj.institute.id;
	$("#institute").val(selectedVal);
}

function setWardIfAlreadtSet(form544Obj) {
	var selectedVal = form544Obj.ward.id;
	$("#ward").val(selectedVal);
}

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

function submitForm544(frmId) {
	$("#" + frmId)[0].submit();
}

function deleteForm544(form544Id) {
	window.location = "/communicable-disease/Form544/delete?id=" + form544Id;
}

$(document).ready(function() {

	// Following default set should be removed or changed according to
	// target
	// release setup.
	$("#district").val("16");
	getMohAreaByDistrictId($("#district").val());
	getInstitutesByDistrictId($("#district").val());

	$("#district").change(function() {
		getMohAreaByDistrictId($("#district").val());
		getInstitutesByDistrictId($("#district").val());
	});

	$("#institute").change(function() {
		getWardByInstituteId($("#institute").val());
	});

});