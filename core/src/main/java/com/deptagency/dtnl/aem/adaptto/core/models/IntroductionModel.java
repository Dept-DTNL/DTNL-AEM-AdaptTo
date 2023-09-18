package com.deptagency.dtnl.aem.adaptto.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Image;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.ImageRendition;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Link;
import com.deptagency.dtnl.aem.adaptto.core.utils.UrlUtils;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

/**
 * Class model that holds the model of the dialog for the introduction component
 */
@Model(adaptables = SlingHttpServletRequest.class,
        adapters = {ComponentExporter.class},
        resourceType = IntroductionModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class IntroductionModel extends BasicModel implements ComponentExporter {
    protected static final String RESOURCE_TYPE = "dtnl-aem-adaptto/components/introduction";

    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String id;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String headline;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String description;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String imageReference;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String ctaLabel;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String ctaUrl;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String size;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected boolean mobileImageFirst;

    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String backgroundStyle;
    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected boolean showImageRightSide;

    @SlingObject
    private ResourceResolver resolver;

    /**
     * Invoke this method as soon as model item is initiated
     * Depending on size, some fields should be null.
     * Larger sizes can contain more content and vice versa
     */
    @PostConstruct
    protected void init() {
        if(size!=null){
            if(StringUtils.equalsIgnoreCase(size, "XS") || StringUtils.equalsIgnoreCase(size,"S")){
                headline = null;
                imageReference = null;
                ctaLabel = null;
                ctaUrl = null;
            } else if(StringUtils.equalsIgnoreCase(size, "M")){
                headline = null;
                imageReference = null;
            } else if(StringUtils.equalsIgnoreCase(size, "L")){
                imageReference = null;
            }
        }
    }

    /**
     * Check if cta is empty. If not return object
     * @return button
     */
    public Link getCta(){
        final Link cta = Link.of(UrlUtils.getURL(ctaUrl, resolver, runModeService.getRunMode()),ctaLabel);
        return cta.isEmpty() ? null : cta;
    }
    public String getHeadline() {
        return headline;
    }
    public String getDescription() {
        return description;
    }
    public String getSize() {
        return size;
    }
    public Image getImage() {
        return Image.of(imageReference, null, null, resolver, ImageRendition.IMAGE_INTRODUCTION);
    }
    public boolean isMobileImageFirst(){
        return mobileImageFirst;
    }

    /**
     * Check which background style was selected for component
     * Default is White Background
     * @return true if the background is purple
     */
    public Boolean getIsInverted(){
        return StringUtils.isNotBlank(backgroundStyle) && backgroundStyle.equals("Purple Background");
    }

    public Boolean getIsReversed(){
        return showImageRightSide;
    }

    public String getId() {
        return id;
    }

    public String getExportedType() {
        return RESOURCE_TYPE;
    }

}
