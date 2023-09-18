package com.deptagency.dtnl.aem.adaptto.core.models;

import com.day.cq.wcm.api.Page;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.*;
import com.deptagency.dtnl.aem.adaptto.core.services.I18nService;
import com.deptagency.dtnl.aem.adaptto.core.services.RunModeService;
import com.deptagency.dtnl.aem.adaptto.core.utils.UrlUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class BasicModel{
    @Self
    protected SlingHttpServletRequest slingHttpServletRequest;

    @Inject
    protected Page currentPage;


    @Inject
    protected I18nService i18nService;

    @SlingObject
    protected Resource resource;

    @SlingObject
    protected ResourceResolver resolver;

    @Inject
    public RunModeService runModeService;


    public RunModesEnum getRunMode(){
        return runModeService.getRunMode();
    }

    protected String translate(final DictionaryEnum i18nKey) {
        if (i18nKey == null) {
            return StringUtils.EMPTY;
        }
        return TranslateUtil.translate(this.i18nService, this.currentPage, i18nKey);
    }

    protected String getURL(final String path) {
        return UrlUtils.getURL(path, this.resolver, this.getRunMode());
    }

    /**
     * Create Link objects for cta
     * @param ctaUrl url of button
     * @param ctaLabel label of button
     * @return Button
     */
    protected Link getCta(final String ctaUrl, final String ctaLabel) {
        return LinkUtil.getMappedLink(ctaUrl, ctaLabel, this.resolver, this.runModeService);
    }

    /**
     * Gets all SLing Selectors from current request
     * As a convenience feature we will omit the "model" selector which is used
     * by the frontend
     * @return
     */
    protected List<String> getSlingSelectors() {
        return Arrays.stream(this.slingHttpServletRequest.getRequestPathInfo().getSelectors())
                .filter(selector -> !selector.equals("model"))
                .collect(Collectors.toList());
    }

    protected String getValueMapString(final String valueName) {
        return this.getValueMapString(this.resource, valueName);
    }

    protected String getValueMapString(final Resource resource, final String valueName) {
        return resource.getValueMap().get(valueName, String.class);
    }
}
