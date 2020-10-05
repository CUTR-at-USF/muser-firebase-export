package edu.usf.cutr.mfe.io;
import com.opencsv.CSVWriter;
import edu.usf.cutr.mfe.constants.FirebaseConstants;
import edu.usf.cutr.mfe.model.MusicAnalysisModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter {
	private CSVWriter mCSVWriter;
	public CSVFileWriter() {
		try {
			File file = new File(FirebaseConstants.MUSIC_ANALYSIS_CSV_FILE);
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);
			mCSVWriter = new CSVWriter(outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createHeader(String[] header) {
		mCSVWriter.writeNext(header);
	}

	public void appendAllToCsV(List<MusicAnalysisModel> musicAnalysisModel) {
		for (MusicAnalysisModel tbr : musicAnalysisModel) {

			appendToCsV(tbr);

		}
	}

	private void appendToCsV(MusicAnalysisModel musicAnalysisModel) {
		mCSVWriter.writeNext(musicAnalysisModel.toStringArray());
	}

	public void closeWriter() {
		try {
			mCSVWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
