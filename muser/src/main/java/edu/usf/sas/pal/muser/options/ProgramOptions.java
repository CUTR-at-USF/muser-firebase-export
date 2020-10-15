package edu.usf.sas.pal.muser.options;

public class ProgramOptions {
    private static ProgramOptions programOptions = null;

    private ProgramOptions() {
    }

    public static final String KEY_FILE = "keyFile";
    public static final String USER_ID = "userId";
    private String KeyFilePath;
    private String UserId;

    public static ProgramOptions getInstance() {
        if (programOptions == null) {
            programOptions = new ProgramOptions();
        }
        return programOptions;
    }

    public String getKeyFilePath() {
        return KeyFilePath;
    }

    public ProgramOptions setKeyFilePath(String keyFilePath) {
        KeyFilePath = keyFilePath;
        return this;
    }

    public String getUserId() {
        return UserId;
    }

    public ProgramOptions setUserId(String userId) {
        UserId = userId;
        return this;
    }

}
