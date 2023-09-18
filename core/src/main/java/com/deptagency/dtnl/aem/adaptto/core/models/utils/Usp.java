package com.deptagency.dtnl.aem.adaptto.core.models.utils;


import lombok.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.Objects;


/**
 * Class model for a USP object inside to USPS collection
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usp {
    @ValueMapValue(name="usp")
    @Inject
    private String label;

    @ValueMapValue(name="overrideUSPLabel")
    @Inject
    private boolean overrideUSPLabel;

    @ValueMapValue(name="style")
    @Inject
    protected String style;


    public boolean isOverrideUSPLabel() {
        return overrideUSPLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usp)) {
            return false;
        }
        Usp uspModel = (Usp) o;
        return getLabel().equals(uspModel.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel());
    }

    public static Usp of(final String label){
        final Usp uspModel = new Usp();
        uspModel.label = label;
        return uspModel;
    }

    public static Usp of(final String label, final String style){
        final Usp uspModel = new Usp();
        uspModel.label = label;
        uspModel.style = style;
        return uspModel;
    }

    /**
     * Get all the references from the resource and assign their value to fields
     * @param resource - sling model resource
     */
    public static Usp of(final Resource resource) {
        final ValueMap values = resource.getValueMap();


        String uspLabel = "Please configure usp label";
        String uspStyle = null;

        if (values.containsKey("uspLabel")) {
            // Variant of Resource where the uspLabel field is used.
            uspLabel = values.get("uspLabel", String.class);
        }

        if (values.containsKey("usp")) {
            // Variant of Resource where the usp field is used
            uspLabel = values.get("usp", String.class);
            uspStyle = values.get("style", String.class);
        }

        return Usp.builder()
                .label(uspLabel)
                .style(uspStyle)
                .build();
    }
}
