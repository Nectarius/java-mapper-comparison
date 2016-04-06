package tea.domain;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 03 April 2016
 */
public class BlackTea extends Item {

    private String variety;

    private String sourceRegion;

    private String sourceCountry;

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

    public BlackTea( String variety, String sourceRegion, String sourceCountry, String description, String content, User registeredBy) {
        super(description, content, registeredBy);
        this.variety = variety;
        this.sourceRegion = sourceRegion;
        this.sourceCountry = sourceCountry;
    }







}
