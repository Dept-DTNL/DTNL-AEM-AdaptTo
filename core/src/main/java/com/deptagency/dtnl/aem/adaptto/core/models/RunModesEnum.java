package com.deptagency.dtnl.aem.adaptto.core.models;

import org.apache.commons.lang3.StringUtils;

public enum RunModesEnum {
    AUTHOR("author"),
    PUBLISH("publish");

    private String value;

    private RunModesEnum(final String value){
        this.value = value;
    }

    public static RunModesEnum fromString(final String value){
        if(StringUtils.isNotEmpty(value) && value.equalsIgnoreCase("author")){
            return RunModesEnum.AUTHOR;
        } else{
            return RunModesEnum.PUBLISH;
        }

    }
}
