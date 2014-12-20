//Important global code here

//'Import' statements
var gui = require("nw.gui");
var win = gui.Window.get();
var fs = require("fs");
var path = require("path");
var execPath = path.dirname(process.execPath);
/*

    execPath on OS X reads:
    /path/to/node-webkit.app/Contents/Frameworks/node-webkit Helper.app/Contents/MacOS

*/


//Cmd+D opens the dev tools at any time
var option = {
    key: "Ctrl+D",
    active: function(){
        require('nw.gui').Window.get().showDevTools();
    },
    failed: function(msg){
        console.log(msg);
    }
};
var shortcut = new gui.Shortcut(option);
gui.App.registerGlobalHotKey(shortcut);

//alert(__dirname);
alert(execPath);
//alert(__filename);

// var chiselFile = fs.readFile("~/sandbox/chisel/test-files/chisel.json","utf8", function(err,data){
//     if(err){
//         return console.log(err);
//     }
// });
//
// alert(chiselFile);
// var chisel = JSON.parse(chiselFile.toString());
//
// alert(chisel);
