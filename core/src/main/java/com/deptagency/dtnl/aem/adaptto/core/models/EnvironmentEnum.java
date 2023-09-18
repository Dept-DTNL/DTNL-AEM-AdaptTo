package com.deptagency.dtnl.aem.adaptto.core.models;

import org.apache.commons.lang3.StringUtils;

public enum EnvironmentEnum {
    DEV("dev"),
    STAGE("stage"),
    PROD("prod");

    private String value;

    private EnvironmentEnum(final String value){
        this.value = value;
    }

    public static EnvironmentEnum fromString(final String value){
        if(StringUtils.isNotEmpty(value) && value.equalsIgnoreCase("DEV")){
            return EnvironmentEnum.DEV;
        } else if(StringUtils.isNotEmpty(value) && value.equalsIgnoreCase("STAGE")){
            return EnvironmentEnum.STAGE;
        } else if(StringUtils.isNotEmpty(value) && value.equalsIgnoreCase("PROD")){
            return EnvironmentEnum.PROD;
        }
        return EnvironmentEnum.DEV;
    }
}
