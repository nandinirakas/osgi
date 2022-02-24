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
package com.atmo.bundle12;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.atmo.addition.Addition;
import com.atmo.subtraction.Subtraction;
import com.atmo.welcome.Welcome;

public class Activator implements BundleActivator {

    public void start(BundleContext context) {
        System.out.println("Starting the bundle");
        Welcome.greetings();
        System.out.println(Addition.add());
        System.out.println(Subtraction.sub());
        Welcome.exit();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }

}