/*
 * Copyright 2011 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.handler.codec.serialization;

import java.util.Map;

class CachingClassResolver implements ClassResolver {

    private final Map<String, Class<?>> classCache;
    private final ClassResolver delegate;

    CachingClassResolver(ClassResolver delegate, Map<String, Class<?>> classCache) {
        this.delegate = delegate;
        this.classCache = classCache;
    }

    /*
     * (non-Javadoc)
     * @see org.jboss.netty.handler.codec.serialization.ClassResolver#resolve(java.lang.String)
     */
    public Class<?> resolve(String className) throws ClassNotFoundException {
        // Query the cache first.
        Class<?> clazz;
        clazz = classCache.get(className);
        if (clazz != null) {
            return clazz;
        }

        // And then try to load.
        clazz = delegate.resolve(className);

        classCache.put(className, clazz);
        return clazz;
    }

}
