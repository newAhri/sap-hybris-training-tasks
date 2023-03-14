package org.training.facades.custom;

import org.training.core.model.EcentaNotificationModel;
import org.training.facades.notification.data.EcentaNotificationData;

public interface EcentaNotificationFacade {
    EcentaNotificationData getEcentaNotificationData(EcentaNotificationModel model);
}
