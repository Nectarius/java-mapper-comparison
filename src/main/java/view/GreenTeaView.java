package view;


/**
 *   { for one to several example }
 *   
 * @author kmolodtsov
 *
 */
public class GreenTeaView {
	
	/**
	 *   description = description + content
	 */
	private String description;
	
	private String variety;
	
	private String sourceRegion;

    private String sourceCountry;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
