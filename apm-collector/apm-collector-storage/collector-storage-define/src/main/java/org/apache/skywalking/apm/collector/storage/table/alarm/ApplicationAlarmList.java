/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.apm.collector.storage.table.alarm;

import org.apache.skywalking.apm.collector.core.data.Column;
import org.apache.skywalking.apm.collector.core.data.RemoteData;
import org.apache.skywalking.apm.collector.core.data.StreamData;
import org.apache.skywalking.apm.collector.core.data.operator.CoverMergeOperation;
import org.apache.skywalking.apm.collector.core.data.operator.NonMergeOperation;
import org.apache.skywalking.apm.collector.remote.service.RemoteDataRegisterService;

/**
 * @author peng-yongsheng
 */
public class ApplicationAlarmList extends StreamData {

    private static final Column[] STRING_COLUMNS = {
        new Column(ApplicationAlarmListTable.COLUMN_ID, new NonMergeOperation()),
        new Column(ApplicationAlarmListTable.COLUMN_METRIC_ID, new NonMergeOperation()),
        new Column(ApplicationAlarmListTable.COLUMN_ALARM_CONTENT, new CoverMergeOperation()),
    };

    private static final Column[] LONG_COLUMNS = {
        new Column(ApplicationAlarmListTable.COLUMN_TIME_BUCKET, new NonMergeOperation()),
    };

    private static final Column[] DOUBLE_COLUMNS = {};

    private static final Column[] INTEGER_COLUMNS = {
        new Column(ApplicationAlarmListTable.COLUMN_ALARM_TYPE, new NonMergeOperation()),
        new Column(ApplicationAlarmListTable.COLUMN_SOURCE_VALUE, new NonMergeOperation()),
        new Column(ApplicationAlarmListTable.COLUMN_APPLICATION_ID, new NonMergeOperation()),
    };

    private static final Column[] BYTE_COLUMNS = {};

    public ApplicationAlarmList() {
        super(STRING_COLUMNS, LONG_COLUMNS, DOUBLE_COLUMNS, INTEGER_COLUMNS, BYTE_COLUMNS);
    }

    @Override public String getId() {
        return getDataString(0);
    }

    @Override public void setId(String id) {
        setDataString(0, id);
    }

    @Override public String getMetricId() {
        return getDataString(1);
    }

    @Override public void setMetricId(String metricId) {
        setDataString(1, metricId);
    }

    public String getAlarmContent() {
        return getDataString(2);
    }

    public void setAlarmContent(String alarmContent) {
        setDataString(2, alarmContent);
    }

    public Integer getAlarmType() {
        return getDataInteger(0);
    }

    public void setAlarmType(Integer alarmType) {
        setDataInteger(0, alarmType);
    }

    public Integer getSourceValue() {
        return getDataInteger(1);
    }

    public void setSourceValue(Integer sourceValue) {
        setDataInteger(1, sourceValue);
    }

    public Integer getApplicationId() {
        return getDataInteger(2);
    }

    public void setApplicationId(Integer applicationId) {
        setDataInteger(2, applicationId);
    }

    public Long getTimeBucket() {
        return getDataLong(0);
    }

    public void setTimeBucket(Long timeBucket) {
        setDataLong(0, timeBucket);
    }

    public static class InstanceCreator implements RemoteDataRegisterService.RemoteDataInstanceCreator {
        @Override public RemoteData createInstance() {
            return new ApplicationAlarmList();
        }
    }
}
