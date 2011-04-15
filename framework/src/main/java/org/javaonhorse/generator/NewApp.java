package org.javaonhorse.generator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;

public class NewApp {

    private File appPath;

    public NewApp(String appPath) {
        this.appPath = new File(appPath);
        if (this.appPath.exists()) {
            throw new IllegalArgumentException("Path already existed, please find another one: ["+this.appPath.getAbsolutePath()+"]");
        }
    }

    public void run() throws Exception {
        String home = System.getenv("HORSE_HOME");
        if (StringUtils.isEmpty(home)) {
            home = System.getProperty("HORSE_HOME");
        }
        if (StringUtils.isEmpty(home)) {
            throw new IllegalStateException("HORSE_HOME is not set!");
        }

        System.out.println("Created: " + this.appPath.getAbsolutePath());
        this.appPath.mkdirs();
        FileUtils.copyDirectory(new File(home + "/resources/newapp"), appPath);
    }
}
