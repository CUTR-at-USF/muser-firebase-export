package edu.usf.sas.pal.muser.utils;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class FirebaseIOUtils {
    public static List<QueryDocumentSnapshot> getAllUserIds(Firestore db) {
        CollectionReference collectionReference = db.collection("users");
        return getQueryDocumentSnapshots(collectionReference);
    }


    public static List<QueryDocumentSnapshot> getAllRecordIdsByUserIdAndFolder(Firestore db, String userId,
                                                                               String folder) {
        CollectionReference cr = db.collection("users/" + userId + "/" + folder);
        return getQueryDocumentSnapshots(cr);
    }


    private static String buildDocumentPathByUid(String uid, String folder) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append("users/").append(uid).append("/").
                append(folder);
        return pathBuilder.toString();
    }

    public static DocumentReference getFirebaseDocReferenceByUserIdAndRecordId(Firestore db, String userId,
                                                                               String recordId, String folder) {
        String path = buildDocumentPathByUid(userId, folder);
        return db.collection(path).document(recordId);
    }

    private static List<QueryDocumentSnapshot> getQueryDocumentSnapshots(CollectionReference cr) {
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = cr.get();
        try {
            return querySnapshotApiFuture.get().getDocuments();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
