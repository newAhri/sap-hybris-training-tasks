package org.training.core.translator;

import de.hybris.platform.impex.jalo.translators.AbstractValueTranslator;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import org.apache.commons.lang.StringUtils;
import org.training.core.jalo.EcentaNotification;

public class MessageValueTranslator extends AbstractValueTranslator {
    @Override
    public Object importValue(String title, Item item) throws JaloInvalidParameterException {
        clearStatus();
        EcentaNotification ecentaNotification = (EcentaNotification) item;
        if (StringUtils.isBlank(title)) {
            String message = ecentaNotification.getMessage();
            if (StringUtils.length(message) < 100) {
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
