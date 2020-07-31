$(document)
.ready(
		function() {

			$("#fNameError").hide();
			$("#lNameError").hide();
			$("#userMailError").hide();
			$("#userContactError").hide();

			var fNameError = false;
			var lNameError = false;
			var userMailError = false;
			var userContactError = false;

			$("#fname").keyup(function() {
				validatefName();
			});
			$("#lname").keyup(function() {
				validatelName();
			});

			$("#email").keyup(function() {
				validateEmail();
			});

			$("#no").keyup(function() {
				validateContact();
			});
			$("#email").blur(function() {
				validate_mail_ajax();
			});

			function validateContact() {
				var val = $("#no").val();
				var exp = /^(\+91)?[6-9][0-9]{9}$/;

				if (val == '') {
					$("#userContactError").show();
					$("#userContactError").html(
							"Enter <b>User Contact</b>");
					$("#userContactError").css("color",
							"red");
					userContactError = false;
				} else if (!exp.test(val)) {
					$("#userContactError").show();
					$("#userContactError").html(
							"Invaild <b>User Contact</b>");
					$("#userContactError").css("color",
							"red");
					userContactError = false;
				} else {
					$("#userContactError").hide();
					userContactError = true;
				}
				return userContactError;
			}

			function validatefName() {

				var val = $("#fname").val();
				if (val == '') {
					$("#fNameError").show();
					$("#fNameError").html(
							"Name <b>Must Requeird </b>");
					$("#fNameError").css("color", "red");
					nameError = false;
				} else {
					$("#fNameError").hide();
					fNameError = true;
				}
				return fNameError;
			}
			function validatelName() {

				var val = $("#lname").val();
				if (val == '') {
					$("#lNameError").show();
					$("#lNameError").html(
							"Name <b>Must Requeird </b>");
					$("#lNameError").css("color", "red");
					nameError = false;
				} else {
					$("#lNameError").hide();
					lNameError = true;
				}
				return lNameError;
			}

			function validateEmail() {
				var val = $("#email").val();
				var exp = /^[a-zA-Z0-9-_]+\@[a-zA-Z]{2,8}\.[a-z]{2,6}$/;
				if (val == '') {
					$("#userMailError").show();
					$("#userMailError").html(
							"Enter <b> User Mail</b>");
					$("#userMailError").css("color", "red");
					userMailError = false;
				} else if (!exp.test(val)) {
					$("#userMailError").show();
					$("#userMailError")
							.html(
									"Not a Valid <b> User Mail</b>");
					$("#userMailError").css("color", "red");
					userMailError = false;

				} else {
					$("#userMailError").hide();
					userMailError = true;

				}
				return userMailError;
			}

			function validateDob() {

				var val = $("#dob").val();
				if (val == '') {
					$("#dobError").show();
					$("#dobError").html(
							"DOB <b>Must Requeird </b>");
					$("#dobError").css("color", "red");
					dobError = false;
				} else {
					$("#dobError").hide();
					dobError = true;
				}
				return dobError;
			}

			$(function() {
				$("#register")
						.click(
								function() {

									var isValid = $(
											"input[name=gender]")
											.is(":checked");

									$("#spnError")[0].style.display = isValid ? "none"
											: "block";
								});
			});

			function validate_mail_ajax() {
				var val = $("#email").val();
				$.ajax({
					url : 'mailValidate',
					data : {
						"email" : $("#email").val()
					},
					success : function(resTxt) {
						if (resTxt != '') {
							$("#userMailError").show();
							$("#userMailError")
									.html(resTxt);
							$("#userMailError").css(
									"color", "red");
							$("#email").focus();
							//$("#register").hide();
							$("#register").attr("disabled",
									true);
						} else {
							$("#userMailError").hide();
							$("#userMailError").html("");
							$("#register").show();
							$("#register").attr("disabled",
									false);

						}
					}
				});
			}
			;

			$("#register").click(
					function() {

						fNameError = false;
						lNameError = false;
						userMailError = false;
						userContactError = false;
						dobError = false;

						validatefName();
						validatelName()
						validateEmail();
						validateContact();
						validateDob();

						if (validatefName()
								&& validatelName()
								&& validateEmail()
								&& validateContact()
								&& validateDob())
							return true;
						else
							return false;

					});

		});
