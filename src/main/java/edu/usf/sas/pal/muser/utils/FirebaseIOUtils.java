package edu.usf.sas.pal.muser.utils;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class FirebaseIOUtils {
    
    public static List<QueryDocumentSnapshot> getAllUserIds(Firestore db) {
    	// fetch list of users
        CollectionReference collectionReference = db.collection("users");
        return getQueryDocumentSnapshots(collectionReference);
    }

    public static List<QueryDocumentSnapshot> getAllInfoByUserIdAndFolder(Firestore db, String userId,
                                                                          String folder) {
    	// fetch data of specify user
        CollectionReference cr = db.collection("users/" + userId + "/" + folder);
        return getQueryDocumentSnapshots(cr);
    }
    
    public static List<QueryDocumentSnapshot> getAllInfoByDateRangeUserIdAndFolder(Firestore db, String userId, long millisStart, long millisEnd,
                                                                                   String folder) {
    	// fetch data based on date range
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