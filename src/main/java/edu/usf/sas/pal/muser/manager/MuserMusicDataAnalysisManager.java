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
import edu.usf.sas.pal.muser.utils.DateTimeUtil;

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

        long startDateMillis = programOptions.getStartDate();
        long endDateMillis = programOptions.getEndDate();

        if (DateTimeUtil.validateDatesProvided(startDateMillis, endDateMillis)) {
            // Valid date range provided
            if (programOptions.getUserId() == null) {
                // Filtered query for all users using date range
                filterUsersDataByDataRange(startDateMillis, endDateMillis);
            } else {
                // Filtered query for a specific user using date range
                filterParticularUsersDataByDataRange(startDateMillis, endDateMillis, programOptions.getUserId());
            }
        } else if (programOptions.getUserId() == null) {
            // Fetch and analyze the entire database for all users
            analyzeAllUsersMusicData();
        } else {
            // Fetch and analyze the database for a specific user
            processUserByIdForPlayerEvent(programOptions.getUserId());
            processUserByIdForUiEvent(programOptions.getUserId());
            processUserByIdForDeviceInfo(programOptions.getUserId());
        }

        // close the CSV file
        csvFileWriter.closeWriter();
    }

    private void analyzeAllUsersMusicData() {
        List<QueryDocumentSnapshot> allUserIds = firebaseReader.getAllUserIds();
        for (QueryDocumentSnapshot doc : allUserIds) {
            processUserByIdForPlayerEvent(doc.getId());
            processUserByIdForUiEvent(doc.getId());
            processUserByIdForDeviceInfo(doc.getId());
        }
    }

    private void filterUsersDataByDataRange(long millisStart, long millisEnd) {
        List<QueryDocumentSnapshot> allUserIds = firebaseReader.getAllUserIds();
        for (QueryDocumentSnapshot doc : allUserIds) {
            processUserByDateRangeForPlayerEvent(doc.getId(), millisStart, millisEnd);
            processUserByIdDateRangeForUiEvent(doc.getId(), millisStart, millisEnd);
            processUserByIdDateRangeForDeviceInfo(doc.getId(), millisStart, millisEnd);
        }
    }

    private void filterParticularUsersDataByDataRange(long millisStart, long millisEnd, String userId) {
        processUserByDateRangeForPlayerEvent(userId, millisStart, millisEnd);
        processUserByIdDateRangeForUiEvent(userId, millisStart, millisEnd);
        processUserByIdDateRangeForDeviceInfo(userId, millisStart, millisEnd);
    }

    private void processUserByIdForPlayerEvent(String userId) {
        // get data of Player Events collection based on user id
        List<QueryDocumentSnapshot> userPlayerEventInfoById = new ArrayList<>(firebaseReader.getPlayerEventInfoByUserId(userId));
        for (QueryDocumentSnapshot doc : userPlayerEventInfoById) {
            writeUserInfoToCsv(doc, userId);
        }
    }

    private void processUserByIdForUiEvent(String userId) {
        // get data of UI Events collection based on user id
        List<QueryDocumentSnapshot> userUiEventInfoById = new ArrayList<>(firebaseReader.getUiEventInfoByUserId(userId));
        for (QueryDocumentSnapshot doc : userUiEventInfoById) {
            writeUserInfoToCsv(doc, userId);
        }
    }

    private void processUserByIdForDeviceInfo(String userId) {
        // get data of Device info  collection based on user id
        List<QueryDocumentSnapshot> userDeviceInfoById = new ArrayList<>(firebaseReader.getDeviceInfoByUserId(userId));
        for (QueryDocumentSnapshot doc : userDeviceInfoById) {
            writeUserInfoToCsv(doc, userId);
        }
    }

    private void processUserByDateRangeForPlayerEvent(String userId, long millisStart, long millisEnd) {
        // get data of Player Events collection based on date range and user id
        List<QueryDocumentSnapshot> userByDateRangeForPlayerEvent = new ArrayList<>(firebaseReader.getInfoByDateRangeForPlayerEventInfo(userId, millisStart, millisEnd));
        for (QueryDocumentSnapshot doc : userByDateRangeForPlayerEvent) {
            writeUserInfoToCsv(doc, userId);
        }
    }

    private void processUserByIdDateRangeForUiEvent(String userId, long millisStart, long millisEnd) {
        // get data of Ui Events info collection on date range and user id
        List<QueryDocumentSnapshot> userByIdDateRangeForUiEvent = new ArrayList<>(firebaseReader.getInfoByDateRangeForUiEventInfo(userId, millisStart, millisEnd));
        for (QueryDocumentSnapshot doc : userByIdDateRangeForUiEvent) {
            writeUserInfoToCsv(doc, userId);
        }
    }

    private void processUserByIdDateRangeForDeviceInfo(String userId, long millisStart, long millisEnd) {
        // get data of device info collection on date range and user id
        List<QueryDocumentSnapshot> userByIdDateRangeForUiEvent = new ArrayList<>(firebaseReader.getInfoByDateRangeForUiEventInfo(userId, millisStart, millisEnd));
        for (QueryDocumentSnapshot doc : userByIdDateRangeForUiEvent) {
            writeUserInfoToCsv(doc, userId);
        }
    }

    private void writeUserInfoToCsv(QueryDocumentSnapshot doc, String userId) {
        // Write the Music Analysis Model to CSV
        MusicAnalysisModel mam = new MusicAnalysisModel(doc.toObject(MusicAnalysisModel.class), doc.getId(), userId);
        musicAnalysisList.add(mam);
        csvFileWriter.appendAllToCsv(musicAnalysisList);
        musicAnalysisList.clear();
    }

}
