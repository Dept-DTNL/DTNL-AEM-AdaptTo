package com.deptagency.dtnl.aem.adaptto.core.models.utils;

public enum ImageRendition {
    IMAGE_HIGHLIGHTED_PRODUCT("image-highlighted-product.png"),
    IMAGE_BANNER("image-banner.png"),
    IMAGE_BANNER_SLIDER("image-banner.png"),
    IMAGE_BANNER_MOBILE("image-banner-mobile.png"),
    IMAGE_HEADER("image-header.png"),
    IMAGE_CAROUSEL("image-carousel.jpeg"),
    IMAGE_INTRODUCTION("image-introduction.png"),
    IMAGE_ENTRANCE("image-entrance.jpeg"),
    IMAGE_INSTALLER("image-installer.png"),
    IMAGE_VISUAL("image-visual.png"),
    IMAGE_SPOT("image-spot.png"),
    IMAGE_SUPPORT("image-support.png"),
    IMAGE_PRODUCT_ROW("image-product-row.png"),
    IMAGE_PRODUCT_DETAIL("image-product-detail.png");

    private String name;

    private ImageRendition(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
