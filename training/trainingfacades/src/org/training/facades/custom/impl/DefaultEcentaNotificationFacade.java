package org.training.facades.custom.impl;

import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.training.core.model.EcentaNotificationModel;
import org.training.facades.custom.EcentaNotificationFacade;
import org.training.facades.data.EcentaNotificationData;

public class DefaultEcentaNotificationFacade implements EcentaNotificationFacade {
    private Converter<EcentaNotificationModel, EcentaNotificationData> ecentaNotificationConverter;

    @Override
    public EcentaNotificationData getEcentaNotificationData(EcentaNotificationModel model) {
        return ecentaNotificationConverter.convert(model);
    }

    public Converter<EcentaNotificationModel, EcentaNotificationData> getEcentaNotificationConverter() {
        return ecentaNotificationConverter;
    }

    public void setEcentaNotificationConverter(Converter<EcentaNotificationModel, EcentaNotificationData> ecentaNotificationConverter) {
        this.ecentaNotificationConverter = ecentaNotificationConverter;
    }
}
