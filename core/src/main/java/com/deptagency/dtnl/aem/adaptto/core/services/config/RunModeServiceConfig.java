package com.deptagency.dtnl.aem.adaptto.core.services.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "[Adaptto] Run Mode Configuration Service", description = "Configuration service provider")
public @interface RunModeServiceConfig {

    @AttributeDefinition(name = "RunMode", description = "Type the runMode AUTHOR or PUBLISH", type = AttributeType.STRING)
    String runMode() default "PUBLISH";

    @AttributeDefinition(name = "environment", description = "Define the environment of the instance can be DEV, STAGE, PROD", type = AttributeType.STRING)
    String environment() default "dev";

}
