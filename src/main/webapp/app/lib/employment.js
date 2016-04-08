$(document).ready(function() {
	validateForm();
	$("#start_date").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		changeYear : true,
		onClose : function(selectedDate) {
			$("#end_date").datepicker("option", "minDate", selectedDate);
		}
	});

	$("#end_date").datepicker({
		defaultDate : "+1w",
		changeMonth : true,
		changeYear : true,
		onClose : function(selectedDate) {
			$("#start_date").datepicker("option", "maxDate", selectedDate);
		}
	});
});

function validateForm() {
	$('#employment_form').validator().on('submit', function(e) {
		if (e.isDefaultPrevented()) {
			// handle the invalid form...
		} else {
			// everything looks good!
		}
	});
}
