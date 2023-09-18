package com.deptagency.dtnl.aem.adaptto.core.models.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag {
    private String label;
    private String value;
    private String prefixedId;
    @Setter
    private String style;
    private String overviewPage;
}
