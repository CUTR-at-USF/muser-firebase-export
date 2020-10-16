package edu.usf.sas.pal.muser.options;

public class ProgramOptions {
	private static ProgramOptions programOptions = null;
	
	private ProgramOptions() {
	}
	
	public static final String KEY_FILE = "keyFile";
	public static final String USER_ID = "userId";
	private String mKeyFilePath;
	private String mUserId;
	
	public static ProgramOptions getInstance() {
		if (programOptions == null) {
			programOptions = new ProgramOptions();
		}
		return programOptions;
	}

	public String getKeyFilePath() {
		return mKeyFilePath;
	}

	public ProgramOptions setKeyFilePath(String keyFilePath) {
		mKeyFilePath = keyFilePath;
		return this;
	}

	public String getUserId() {
		return mUserId;
	}

	public ProgramOptions setUserId(String userId) {
		mUserId = userId;
		return this;
	}
}