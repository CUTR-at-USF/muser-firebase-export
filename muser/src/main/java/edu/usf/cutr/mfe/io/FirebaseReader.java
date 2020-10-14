package edu.usf.cutr.mfe.io;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import edu.usf.cutr.mfe.constants.FirebaseConstants;
import edu.usf.cutr.mfe.exception.FirebaseFileNotInitializedException;
import edu.usf.cutr.mfe.options.ProgramOptions;
import edu.usf.cutr.mfe.utils.FirebaseIOUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FirebaseReader {

	private Firestore mFirestoreDB;

	public FirebaseReader() throws FirebaseFileNotInitializedException {
		initFirebase();
	}

	private void initFirebase() throws FirebaseFileNotInitializedException {
		FileInputStream serviceAccount = null;
		try {
			String filePath = ProgramOptions.getInstance().getKeyFilePath();
			if (filePath == null) {
				throw new FirebaseFileNotInitializedException();
			}
			serviceAccount = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		FirestoreOptions options = null;
		try {
			options = FirestoreOptions.newBuilder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setTimestampsInSnapshotsEnabled(true).build();
		} catch (IOException e) {
			e.printStackTrace();
		}

		mFirestoreDB = options.getService();
	}

	public List<QueryDocumentSnapshot> getAllUserIds() {
		return FirebaseIOUtils.getAllUserIds(mFirestoreDB);
	}

	public List<QueryDocumentSnapshot> getAllUserInfoById(String userId) {
		return FirebaseIOUtils.getAllRecordIdsByUserIdAndFolder(mFirestoreDB, userId,
				FirebaseConstants.FIREBASE_PLAYER_EVENTS_FOLDER);
	}

	public List<QueryDocumentSnapshot> getAllUserUIInfoById(String userId) {
		return FirebaseIOUtils.getAllRecordIdsByUserIdAndFolder(mFirestoreDB, userId,
				FirebaseConstants.FIREBASE_UI_EVENTS_FOLDER);
	}
	
}
