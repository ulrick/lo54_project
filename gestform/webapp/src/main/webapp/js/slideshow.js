$("document").ready(function(){

	$("#slideshow1").cycle({
		fx : 'scrollLeft',
		timeout : 2000,
		speed : 2500
	});
	
	$("#slideshow2").cycle({
		fx : 'scrollRight',
		timeout : 2000,
		speed : 2500
	});
});