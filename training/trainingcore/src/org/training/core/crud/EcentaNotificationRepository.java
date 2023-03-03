package org.training.core.crud;

import org.training.core.model.EcentaNotificationModel;

import java.util.List;

public interface EcentaNotificationRepository {
    void saveNewOrUpdateEcentaNotification(EcentaNotificationModel ecentaNotificationModel);
    void saveNewOrUpdateEcentaNotificationList(List<EcentaNotificationModel> ecentaNotificationModelList);
    EcentaNotificationModel cloneEcentaNotification(EcentaNotificationModel ecentaNotificationModel);
    void deleteEcentaNotification(EcentaNotificationModel ecentaNotificationModel);

}
