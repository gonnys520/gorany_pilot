


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
            type: 'get',
            url: "/search/" + keyword,
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
		
	}
	
	return {
		autoComplete : autoComplete,
		search : search
	};//end return
	
})();