package edu.usf.sas.pal.muser.utils;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class FirebaseIOUtils {
    // fetch list of users
    public static List<QueryDocumentSnapshot> getAllUserIds(Firestore db) {
        CollectionReference collectionReference = db.collection("users");
        return getQueryDocumentSnapshots(collectionReference);
    }

    // fetch data of specify user
    public static List<QueryDocumentSnapshot> getAllInfoByUserIdAndFolder(Firestore db, String userId,
                                                                          String folder) {
        CollectionReference cr = db.collection("users/" + userId + "/" + folder);
        return getQueryDocumentSnapshots(cr);
    }

    // fetch data based on date range
    public static List<QueryDocumentSnapshot> getAllInfoByDateRangeUserIdAndFolder(Firestore db, String userId, long millisStart, long millisEnd,
                                                                                   String folder) {
        CollectionReference cr = db.collection("users/" + userId + "/" + folder);
        Query dateQuery = cr.orderBy("currentTimeMs").startAt(millisStart).endAt(millisEnd);
        return getQuerySnapshots(dateQuery);
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

    private static List<QueryDocumentSnapshot> getQuerySnapshots(Query cr) {
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