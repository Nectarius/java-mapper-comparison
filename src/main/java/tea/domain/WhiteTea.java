package tea.domain;

/**
 * @author adelfiri, <a href="mailto:Konstantin.Molodtsov@returnonintelligence.com">Konstantin Molodtsov</a>
 * @since 28 March 2016
 *
 *  Green tea
In regions of the world that prefer mild beverages,
such as the West and Far East, green tea should be steeped in water around 80 to 85 °C (176 to 185 °F),
the higher the quality of the leaves the lower the temperature.
Regions such as North Africa or Central Asia prefer a bitter tea, and hotter water is used.
In Morocco, green tea is steeped in boiling water for 15 minutes.
The container in which green tea is steeped is often warmed beforehand to prevent
premature cooling. High-quality green and white teas can have new water added as many as five or more times,
depending on variety, at increasingly higher temperatures.
 */

public class WhiteTea extends Item {

    /**
     *
     * Darjeeling White Item

	Moonlight White

	Shou Mei

	Silver Needle

    Snow Buds

	 White Matcha

	White Peony Item

     */



    public WhiteTea( String description, String content,  User registeredBy) {
        super( description, content, registeredBy);

    }


}
