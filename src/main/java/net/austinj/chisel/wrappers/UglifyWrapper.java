package net.austinj.chisel.wrappers;

import java.io.FileReader;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.Invocable;

import org.lesscss.LessCompiler;

import net.austinj.chisel.io.SimpleIO;
import net.austinj.chisel.ui.Chisel;

public class UglifyWrapper 
{
	
	final public static ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
	final public static String ERROR = "c1159dbab86936e561f39a5a0f67b050";
	public static String UGLIFY_PATH = "/js/uglify/uglifyjs-2.4.15-nashorn.js";
	public static String UGLIFY_FUNCTION = "uglify";
	public static String DEFAULT_SUFFIX = ".min.js";
	public static String DEFAULT_ARGS = "{}";
	public static String UGLIFY_LIB = "unset";
	//String url = Chisel.class.getResource("/html/index.html").toExternalForm();
	private static String libUrl = Chisel.class.getResource(UGLIFY_PATH).toExternalForm();
	
	
	public static void init()
	{
		try
		{
			System.out.print("Loading UglifyJS2... ");
			UGLIFY_LIB = SimpleIO.readFile(libUrl);
			System.out.println("DONE.");
		}
		catch(Exception e)
		{
			System.out.println("FAILED.");
			e.printStackTrace();
		}
	}
	
	public static String uglifyString(String code, String args) throws Exception
	{
		engine.eval(UGLIFY_LIB);
		Invocable inv = (Invocable) engine;
    	Object result = inv.invokeFunction(UGLIFY_FUNCTION,code,args);
    	return (String) result;
	}
	
	public static String uglifyString(String code) throws Exception
	{
		return uglifyString(code, "{}");
	}
	
	public static void uglifyFile(String input, String output, String args) throws Exception
	{
		String code = SimpleIO.readFile(input);
		SimpleIO.writeFile(uglifyString(code,args), output);
	}
	public static void uglifyFile(String input, String output) throws Exception
	{
		String code = SimpleIO.readFile(input);
		SimpleIO.writeFile(uglifyString(code,DEFAULT_ARGS), output);
	}
	
	
}