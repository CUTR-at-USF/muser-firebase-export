package edu.usf.cutr.mfe.exception;

public class FirebaseFileNotInitializedException extends Exception {
	public FirebaseFileNotInitializedException() {
		super("Firebase file is not initialized.");
	}
}