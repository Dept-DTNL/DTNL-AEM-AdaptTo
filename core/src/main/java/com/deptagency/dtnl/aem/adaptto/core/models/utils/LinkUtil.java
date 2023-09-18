package com.deptagency.dtnl.aem.adaptto.core.models.utils;

import com.deptagency.dtnl.aem.adaptto.core.services.RunModeService;
import com.deptagency.dtnl.aem.adaptto.core.utils.UrlUtils;
import org.apache.sling.api.resource.ResourceResolver;

public class LinkUtil {
    public static Link getMappedLink(final String url, final String label, final ResourceResolver resolver, final RunModeService runModeService) {
        final String mappedUrl = UrlUtils.getURL(url, resolver, runModeService.getRunMode());
        final Link link = Link.of(mappedUrl, label);
        return link.isEmpty() ? null : link;
    }
}
