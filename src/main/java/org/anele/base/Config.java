package org.anele.base;

public class Config {

    public static String browser = System.getProperty("browser", "edge");
    public static String platform = System.getProperty("platform", "local");
    public static boolean browserOptions = Boolean.parseBoolean(System.getProperty("browserOptions", String.valueOf(false)));
}
