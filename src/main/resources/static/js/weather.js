$(document).ready(function() {
	
	// Attach a submit handler to the form
	$(document).on("click", ".weatherButton", function(event) {
	
	  	let $form = $( this ).closest("form");
	  	
	  	doWork($form, "/weather/");
	});

});

function doWork(formIn, url) {
	
	let $form = formIn;
  	  
	// Send the data using post
	let posting = $.post(url, $form.serialize());

	// Put the results in a div
	posting.done(function(data) {
		
		let errorMessageDiv = $( "#message" );
		let weatherDiv = $( "#weather" );
		
		if(data != null) {
		
			if(data.responseData != null) {
				
				// set values
				$( "td#description" ).html(data.responseData.description);
				$( "td#temperature" ).html(data.responseData.temp);
				$( "td#temp_range" ).html(data.responseData.temp_min+"-"+data.responseData.temp_max);
				$( "td#pressure" ).html(data.responseData.pressure);
				$( "td#humidity" ).html(data.responseData.humidity);
				$( "td#visibility" ).html(data.responseData.visibility);
				
				errorMessageDiv.hide();
				weatherDiv.removeClass('hidden');
				
			} else {
				displayAlertMessage(errorMessageDiv, 1, data.errorMessage);	
				weatherDiv.addClass('hidden');
				errorMessageDiv.show();
			}
			
		} else {
			displayAlertMessage(errorMessageDiv, 1, failedToGetDataLabel);
			weatherDiv.addClass('hidden');
			errorMessageDiv.show();
		}
	});
	
}