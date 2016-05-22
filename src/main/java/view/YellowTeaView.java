package view;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 22 May 2016
 */
public class YellowTeaView {

    private String description;

    private String content;

    private PropertyValueView primaryProperties;

    private PropertyValueView secondaryProperties;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PropertyValueView getPrimaryProperties() {
        return primaryProperties;
    }

    public void setPrimaryProperties(PropertyValueView primaryProperties) {
        this.primaryProperties = primaryProperties;
    }

    public PropertyValueView getSecondaryProperties() {
        return secondaryProperties;
    }

    public void setSecondaryProperties(PropertyValueView secondaryProperties) {
        this.secondaryProperties = secondaryProperties;
    }
}
