var _msg = "系统异常,请联系管理员";
$.ajaxSetup({
	contentType : "application/x-www-form-urlencoded;charset=utf-8",
	complete : function(XMLHttpRequest, textStatus) {
	},
	statusCode : {
		400 : function(result) {
			var responseJSON = JSON.parse(result.responseText);
			var	msg = responseJSON == undefined ? _msg : responseJSON.message;
			alert(msg);
		},
		500 : function(result) {
			var responseJSON = result.responseJSON;
			alert(_msg);
		},
		error : function() {
		}
	}
});