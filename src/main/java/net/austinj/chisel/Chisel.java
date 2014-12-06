package net.austinj.chisel;

import java.io.File;
import java.io.IOException;

import net.austinj.chisel.io.SimpleIO;
import net.austinj.chisel.wrappers.UglifyWrapper;

import org.lesscss.LessCompiler;
import org.lesscss.LessException;

public class Chisel 
{
	
    public static void main(String[] args)
    {
    	System.out.println("Starting Chisel...");
    	UglifyWrapper.init();
    	try
    	{
    		if(args[0].equals("compile"))
    		{
    			if(args[1].equals("less"))
    			{
    				if(args[2].equals("-i"))
    				{
    					String lessCode = new LessCompiler().compile(new File(args[3]));
    					if(args[4].equals("-o"))
    					{
    						//String compiledName = args[3].substring(0, args[3].indexOf(".less")) + ".css";
    						SimpleIO.writeFile(lessCode, args[5]);
    					}
    				}
    			}
    			else if(args[1].equals("uglify"))
    			{
    				if(args[2].equals("-i") && args[4].equals("-o"))
    				{
    					String code = SimpleIO.readFile(args[3]);
    					SimpleIO.writeFile(UglifyWrapper.uglifyString(code), args[5]);
    				}
    			}
    		}
    		else if(args[0].equals("help"))
    		{
    			System.out.println("Use:");
    			System.out.println();
    		}
    		else
    		{
    			System.out.println("That wasn\'t a valid command. Try \'help\'.");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
