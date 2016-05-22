package tea.domain;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 01 May 2016
 */
public class OolongTea extends Item  {

    private String variety;

    private String sourceRegion;

    private String sourceCountry;


    public OolongTea(String description, String content, User registeredBy) {
        super(description, content, registeredBy);
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSourceRegion() {
        return sourceRegion;
    }

    public void setSourceRegion(String sourceRegion) {
        this.sourceRegion = sourceRegion;
    }

    public String getSourceCountry() {
        return sourceCountry;
    }

    public void setSourceCountry(String sourceCountry) {
        this.sourceCountry = sourceCountry;
    }

    public OolongTea withVariety(String variety){
        this.variety = variety;
        return this;
    }

    public OolongTea withSourceRegion(String region){
        this.sourceRegion = region;
        return this;
    }

    public OolongTea withSourceCountry(String sourceCountry){
        this.sourceCountry = sourceCountry;
        return this;
    }
}
