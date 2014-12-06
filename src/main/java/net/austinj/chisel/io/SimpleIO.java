package net.austinj.chisel.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

//Thanks http://goo.gl/0esLdm

public class SimpleIO
{
	
	public static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
	public static String readFile(String path) throws IOException 
	{
		return readFile(path,Charset.defaultCharset());
	}
	
}
