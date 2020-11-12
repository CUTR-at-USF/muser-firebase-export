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

        List<QueryDocumentSnapshot> userPlayerEventInfoById = new ArrayList<>(firebaseReader.getAllUserPlayerEventInfoById(userId));
        for (QueryDocumentSnapshot doc : userPlayerEventInfoById) {
            MusicAnalysisModel mam = new MusicAnalysisModel(doc.toObject(MusicAnalysisModel.class), doc.getId(), userId);
            musicAnalysisList.add(mam);
            csvFileWriter.appendAllToCsV(musicAnalysisList);
            musicAnalysisList.clear();
        }
    }

    private void processUserByIdForUiEvent(String userId) {
        List<QueryDocumentSnapshot> userUiEventInfoById = new ArrayList<>(firebaseReader.getAllUserUiEventInfoById(userId));
        for (QueryDocumentSnapshot doc : userUiEventInfoById) {
            MusicAnalysisModel mam = new MusicAnalysisModel(doc.toObject(MusicAnalysisModel.class), doc.getId(), userId);
            musicAnalysisList.add(mam);
            csvFileWriter.appendAllToCsV(musicAnalysisList);
            musicAnalysisList.clear();
        }
    }
}
