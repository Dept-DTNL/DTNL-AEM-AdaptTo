package com.deptagency.dtnl.aem.adaptto.core.models.utils;

import com.day.cq.wcm.api.Page;
import com.deptagency.dtnl.aem.adaptto.core.services.I18nService;

public class TranslateUtil {
    public static String translate(final I18nService i18nService, final Page currentPage, final DictionaryEnum i18nKey) {
        return i18nService.get(currentPage,i18nKey);
    }
}
