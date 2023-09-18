package com.deptagency.dtnl.aem.adaptto.core.models.herobanner;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

import com.deptagency.dtnl.aem.adaptto.core.models.utils.Link;
import com.fasterxml.jackson.annotation.JsonIgnore;

@EqualsAndHashCode
public class TargetSwitch {
    private String headline;
    private Link cta;

    public TargetSwitch() {

    }

    public String getHeadline() {
        return headline;
    }

    public Link getCta() {
        return cta;
    }

    /**
     * Check if any fields are either empty or null
     * @return true if Link is null or headline empty
     */
    @JsonIgnore
    public boolean isEmpty(){
        return getCta() == null || StringUtils.isEmpty(this.headline);
    }

    public static TargetSwitch of(final String headline, final Link cta) {
        final TargetSwitch targetSwitch = new TargetSwitch();
        targetSwitch.headline = headline;
        targetSwitch.cta = cta;
        return targetSwitch;
    }
}
