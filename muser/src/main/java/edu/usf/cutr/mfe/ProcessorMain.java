package edu.usf.cutr.mfe;

import edu.usf.cutr.mfe.exception.FirebaseFileNotInitializedException;
import edu.usf.cutr.mfe.manager.MuserMusicDataAnalysisManager;
import edu.usf.cutr.mfe.options.ProgramOptions;
import org.apache.commons.cli.*;

/**
 * Main class to set the user id and Admin key file path passed by user through commond line arrguments.
 */
public class ProcessorMain {

    public static void main(String[] args) {

        Options options = createCommandLineOptions();

        ProgramOptions programOptions = ProgramOptions.getInstance();

        CommandLineParser parser = new DefaultParser();


//      try {
//      CommandLine cmd = parser.parse(options, args);
//
//      if (cmd.hasOption(ProgramOptions.KEY_FILE)) {
//          programOptions.setKeyFilePath(cmd.getOptionValue(ProgramOptions.KEY_FILE));
//      } else {
//          System.err.println("Firebase admin key is not provided. \n" +
//                  "Provide an admin key using -keyFile path/to/file.json");
//          return;
//      }
//
//      if (cmd.hasOption(ProgramOptions.USER_ID)) {
//          programOptions.setUserId(cmd.getOptionValue(ProgramOptions.USER_ID));
//      }
//
//  } catch (ParseException e) {
//      System.err.println("Invalid command line options");
//  }
  programOptions.setKeyFilePath("/Users/pradeepipol/Music/RA-OCTOBER/muser-1d7ac-firebase-adminsdk-stkuo-1a5e1fccc4.json");
	programOptions.setUserId("3H1zVpV0LPZeYOGGxFNNHK68TRf1");
        System.out.println("Analysis started!");

        try {
            new MuserMusicDataAnalysisManager().processData();
        } catch (FirebaseFileNotInitializedException e) {
            System.err.println("Firebase file is not initialized properly.");
        }
        System.out.println("Analysis finished!");
    }

    private static Options createCommandLineOptions() {
        Options options = new Options();
        options.addOption(ProgramOptions.USER_ID, true, "Only run the analysis for specific user");
        options.addOption(ProgramOptions.KEY_FILE, true, "Admin key file of the Firebase account");
        return options;
    }
}