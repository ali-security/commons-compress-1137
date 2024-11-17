/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/**
 * Private copies of methods from Commons Lang.
 * <p>
 *   These methods currently account to less then 1% of the size of Commons Lang.
 *   They have been copied to prevent the addition of Commons Lang as a dependency.
 * </p>
 * <p>If the size of this package becomes larger than 1% of the size of Commons Lang:</p>
 * <ol>
 *   <li>Consider shading of up to 10% of the size of Commons Lang.</li>
 *   <li>If that does not work include Commons Lang as dependency.</li>
 * </ol>
 */
package org.apache.commons.compress.internal.lang3;
