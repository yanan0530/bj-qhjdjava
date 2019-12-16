
$(function () {



    //查看密码
    $(".eyes_box").click(function () {
        var _input = $(this).prev();
        var _type = _input.attr("type");
        if (_type == "password") {
            _input.attr("type", "text");
            $(this).children("img").attr('src', "/phone/images/yan-huang.png");
        }
        else {
            _input.attr("type", "password");
            $(this).children("img").attr('src', "/phone/images/yan-hui.png");
        }
        //if($(this).attr("data-show")==1){//明文
        //	$(this).attr("data-show","2");
        //	$(this).children("img").attr('src',"/phone/images/yan-huang.png");
        //	$(this).parent("li").children(".mima_dd").hide();
        //	$(this).parent("li").children(".mima_wz").show();
        //	$(this).parent("li").children(".mima_wz").val($(this).parent("li").children(".mima_dd").val()); 
        //	return;
        //	}
        //if($(this).attr("data-show")==2){//密文
        //	$(this).attr("data-show","1");
        //	$(this).children("img").attr('src', "/phone/images/yan-hui.png");
        //	$(this).parent("li").children(".mima_dd").show();
        //	$(this).parent("li").children(".mima_wz").hide();
        //	$(this).parent("li").children(".mima_dd").val($(this).parent("li").children(".mima_wz").val()); 
        //	return;
        //	} 
    });




});