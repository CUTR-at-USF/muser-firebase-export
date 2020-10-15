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
		    	    MusicAnalysisModel tbr1 = new MusicAnalysisModel(userId);
			        MusicAnalysisModel tbr = doc.toObject(MusicAnalysisModel.class);
			        tbr1.setCurrentTimeMs(tbr.getCurrentTimeMs());
			        tbr1.setNanoTime(tbr.getNanoTime());
			        tbr1.setPlayerEventType(tbr.getPlayerEventType());
			        tbr1.setSeekPositionMs(tbr.getSeekPositionMs());
			        tbr1.setmAlbumID(tbr.song.getAlbumID());
			        tbr1.setmAlbumName(tbr.song.getAlbumName());
			        tbr1.setmArtistID(tbr.song.getArtistID());
			        tbr1.setmArtistName(tbr.song.getAlbumName());
			        tbr1.setmBitrateLabel(tbr.song.getBitrateLabel());
			        tbr1.setmDateAdded(tbr.song.getDateAdded());
			        tbr1.setmDiscNumber(tbr.song.getDiscNumber());
			        tbr1.setmDuration(tbr.song.getDuration());
			        tbr1.setmFileSizeLabel(tbr.song.getFileSizeLabel());
			        tbr1.setmFormatLabel(tbr.song.getFormatLabel());
			        tbr1.setmId(tbr.song.getId());
			        tbr1.setmLastPlayed(tbr.song.getLastPlayed());
			        tbr1.setmName(tbr.song.getName());
			        tbr1.setmPath(tbr.song.getPath());
			        tbr1.setmPlayCount(tbr.song.getPlayCount());
			        tbr1.setmPlaylistID(tbr.song.getPlaylistID());
			        tbr1.setmPlaylistPlayOrder(tbr.song.getPlaylistPlayOrder());
			        tbr1.setmPodCast(tbr.song.getPodCast());
			        tbr1.setmSampleRateLabel(tbr.song.getSampleRateLabel());
			        tbr1.setmTrack(tbr.song.getTrack());
			        tbr1.setmYear(tbr.song.getYear());
			        musicAnalysisList.add(tbr1);
			        mCSVFileWriter.appendAllToCsV(musicAnalysisList);
			        musicAnalysisList.clear();
			       
	        }
	}
	private void processUserByIdForUiEvent(String userId) {
        List<QueryDocumentSnapshot> userInfoById = new ArrayList<>(mFirebaseReader.getAllUserUIInfoById(userId));
		    for (QueryDocumentSnapshot doc : userInfoById) {
		    	    MusicAnalysisModel tbr1 = new MusicAnalysisModel(userId);
			        MusicAnalysisModel tbr = doc.toObject(MusicAnalysisModel.class);
			        tbr1.setCurrentTimeMs(tbr.getCurrentTimeMs());
			        tbr1.setNanoTime(tbr.getNanoTime());
			        tbr1.setUiEventType(tbr.getUiEventType());
			        tbr1.setSeekPositionMs(tbr.getSeekPositionMs());
			        tbr1.setmAlbumID(tbr.song.getAlbumID());
			        tbr1.setmAlbumName(tbr.song.getAlbumName());
			        tbr1.setmArtistID(tbr.song.getArtistID());
			        tbr1.setmArtistName(tbr.song.getAlbumName());
			        tbr1.setmBitrateLabel(tbr.song.getBitrateLabel());
			        tbr1.setmDateAdded(tbr.song.getDateAdded());
			        tbr1.setmDiscNumber(tbr.song.getDiscNumber());
			        tbr1.setmDuration(tbr.song.getDuration());
			        tbr1.setmFileSizeLabel(tbr.song.getFileSizeLabel());
			        tbr1.setmFormatLabel(tbr.song.getFormatLabel());
			        tbr1.setmId(tbr.song.getId());
			        tbr1.setmLastPlayed(tbr.song.getLastPlayed());
			        tbr1.setmName(tbr.song.getName());
			        tbr1.setmPath(tbr.song.getPath());
			        tbr1.setmPlayCount(tbr.song.getPlayCount());
			        tbr1.setmPlaylistID(tbr.song.getPlaylistID());
			        tbr1.setmPlaylistPlayOrder(tbr.song.getPlaylistPlayOrder());
			        tbr1.setmPodCast(tbr.song.getPodCast());
			        tbr1.setmSampleRateLabel(tbr.song.getSampleRateLabel());
			        tbr1.setmTrack(tbr.song.getTrack());
			        tbr1.setmYear(tbr.song.getYear());
			        tbr1.setStartTime(tbr.getStartTime());
			        tbr1.setElapsedTime(tbr.getElapsedTime());
			        musicAnalysisList.add(tbr1);
			        mCSVFileWriter.appendAllToCsV(musicAnalysisList);
			        musicAnalysisList.clear();
			       
	        }
	}
}
