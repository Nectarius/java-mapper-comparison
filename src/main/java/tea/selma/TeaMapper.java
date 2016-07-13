package tea.selma;


import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;
import tea.domain.BlackTea;
import tea.domain.GreenTea;
import tea.domain.User;
import tea.domain.WhiteTea;
import view.BlackTeaView;
import view.GreenTeaView;
import view.WhiteTeaView;

/**
 * Created by nefarius on 4/5/15.
 */
@Mapper(withIoC = IoC.SPRING)
public abstract class TeaMapper {


    @Maps(withIgnoreFields = {"variety", "registeredby"}, withCustom = {TeaCustomMapper.class})
    //@Mapping(target = "variety", constant = "White Peony")
   public abstract WhiteTeaView whiteTeaToView(WhiteTea whiteTea);

    @Maps(withIgnoreFields={"content", "registeredby"}, withCustom = {TeaCustomMapper.class})
    //@Mapping(target = "description", expression = "java(greenTea.getDescription() + greenTea.getContent())")
   public abstract GreenTeaView greenTeaToView(GreenTea greenTea);

    @Maps(withIgnoreFields={ "registeredBy"}, withCustom = {TeaCustomMapper.class})
        //@Mapping(target = "registeredBy", expression = "java(abstractUserMapper.getRegisteredBy(blackTea.getRegisteredBy(), isEmployee))")
    abstract BlackTeaView blackTeaToView(BlackTea blackTea);

    private String defaultMessage = "Unknown user";

    private String asString(User user) {
        return user == null ? defaultMessage : user.getName();
    }

    private String getRegisteredBy(User user, Boolean isEmployee) {
        if (isEmployee) {
            return asString(user);
        } else {
            return "";
        }

    }


    //@Mapping(target = "registeredBy", expression = "java(abstractUserMapper.getRegisteredBy(blackTea.getRegisteredBy(), isEmployee))")
    public BlackTeaView blackTeaToView(BlackTea blackTea, Boolean isEmployee){

        BlackTeaView blackTeaToView = this.blackTeaToView(blackTea);

        blackTeaToView.setRegisteredBy(getRegisteredBy(blackTea.getRegisteredBy(), isEmployee));

        return blackTeaToView;
    }


}
