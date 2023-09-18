package com.deptagency.dtnl.aem.adaptto.core.utils;

import com.day.cq.commons.Externalizer;
import com.deptagency.dtnl.aem.adaptto.core.models.RunModesEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ResourceResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UrlUtils {
    private static final Logger logger = LoggerFactory.getLogger(UrlUtils.class);
    public static final String HTML = ".html";

    private UrlUtils() {

    }

    /**
     * Returns the url base on the run mode of the server author or publish and if the externalizer url is required
     * @param path
     * @param resourceResolver
     * @param runMode
     * @return
     */
    public static String getURL(String path, final ResourceResolver resourceResolver, RunModesEnum runMode) {
        if (resourceResolver == null || StringUtils.isEmpty(path)) {
            return path;
        }
        //Check if it is an internal URL
        if (!path.contains("/content/dtnl-aem-adaptto")) {
            return path;
        }
        //Remove the html if it is present
        String pathWithoutHTML = path.contains(HTML) ? path.replace(HTML, "") : path;
        //Get shortener URL only applicable to publish because of the config located in file
        // src/main/content/jcr_root/apps/dtnl-aem-adaptto/osgiconfig/config.publish/org.apache.sling.jcr.resource.internal.JcrResourceResolverFactoryImpl.cfg.json
        String url = resourceResolver.map(pathWithoutHTML);
        if (StringUtils.isEmpty(url)) {
            return url;
        }

        if(runMode == RunModesEnum.PUBLISH){
            final Externalizer externalizer = resourceResolver.adaptTo(Externalizer.class);
            if(externalizer != null) {
                url = externalizer.publishLink(resourceResolver, url);
            }
        }


        return UrlUtils.getURLWithHtml(url);
    }

    private static String getURLWithHtml(final String path) {
        if (StringUtils.isEmpty(path)) {
            return path;
        }
        return path.contains("html") ? path : path.concat(HTML);
    }


}
