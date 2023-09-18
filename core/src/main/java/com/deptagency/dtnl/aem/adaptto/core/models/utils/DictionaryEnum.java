package com.deptagency.dtnl.aem.adaptto.core.models.utils;

import java.util.HashMap;
import java.util.Map;

public enum DictionaryEnum {
    SHOW_MORE("showMore"),
    SHOW_ALL("showAll"),
    AL("al"),
    HR("hr"),
    RS("rs"),
    SL("sl"),
    AT("at"),
    CH("ch"),
    LV("lv"),
    LT("lt"),
    BG("bg"),
    LU("lu"),
    NL("nl"),
    CZ("cz"),
    SK("sk"),
    FR("fr"),
    DE("de"),
    GR("gr"),
    HU("hu"),
    IT("it"),
    DK("dk"),
    FI("fi"),
    NO("no"),
    SW("sw"),
    PT("pt"),
    PL("pl"),
    RO("ro"),
    ES("es"),
    IE("ie"),
    UK("uk"),
    ALBANIAN("albanian"),
    BULGARIAN("bulgarian"),
    CROATIAN("croatian"),
    CZECH("czech"),
    DANISH("danish"),
    ENGLISH("english"),
    ESTONIAN("estonian"),
    FINNISH("finnish"),
    FRENCH("french"),
    GERMAN("german"),
    GREEK("greek"),
    HUNGARIAN("hungarian"),
    ITALIAN("italian"),
    LATVIAN("latvian"),
    LITHUANIAN("lithuanian"),
    NORWEGIAN("norwegian"),
    POLISH("polish"),
    PORTUGUESE("portuguese"),
    ROMANIAN("romanian"),
    SERBIAN("serbian"),
    SLOVAK("slovak"),
    SLOVENIAN("slovenian"),
    SPANISH("spanish"),
    SWEDISH("swedish"),
    CHOOSE_YOUR_COUNTRY("chooseYourCountry"),
    SEE_THE_SOLUTIONS("seeTheSolutions"),
    MAP("map"),
    LIST("list"),
    CLOSE("close"),
    FEATURES("features"),
    TYPE("type"),
    MORE_INFORMATION("More Information")
    ;

    private final String text;
    private static final Map<String, DictionaryEnum> lookup = new HashMap<String, DictionaryEnum>();

    static {
        for (DictionaryEnum e : DictionaryEnum.values()) {
            lookup.put(e.getText(), e);
        }
    }

    DictionaryEnum(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static DictionaryEnum lookup(final String text){
        return lookup.get(text);
    }
}
