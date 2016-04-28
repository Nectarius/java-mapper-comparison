package tea.domain;

import com.googlecode.jmapper.annotations.JMapConversion;

public class GreenTea extends Item {
	
	 private String variety;
	 
	 private String sourceRegion;

	 private String sourceCountry;
	 

	public GreenTea withVariety(String variety){
		this.variety = variety;
        return this;
	}
	
	public GreenTea withSourceRegion(String region){
		this.sourceRegion = region;
        return this;
	}
	
	public GreenTea withSourceCountry(String sourceCountry){
		this.sourceCountry = sourceCountry;
        return this;
	}

    @JMapConversion(from={"description"}, to={"description"})
    public String conversion(String str){
        return this.description + this.content;
    }

	public GreenTea(String description, String content,  User registeredBy) {
		super(description, content, registeredBy);
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

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}
 
	
}
