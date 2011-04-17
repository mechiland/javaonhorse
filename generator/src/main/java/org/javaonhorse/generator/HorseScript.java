package org.javaonhorse.generator;

import org.apache.commons.cli.*;

/**
 * Main entry for horse sciript.
 *
 * horse new  -- create new
 * horse server -- start the server
 * horse generate controller Welcome index new -- generate controller
 *
 */
public class HorseScript {

    public static void main(String[] args) throws Exception {
        Options options = new Options();
        CommandLineParser parser = new PosixParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.getArgs().length == 0) {
            help();
            return;
        }
        String subcommand = cmd.getArgs()[0];

        if ("new".equals(subcommand)) {
            try {
                new NewApp(cmd.getArgs()[1]).run();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Unknow command: " + subcommand);
        }

    }

    private static void help() {
        System.out.println("Usage: \nhorse new APP_PATH [options]");
    }

}
