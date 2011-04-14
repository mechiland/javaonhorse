package org.javaonhorse.generator;

import org.apache.commons.cli.*;

public class HorseScript {

    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("new", false, "Create a new horse application");
        options.addOption("t", "tree", false, "Create a new horse application");
        CommandLineParser parser = new PosixParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("new")) {
            System.out.println("fuck");
        } else {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("horse", options);
        }
        System.out.println(cmd.getArgs()[0]);

    }

}
