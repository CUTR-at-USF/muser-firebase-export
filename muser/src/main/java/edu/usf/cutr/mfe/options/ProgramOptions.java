package edu.usf.cutr.mfe.options;
public class ProgramOptions {
	private static ProgramOptions sProgramOptions = null;
	private ProgramOptions() {
	}
	public static final String KEY_FILE = "keyFile";
	public static final String USER_ID = "userId";
	private String mKeyFilePath;
	private String mUserId;
	public static ProgramOptions getInstance() {
		if (sProgramOptions == null) {
			sProgramOptions = new ProgramOptions();
		}
		return sProgramOptions;
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
