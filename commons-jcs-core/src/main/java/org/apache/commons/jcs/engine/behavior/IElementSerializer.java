package org.apache.commons.jcs.engine.behavior;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.IOException;

/**
 * Defines the behavior for cache element serializers. This layer of abstraction allows us to plug
 * in different serialization mechanisms, such as a compressing standard serializer.
 * <p>
 * @author Aaron Smuts
 */
public interface IElementSerializer
{
    /**
     * Turns an object into a byte array.
     * @param obj
     * @return byte[]
     * @throws IOException
     */
    <T> byte[] serialize( T obj )
        throws IOException;

    /**
     * Turns a byte array into an object.
     * @param bytes data bytes
     * @param loader class loader to use
     * @return Object
     * @throws IOException
     * @throws ClassNotFoundException thrown if we don't know the object.
     */
    <T> T deSerialize( byte[] bytes, ClassLoader loader )
        throws IOException, ClassNotFoundException;
}
