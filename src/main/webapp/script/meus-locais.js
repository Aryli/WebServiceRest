$(document)
		.ready(
				function() {
					$.ajax({
								cache : false,
								type : "GET",
								url : "rest/local/todosLocais",
								headers : [],
								async : false,
								contentType : "application/json; charset=utf-8",
								datatype : "json",
								success : function(mensagemRetorno) {
									for ( var index in mensagemRetorno) {
										$("#listagemDeLocais")
												.append(
														"<div class=\"local row\" id='local-" + mensagemRetorno[index].id + "' >"
																+ "<div class=\"col-md-4\">"
																+ "<p style=\"font-weight: bold\">Nome do Local</p>"
																+ "<p class=\"titulo-local\">"
																+ mensagemRetorno[index].titulo
																+ "</p>"
																+ "</div>"
																+ "<div class=\"col-md-4\">"
																+ "<p class=\"latitude\"> Latitude: <span>"
																+ mensagemRetorno[index].latitude
																+ "</span> </p>"
																+ " <p class=\"longitude\"> Longitude <span>"
																+ mensagemRetorno[index].longitude
																+ "</span></p>"
																+ " </div>"
																+ "<div class=\"col-md-4\">"
																+ "<button class=\"btn btn-primary\" onclick=\"excluir("
																+ mensagemRetorno[index].id
																+ ")\">Excluir</button>"
																+ "<a class=\" btn btn-primary view\" href=\"view-local.jsp\" >Ver/Alterar</a>"
																+ " </div>"
																+ "</div>");

									}

								},
								error : function() {

								}
							});
				});

function excluir(id) {
	$.ajax({
		cache : false,
		type : "DELETE",
		url : "rest/local/excluir/" + id,
		headers : [],
		async : false,
		contentType : "application/json; charset=utf-8",
		datatype : "json",
		success : function(mensagemRetorno) {			
			$("#local-" + id).remove();
			console.log("batata");
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
		}
	});
}