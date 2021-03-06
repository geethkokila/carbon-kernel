/*
*  Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.carbon.launcher.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.wso2.carbon.launcher.bootstrapLogging.BootstrapLogger;
import org.wso2.carbon.launcher.bootstrapLogging.LoggingFormatter;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

public class CarbonLoggerTest extends BaseTest {
    Logger logger;
    CarbonLogHandler carbonLogHandler;
    protected String testDir = "src" + File.separator + "test" + File.separator;
    protected String testResourceDir = testDir + "resources";
    private final static String LOGS = "logs" + File.separator + "test.logs";

    /**
     * @param testName
     */
    public CarbonLoggerTest(String testName) {
        super(testName);
    }

    @BeforeSuite
    public void doBeforeEachTest() throws IOException{
        logger = BootstrapLogger.getBootstrapLogger();
        carbonLogHandler = new CarbonLogHandler(new File(getTestResourceFile(LOGS).getAbsolutePath()));
        carbonLogHandler.setFormatter(new LoggingFormatter());
        logger.addHandler(carbonLogHandler);
    }

    @Test
    public void testCarbonLogAppend() throws IOException{
        String sampleMessage = "Sample message-01";
        String resultLog = "INFO {org.wso2.carbon.launcher.test.CarbonLoggerTest} - Sample message-01";

        logger.info(sampleMessage);
        ArrayList<String> logRecords = getLogsFromTestResource(new FileInputStream(new File(getTestResourceFile(LOGS).getAbsolutePath())));
        Assert.assertTrue(logRecords.get(0).contains(resultLog));
    }

    @AfterTest
    public void cleanupLogfile() throws IOException {
        FileOutputStream writer = new FileOutputStream(new File(getTestResourceFile(LOGS).getAbsolutePath()));
        writer.write((new String()).getBytes());
        writer.close();
    }


    /**
     * Implementation of java.util.logging.Handler that does simple appending
     * to a named file.  Should be able to use this for bootstrap logging
     * via java.util.logging prior to startup of pax logging.
     */
    private static class CarbonLogHandler extends StreamHandler {

        private CarbonLogHandler(File file) throws IOException {
            open(file, true);
        }

        private void open(File logfile, boolean append) throws IOException {
            if (!logfile.getParentFile().exists()) {
                try {
                    logfile.getParentFile().mkdirs();
                } catch (SecurityException se) {
                    throw new IOException(se.getMessage());
                }
            }
            FileOutputStream fout = new FileOutputStream(logfile, append);
            BufferedOutputStream out = new BufferedOutputStream(fout);
            setOutputStream(out);
        }

        public synchronized void publish(LogRecord record) {
            if (!isLoggable(record)) {
                return;
            }
            super.publish(record);
            flush();
        }
    }

}
