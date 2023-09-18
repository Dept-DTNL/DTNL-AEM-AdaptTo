package com.deptagency.dtnl.aem.adaptto.core.models;


import com.deptagency.dtnl.aem.adaptto.core.utils.UrlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

/**
 * Model that respond to the HeroBanner
 */
@Model(adaptables = SlingHttpServletRequest.class,
        resourceType = PageModel.RESOURCE_TYPE)
public class PageModel extends BasicModel {
    protected static final String RESOURCE_TYPE = "dtnl-aem-adaptto/components/page";
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String canonicalLink;

    public String getCanonicalLink() {
        if(StringUtils.isEmpty(canonicalLink)){
            return UrlUtils.getURL(currentPage.getPath(),resolver, runModeService.getRunMode());
        }
        return UrlUtils.getURL(canonicalLink, resolver, runModeService.getRunMode());
    }

    /**
     * Translates given .html page to a model json url.
     * This takes slingselectors into account.
     * It will construct the data url like:
     *
     * <<pagePath>>.model.<<SlingSelectors>>.json
     * @return
     */

    public String getJsonExportUrl() {
        final StringBuilder jsonExportUrlBuilder = new StringBuilder(this.currentPage.getPath());
        final String selectorString = this.slingHttpServletRequest.getRequestPathInfo().getSelectorString();

        //RULE: .model needs to be the first sling selector of the JsonExporter Url
        jsonExportUrlBuilder.append(".model");

        if (StringUtils.isNotBlank(selectorString)) {
            jsonExportUrlBuilder.append(".").append(selectorString);
        }

        return jsonExportUrlBuilder.append(".json").toString();
    }
}
