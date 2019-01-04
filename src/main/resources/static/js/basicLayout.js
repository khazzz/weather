$(function () {
	
	$.ajaxSetup({ cache: false });
	
	$(document)
	.ajaxStart(function(){
	    $("#loading-indicator").show();
	})
	.ajaxStop(function(){
	    $("#loading-indicator").hide();
	});
	
	// closes alert div
	$(document).on("click", ".close", function(event) {
		event.stopPropagation();
	    event.preventDefault();
	    $( this ).parent().attr('class', 'message').html('');
    });
	
	// shows tooltip over button
	$('[data-toggle="tooltip"]').tooltip({
	    animated: 'fade',
	    html: true
	}); 	
	
	// activate tooltip for dynamicly generated html
	$("body").tooltip({
	    selector: '[data-toggle="tooltip"]'
	});
	
	$('[data-toggle="popover"]').popover({
        html: true,
        container: 'body',
        content: $( document ).find("#popoverContentData").html(),
        title: $( document ).find("#popoverTitleData").html()
    });
});

function displayAlertMessage(div, code, message) {
	  
	  div.attr('role', 'alert');
	  div.attr('class', code == '0' ? 'alert alert-success alert-dismissible message' : 'alert alert-danger alert-dismissible message');
	  div.html('<button type=\"button\" class=\"close\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>'+message);
	  
	  // scroll to div
	  var etop = div.offset().top;
	  setTimeout(function(){
		  // scroll after delay cuz browser jumps to top first
		  $(window).scrollTop(etop);
	  }, 100);	
	  
}
	