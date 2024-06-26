/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.snowdrop.example.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private GreetingProperties properties;
    private NewGreetingProperties newproperties;
    private String greeterMessageFormat; 

    @Autowired
    public GreetingController(GreetingProperties properties, NewGreetingProperties newproperties) {
        this.properties = properties;
        this.newproperties = newproperties;
    }

    @RequestMapping("/api/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        Objects.requireNonNull(newproperties, "New Properties was not set in the properties");
//        Objects.requireNonNull(newproperties.getNewMessage(), "New Greeting message was not set in the properties");

        String message = String.format(properties.getMessage(), name);
        //use below for new greeting 
        //String message = String.format(newproperties.getNewMessage(), name);
        return new Greeting(message);
    }

    @RequestMapping("/api/greeting/message")
    public String greetingMessage() {
        return properties.getMessage();
    }

    @RequestMapping("/api/newgreeting/newmessage")
    public String newGreetingMessage() {
        return newproperties.getNewMessage();
    }

    @RequestMapping("/api/greeting/volume-message")
    public String greet() {

        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi ");
        
        if (prefix == null) {
            prefix = "Hello! ";
        }

        return prefix;
        
        
    }
}
