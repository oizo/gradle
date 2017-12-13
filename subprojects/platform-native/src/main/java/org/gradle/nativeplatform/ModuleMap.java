/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.nativeplatform;

import org.gradle.api.Incubating;
import org.gradle.api.attributes.Attribute;
import org.gradle.api.tasks.Input;

import java.io.Serializable;
import java.util.List;

/**
 * Represents a mapping between a module and the header files associated with the module.
 *
 * @since 4.5
 */
@Incubating
public class ModuleMap implements Serializable {
    public static final Attribute<Boolean> REQUIRES_MODULE_MAP = Attribute.of("org.gradle.requires-module-map", Boolean.class);

    private final String moduleName;
    private final List<String> publicHeaderPaths;

    public ModuleMap(String moduleName, List<String> publicHeaderPaths) {
        this.moduleName = moduleName;
        this.publicHeaderPaths = publicHeaderPaths;
    }

    /**
     * The name of the module to use for the generated module map.
     */
    @Input
    public String getModuleName() {
        return moduleName;
    }

    /**
     * The list of public header paths that should be exposed by the module.
     */
    @Input
    public List<String> getPublicHeaderPaths() {
        return publicHeaderPaths;
    }
}
