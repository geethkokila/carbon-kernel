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

package org.wso2.carbon.launcher.config;

import java.net.URL;

public class CarbonInitialBundle {
    public final URL location;
    public final int level;
    public final boolean start;

    CarbonInitialBundle(URL location, int level, boolean start) {
        this.location = location;
        this.level = level;
        this.start = start;
    }

    public URL getLocation() {
        return location;
    }

    public int getLevel() {
        return level;
    }

    public boolean shouldStart() {
        return start;
    }
}
