package com.deptagency.dtnl.aem.adaptto.core.services;
import com.adobe.fontengine.font.cff.Dict;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.DictionaryEnum;
import org.apache.sling.api.SlingHttpServletRequest;
import com.day.cq.wcm.api.Page;

import java.util.Locale;

public interface I18nService {
    String get(final Page currentPage,
               final SlingHttpServletRequest slingRequest,
               final String text);

    String get(final Page currentPage,
               final DictionaryEnum i18nKey);

    String get(final Page currentPage,
               final String i18nKey);

    String get(final Locale lang,
               final DictionaryEnum i18nKey);

    String get(final Locale lang,
               final String i18nKey);
}