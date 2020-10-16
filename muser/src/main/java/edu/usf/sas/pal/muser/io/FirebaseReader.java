package edu.usf.sas.pal.muser.io;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import edu.usf.sas.pal.muser.constants.FirebaseConstants;
import edu.usf.sas.pal.muser.exception.FirebaseFileNotInitializedException;
import edu.usf.sas.pal.muser.options.ProgramOptions;
import edu.usf.sas.pal.muser.utils.FirebaseIOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FirebaseReader {

    private Firestore firestoreDB;

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

        firestoreDB = options.getService();
    }

    public List<QueryDocumentSnapshot> getAllUserIds() {
        return FirebaseIOUtils.getAllUserIds(firestoreDB);
    }

    public List<QueryDocumentSnapshot> getAllUserInfoById(String userId) {
        return FirebaseIOUtils.getAllRecordIdsByUserIdAndFolder(firestoreDB, userId,
                FirebaseConstants.FIREBASE_PLAYER_EVENTS_FOLDER);
    }

    public List<QueryDocumentSnapshot> getAllUserUIInfoById(String userId) {
        return FirebaseIOUtils.getAllRecordIdsByUserIdAndFolder(firestoreDB, userId,
                FirebaseConstants.FIREBASE_UI_EVENTS_FOLDER);
    }
}
