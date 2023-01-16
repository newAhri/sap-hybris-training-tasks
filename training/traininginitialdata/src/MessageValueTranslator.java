import de.hybris.platform.impex.jalo.translators.AbstractValueTranslator;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import org.training.core.jalo.EcentaNotification;

public class MessageValueTranslator extends AbstractValueTranslator {
    @Override
    public Object importValue(String s, Item item) throws JaloInvalidParameterException {
        clearStatus();
        EcentaNotification ecentaNotification = (EcentaNotification) item;
        String title = ecentaNotification.getTitle();
        if (title.isEmpty()) {
            String message = ecentaNotification.getMessage();
            if (message.length() < 100) {
                return message;
            }
            return message.substring(0, 100);
        }
        return title;
    }

    @Override
    public String exportValue(Object o) throws JaloInvalidParameterException {
        return o == null ? "" : o.toString();
    }
}
