/*
 * Copyright 2016-2017 Red Hat, Inc, and individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.snowdrop.example.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("newgreeting")
public class NewGreetingProperties {

    /**
     * This message has to be set in the application.yml file. If application is executed locally, "local" profile is
     * expected. On OpenShift, this property is set by a ConfigMap.
     */
    private String newmessage = null;

    public String getNewMessage() {
        return newmessage;
    }

    public void setNewMessage(String newmessage) {
        this.newmessage = newmessage;
    }
}
