package com.deptagency.dtnl.aem.adaptto.core.utils;

import com.day.cq.wcm.api.Page;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PageUtils {

    public static ValueMap getCurrentPageProperties(final Page page){
        if(page == null){
            return null;
        }
        return page.getProperties();
    }

    public static List<String> getSiblingsPaths(final String path, final ResourceResolver resolver){
        final List<String> siblingsResources = new ArrayList<>();
        if(StringUtils.isNotEmpty(path)) {
            final Resource page = resolver.getResource(path);
            if(page != null) {
                final Resource parent = page.getParent();
                if(parent!= null && parent.hasChildren()) {
                    parent.getChildren().forEach(node -> siblingsResources.add(node.getPath()));
                }
            }
        }
        return siblingsResources;
    }

    public static String getPropertyAsString(final ValueMap properties, final String key){
        if(MapUtils.isEmpty(properties)){
            return null;
        }
        return Optional.ofNullable(properties.get(key, String.class)).orElse(null);
    }

    public static String getTemplateName(final ValueMap properties){
        if(MapUtils.isEmpty(properties)){
            return null;
        }
        final String template = PageUtils.getPropertyAsString(properties, com.day.cq.wcm.api.NameConstants.NN_TEMPLATE);
        if (StringUtils.isEmpty(template) || !template.contains("/") || (template.lastIndexOf("/") + 1 >= template.length())) {
            return null;
        }
        return template.substring(template.lastIndexOf("/") + 1);
    }

    public static String getPagePath(final String resourcePath){
        if(StringUtils.isEmpty(resourcePath)){
            return StringUtils.EMPTY;
        }
        if(resourcePath.indexOf("/jcr:content") > 0){
            return resourcePath.substring(0, resourcePath.indexOf("/jcr:content"));
        }
        return resourcePath;
    }
}
