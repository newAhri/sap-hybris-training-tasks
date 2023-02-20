package org.training.core.dao;

import org.training.core.model.EcentaNotificationModel;

import java.util.Date;
import java.util.List;

public interface CustomEcentaNotificationsDAO {
    public List<EcentaNotificationModel> findAllNotificationsOlderThanSpecifiedDays(final Date oldDate);
}
