package net.austinj.chisel.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AustinJ on 12/30/2014.
 */
public class EntryPoint
{

    private static String operation = "default"; //This selects which class to use
    private static String[] baton = {"default"}; //This passes the additional arguments to each class
    private static String usageMessage = "Usage: java -jar builder.jar <operation> [options...]";

    public static void main(String args[])
    {

        try
        {
            operation =  args[0].toLowerCase();
            baton = getOptions(args);
        }
        catch(IndexOutOfBoundsException e) //If the user enters no additional arguments
        {
            System.out.println(usageMessage);
            System.exit(0);
        }

        if(operation.equals("BuildArchive"))
        {
            BuildArchive.start(baton);
        }
        else if(operation.equals("MakeOSXApp"))
        {
            //MakeOSXApp.start();
        }
        else
        {
            System.out.println(usageMessage);
        }

    }

    public static String[] getOptions(String[] arr) //Removes the first index of the String array
    {
        String[] options = new String[arr.length-1];

        for(int i = 1; i < arr.length; i++)
        {
            options[i-1] = arr[i];
        }

        return options;

    }

}
