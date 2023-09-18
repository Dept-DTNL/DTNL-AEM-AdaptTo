package com.deptagency.dtnl.aem.adaptto.core.models.utils;

import java.util.Objects;
import java.util.ResourceBundle;

import com.day.cq.i18n.I18n;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.resolver.Resolver;

import javax.inject.Inject;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@JsonInclude(JsonInclude.Include.NON_NULL)
// Cannot use LOMBOK due to this Model Class is used as a ChildResource
public class Link {

    @ValueMapValue(name="url")
    @Inject
    private String url;

    @ValueMapValue(name="label")
    @Inject
    private String label;

    @ValueMapValue(name="newTabTarget")
    @Inject
    private Boolean newTabTarget;

    private Link(){

    }

    public String getUrl() {
        return url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label=label;
    }

    public Boolean getNewTabTarget() {
        return newTabTarget;
    }

    public static Link of(final String url, final String label){
        final Link link = new Link();
        link.url = url;
        link.label = label;
        return link;
    }

    /**
     * Constructor for links that can be translated
     * @param url
     * @param label
     * @param resourceBundle
     * @return
     */
    public static Link of(final String url, final String label, final ResourceBundle resourceBundle){
        final Link link = new Link();
        link.url = url;
        link.label = I18n.get(resourceBundle,label);
        return link;
    }

    public static Link of(final String url, final String label, final Boolean newTabTarget){
        final Link link = new Link();
        link.url = url;
        link.label = label;
        link.newTabTarget = newTabTarget;
        return link;
    }

    public static Link emptyLink() {
        return of("Please configure link url", "Please configure link label", false);
    }

    @JsonIgnore
    public boolean isEmpty(){
        return StringUtils.isEmpty(this.url) || StringUtils.isEmpty(this.label);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Link)) {
            return false;
        }
        Link link = (Link) o;
        return Objects.equals(getUrl(), link.getUrl()) && Objects.equals(getLabel(), link.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl(), getLabel());
    }
}
