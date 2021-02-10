/*
 * Copyright (C) 2019-2020 University of South Florida
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    public void appendAllToCSV(List<MusicAnalysisModel> musicAnalysisModel) {
        for (MusicAnalysisModel mam : musicAnalysisModel) {
            appendToCsV(mam);
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
