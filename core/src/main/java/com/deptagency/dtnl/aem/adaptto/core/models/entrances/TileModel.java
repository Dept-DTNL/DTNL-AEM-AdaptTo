package com.deptagency.dtnl.aem.adaptto.core.models.entrances;

import com.deptagency.dtnl.aem.adaptto.core.models.utils.Image;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Link;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Usp;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class model for a Tile object that responds to Entrances Model
 */
public class TileModel {
    private String headline;
    private String description;
    private Link cta;
    private Image image;
    private List<Usp> usps;

    private TileModel() {

    }


    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public Link getCta() {
        return cta;
    }

    protected void setUsps(List<Usp> usps) {
        this.usps = CollectionUtils.isEmpty(usps) ? Collections.emptyList() : Collections.unmodifiableList(usps);
    }
    /**
     * Get usps inside the multi filled collection
     * @return Collection of usps
     */
    public List<Usp> getUsps() {
        if(CollectionUtils.isEmpty(usps)){
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(usps);
    }

    public Image getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TileModel)) {
            return false;
        }
        TileModel tileModel = (TileModel) o;
        return getHeadline().equals(tileModel.getHeadline()) &&
                getDescription().equals(tileModel.getDescription()) &&
                getCta().equals(tileModel.getCta()) &&
                getImage().equals(tileModel.getImage()) &&
                getUsps().equals(tileModel.getUsps());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeadline(), getDescription(), getCta(), getImage(), getUsps());
    }

    public static TileModel of(
            final String headline,
            final String description,
            final Link cta,
            final Image image,
            final List<Usp> usps) {
        final TileModel tileModel = new TileModel();
        tileModel.headline = headline;
        tileModel.description = description;
        tileModel.cta = cta;
        tileModel.image = image;
        tileModel.usps = CollectionUtils.isNotEmpty(usps) ? Collections.unmodifiableList(usps) : Collections.emptyList();
        return tileModel;
    }

}
