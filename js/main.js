/*var resources = {
	colors: {
		randomHex: function() {
			var hex = '#';
			var colorOptions = [1,2,3,"a","b","c","d","e","f"];
      for (var i = 0; i < 6; i++) {
        hex += colorOptions[Math.floor(Math.random() * 6)];
      }
			return hex;
		},
		randomHexArray: function() {
			var randomLength = Math.floor(Math.random() * 10 + 4);
			var array = [];
			for (var i = 0; i < randomLength; i++) {
				array.push(this.randomHex());
			}
			return array;
		}
	}
}

resources.bg = {
	opacity: 0,
	pattern: new Trianglify({noiseIntensity: 0, x_gradient: resources.colors.randomHexArray(), y_gradient: resources.colors.randomHexArray(), cellsize: 1000, fillOpacity: this.opacity, strokeOpacity: this.opacity}),
	height: function() {
		return Math.max(document.body.scrollHeight, document.documentElement.scrollHeight,document.body.offsetHeight, document.documentElement.offsetHeight,document.body.clientHeight,document.documentElement.clientHeight);
	},
	setBgImage: function() {
    document.body.style.backgroundImage = this.pattern.generate(document.body.clientWidth + 100, this.height() + 100).dataUrl;
	}
}*/

var clicks = 0;

$(document).ready(function() {
	window.scroll(0, 0);
	new WOW().init();
	setTimeout(function() {
		$(".fade-in").animate({opacity: 1});
		$("body").css({"overflow": "scroll"});
	}, 1500);
	setTimeout(function() {
		$(".content-main").fadeIn();
	}, 2000);
	$("#logo img").click(function() {
		clicks++;
		if (clicks === 7) {
			window.location.href = "http://doge2048.com";
		}
	});
});