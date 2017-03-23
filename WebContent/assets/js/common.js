function getPath(){
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	if(contextPath=="view"){
		contextPath = "";
	}
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	return basePath;
}

function getUrl(path){
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	if(contextPath=="view"){
		contextPath = "";
	}
	var basePath = [];
	basePath.push(localObj.protocol);
	basePath.push("//");
	basePath.push(localObj.host);
	basePath.push("/");
	basePath.push(contextPath);
	basePath.push(path);
	return basePath.join("");
}

function getTableActions(showFun,editFun,delFun){
	var dom = [];
	dom.push('<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">');
	if(showFun != ""){
		dom.push('		<a class="blue" title="查看" href="javascript:'+showFun+'">');
		dom.push('			<i class="icon-zoom-in bigger-130"></i>查看');
		dom.push('		</a>');
	}
	if(editFun != ""){
		dom.push('		<a class="green" title="编辑"   href="javascript:'+editFun+'">');
		dom.push('			<i class="icon-edit bigger-130"></i>编辑');
		dom.push('		</a>');
	}
	if(delFun != ""){
		dom.push('		<a class="red" title="删除" href="javascript:'+delFun+'">');
		dom.push('			<i class="icon-trash bigger-130"></i>删除');
		dom.push('		</a>');
	}
	dom.push('</div>');
	dom.push('<div class="visible-xs visible-sm hidden-md hidden-lg">');
	dom.push('		<div class="inline position-relative">');
	dom.push('			<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">');
	dom.push('				<i class="icon-caret-down icon-only bigger-120"></i>');
	dom.push('			</button>');
	dom.push('			<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">');
	if(showFun != ""){
		dom.push('				<li>');
		dom.push('					<a href="#" class="tooltip-info" data-rel="tooltip" title="查看" onclick="'+showFun+'">');
		dom.push('						<span class="blue">');
		dom.push('							<i class="icon-zoom-in bigger-120"></i>查看');
		dom.push('						</span>');
		dom.push('					</a>');
		dom.push('				</li>');
	}
	if(editFun != ""){
		dom.push('				<li>');
		dom.push('					<a href="#" class="tooltip-success" data-rel="tooltip" title="编辑" onclick="'+editFun+'">');
		dom.push('						<span class="green">');
		dom.push('							<i class="icon-edit bigger-120"></i>编辑');
		dom.push('						</span>');
		dom.push('					</a>');
		dom.push('				</li>');
	}
	if(delFun != ""){
		dom.push('				<li>');
		dom.push('					<a href="#" class="tooltip-error" data-rel="tooltip" title="删除" onclick="'+delFun+'">');
		dom.push('						<span class="red">');
		dom.push('							<i class="icon-trash bigger-120"></i>删除');
		dom.push('						</span>');
		dom.push('					</a>');
		dom.push('				</li>');
	}
	dom.push('			</ul>');
	dom.push('		</div>');
	dom.push('</div>');
	return dom.join('');
}

function request(paras) {
	var url = location.href;
	var paraString = url.substring(url.indexOf("?") + 1, url.length).split(
			"&");
	var paraObj = {};
	for ( var i = 0; j = paraString[i]; i++) {
		paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j
				.substring(j.indexOf("=") + 1, j.length);
	}
	var returnValue = paraObj[paras.toLowerCase()];
	if (typeof (returnValue) == "undefined") {
		return "";
	} else {
		return returnValue;
	}
}

Date.prototype.format = function(format) {  
    /* 
     * eg:format="yyyy-MM-dd hh:mm:ss"; 
     */  
    var o = {  
        "M+" : this.getMonth() + 1, // month  
        "d+" : this.getDate(), // day  
        "h+" : this.getHours(), // hour  
        "m+" : this.getMinutes(), // minute  
        "s+" : this.getSeconds(), // second  
        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter  
        "S" : this.getMilliseconds()  
        // millisecond  
    }; 
  
    if (/(y+)/.test(format)) {  
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4  
                        - RegExp.$1.length));  
    }  
  
    for (var k in o) {  
        if (new RegExp("(" + k + ")").test(format)) {  
            format = format.replace(RegExp.$1, RegExp.$1.length == 1  
                            ? o[k]  
                            : ("00" + o[k]).substr(("" + o[k]).length));  
        }  
    }  
    return format;  
};