$(function() {
	$("#reportDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#fromDate").datepicker({
		dateFormat : 'yy-mm-dd'
	});
});

$(function() {
	$("#toDate").datepicker({
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

function generateYearList(selectId) {
	var min = 2010;
	var max = new Date().getFullYear();
	var select = document.getElementById(selectId);

	for (var i = min; i <= max; i++) {
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		select.appendChild(opt);
	}
}

function generateMonthList(selectId) {
	var select = document.getElementById(selectId);

	var jan = document.createElement("option");
	jan.text = "January";
	jan.value = "1";

	var feb = document.createElement("option");
	feb.text = "February";
	feb.value = "2";

	var mar = document.createElement("option");
	mar.text = "March";
	mar.value = "3";

	var apr = document.createElement("option");
	apr.text = "April";
	apr.value = "4";

	var may = document.createElement("option");
	may.text = "May";
	may.value = "5";

	var jun = document.createElement("option");
	jun.text = "June";
	jun.value = "6";

	var jul = document.createElement("option");
	jul.text = "July";
	jul.value = "7";

	var aug = document.createElement("option");
	aug.text = "August";
	aug.value = "8";

	var sep = document.createElement("option");
	sep.text = "September";
	sep.value = "9";

	var oct = document.createElement("option");
	oct.text = "October";
	oct.value = "10";

	var nov = document.createElement("option");
	nov.text = "November";
	nov.value = "11";

	var dec = document.createElement("option");
	dec.text = "December";
	dec.value = "12";

	select.appendChild(jan);
	select.appendChild(feb);
	select.appendChild(mar);
	select.appendChild(apr);
	select.appendChild(may);
	select.appendChild(jun);
	select.appendChild(jul);
	select.appendChild(aug);
	select.appendChild(sep);
	select.appendChild(oct);
	select.appendChild(nov);
	select.appendChild(dec);
}

function formatReseiverAddr() {
	var content = document.getElementById('resAddr').innerHTML;
	document.getElementById('resAddr').innerHTML = content.replace(/,/g,
			",<br>");
}

function getMonthByIndex(monthIndex) {
	var month = "";
	switch (monthIndex) {
	case 1:
		month = "January";
		break;
	case 2:
		month = "February";
		break;
	case 3:
		month = "March";
		break;
	case 4:
		month = "April";
		break;
	case 5:
		month = "May";
		break;
	case 6:
		month = "June";
		break;
	case 7:
		month = "July";
		break;
	case 8:
		month = "August";
		break;
	case 9:
		month = "September";
		break;
	case 10:
		month = "October";
		break;
	case 11:
		month = "November";
		break;
	case 12:
		month = "December";
		break;
	}

	return month;
}
