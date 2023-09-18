package com.deptagency.dtnl.aem.adaptto.core.models.utils;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.drew.lang.annotations.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.Objects;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Builder
@AllArgsConstructor
@Getter
public class Image {
    final static Image emptyImage = Image.builder()
            .url("please configure url")
            .alt("please configure alt")
            .title("please configure title")
            .build();


    @ValueMapValue(name = "imageReference")
    @Inject
    private String url;
    private String alt;
    private String title;

    private Image() {

    }

    public static Image of(final String url, @Nullable final String alt, @Nullable final String title, final ResourceResolver resourceResolver, final ImageRendition imageRendition) {
        final Image image = new Image();
        image.url = url;
        image.alt = alt;
        image.title = title;

        return Image.of(image, resourceResolver, imageRendition);
    }

    public static Image of(final Image imageSrc, final ResourceResolver resourceResolver, final ImageRendition imageRendition) {
        if (imageSrc == null || StringUtils.isEmpty(imageSrc.url)) {
            return null;
        }

        final Asset imageAsset = getAsset(imageSrc.url, resourceResolver);

        final String rendition = imageAsset != null ? getRendition(imageAsset, imageRendition) : imageSrc.url;
        final String alt = StringUtils.isNotBlank(imageSrc.alt) ? imageSrc.alt : getAltFromMetadata(imageAsset);
        final String title = StringUtils.isNotBlank(imageSrc.title) ? imageSrc.title : getTitleFromMetadata(imageAsset);

        return Image.builder()
                .url(rendition)
                .alt(alt)
                .title(title)
                .build();
    }

    public static Image of(final String imageUrl, final ResourceResolver resourceResolver, final ImageRendition imageRendition) {
        if (StringUtils.isBlank(imageUrl)) {
            return null;
        }

        final Asset imageAsset = getAsset(imageUrl, resourceResolver);

        final String rendition = imageAsset != null ? getRendition(imageAsset, imageRendition) : imageUrl;
        final String alt = getAltFromMetadata(imageAsset);
        final String title = getTitleFromMetadata(imageAsset);

        return Image.builder()
                .url(rendition)
                .alt(alt)
                .title(title)
                .build();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return StringUtils.isEmpty(this.url);
    }

    /**
     * empty data for image
     * @return empty data
     */
    public static Image emptyImage() {
        return emptyImage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Image)) {
            return false;
        }
        final Image image = (Image) o;
        return Objects.equals(getUrl(), image.getUrl()) && Objects.equals(getAlt(), image.getAlt()) && Objects.equals(getTitle(), image.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getAlt(), getTitle());
    }

    private static String getAltFromMetadata(final Asset imageAsset) {
        if (imageAsset == null) {
            return StringUtils.EMPTY;
        }

        String alt = imageAsset.getMetadataValue("dc:description");

        if (StringUtils.isBlank(alt)) {
            alt = getTitleFromMetadata(imageAsset);
        }

        if (StringUtils.isBlank(alt)) {
            alt = getAssetNameWithoutExtension(imageAsset);
        }

        return alt;
    }

    private static String getAssetNameWithoutExtension(final Asset imageAsset) {
        String cleanAssetName = imageAsset.getName();
        // Remove extension
        int dotIndex = cleanAssetName.lastIndexOf(".");
        if (dotIndex != -1) {
            cleanAssetName = cleanAssetName.substring(0, dotIndex);
        }

        return cleanAssetName.replaceAll("[-_.]", " ").trim();
    }

    private static String getTitleFromMetadata(final Asset imageAsset) {
        if (imageAsset == null) {
            return StringUtils.EMPTY;
        }

        return imageAsset.getMetadataValue("dc:title");
    }

    private static String getRendition(final Asset imageAsset, final ImageRendition imageRendition) {
        if (imageAsset == null || imageRendition == null || StringUtils.isEmpty(imageRendition.getName())) {
            return StringUtils.EMPTY;
        }

        final Rendition rendition = imageAsset.getRendition(imageRendition.getName());
        return rendition == null ? imageAsset.getPath() : rendition.getPath();
    }

    private static Asset getAsset(final String imageSrc, final ResourceResolver resourceResolver) {
        if (resourceResolver == null || StringUtils.isBlank(imageSrc)) {
            return null;
        }

        final Resource resourceImage = resourceResolver.getResource(imageSrc);

        return resourceImage == null ? null : resourceImage.adaptTo(Asset.class);
    }
}
