function Alfeo() {
    var textarea = document.getElementById("textarea-main");
    if(textarea.value == undefined || textarea.value == "") {
        sweetAlert({
            title: "You didn't type anything in!",
            text: "In order for Alfeo to evaluate anything, you have to type something in. If you're stuck, try pressing the help button.",
            type: "warning"
        });
    }
    else {
        var cmd = api + "\n" + textarea.value;
        try {
            var myInterpreter = new Interpreter(cmd);
            myInterpreter.run();
            $("#errorbox").addClass("hidden");
        }
        catch(err){
            $("#errorbox").removeClass("hidden");
            document.getElementById("errorbox").innerHTML = ("<span class=\"errorname\">"+err.name+"</span><br><span class=\"errormessage\">"+err.message+"</span>");
        }
        var r = document.getElementById("result-value");
        r.innerHTML = myInterpreter.value;
    }
}

var api = new String();
var helpmarkdown = new String();
var helpShown =  false;

function help(){
    var box = document.getElementById("helpbox");
    var activator = document.getElementById("helpbutton");
    
    box.innerHTML = markdown.toHTML(helpmarkdown);
    if(helpShown == false){
        $("#helpbox").removeClass("hidden");
        activator.innerHTML = "Hide README";
        helpShown = true;
    }
    else {
        $("#helpbox").addClass("hidden");
        activator.innerHTML = "Show README";
        helpShown = false;
    }
}

function factorial(n) {
    var b = 1;
    while(n > 1)
    {
      b *= n;
      n--;
    }
    return b;
}

function pow(a,b) {
    return Math.pow(a,b);
}
function power(a,b) {
    return Math.pow(a,b);
}
function sqrt(a) {
    return Math.sqrt(a);
}
function squareroot(a) {
    return Math.sqrt(a);
}
function nroot(degree,radicand){ // cuberoot of 8 would be nroot(3,8)
    return Math.pow(Math.abs(radicand), (1.0 / degree));
}
//function quadraticFormula(a,b,c){
//    var s1 = NaN, s2 = NaN;
//    try{
//        s1 = ( (-(b)) + Math.sqrt(( b * b) - (4 * a * c)) )  / (2 * a);
//    }
//    catch(Exception)
//}
