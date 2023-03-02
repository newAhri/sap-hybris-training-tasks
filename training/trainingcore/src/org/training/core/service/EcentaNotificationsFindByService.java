package org.training.core.service;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import org.training.core.enums.NotificationPriorityEnum;
import org.training.core.enums.NotificationTypeEnum;
import org.training.core.model.EcentaNotificationModel;

import java.util.List;

public interface EcentaNotificationsFindByService {
    List<EcentaNotificationModel> getAllEcentaNotificatonsByB2BCustomer(B2BCustomerModel b2BCustomerModel);

    List<EcentaNotificationModel> getAllEcentaNotificatonsByB2BCustomerAndPriority(B2BCustomerModel b2BCustomerModel
            , NotificationPriorityEnum priorityEnum);

    List<EcentaNotificationModel> getAllEcentaNotificatonsByB2BCustomerAndType(B2BCustomerModel b2BCustomerModel
            , NotificationTypeEnum typeEnum);
}
