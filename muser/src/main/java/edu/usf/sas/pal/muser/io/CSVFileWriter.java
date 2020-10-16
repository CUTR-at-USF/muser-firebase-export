package edu.usf.sas.pal.muser.io;

import com.opencsv.CSVWriter;
import edu.usf.sas.pal.muser.constants.FirebaseConstants;
import edu.usf.sas.pal.muser.model.MusicAnalysisModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVFileWriter {

    private CSVWriter csvWriter;

    public CSVFileWriter() {
        try {
            File file = new File(FirebaseConstants.MUSIC_ANALYSIS_CSV_FILE);
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);
            csvWriter = new CSVWriter(outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHeader(String[] header) {
        csvWriter.writeNext(header);
    }

    public void appendAllToCsV(List<MusicAnalysisModel> musicAnalysisModel) {
        for (MusicAnalysisModel tbr : musicAnalysisModel) {

            appendToCsV(tbr);

        }
    }

    private void appendToCsV(MusicAnalysisModel musicAnalysisModel) {
        csvWriter.writeNext(musicAnalysisModel.toStringArray());
    }

    public void closeWriter() {
        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
