package com.deptagency.dtnl.aem.adaptto.core.models;

import com.deptagency.dtnl.aem.adaptto.core.models.utils.DictionaryEnum;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.ImageRendition;
import com.deptagency.dtnl.aem.adaptto.core.utils.UrlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Image;
import com.deptagency.dtnl.aem.adaptto.core.models.herobanner.BannerInfo;
import com.deptagency.dtnl.aem.adaptto.core.models.herobanner.TargetSwitch;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Link;

import javax.inject.Inject;

/**
 * Model that respond to the HeroBanner
 */
@Model(adaptables = SlingHttpServletRequest.class,
        adapters = { ComponentExporter.class },
        resourceType = HeroBannerModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HeroBannerModel extends BasicModel implements ComponentExporter {
    protected static final String RESOURCE_TYPE = "dtnl-aem-adaptto/components/herobanner";

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String id;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String purpose;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String headline;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String ctaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String ctaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String category;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String imageDesktopReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected Image imageDesktop;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String imageMobileReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected Image imageMobile;

    @ValueMapValue(injectionStrategy= InjectionStrategy.OPTIONAL)
    protected boolean decreaseFontSize;
    @ValueMapValue(injectionStrategy= InjectionStrategy.OPTIONAL)
    protected boolean placeHeadlineInTop;

    //Target Tab
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String targetCheckbox;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String targetHeadline;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String targetCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String targetCtaUrl;

    @SlingObject
    private ResourceResolver resolver;

    /**
     * If isTargetChecked = true, this method is called
     * @return TargetSwitch object with all the information it needs
     */
    public TargetSwitch getTargetSwitch(){
        final Link ctaTarget = Link.of(UrlUtils.getURL(targetCtaUrl, resolver, runModeService.getRunMode()), targetCtaLabel);
        final TargetSwitch targetSwitch = TargetSwitch.of(targetHeadline,ctaTarget.isEmpty() ? null : ctaTarget);
        return targetSwitch.isEmpty() ? null : targetSwitch;
    }

    /**
     * Method that wrap the information that the HeroBanner needs
     *
     * @return BannerInfo
     */
    public BannerInfo getContent() {
        final Link cta = Link.of(UrlUtils.getURL(ctaUrl, resolver, runModeService.getRunMode()), ctaLabel);
        final com.deptagency.dtnl.aem.adaptto.core.models.utils.Image deskImage = com.deptagency.dtnl.aem.adaptto.core.models.utils.Image.of(imageDesktopReference, null, null, resolver, ImageRendition.IMAGE_BANNER);
        final com.deptagency.dtnl.aem.adaptto.core.models.utils.Image mobileImage = com.deptagency.dtnl.aem.adaptto.core.models.utils.Image.of(imageMobileReference, null, null, resolver, ImageRendition.IMAGE_BANNER_MOBILE);
        final boolean isForProduct = StringUtils.equalsIgnoreCase(purpose, "product");

        final boolean isTargetChecked = Boolean.parseBoolean(targetCheckbox);

        BannerInfo.BannerInfoBuilder builder = BannerInfo.builder()
                .id(this.id)
                .headline(this.headline)
                .cta(cta)
                .decreaseFontSize(this.decreaseFontSize)
                .placeHeadlineInTop(this.placeHeadlineInTop)
                .imageDesktop(deskImage)
                .imageMobile(mobileImage)
                .isForProduct(isForProduct)
                .scrollTitle("Scroll Down");

        if (isTargetChecked) {
            builder.targetSwitch(getTargetSwitch());
        }

        if (isForProduct) {
            builder.category(this.category);
        }

        return builder.build();
    }

    public String getExportedType() {
        return RESOURCE_TYPE;
    }

}
