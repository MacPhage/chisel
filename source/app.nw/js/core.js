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

// Commenting this out until chisel.json is fully implemented.
/*
//Generates commandline arguments as a String
var args = "";
gui.App.argv.forEach(function(val, index, array) {
    args += (index + ': ' + val)+"\n";
});
alert(args);

//Reads the file given in the commandline arguments
var file;
try {
    file = fs.readFileSync(String(gui.App.argv[0]),"utf8");

} catch(err) {
    alert("There was an error: " + err);
}
alert(file);

//chisel.json parsed and applied to the 'chisel' variable
var chisel = JSON.parse(String(file));

alert("Ready to do the thing!");
//Ready for actioning B-)
*/
