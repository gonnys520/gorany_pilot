


console.log("Search Module.........");

var searchService = (function(){
	
	function autoComplete(callback,error){
		console.log("autoComplete...........");
		
		$.ajax({
            type: 'post',
            url: "/autocomplete",
            dataType: "json",
            success: function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error: function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});//end ajax
	};
	
	function search(keyword,callback,error){
		console.log("search...............");
		
		$.ajax({
            type: 'post',
            url: "/search",
            dataType: "json",
            success: function(keyword,status,xhr){
				if(callback){
					callback(keyword);
				}
			},
			error: function(xhr,status,er){
				if(error){
					error(er);
				}
			}
		});//end ajax
		
	}
	
	return {
		autoComplete : autoComplete,
		search : search
	};//end return
	
})();