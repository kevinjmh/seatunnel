/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.connectors.seatunnel.hudi.config;

import org.apache.seatunnel.shade.com.fasterxml.jackson.core.type.TypeReference;

import org.apache.seatunnel.api.configuration.Option;
import org.apache.seatunnel.api.configuration.Options;

import org.apache.hudi.common.model.HoodieTableType;
import org.apache.hudi.common.model.WriteOperationType;

public interface HudiOptions {

    Option<String> CONF_FILES_PATH =
            Options.key("conf_files_path")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("hudi conf files");

    Option<String> TABLE_NAME =
            Options.key("table_name").stringType().noDefaultValue().withDescription("table_name");

    Option<String> TABLE_DFS_PATH =
            Options.key("table_dfs_path")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("table_dfs_path");

    Option<String> RECORD_KEY_FIELDS =
            Options.key("record_key_fields")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("recordKeyFields");

    Option<String> PARTITION_FIELDS =
            Options.key("partition_fields")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("partitionFields");

    Option<HoodieTableType> TABLE_TYPE =
            Options.key("table_type")
                    .type(new TypeReference<HoodieTableType>() {})
                    .defaultValue(HoodieTableType.COPY_ON_WRITE)
                    .withDescription("table_type");
    Option<WriteOperationType> OP_TYPE =
            Options.key("op_type")
                    .type(new TypeReference<WriteOperationType>() {})
                    .defaultValue(WriteOperationType.INSERT)
                    .withDescription("op_type");

    Option<Integer> BATCH_INTERVAL_MS =
            Options.key("batch_interval_ms")
                    .intType()
                    .defaultValue(1000)
                    .withDescription("batch interval milliSecond");

    Option<Integer> INSERT_SHUFFLE_PARALLELISM =
            Options.key("insert_shuffle_parallelism")
                    .intType()
                    .defaultValue(2)
                    .withDescription("insert_shuffle_parallelism");

    Option<Integer> UPSERT_SHUFFLE_PARALLELISM =
            Options.key("upsert_shuffle_parallelism")
                    .intType()
                    .defaultValue(2)
                    .withDescription("upsert_shuffle_parallelism");

    Option<Integer> MIN_COMMITS_TO_KEEP =
            Options.key("min_commits_to_keep")
                    .intType()
                    .defaultValue(20)
                    .withDescription("hoodie.keep.min.commits");

    Option<Integer> MAX_COMMITS_TO_KEEP =
            Options.key("max_commits_to_keep")
                    .intType()
                    .defaultValue(30)
                    .withDescription("hoodie.keep.max.commits");
}
