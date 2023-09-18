package com.deptagency.dtnl.aem.adaptto.core.services.impl;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.i18n.ResourceBundleProvider;
import org.osgi.service.component.annotations.Component;

import com.day.cq.i18n.I18n;
import com.day.cq.wcm.api.Page;
import com.deptagency.dtnl.aem.adaptto.core.models.utils.DictionaryEnum;
import com.deptagency.dtnl.aem.adaptto.core.services.I18nService;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = I18nService.class)
public class I18nServiceImpl implements I18nService {

    @Reference(target="(component.name=org.apache.sling.i18n.impl.JcrResourceBundleProvider)")
    private ResourceBundleProvider resourceBundleProvider;

    @Override
    public String get(final Page currentPage, final SlingHttpServletRequest slingHttpServletRequest, final String textToTranslate){
        if(currentPage == null || slingHttpServletRequest == null){
            return textToTranslate;
        }
        final ResourceBundle resourceBundle = slingHttpServletRequest.getResourceBundle(currentPage.getLanguage(true));;
        return I18n.get(resourceBundle,textToTranslate.trim());
    }

    @Override
    public String get(final Page currentPage, final String i18nKey){
        if (currentPage == null || StringUtils.isBlank(i18nKey)) {
            return i18nKey;
        }
        final Optional<DictionaryEnum> optionalDictionaryKey = Optional.ofNullable(DictionaryEnum.lookup(i18nKey));
        return optionalDictionaryKey.map(key -> this.get(currentPage, key)).orElse(i18nKey);
    }

    @Override
    public String get(final Page currentPage, final DictionaryEnum i18nKey){
        if (currentPage == null) {
            return i18nKey.getText();
        }

        final ResourceBundle resourceBundle = resourceBundleProvider.getResourceBundle(currentPage.getLanguage(true));
        return I18n.get(resourceBundle,i18nKey.getText().trim());
    }

    @Override
    public String get(final Locale lang, final DictionaryEnum i18nKey) {
        return this.get(lang, i18nKey.getText());
    }

    @Override
    public String get(final Locale lang, final String i18nKey) {
        final ResourceBundle resourceBundle = resourceBundleProvider.getResourceBundle(lang);
        return I18n.get(resourceBundle,i18nKey.trim());
    }
}