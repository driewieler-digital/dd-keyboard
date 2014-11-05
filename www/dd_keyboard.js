window.DDK = {};
window.DDK.hide = function(callback) {
		var str="boo";

        cordova.exec(callback, function(err) {
        	console.log("cordova.exec error "+err);
            callback('Nothing to echo.');
        }, "DDKeyboard", "hide", [str]);
    };
    

    
window.DDK.listen = function(callback) {
		var str="boo";

		// store the callback (because after it's been called, we need to set it again
		window.DDK.callback = callback;
		
		var callback2 = function(str) {
			// do the callback
			window.DDK.callback(str);
			// set the callback again.
			window.DDK.listen(window.DDK.callback);
		}
		
        cordova.exec(callback2, function(err) {
        	console.log("cordova.exec error "+err);
            callback2('Nothing to echo.');
        }, "DDKeyboard", "listen", [str]);
    };    