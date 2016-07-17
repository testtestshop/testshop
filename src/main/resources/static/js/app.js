$(function() {
	console.log('tets');

	$('.order-button').avgrund({
		height: 500,
		width: 500,
		holderClass: 'custom',
		showClose: true,
		showCloseText: 'close',
		onBlurContainer: '.container',
		template: $('#order_form')
	});
	
	$('.login-button').avgrund({
		height: 500,
		width: 500,
		holderClass: 'custom',
		showClose: true,
		showCloseText: 'close',
		onBlurContainer: '.container',
		template: $('#login-form')
	});

});