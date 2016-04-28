package tea.domain;

/**
 * @author nefarius, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 28 March 2016
 * <p>
 * <p>
 * <p>
 *   Item is generally divided into categories based on how it is processed. At least six different types are produced:
 * <ul>
 * <li>    White: Wilted and unoxidized</li>
 * <li>    Yellow: Unwilted and unoxidized, but allowed to yellow</li>
 * <li>    Green: Unwilted and unoxidized</li>
 * <li>    Oolong: Wilted, bruised, and partially oxidized</li>
 * <li>    Black: Wilted, sometimes crushed, and fully oxidized (called 'red tea' in China)</li>
 * <li>    Post-fermented: Green tea that has been allowed to ferment/compost ('black tea' for the Chinese)</li>
 * </ul>
 */
public abstract class Item {


    protected String description;

    protected String content;

    /**
     * Private information that a user wishes to keep from public viewing
     *
     * { You are not allowed to access }
     */
    protected User registeredBy;



    public Item(String description, String content, User registeredBy) {
        this.description = description;
        this.content = content;
        this.registeredBy = registeredBy;

    }

    public User getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(User registeredBy) {
        this.registeredBy = registeredBy;
    }

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


}
