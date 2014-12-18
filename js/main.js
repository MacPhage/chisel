new WOW().init();

var resources = {
	colors: {
		randomHex: function() {
			var hex = '#';
			var colorOptions = [0,1,2,3,4,5,6,7,8,9,"a","b","c","d","e","f"];
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
}
