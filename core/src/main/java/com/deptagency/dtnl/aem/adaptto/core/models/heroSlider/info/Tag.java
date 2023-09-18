package com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag {
    final String label;
    final String style;
}
