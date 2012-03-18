/**
 * 验证非法字符
 */
$.validator.addMethod("strangecode", function(value, element) {
	var regExpress =  /[\'\"\\/<>*:?|%$#@&~^]/;
    var flag = value.search(regExpress);
    if(flag == -1){
    	return true;
    }else{
    	return false;
    }  
}, "输入框中存在 \'\"\\/<>*:?|%$#@&~^ 非法字符， \n\n请更正或以中文符号替换 ！");  


/**
 * 验证备注中的非法字符
 */
$.validator.addMethod("strangecodememo", function(value, element) {
	var regExpress =  /[\'\"\\/<>*:?|%$#&~_+^]/;
    var flag = value.search(regExpress);
    if(flag == -1){
    	return true;
    }else{
    	return false;
    }  
}, "【备注】中存在 \'\"\\/<>*:?|%$#&~_+^ 非法字符， \n\n请更正或以中文符号替换 ！");

/**
 * 验证查询条件中的非法字符
 */
$.validator.addMethod("strangecodequery", function(value, element) {
	var regExpress =  /[\'\"\\/<>*:?|%$#@&~_+^]/;
    var flag = value.search(regExpress);
    if(flag == -1){
    	return true;
    }else{
    	return false;
    }  
}, "查询条件中存在 \'\"\\/<>*:?|%$#@&~_+^ 非法字符， \n\n请更正或以中文符号替换 ！");

/**
 * 验证邮编
 */
$.validator.addMethod("zipcode", function(value, element) { 
	var tel = /^[0-9]{6}$/; 
	return this.optional(element) || (tel.test(value)); 
}, "请正确填写您的邮政编码！"); 
/**
 * 验证下拉列表是否选择
 */
$.validator.addMethod("selectvalidate", function(value, element) {
	if( value == "" ){
    	return false;
    }else{
    	return true;
    }  
}, "请选择下拉列表中内容！");
/**
 * 身份证验证
 */ 
$.validator.addMethod( "validateidcard", function(value, element){
	  var   aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
      var   iSum=0
      var   info=""
	  sId=value.toUpperCase();
      if(!/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(value)){
          //alert("请输入正确的身份证号码！");
          return false;
      }else{
	      if(value.length==15){
		      value=converttonew(value);
		  }
          value=value.replace(/x$/i,"a");
          if(aCity[parseInt(value.substr(0,2))]==null){
              //alert("身份证号所显示的地区为非法地区！");
              return false;
          }else{
             sBirthday=value.substr(6,4)+"-"+Number(value.substr(10,2))+"-"+Number(value.substr(12,2));
             var   d=new   Date(sBirthday.replace(/-/g,"/"))
             if(sBirthday!=(d.getFullYear()+"-"+   (d.getMonth()+1)   +   "-"   +   d.getDate())){
                 //alert("身份证所显示的生日为非法生日!");
                 return false;
             }else{
                 for(var   i   =   17;i>=0;i   --)   iSum   +=   (Math.pow(2,i)   %   11)   *   parseInt(value.charAt(17   -   i),11)
                 if(iSum%11!=1){
                     //alert("身份证为非法证号！");
                     return false;
                 }else{
                     // var a=confirm("请您确认:"+aCity[parseInt(value.substr(0,2))]+","+sBirthday+","+(value.substr(16,1)%2?"男":"女"));
					 // if(a)
                      return true;
					  //else
					 // return false;
                 }
             }
          }	 
	  }
 }, "请输入正确的身份证号码！"); 
/**
 * 将15位身份证转换为18位
 */
function converttonew(x){
    var s="0",i,r;
    var id_w=new Array (0,2,4,8,5,10,9,7,3,6,1,2,4,8,5,10,9,7);
    var id_c=new Array ('1','0','X','9','8','7','6','5','4','3','2');
    s=x.substr(0,6);		//地区
    s+='19'+x.substr(6,6);	//年月日
    s+=x.substr(12,3);		//县内编码
    r=0;
    for (i=0;i<17;i++) r+=(s.charCodeAt(i)-48)*id_w[17-i];
        r=id_c[r % 11];
    return s+r;
}
/**
 * 验证日期格式
 */
 $.validator.addMethod("validatedate", function(value, element) {
	if (value == null || value == "") {
		return true;
	}
	subYY = value.substr(0, 4);
	if (isNaN(subYY) || subYY <= 0) {
		return false;
	}
 	//转换月份
	if (value.indexOf("-", 0) != -1) {
		separate = "-";
	} else {
		if (value.indexOf("/", 0) != -1) {
			separate = "/";
		} else {
			return false;
		}
	}
	area = value.indexOf(separate, 0);
	subMM = value.substr(area + 1, value.indexOf(separate, area + 1) - (area + 1));
	if (isNaN(subMM) || subMM <= 0) {
		return false;
	}
	if (subMM.length < 2) {
		subMM = "0" + subMM;
	}
 	//转换日
	area = value.lastIndexOf(separate);
	subDD = value.substr(area + 1, value.length - area - 1);
	if (isNaN(subDD) || subDD <= 0) {
		return false;
	}
	if (eval(subDD) < 10) {
		subDD = "0" + eval(subDD);
	}
	NewDate = subYY + "-" + subMM + "-" + subDD;
	if (NewDate.length != 10) {
		return false;
	}
	if (NewDate.substr(4, 1) != "-") {
		return false;
	}
	if (NewDate.substr(7, 1) != "-") {
		return false;
	}
	var MM = NewDate.substr(5, 2);
	var DD = NewDate.substr(8, 2);
	if ((subYY % 4 == 0 && subYY % 100 != 0) || subYY % 400 == 0) { //判断是否为闰年
		if (parseInt(MM) == 2) {
			if (DD > 29) {
				return false;
			}
		}
	} else {
		if (parseInt(MM) == 2) {
			if (DD > 28) {
				return false;
			}
		}
	}
	var mm = new Array(1, 3, 5, 7, 8, 10, 12); //判断每月中的最大天数
	var flag = false;
	for (i = 0; i < mm.length; i++) {
		if (parseInt(MM, 10) == mm[i]) {
			flag = false;
		}
	}
	if (flag == false) {
		if (parseInt(DD) > 31) {
			return false;
		}
	} else {
		if (parseInt(DD) > 30) {
			return false;
		}
	}
	if (parseInt(MM) > 12) {
		return false;
	}
	return true;
},"日期格式不正确！");
 
$.validator.addMethod("validatecertificatenum", function(value, element){
   if(value != null && value != "")
   {
   		var regExpression = /^[a-zA-Z0-9]+$/;
   		var flag = value.search(regExpression);
	    if ( flag == -1 )
	    {
	        return false;
	    }
   }
   return true;
	
},"证件编号只能由字母和数字组成！");  


/**
 * 验证日期格式
 */
 $.validator.addMethod("validatedate2", function(value, element) {
	if (value == null || value == "") {
		return true;
	}

	var hour;
	var minute;
	
	hour = value.substr(11, 2);
	minute = value.substr(14, 2);
	if (parseInt(hour) > 23) {
		return false;
	}
	if (parseInt(minute) > 59) {
		return false;
	}

	value = value.substr(0, 10);
	subYY = value.substr(0, 4);
	if (isNaN(subYY) || subYY <= 0) {
		return false;
	}
 	//转换月份
	if (value.indexOf("-", 0) != -1) {
		separate = "-";
	} else {
		if (value.indexOf("/", 0) != -1) {
			separate = "/";
		} else {
			return false;
		}
	}
	area = value.indexOf(separate, 0);
	subMM = value.substr(area + 1, value.indexOf(separate, area + 1) - (area + 1));
	if (isNaN(subMM) || subMM <= 0) {
		return false;
	}
	if (subMM.length < 2) {
		subMM = "0" + subMM;
	}
 	//转换日
	area = value.lastIndexOf(separate);
	subDD = value.substr(area + 1, value.length - area - 1);
	if (isNaN(subDD) || subDD <= 0) {
		return false;
	}
	if (eval(subDD) < 10) {
		subDD = "0" + eval(subDD);
	}
	NewDate = subYY + "-" + subMM + "-" + subDD;
	if (NewDate.length != 10) {
		return false;
	}
	if (NewDate.substr(4, 1) != "-") {
		return false;
	}
	if (NewDate.substr(7, 1) != "-") {
		return false;
	}
	var MM = NewDate.substr(5, 2);
	var DD = NewDate.substr(8, 2);
	if ((subYY % 4 == 0 && subYY % 100 != 0) || subYY % 400 == 0) { //判断是否为闰年
		if (parseInt(MM) == 2) {
			if (DD > 29) {
				return false;
			}
		}
	} else {
		if (parseInt(MM) == 2) {
			if (DD > 28) {
				return false;
			}
		}
	}
	var mm = new Array(1, 3, 5, 7, 8, 10, 12); //判断每月中的最大天数
	var flag = false;
	for (i = 0; i < mm.length; i++) {
		if (parseInt(MM, 10) == mm[i]) {
			flag = false;
		}
	}
	if (flag == false) {
		if (parseInt(DD) > 31) {
			return false;
		}
	} else {
		if (parseInt(DD) > 30) {
			return false;
		}
	}
	if (parseInt(MM) > 12) {
		return false;
	}

	
	
	return true;
},"日期格式不正确！");