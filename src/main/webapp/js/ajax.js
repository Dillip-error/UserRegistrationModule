$(document).ready(
		function(event) {

			$('#countryId').change(
					function() {

						$("#stateId").find('option').remove();
						$('<option>').val('').text('Choose State..').appendTo(
								"#stateId");
						
						$("#cityId").find('option').remove();
						$('<option>').val('').text('Choose City..').appendTo("#cityId");

						var countryId = $('#countryId').val();

						$.ajax({
							type : 'GET',
							url : "getStates?conId=" + countryId,
							success : function(res) {

								$.each(res, function(stateId, stateName) {
									$('<option>').val(stateId).text(stateName)
											.appendTo("#stateId");
								});
							}

						});
					});

			$("#stateId").change(
					function() {

						
						$("#cityId").find('option').remove();
						$('<option>').val('').text('Choose City..').appendTo("#cityId");
						var stateId = $("#stateId").val();

						$.ajax({
							type : "GET",
							url : "getCities?steId=" + stateId,
							success : function(data) {
								$.each(data, function(cityId, cityName) {
									$('<option>').val(cityId).text(cityName)
											.appendTo("#cityId");
								});
							}
						});
					});

		});
