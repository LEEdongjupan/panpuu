var replyService = (function replyService() {

    const host="/replies/"

    function countUp() {
        return ++idx;
    }
    function updateReply(vo,callback) {
   	 $.ajax({
            type:"put",
            url:host+"modify",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify(vo),
            success: function () {
                if(callback){
                    callback();
                }
            }
        })
	}
    function removeReply(rno,callback) {
    	 $.ajax({
             type:"delete",
             url:host+rno,
             success: function () {
                 if(callback){
                     callback();
                 }
             }
         })
	}
    
    function addReply(obj,callback) {
        $.ajax({
            type:"post",
            url:host+"new",
            data:JSON.stringify(obj),
            contentType:"application/json;charset=UTF-8",
            success: function () {
                if(callback){
                    callback();
                }
            }
        })
    }
    function getList(bno,callback) {
        $.getJSON(  host+bno+"/1.json", null,  function(arr) {if(callback){callback(arr)}})
    }
    
    function getReply(rno,callback) {
        $.getJSON(host+"/"+rno+".json", null,  function(arr) {if(callback){callback(arr)}})
    }
    return{
    	updateReply:updateReply,
    	getReply:getReply,
    	removeReply:removeReply,
        getList:getList,
        countUp:countUp,
        addReply:addReply
    }



})();