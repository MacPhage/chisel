package net.austinj.chisel.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.lesscss.deps.org.apache.commons.io.IOUtils;

import net.austinj.chisel.Chisel;

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
	
	public static void writeFile(String contents, String path) throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter(path);
		out.println(contents);
		out.close();
	}
	
	public static String readURL(URL path) throws IOException
	{
        BufferedReader in = new BufferedReader(
        new InputStreamReader(path.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null)
            result += (inputLine+"\n");
        in.close();
        return result;
	}
	
	public static String readURL(String url) throws IOException
	{
		URL path = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(path.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null)
            result += (inputLine+"\n");
        in.close();
        return result;
	}
	
	public static String readJarResource(String path) throws IOException
	{
		String currentLine = "";
		String result = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(Chisel.class.getClass().getResourceAsStream(path)));
		while((currentLine = reader.readLine()) != null)
		{
			result += currentLine;
		}
		return result;
	}
	
}
