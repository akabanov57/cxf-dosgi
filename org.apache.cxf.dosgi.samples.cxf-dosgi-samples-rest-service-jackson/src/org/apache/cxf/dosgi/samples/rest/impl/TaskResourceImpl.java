/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.dosgi.samples.rest.impl;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.dosgi.common.api.IntentsProvider;
import org.apache.cxf.dosgi.samples.rest.Task;
import org.apache.cxf.dosgi.samples.rest.TaskResource;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.feature.Features;
import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import io.swagger.annotations.Api;

@Component//
(//
    immediate = true, //
    name = "TaskResource", //
    property = //
    { //
            "service.exported.interfaces=*", //
            "service.exported.configs=org.apache.cxf.rs", //
            "org.apache.cxf.rs.address=/tasks", //
            // By default CXF will favor the default json provider
            "cxf.bus.prop.skip.default.json.provider.registration=true" } //
)
@Api(value = "mytest")
@Features(classes = { LoggingFeature.class })
public class TaskResourceImpl implements TaskResource, IntentsProvider {
    private Map<Integer, Task> taskMap;

    public TaskResourceImpl() {
        taskMap = new HashMap<>();
        Task task = new Task();
        task.setId(1);
        task.setTitle("Buy some coffee");
        task.setDescription("Take the extra strong");
        add(task);
        task = new Task();
        task.setId(2);
        task.setTitle("Finish DOSGi example");
        task.setDescription("");
        add(task);
    }

    @Override
    public Task get(Integer id) {
        return taskMap.get(id);
    }

    @Override
    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    @Override
    public void update(Integer id, Task task) {
        taskMap.put(id, task);
    }

    @Override
    public Task[] getAll() {
        return taskMap.values()
                      .toArray(new Task[] {});
    }

    @Override
    public void delete(Integer id) {
        taskMap.remove(id);
    }

    @Override
    public List<?> getIntents() {
        return asList(new JacksonJaxbJsonProvider());
    }

}
