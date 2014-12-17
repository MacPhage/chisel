var colors = require("colors");

function log(type,message){
    if(type === "info"){
        info(message);
    }
    else if(type === "imp"){
        imp(message);
    }
    else if(type === "warn"){
        warn(message);
    }
    else if(type === "error"){
        error(message);
    }
    else if(type === "subtle"){
        subtle(message);
    }
    else{
        info(message);
    }
}

function subtle(m){
    console.log("[Log] "+m.toString().grey.italic);
}

function info(m){
    console.log("[Info] "+m.toString().white);
}

function imp(m){
    console.log("[IMPORTANT] "+m.toString().magenta);
}

function warn(m){
    console.log("[Warn] "+m.toString().yellow.underline);
}

function error(m){
    console.log("[ERROR] "+m.toString().red.bold.underline);
}

function startup(){
    imp("==============================");
    imp("");
    imp("       Starting Chisel");
    imp("");
    imp("==============================");
}
