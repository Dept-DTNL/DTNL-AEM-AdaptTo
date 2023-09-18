package com.deptagency.dtnl.aem.adaptto.core.models.herobanner;

import com.deptagency.dtnl.aem.adaptto.core.models.utils.Image;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.Link;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class BannerInfo {
    private String id;
    private String headline;
    private Link cta;
    private String category;
    private Image imageDesktop;
    private Image imageMobile;
    private boolean isForProduct;
    private TargetSwitch targetSwitch;
    private String scrollTitle;
    private boolean decreaseFontSize;
    private boolean placeHeadlineInTop;
}
