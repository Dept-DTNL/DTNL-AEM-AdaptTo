package com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.model;

import lombok.Getter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Getter
public class HeroSliderTagModel {

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String label;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String style;
}