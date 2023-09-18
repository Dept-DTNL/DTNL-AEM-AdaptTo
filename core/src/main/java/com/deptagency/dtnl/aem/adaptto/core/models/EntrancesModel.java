package com.deptagency.dtnl.aem.adaptto.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.Page;
import com.deptagency.dtnl.aem.adaptto.core.models.entrances.EntrancesInfo;
import com.deptagency.dtnl.aem.adaptto.core.models.entrances.TileModel;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.*;
import com.deptagency.dtnl.aem.adaptto.core.services.I18nService;
import com.deptagency.dtnl.aem.adaptto.core.utils.UrlUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Model that responds to Entrances component
 */
@Model(adaptables = SlingHttpServletRequest.class,
        adapters = { ComponentExporter.class },
        resourceType = EntrancesModel.RESOURCE_TYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EntrancesModel extends BasicModel implements ComponentExporter {
    protected static final String RESOURCE_TYPE = "dtnl-aem-adaptto/components/entrances";

    @Self
    private SlingHttpServletRequest slingHttpServletRequest;

    @Inject
    private Page currentPage;

    @Inject
    private transient I18nService i18nService;

    @ValueMapValue(injectionStrategy=InjectionStrategy.OPTIONAL)
    protected String id;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String primaryHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String primaryDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String primarySize;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String configSelect;

    //Tile one
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileOneHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileOneDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileOneCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileOneCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileOneImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileOneImageName;

    //Tile two
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileTwoHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileTwoDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileTwoCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileTwoCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileTwoImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileTwoImageName;

    //Tile three
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileThreeHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileThreeDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileThreeCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileThreeCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileThreeImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileThreeImageName;

    @ChildResource(name = "uspsOne")
    @Inject
    @Optional
    protected List<Usp> uspsOne;
    @ChildResource(name = "uspsTwo")
    @Inject
    @Optional
    protected List<Usp> uspsTwo;
    @ChildResource(name = "uspsThree")
    @Inject
    @Optional
    protected List<Usp> uspsThree;

    //Tile Four
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFourHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFourDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFourCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFourCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFourImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFourImageName;
    @ChildResource(name = "uspsFour")
    @Inject
    @Optional
    protected List<Usp> uspsFour;

    //Tile Five
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFiveHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFiveDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFiveCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFiveCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFiveImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileFiveImageName;
    @ChildResource(name = "uspsFive")
    @Inject
    @Optional
    protected List<Usp> uspsFive;

    //Tile Six
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSixHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSixDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSixCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSixCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSixImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSixImageName;
    @ChildResource(name = "uspsSix")
    @Inject
    @Optional
    protected List<Usp> uspsSix;

    //Tile Seven
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSevenHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSevenDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSevenCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSevenCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSevenImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileSevenImageName;
    @ChildResource(name = "uspsSeven")
    @Inject
    @Optional
    protected List<Usp> uspsSeven;

    //Tile Eight
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileEightHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileEightDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileEightCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileEightCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileEightImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileEightImageName;
    @ChildResource(name = "uspsEight")
    @Inject
    @Optional
    protected List<Usp> uspsEight;

    //Tile Nine
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileNineHeadLine;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileNineDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileNineCtaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileNineCtaUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileNineImageReference;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    protected String tileNineImageName;
    @ChildResource(name = "uspsNine")
    @Inject
    @Optional
    protected List<Usp> uspsNine;

    @SlingObject
    private ResourceResolver resolver;

    @PostConstruct
    protected void init() {
        if (configSelect != null) {
            if (configSelect.equals("CTA")) {
                uspsOne = null;
                uspsTwo = null;
                uspsThree = null;
                uspsFour = null;
                uspsFive = null;
                uspsSix = null;
                uspsSeven = null;
                uspsEight = null;
                uspsNine = null;
            } else if (configSelect.equals("USPS")) {
                tileOneCtaUrl = null;
                tileOneCtaLabel = null;
                tileTwoCtaLabel = null;
                tileTwoCtaUrl = null;
                tileThreeCtaLabel = null;
                tileThreeCtaUrl = null;
                uspsOne = CollectionUtils.isEmpty(this.uspsOne) ? Collections.emptyList() : this.uspsOne;
                uspsTwo = CollectionUtils.isEmpty(this.uspsTwo) ? Collections.emptyList() : this.uspsTwo;
                uspsThree = CollectionUtils.isEmpty(this.uspsThree) ? Collections.emptyList() : this.uspsThree;

                tileFourCtaLabel = null;
                tileFourCtaUrl = null;
                uspsFour = CollectionUtils.isEmpty(this.uspsFour) ? Collections.emptyList() : this.uspsFour;

                tileFiveCtaLabel = null;
                tileFiveCtaUrl = null;
                uspsFive = CollectionUtils.isEmpty(this.uspsFive) ? Collections.emptyList() : this.uspsFive;

                tileSixCtaLabel = null;
                tileSixCtaUrl = null;
                uspsSix = CollectionUtils.isEmpty(this.uspsSix) ? Collections.emptyList() : this.uspsSix;

                tileSevenCtaLabel = null;
                tileSevenCtaUrl = null;
                uspsSeven = CollectionUtils.isEmpty(this.uspsSeven) ? Collections.emptyList() : this.uspsSeven;

                tileEightCtaLabel = null;
                tileEightCtaUrl = null;
                uspsEight = CollectionUtils.isEmpty(this.uspsEight) ? Collections.emptyList() : this.uspsEight;

                tileNineCtaLabel = null;
                tileNineCtaUrl = null;
                uspsNine = CollectionUtils.isEmpty(this.uspsNine) ? Collections.emptyList() : this.uspsNine;
            }
        }
    }

    /**
     * Create Link objects for cta
     * @param ctaUrl url of button
     * @param ctaLabel label of button
     * @return Button
     */
    public Link getCta(String ctaUrl, String ctaLabel) {
        final String url = UrlUtils.getURL(ctaUrl, resolver, runModeService.getRunMode());
        final Link cta = Link.of(url, ctaLabel);
        return cta.isEmpty() ? null : cta;
    }

    /**
     * Create Image object
     * @param imageReference reference to image
     * @return Image
     */
    protected Image getImage(String imageReference) {
        return Image.of(imageReference, null, null, resolver, ImageRendition.IMAGE_ENTRANCE);
    }


    public EntrancesInfo getContent() {
        final String moreInformationLabel = this.translate(DictionaryEnum.MORE_INFORMATION);

        List<TileModel> tiles = new ArrayList<>();
        final Link ctaOne = getCta(tileOneCtaUrl, moreInformationLabel);
        final Link ctaTwo = getCta(tileTwoCtaUrl, moreInformationLabel);
        final Image imageOne = getImage(tileOneImageReference);
        final Image imageTwo = getImage(tileTwoImageReference);

        final Link ctaThree = getCta(tileThreeCtaUrl, moreInformationLabel);
        final Image imageThree = getImage(tileThreeImageReference);

        TileModel tileOne = TileModel.of(tileOneHeadLine, tileOneDescription, ctaOne, imageOne, uspsOne);
        TileModel tileTwo = TileModel.of(tileTwoHeadLine, tileTwoDescription, ctaTwo, imageTwo, uspsTwo);
        TileModel tileThree = TileModel.of(tileThreeHeadLine, tileThreeDescription, ctaThree, imageThree, uspsThree);

        tiles.add(tileOne);
        tiles.add(tileTwo);

        if(tileThreeHeadLine!=null){
            tiles.add(tileThree);
        }

        final Link ctaFour = getCta(tileFourCtaUrl, moreInformationLabel);
        final Image imageFour = getImage(tileFourImageReference);
        TileModel tileFour = TileModel.of(tileFourHeadLine, tileFourDescription, ctaFour, imageFour, uspsFour);

        if (tileFourHeadLine != null) {
            tiles.add(tileFour);
        }

        final Link ctaFive = getCta(tileFiveCtaUrl, moreInformationLabel);
        final Image imageFive = getImage(tileFiveImageReference);
        TileModel tileFive = TileModel.of(tileFiveHeadLine, tileFiveDescription, ctaFive, imageFive, uspsFive);

        if (tileFiveHeadLine != null) {
            tiles.add(tileFive);
        }

        final Link ctaSix = getCta(tileSixCtaUrl, moreInformationLabel);
        final Image imageSix = getImage(tileSixImageReference);
        TileModel tileSix = TileModel.of(tileSixHeadLine, tileSixDescription, ctaSix, imageSix, uspsSix);

        if (tileSixHeadLine != null) {
            tiles.add(tileSix);
        }

        final Link ctaSeven = getCta(tileSevenCtaUrl, moreInformationLabel);
        final Image imageSeven = getImage(tileSevenImageReference);
        TileModel tileSeven = TileModel.of(tileSevenHeadLine, tileSevenDescription, ctaSeven, imageSeven, uspsSeven);

        if (tileSevenHeadLine != null) {
            tiles.add(tileSeven);
        }

        final Link ctaEight = getCta(tileEightCtaUrl, moreInformationLabel);
        final Image imageEight = getImage(tileEightImageReference);
        TileModel tileEight = TileModel.of(tileEightHeadLine, tileEightDescription, ctaEight, imageEight, uspsEight);

        if (tileEightHeadLine != null) {
            tiles.add(tileEight);
        }

        final Link ctaNine = getCta(tileNineCtaUrl, moreInformationLabel);
        final Image imageNine = getImage(tileNineImageReference);
        TileModel tileNine = TileModel.of(tileNineHeadLine, tileNineDescription, ctaNine, imageNine, uspsNine);

        if (tileNineHeadLine != null) {
            tiles.add(tileNine);
        }



        return EntrancesInfo.of(id,primaryHeadLine, primaryDescription, tiles);
    }

    private String getI18nService(String text){
        return i18nService.get(currentPage,slingHttpServletRequest,text);
    }

    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
