$(document).ready(function() {

	$("#userMailError").hide();

	var userMailError = false;

	$("#email").keyup(function() {
		validateEmail();
	});

	$("#email").blur(function() {
		validate_mail_ajax();
	});

	function validateEmail() {
		var val = $("#email").val();
		var exp = /^[a-zA-Z0-9-_]+\@[a-zA-Z]{2,8}\.[a-z]{2,6}$/;
		if (val == '') {
			$("#userMailError").show();
			$("#userMailError").html("Enter <b> User Mail</b>");
			$("#userMailError").css("color", "red");
			userMailError = false;
		} else if (!exp.test(val)) {
			$("#userMailError").show();
			$("#userMailError").html("Not a Valid <b> User Mail</b>");
			$("#userMailError").css("color", "red");
			userMailError = false;

		} else {
			$("#userMailError").hide();
			userMailError = true;

		}
		return userMailError;
	}

	function validate_mail_ajax() {
		var val = $("#email").val();
		$.ajax({
			url : 'reg/mailValidate',
			data : {
				"email" : $("#email").val()
			},
			success : function(resTxt) {
				if (resTxt != '') {
					
					$("#userMailError").hide();
					$("#userMailError").html("");
					$("#register").show();
					$("#register").attr("disabled", false);
		
				} else {
					
					$("#userMailError").show();
					$("#userMailError").hide();
					$("#userMailError").html("This mail is not regiterd");
					$("#userMailError").show();
					$("#userMailError").css("color", "red");
					$("#email").focus();
					// $("#register").hide();
					$("#register").attr("disabled", true);

				}
			}
		});
	}
	;

	$("#register").click(function() {

		userMailError = false;

		validateEmail();

		if (validateEmail())
			return true;
		else
			return false;

	});

});
