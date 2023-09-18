package com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.model;

import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class HeroSliderSlideModel {

    @ValueMapValue
    protected String slideTitle;

    @ValueMapValue
    protected Date date;

    @ValueMapValue
    protected String headline;

    @ValueMapValue
    protected String description;

    @ValueMapValue
    protected String ctaLabel;

    @ValueMapValue
    protected String ctaUrl;

    @ValueMapValue
    protected String bgColor;

    @ChildResource(name = "tags")
    @Inject
    protected List<HeroSliderTagModel> tags;

    @ValueMapValue
    protected String imageReference;

    @ValueMapValue
    protected String imageTitle;

    @ValueMapValue
    protected String imageAlt;

}
