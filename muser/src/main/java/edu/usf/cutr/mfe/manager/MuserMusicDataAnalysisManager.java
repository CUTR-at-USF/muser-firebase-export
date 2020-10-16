package edu.usf.cutr.mfe.manager;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import edu.usf.cutr.mfe.exception.FirebaseFileNotInitializedException;
import edu.usf.cutr.mfe.io.CSVFileWriter;
import edu.usf.cutr.mfe.io.FirebaseReader;
import edu.usf.cutr.mfe.model.MusicAnalysisModel;
import edu.usf.cutr.mfe.options.ProgramOptions;
import java.util.ArrayList;
import java.util.List;

public class MuserMusicDataAnalysisManager {
	private CSVFileWriter mCSVFileWriter;
	private FirebaseReader mFirebaseReader;
	private ProgramOptions mProgramOptions;
	private List<MusicAnalysisModel> musicAnalysisList;
	public MuserMusicDataAnalysisManager() throws FirebaseFileNotInitializedException {
        mFirebaseReader = new FirebaseReader();
        mCSVFileWriter = new CSVFileWriter();
        musicAnalysisList = new ArrayList<>();
        mProgramOptions = ProgramOptions.getInstance();
    }
	public void processData() {
        // create csv file and add the header
        mCSVFileWriter.createHeader(MusicAnalysisModel.CSV_HEADER);
        if (mProgramOptions.getUserId() == null) {
            // analyze all data and append the data in the csv file
            analyzeAllUsersMusicData();
        } else {
            // analyze specific user data
        	processUserByIdForPlayerEvent(mProgramOptions.getUserId());
        	processUserByIdForUiEvent(mProgramOptions.getUserId());
        }
        //close the csv file
        mCSVFileWriter.closeWriter();
    }
	private void analyzeAllUsersMusicData() {
        List<QueryDocumentSnapshot> allUserIds = mFirebaseReader.getAllUserIds();
        for (QueryDocumentSnapshot doc : allUserIds) {
            processUserByIdForPlayerEvent(doc.getId());
            processUserByIdForUiEvent(doc.getId());
        }
    }
	private void processUserByIdForPlayerEvent(String userId) {
        List<QueryDocumentSnapshot> userInfoById = new ArrayList<>(mFirebaseReader.getAllUserInfoById(userId));
		    for (QueryDocumentSnapshot doc : userInfoById) {
		    	    MusicAnalysisModel mam1 = new MusicAnalysisModel(userId);
			        MusicAnalysisModel mam = doc.toObject(MusicAnalysisModel.class);
			        processSetterForUiEventAndPlayerevenets(mam1,mam);
			       
	        }
	}
	private void processUserByIdForUiEvent(String userId) {
        List<QueryDocumentSnapshot> userInfoById = new ArrayList<>(mFirebaseReader.getAllUserUIInfoById(userId));
		    for (QueryDocumentSnapshot doc : userInfoById) {
		    	    MusicAnalysisModel mam1 = new MusicAnalysisModel(userId);
			        MusicAnalysisModel mam = doc.toObject(MusicAnalysisModel.class);
			        processSetterForUiEventAndPlayerevenets(mam1,mam);
			        
			       
	        }
	}
	
	private void processSetterForUiEventAndPlayerevenets(MusicAnalysisModel mam1,MusicAnalysisModel tbr) {
		//System.out.print(doc.getId());
		mam1.setCurrentTimeMs(tbr.getCurrentTimeMs());
		mam1.setNanoTime(tbr.getNanoTime());
		mam1.setPlayerEventType(tbr.getPlayerEventType());
		mam1.setUiEventType(tbr.getUiEventType());
		mam1.setSeekPositionMs(tbr.getSeekPositionMs());
		mam1.setmAlbumID(tbr.song.getAlbumID());
		mam1.setmAlbumName(tbr.song.getAlbumName());
		mam1.setmArtistID(tbr.song.getArtistID());
		mam1.setmArtistName(tbr.song.getAlbumName());
		mam1.setmBitrateLabel(tbr.song.getBitrateLabel());
		mam1.setmDateAdded(tbr.song.getDateAdded());
		mam1.setmDiscNumber(tbr.song.getDiscNumber());
		mam1.setmDuration(tbr.song.getDuration());
		mam1.setmFileSizeLabel(tbr.song.getFileSizeLabel());
		mam1.setmFormatLabel(tbr.song.getFormatLabel());
		mam1.setmId(tbr.song.getId());
		mam1.setmLastPlayed(tbr.song.getLastPlayed());
		mam1.setmName(tbr.song.getName());
		mam1.setmPath(tbr.song.getPath());
		mam1.setmPlayCount(tbr.song.getPlayCount());
		mam1.setmPlaylistID(tbr.song.getPlaylistID());
		mam1.setmPlaylistPlayOrder(tbr.song.getPlaylistPlayOrder());
		mam1.setmPodCast(tbr.song.getPodCast());
		mam1.setmSampleRateLabel(tbr.song.getSampleRateLabel());
        mam1.setmTrack(tbr.song.getTrack());
        mam1.setmYear(tbr.song.getYear());
        mam1.setStartTime(tbr.getStartTime());
        mam1.setElapsedTime(tbr.getElapsedTime());
        musicAnalysisList.add(mam1);
        mCSVFileWriter.appendAllToCsV(musicAnalysisList);
        musicAnalysisList.clear();
	}
}
