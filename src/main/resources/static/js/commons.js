var softSumit = function(formId, showUrl, param, fields, responseFunc) {
	var showRequest = function(formData, jqForm, options) {
	};

	var showResponse = function(result) {
		alert("操作成功,请登录");
		window.open("/C/toUser");
	};
	var options = {
		traditional : true,
		data : param,
		beforeSubmit : showRequest,
		success : typeof (responseFunc) === "function" ? responseFunc
				: showResponse,
	}
	$.ajaxSettings.async = false;
	$.getScript('/js/jquery-form.js', function() {
		$("#" + formId).ajaxSubmit(options);
		return false;
	});
	$.ajaxSettings.async = true;
};
var softSumitm = function(formId, showUrl, param, fields, responseFunc) {
	var showRequest = function(formData, jqForm, options) {
	};

	var showResponse = function(result) {
		alert("操作成功,请登录");
		window.open("/m/login");
	};
	var options = {
		traditional : true,
		data : param,
		beforeSubmit : showRequest,
		success : typeof (responseFunc) === "function" ? responseFunc
			: showResponse,
	}
	$.ajaxSettings.async = false;
	$.getScript('/js/jquery-form.js', function() {
		$("#" + formId).ajaxSubmit(options);
		return false;
	});
	$.ajaxSettings.async = true;
};
