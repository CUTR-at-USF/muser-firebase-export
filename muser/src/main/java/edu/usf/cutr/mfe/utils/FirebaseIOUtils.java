package edu.usf.cutr.mfe.utils;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
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
