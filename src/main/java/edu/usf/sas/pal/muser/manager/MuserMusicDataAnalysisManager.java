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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
        // it will enter if loop if only date range is provided 
        if (programOptions.getStartDate() != null && programOptions.getEndDate() != null && programOptions.getUserId() == null) {
            filterUsersDataByDataRange(getStartDateInMillis(), getEndDateInMillis());
        }
        // it will enter this else if loop if a specific user date range is required
        else if (programOptions.getStartDate() != null && programOptions.getEndDate() != null && programOptions.getUserId() != null) {
            filterParticularUsersDataByDataRange(getStartDateInMillis(), getEndDateInMillis(), programOptions.getUserId());
        }
        // this loop will run on entire database
        else if (programOptions.getUserId() == null) {
            // analyze all data and append the data in the csv file
            analyzeAllUsersMusicData();
        }
        //this loop will run for a specific user info input 
        else {
            // analyze specific user data
            processUserByIdForPlayerEvent(programOptions.getUserId());
            processUserByIdForUiEvent(programOptions.getUserId());
            processUserByIdForDeviceInfo(programOptions.getUserId());
        }
        //close the CSV file
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

    //get data of Player Events collection based on user id
    private void processUserByIdForPlayerEvent(String userId) {
        List<QueryDocumentSnapshot> userPlayerEventInfoById = new ArrayList<>(firebaseReader.getPlayerEventInfoByUserId(userId));
        for (QueryDocumentSnapshot doc : userPlayerEventInfoById) {
            writeUserInfoToCSV(doc, userId);
        }
    }

    //get data of UI Events collection based on user id
    private void processUserByIdForUiEvent(String userId) {
        List<QueryDocumentSnapshot> userUiEventInfoById = new ArrayList<>(firebaseReader.getUiEventInfoByUserId(userId));
        for (QueryDocumentSnapshot doc : userUiEventInfoById) {
            writeUserInfoToCSV(doc, userId);
        }
    }

    //get data of Device info  collection based on user id
    private void processUserByIdForDeviceInfo(String userId) {
        List<QueryDocumentSnapshot> userDeviceInfoById = new ArrayList<>(firebaseReader.getDeviceInfoByUserId(userId));
        for (QueryDocumentSnapshot doc : userDeviceInfoById) {
            writeUserInfoToCSV(doc, userId);
        }
    }

    //get data of Player Events collection based on date range and user id
    private void processUserByDateRangeForPlayerEvent(String userId, long millisStart, long millisEnd) {
        List<QueryDocumentSnapshot> userByDateRangeForPlayerEvent = new ArrayList<>(firebaseReader.getInfoByDateRangeForPlayerEventInfo(userId, millisStart, millisEnd));
        for (QueryDocumentSnapshot doc : userByDateRangeForPlayerEvent) {
            writeUserInfoToCSV(doc, userId);
        }
    }

    //get data of Ui Events info collection on date range and user id
    private void processUserByIdDateRangeForUiEvent(String userId, long millisStart, long millisEnd) {
        List<QueryDocumentSnapshot> userByIdDateRangeForUiEvent = new ArrayList<>(firebaseReader.getInfoByDateRangeForUiEventInfo(userId, millisStart, millisEnd));
        for (QueryDocumentSnapshot doc : userByIdDateRangeForUiEvent) {
            writeUserInfoToCSV(doc, userId);
        }
    }

    //get data of device info collection on date range and user id
    private void processUserByIdDateRangeForDeviceInfo(String userId, long millisStart, long millisEnd) {
        List<QueryDocumentSnapshot> userByIdDateRangeForUiEvent = new ArrayList<>(firebaseReader.getInfoByDateRangeForUiEventInfo(userId, millisStart, millisEnd));
        for (QueryDocumentSnapshot doc : userByIdDateRangeForUiEvent) {
            writeUserInfoToCSV(doc, userId);
        }
    }

    //Write the Music Analysis Model to CSV
    private void writeUserInfoToCSV(QueryDocumentSnapshot doc, String userId) {
        MusicAnalysisModel mam = new MusicAnalysisModel(doc.toObject(MusicAnalysisModel.class), doc.getId(), userId);
        musicAnalysisList.add(mam);
        csvFileWriter.appendAllToCSV(musicAnalysisList);
        musicAnalysisList.clear();
    }

    //below methodconverts start date to milliseconds
    public long getStartDateInMillis() {
        String startDate = programOptions.getStartDate() + " 00:00:00";
        LocalDateTime localStartDateTime = LocalDateTime.parse(startDate,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        long millisStart = localStartDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
        return millisStart;
    }

    //below method converts end date to milliseconds
    private long getEndDateInMillis() {
        String endDate = programOptions.getEndDate() + " 23:59:59";
        LocalDateTime localEndDateTime = LocalDateTime.parse(endDate,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        long millisEnd = localEndDateTime
                .atZone(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
        return millisEnd;
    }
}
