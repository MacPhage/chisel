package net.austinj.chisel;

import java.io.File;

import org.lesscss.LessCompiler;


public class Chisel
{

    public static void main(String args[])
    {
        LessCompiler l = new LessCompiler();
        try
        {
        	System.out.println(l.compile("body{font-size: 12px; .foo{color: red;}}"));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }


}
