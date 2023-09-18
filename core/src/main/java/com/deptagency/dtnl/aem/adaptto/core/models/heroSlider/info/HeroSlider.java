package com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeroSlider {
    final String id;
    final List<Slide> slides;
}