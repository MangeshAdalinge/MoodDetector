function vdo1(e,t){res=e;for(var n=0;n<t.length;n++){res=res.replace(/\{\{(.*?)\}\}/g,function(e,r){return t[n][r]})}return res}

$(document).ready(function(){
	$(window).load(function(){
	
var mood = $('#auto-form-submit').html();
	if (mood != ''){
		
		$( ".submit input" ).trigger( "click" );
		
	}
		});
});
$(function() {
    $("form").on("submit", function(e) {
       e.preventDefault();
       
       var request = gapi.client.youtube.search.list({
            part: "snippet",
            type: "video",
            q: encodeURIComponent($("#search").val()).replace(/%20/g, "+"),
            maxResults: 3,
            order: "viewCount",
            publishedAfter: "2015-01-01T00:00:00Z"
       }); 
       

       request.execute(function(response) {
          var results = response.result;
          $("#results").html("");
          //$("#results").append(item.id.videoId+""+item.snippet.title+"<br>");
           //$.get("item.html", function(data) {
                //$("#results").append(tplawesome(data, [{"title":item.snippet.title, "videoid":item.id.videoId}]));
          $.each(results.items, function(index, item) {
            $.get("item.html",  function(data) {
                $("#results").append(vdo1(data, [{"title":item.snippet.title, "videoid":item.id.videoId}]));
            });
          });
          resetVideoHeight();
       });
    });
    
    $(window).on("resize", resetVideoHeight);
});

function resetVideoHeight() {
    $(".video").css("height", $("#results").width() * 9/16);
}

function init() {
    gapi.client.setApiKey("AIzaSyBEhTCDSrKF2biiIDXFCIwnRpZkbh62Nb4");
    gapi.client.load("youtube", "v3", function() {
        // yt api is ready
    });
}