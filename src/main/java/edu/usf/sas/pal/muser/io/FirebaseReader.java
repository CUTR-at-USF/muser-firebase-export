/*
 * Copyright (C) 2019-2020 University of South Florida
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
            String filePath = ProgramOptions.getInstance().getFileKeyPath();
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

    public List<QueryDocumentSnapshot> getAllUserPlayerEventInfoById(String userId) {
        return FirebaseIOUtils.getAllRecordIdsByUserIdAndFolder(firestoreDB, userId,
                FirebaseConstants.FIREBASE_PLAYER_EVENTS_FOLDER);
    }

    public List<QueryDocumentSnapshot> getAllUserUiEventInfoById(String userId) {
        return FirebaseIOUtils.getAllRecordIdsByUserIdAndFolder(firestoreDB, userId,
                FirebaseConstants.FIREBASE_UI_EVENTS_FOLDER);
    }
}
