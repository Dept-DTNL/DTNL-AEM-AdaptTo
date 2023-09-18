package com.deptagency.dtnl.aem.adaptto.core.models.entrances;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Class model for the Entrances class object
 */
public class EntrancesInfo {
    private String id;
    private String headline;
    private String description;
    private List<TileModel> tiles;

    private EntrancesInfo (){

    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }

    public List<TileModel> getTiles() {
        if(CollectionUtils.isEmpty(tiles)){
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(tiles);
    }

    protected void setTiles(List<TileModel> tiles) {
        this.tiles = CollectionUtils.isEmpty(tiles) ? Collections.emptyList() : Collections.unmodifiableList(tiles);
    }

    public String getId() {
        return id;
    }

    public static EntrancesInfo of(final String id,
                                   final String headline,
                                   final String description,
                                   final List<TileModel> tiles){
        final EntrancesInfo entrancesInfo = new EntrancesInfo();
        entrancesInfo.id=id;
        entrancesInfo.headline=headline;
        entrancesInfo.description=description;
        entrancesInfo.tiles = CollectionUtils.isEmpty(tiles) ? Collections.emptyList() : Collections.unmodifiableList(tiles);
        return entrancesInfo;
    }
}
