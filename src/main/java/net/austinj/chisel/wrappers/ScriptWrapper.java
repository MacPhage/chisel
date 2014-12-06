package net.austinj.chisel.wrappers;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

import javax.script.*;

import net.austinj.chisel.io.SimpleIO;

public class ScriptWrapper 
{
	
    public static void main( String[] args )
    {
    	try
    	{
    		
    		String s = SimpleIO.readFile("js/alfeo.js");
    	
	    	ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
	    	engine.eval(new FileReader("js/uglify/magic.js"));
	        
	    	Invocable inv = (Invocable) engine;
	    	
	    	Object result = inv.invokeFunction("uglify",s,"{}");
	    	System.out.println(result);
	    	//System.out.println(result.getClass());
	    	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
	
    
    static String fun1(String name) {
        System.out.format("Hi there from Java, %s", name);
        return "greetings from java";
    }
}

class Person
{
	String name;
	Person() {
		name = "bob";
	}
}
