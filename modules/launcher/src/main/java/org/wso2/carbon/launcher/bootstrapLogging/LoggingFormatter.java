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

package org.wso2.carbon.launcher.bootstrapLogging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Logging formatter of java.util.logging correspond to log4j logging pattern
 */
public class LoggingFormatter extends Formatter {
    // Create a DateFormat to format the logger timestamp.
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss,SSS");

    /**
     * Convenience method for configuring java.util.logging log format to
     * compatible with configured log4j pattern.
     *
     * @return formatted log message
     */
    public String format(LogRecord record) {
        // TODO - add tenant id and other required logging elements to match with log4j.properties configuration
        StringBuilder builder = new StringBuilder(1000);
        builder.append("[").append(df.format(new Date(record.getMillis()))).append("] ");
        builder.append(record.getLevel());
        builder.append(" {").append(record.getSourceClassName()).append("} - ");
        builder.append(formatMessage(record)).append("\n");
        return builder.toString();
    }

}
