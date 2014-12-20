//Important global code here

var gui = require("nw.gui");
var win = gui.Window.get();

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
