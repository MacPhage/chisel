package net.austinj.chisel;

public class Debug {
    public static void printInfo(String msg) {
        System.out.println("[INFO]: " + msg);
    }

    public static void printWarning(String msg) {
        System.out.println("[WARN]: " + msg);
    }

    public static void printError(Throwable err) {
        System.err.println(err);
    }
}
