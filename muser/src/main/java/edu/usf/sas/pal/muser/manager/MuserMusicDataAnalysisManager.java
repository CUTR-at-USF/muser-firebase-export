package edu.usf.sas.pal.muser.manager;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import edu.usf.sas.pal.muser.exception.FirebaseFileNotInitializedException;
import edu.usf.sas.pal.muser.io.CSVFileWriter;
import edu.usf.sas.pal.muser.io.FirebaseReader;
import edu.usf.sas.pal.muser.model.MusicAnalysisModel;
import edu.usf.sas.pal.muser.options.ProgramOptions;

import java.util.ArrayList;
import java.util.List;

public class MuserMusicDataAnalysisManager {

    private CSVFileWriter csvFileWriter;

    private FirebaseReader firebaseReader;

    private ProgramOptions programOptions;

    private List<MusicAnalysisModel> musicAnalysisList;

    public MuserMusicDataAnalysisManager() throws FirebaseFileNotInitializedException {
        firebaseReader = new FirebaseReader();
        csvFileWriter = new CSVFileWriter();
        musicAnalysisList = new ArrayList<>();
        programOptions = ProgramOptions.getInstance();
    }

    public void processData() {
        // create csv file and add the header
        csvFileWriter.createHeader(MusicAnalysisModel.CSV_HEADER);
        if (programOptions.getUserId() == null) {
            // analyze all data and append the data in the csv file
            analyzeAllUsersMusicData();
        } else {
            // analyze specific user data
            processUserByIdForPlayerEvent(programOptions.getUserId());
            processUserByIdForUiEvent(programOptions.getUserId());
        }
        //close the csv file
        csvFileWriter.closeWriter();
    }

    private void analyzeAllUsersMusicData() {
        List<QueryDocumentSnapshot> allUserIds = firebaseReader.getAllUserIds();
        for (QueryDocumentSnapshot doc : allUserIds) {
            processUserByIdForPlayerEvent(doc.getId());
            processUserByIdForUiEvent(doc.getId());
        }
    }

    private void processUserByIdForPlayerEvent(String userId) {
        List<QueryDocumentSnapshot> userInfoById = new ArrayList<>(firebaseReader.getAllUserInfoById(userId));
        for (QueryDocumentSnapshot doc : userInfoById) {
            MusicAnalysisModel mam1 = new MusicAnalysisModel(userId, doc.getId());
            MusicAnalysisModel mam = doc.toObject(MusicAnalysisModel.class);
            processSetterForUiEventAndPlayerevenets(mam1, mam);
        }
    }

    private void processUserByIdForUiEvent(String userId) {
        List<QueryDocumentSnapshot> userInfoById = new ArrayList<>(firebaseReader.getAllUserUIInfoById(userId));
        for (QueryDocumentSnapshot doc : userInfoById) {
            MusicAnalysisModel mam1 = new MusicAnalysisModel(userId, doc.getId());
            MusicAnalysisModel mam = doc.toObject(MusicAnalysisModel.class);
            processSetterForUiEventAndPlayerevenets(mam1, mam);
        }
    }

    private void processSetterForUiEventAndPlayerevenets(MusicAnalysisModel mam1, MusicAnalysisModel mam) {
        mam1.setCurrentTimeMs(mam.getCurrentTimeMs());
        mam1.setNanoTime(mam.getNanoTime());
        mam1.setPlayerEventType(mam.getPlayerEventType());
        mam1.setUiEventType(mam.getUiEventType());
        mam1.setSeekPositionMs(mam.getSeekPositionMs());
        mam1.setmAlbumID(mam.song.getAlbumID());
        mam1.setmAlbumName(mam.song.getAlbumName());
        mam1.setmArtistID(mam.song.getArtistID());
        mam1.setmArtistName(mam.song.getAlbumName());
        mam1.setmBitrateLabel(mam.song.getBitrateLabel());
        mam1.setmDateAdded(mam.song.getDateAdded());
        mam1.setmDiscNumber(mam.song.getDiscNumber());
        mam1.setmDuration(mam.song.getDuration());
        mam1.setmFileSizeLabel(mam.song.getFileSizeLabel());
        mam1.setmFormatLabel(mam.song.getFormatLabel());
        mam1.setmId(mam.song.getId());
        mam1.setmLastPlayed(mam.song.getLastPlayed());
        mam1.setmName(mam.song.getName());
        mam1.setmPath(mam.song.getPath());
        mam1.setmPlayCount(mam.song.getPlayCount());
        mam1.setmPlaylistID(mam.song.getPlaylistID());
        mam1.setmPlaylistPlayOrder(mam.song.getPlaylistPlayOrder());
        mam1.setmPodCast(mam.song.getPodCast());
        mam1.setmSampleRateLabel(mam.song.getSampleRateLabel());
        mam1.setmTrack(mam.song.getTrack());
        mam1.setmYear(mam.song.getYear());
        mam1.setStartTime(mam.getStartTime());
        mam1.setElapsedTime(mam.getElapsedTime());
        musicAnalysisList.add(mam1);
        csvFileWriter.appendAllToCsV(musicAnalysisList);
        musicAnalysisList.clear();
    }
}
