package com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.model;

import javax.inject.Inject;

import com.deptagency.dtnl.aem.adaptto.core.models.BasicModel;
import com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.info.HeroSlider;
import com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.info.Slide;
import com.deptagency.dtnl.aem.adaptto.core.models.heroSlider.info.Tag;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Image;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.ImageRendition;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.models.annotations.Exporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Model(adaptables = SlingHttpServletRequest.class,
        adapters = {ComponentExporter.class},
        resourceType = HeroSliderModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HeroSliderModel extends BasicModel implements ComponentExporter  {
    protected static final String RESOURCE_TYPE = "dtnl-aem-adaptto/components/heroslider";
    private static final int SLIDE_LIMIT = 4;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String id;

    @ChildResource(name = "slides")
    @Inject
    @Optional
    protected List<HeroSliderSlideModel> slides;


    public String getId() {
        return this.id;
    }

    public HeroSlider getContent() {
        return HeroSlider.builder()
                .id(this.id)
                .slides(getSlides())
                .build();
    }

    public List<Slide> getSlides() {
        if(!CollectionUtils.isEmpty(this.slides)){
            return this.slides.stream()
                    .limit(SLIDE_LIMIT)
                    .map(this::getSlide)
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    public Slide getSlide(final HeroSliderSlideModel slideModel) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM/yyyy");

        final Slide.SlideBuilder slideBuilder = Slide.builder()
                .slideTitle(slideModel.getSlideTitle())
                .headline(slideModel.getHeadline())
                .description(slideModel.getDescription())
                .bgColor(slideModel.getBgColor())
                .cta(getCta(slideModel.getCtaUrl(), slideModel.getCtaLabel()));

        if (slideModel.getDate() != null) {
            slideBuilder.date(dateFormat.format(slideModel.getDate()));
        }

        // Tags
        if (slideModel.getTags() != null) {
            final List<Tag> tags = new ArrayList<>();
            for (final HeroSliderTagModel tagModel : slideModel.getTags()) {
                tags.add(getTag(tagModel));
            }
            slideBuilder.tags(tags);
        }

        // Image
        if (StringUtils.isNotBlank(slideModel.getImageReference())) {
            final Image image = Image.of(slideModel.getImageReference(), slideModel.getImageAlt(), slideModel.getImageTitle(), resolver, ImageRendition.IMAGE_BANNER_SLIDER);
            slideBuilder.image(image);
        }

        return slideBuilder.build();
    }

    public Tag getTag(final HeroSliderTagModel tagModel) {
        return Tag.builder()
                .label(tagModel.getLabel())
                .style(tagModel.getStyle())
                .build();
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
