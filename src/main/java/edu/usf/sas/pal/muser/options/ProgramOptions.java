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
package edu.usf.sas.pal.muser.options;

public class ProgramOptions {

    private static ProgramOptions programOptions = null;

    private ProgramOptions() {
    }

    public static final String KEY_FILE = "keyFile";

    public static final String USER_ID = "userId";

    // Start date option to perform a document search
    public static final String START_DATE = "startDate";

    // End date option to perform a document search
    public static final String END_DATE = "endDate";

    // Time zone used to parse the date parameters
    public  static final String TIME_ZONE = "Etc/UTC";

    private String fileKeyPath;

    private String userId;

    private long startDate = 0;

    private long endDate = 0;

    public static ProgramOptions getInstance() {
        if (programOptions == null) {
            programOptions = new ProgramOptions();
        }
        return programOptions;
    }

    public String getFileKeyPath() {
        return fileKeyPath;
    }

    public ProgramOptions setFileKeyPath(String fileKeyPath) {
        this.fileKeyPath = fileKeyPath;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public ProgramOptions setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public long getStartDate() {
        return startDate;
    }

    public ProgramOptions setStartDate(long startDate) {
        this.startDate = startDate;
        return this;
    }

    public long getEndDate() {
        return endDate;
    }

    public ProgramOptions setEndDate(long endDate) {
        this.endDate = endDate;
        return this;
    }
}