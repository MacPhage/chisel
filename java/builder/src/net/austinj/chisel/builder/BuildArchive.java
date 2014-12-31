/**
 * Created by Tarun on 12/30/2014.
 */

package net.austinj.chisel.builder;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class BuildArchive {

    private static File buildDirectory = new File("build/");
    private static File directoryToZip;
    private static String outName;
    private static List<File> fileList = new ArrayList<File>();

    private static Timer timer = new Timer();

    public static void start(String[] args) {
        new Thread(() -> {
            timer.startTimer();
            System.out.print("Building archive...");
            while (true) {
                try {
                    Thread.sleep(500);
                    System.out.print(".");
                } catch (InterruptedException e) {
                    System.out.println("Something went wrong");
                }
            }
        }).start();

        try {
            directoryToZip = new File(args[0]);
            outName = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: java BuildArchive <directory name> <output file name>");
            System.exit(0);
        }

        if (!buildDirectory.exists()) {
            buildDirectory.mkdir();
        }

        getAllFiles(directoryToZip); // Adds all files in the given directory (args[0]) to the ArrayList
        writeZipFile(directoryToZip); // Creates the archive with the given name (args[1])

        timer.stopTimer();
        System.out.println("\nCreated Application: build/" + outName);
        System.out.println("Finished task in "+timer.getTimerDuration()+" seconds.");
        System.exit(0); // Required for the other thread to stop
    }

    public static void getAllFiles(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            fileList.add(file);
            if (file.isDirectory()) {
                getAllFiles(file);
            }
        }
    }

    public static void writeZipFile(File directoryToZip) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(buildDirectory, outName));
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (File file : fileList) {
                if (!file.isDirectory()) { // we only zip files, not directories
                    addToZip(directoryToZip, file, zos);
                }
            }

            zos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) {
        try {
            FileInputStream fis = new FileInputStream(file);

            // we want the zipEntry's path to be a relative path that is relative
            // to the directory being zipped, so chop off the rest of the path
            String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1, file.getCanonicalPath().length());
            ZipEntry zipEntry = new ZipEntry(zipFilePath);
            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }

            zos.closeEntry();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

