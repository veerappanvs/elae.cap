$(document).ready(function() {
	
	
	$('[class^="col-sm-"]:has(.col-form-label.float-right.font-weight-bold)').css("padding-right", "0");
	textAreaInit();
	
	if (typeof(pageLoad) === "function") {
		pageLoad();
		}
	
	if(typeof(pageName)!="undefined"){
	$('.list-unstyled li').removeClass('active');
	$('#'+pageName).addClass('active');
	}
	
	$("form").on("submit", function(){
		var lastTime = $(this).data("lastSubmitTime");
		if (lastTime && typeof lastTime === "object") {
		    var now = new Date();
		    if ((now - lastTime) > 30000) // 2000ms
		        return true;
		    else
		        return false;
		}
		$(this).data("lastSubmitTime", new Date());
		return true;
		 })
	
    });



function textAreaInit(){
	
	var isCtrlV=false;
	var originalTxt = [];

	
	if (typeof(autosize) === "function") {
	autosize($('textarea'));
	}
	
	
	if (typeof(autosize) === "function") {
		autosize($('textarea'));
		}
		
		$('textarea:not([maxLength])').attr('maxLength','4000');

		
		$('textarea').each(function( index ) {
			  if($(this).next('.countchar').length==0)
				 $(this).after('<div class="countchar" style="width:100%;text-align:left"></div>');
			});
		
		$('textarea').each(
				function(){
					var maxlen = this.maxLength==-1?4000:this.maxLength;
					var length = $(this).val().length;
					var text=$(this).val();
					$(this).val(text);
			        $(this).next('.countchar').html('<span" >Count: '+(maxlen-length )+' chars left</span>');
			    }
		);
		
		$('textarea').on('keydown',function(e) {
			if(e.ctrlKey && e.keyCode==86)
				isCtrlV=true;
			originalTxt.push($(this).val());
			console.log('keydown ' +originalTxt.length);
		});
		
		$('textarea').on('keyup paste',function(e) 
			{
		
			if(e.type=='keyup'&&(isCtrlV && e.keyCode==86)||e.keyCode==17){
				isCtrlV=false;
				return;
			}
				
				var maxlen = this.maxLength==-1?4000:this.maxLength;
				
				var text=$(this).val();
				
				var length = text.length;
				
				var  copyText='';
				
				  if(e.type=='paste'){
				  copyText=e.originalEvent.clipboardData.getData('text').replace(/(\r\n|\n|\r)/g, "\r\n");
				  length=length+copyText.length;
				  }
				  if(length > (maxlen)){
					  $(this).next().css('font-weight','bold').css('color','red');
					  $(this).next().html('<span>Count: max length '+maxlen+' chars only!</span>')
					 					  
					  while (originalTxt.length>0) {
						  $(this).val(originalTxt.pop());
				        }
				 
					  console.log(length);
					  e.preventDefault();
				  }
				  else
				    {
					  while (originalTxt.length>0) {
						  originalTxt.pop();
				        }
					  $(this).next().css('color','black').css('font-weight','normal');
					  $(this).next().html('<span>Count: '+(maxlen-length )+' chars left</span>');
				    }
				  
				  
				});
}


function loadGlobalMessages(message){
	$('#global-errors').append('<span class="error" >'+message+'</span>');
}

function resetFormData(path){

	var uri=path;
	
	$.ajax({
		type : "GET",
		url : uri,
		 async: false,
		success : function(response) {},
		error : function(msg, url, line) {
			targetElement.after('<span class="error" >Unknown System Exception</span>');
		}
	});
}

function loadDropDown(path,targetElementId) {		
		var targetElement = $('#' + targetElementId);
		var elementName=targetElement.attr("name");
		targetElement.val('');
		targetElement.children('option:not(:first)').remove();
		var uri=path;

		$.ajax({
			type : "GET",
			url : uri,
			 async: false,
			success : function(response) {
				$.each(response, function( key, value) {
					targetElement.append($("<option></option>").attr("value",
							key).text(value));
				});
			},
			error : function(msg, url, line) {
				targetElement.after('<span class="error" >Unknown System Exception</span>');
			}
		});
	}

function loadDropDownWithSortOrder(path,targetElementId) {		
	var targetElement = $('#' + targetElementId);
	var elementName=targetElement.attr("name");
	targetElement.val('');
	targetElement.children('option:not(:first)').remove();
	var uri=path;

	$.ajax({
		type : "GET",
		url : uri,
		 async: false,
		success : function(response) {
			$.each(response, function( index, map) {
				targetElement.append($("<option></option>").attr("value",
						map.key).text(map.value));
			});
		},
		error : function(msg, url, line) {
			targetElement.after('<span class="error" >Unknown System Exception</span>');
		}
	});
}



function loadDataTable(path,update,process,emptyMessage,errorSection){
	
	
	if(typeof(errorSection)==='undefined')
		errorSection='error-section';
	
	$('#'+errorSection).text("");
	
	var processElements = process.split(',');
	
	var parameters=[];
	
	for (element in processElements) {	
		parameter={name:$('#'+processElements[element]).attr("name"),value: $('#'+processElements[element]).val()}
		parameters.push(parameter);
    }
	
	var queryString=jQuery.param(parameters);
	
	if(queryString!='')
		queryString='?'+queryString;
	
	var uri= path +queryString;
	
	 jQuery.param(parameters);
	
	var elementName=$('#'+process).attr("name");
	
	
	jQuery.support.cors = true;
	$.ajax({
				type : "GET",
				url : uri,
				async : false,
				success : function(
						response) {

					$('#'+ update+'Wrapper' ).text("");
					
					result=$(response).find('#'+update+'Datatable');
					
					if(result.length==0){
						result=$(response).children()[0];
						$('#'+errorSection ).append(result);
					return;
					}
					
					$('#'+ update+'Wrapper' ).append(result);
					
					result.dataTable({																		
								"language": {
							      "emptyTable": emptyMessage
						    } });														
					
				},
				error : function(msg,
						url, line) {
					$('#table-section')
							.text(
									'Unknown Exception');
				}
			});
	
	
}
var originalVal = $.fn.val;

$.fn.val = function (value) {
    if (typeof value == 'undefined') {
        if ($(this).is("textarea")) {
            return originalVal.call(this)
                .replace(/(\r\n|\n|\r)/g, "\r\n");
        }

        return originalVal.call(this);
    }
    else {
        return originalVal.call(this, value);
    }
};


String.prototype.includes = function (str) {
	  var returnValue = false;

	  if (this.indexOf(str) !== -1) {
	    returnValue = true;
	  }

	  return returnValue;
	}

