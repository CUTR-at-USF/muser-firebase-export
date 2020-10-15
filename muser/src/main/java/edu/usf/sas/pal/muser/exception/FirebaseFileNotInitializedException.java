package edu.usf.sas.pal.muser.exception;

public class FirebaseFileNotInitializedException extends Exception {
    public FirebaseFileNotInitializedException() {
        super("Firebase file is not initialized.");
    }
}