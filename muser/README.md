muser-firebase-export Build Status

Java application to process Muser Music Analysis. The data collected by Muser and stored in Firebase Firestore.

Build

To build the application use mvn clean package command. This command will create a jar file (i.e., muser-0.0.1-SNAPSHOT.jar) under the target folder.

Setup Firebase Account

Generate a admin private-key json file (e.g., admin-key.json) for your service account. To generate the key file follow the instructions in Firebase setup page.
Run

To run the application use java -jar command and pass the admin-key.json file as an argument: java -jar muser-0.0.1-SNAPSHOT.jar -keyFile /path/to/file/fileName.json

Additional Optional Command Line Arguments

-userId <userId> Takes a user id as an argument and performs the analysis for that specific user. Example usage: -userId abcdef.

License

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