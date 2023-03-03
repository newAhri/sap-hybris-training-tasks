package org.training.core.service;

import org.training.core.model.EcentaNotificationModel;

import java.util.Date;
import java.util.List;

public interface EcentaNotificationRemovalService {
    List<EcentaNotificationModel> getOldEcentaNotifications(Date oldDate);
}
