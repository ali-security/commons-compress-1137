/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;

/**
 * The different modes the Pack200 streams can use to wrap input and output.
 *
 * @since 1.3
 */
public enum Pack200Strategy {
    /** Cache output in memory */
    IN_MEMORY() {
        @Override
        AbstractStreamBridge newStreamBridge() {
            return new InMemoryCachingStreamBridge();
        }
    },
    /** Cache output in a temporary file */
    TEMP_FILE() {
        @Override
        AbstractStreamBridge newStreamBridge() throws IOException {
            return new TempFileCachingStreamBridge();
        }
    };

    abstract AbstractStreamBridge newStreamBridge() throws IOException;
}
