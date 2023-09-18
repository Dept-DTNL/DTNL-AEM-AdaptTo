package com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.info;

import com.deptagency.dtnl.aem.adaptto.core.models.utils.Image;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Link;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Slide {
    final String slideTitle;
    final String date;
    final String headline;
    final String description;
    final Link  cta;
    final String bgColor;
    final List<Tag> tags;
    final Image image;
}
