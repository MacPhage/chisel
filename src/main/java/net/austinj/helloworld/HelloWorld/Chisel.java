package net.austinj.helloworld.HelloWorld;

import org.lesscss.LessCompiler;
import org.lesscss.LessException;

/**
 * Hello world!
 *
 */
public class Chisel 
{
    public static void main( String[] args )
    {
    	LessCompiler l = new LessCompiler();
        try {
			System.out.println(l.compile("@variable: rgb(255,25,132); body{ background: @variable; }"));
		} catch (LessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
