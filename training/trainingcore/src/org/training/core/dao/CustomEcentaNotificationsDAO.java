package org.training.core.dao;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import org.training.core.enums.NotificationPriorityEnum;
import org.training.core.enums.NotificationTypeEnum;
import org.training.core.model.EcentaNotificationModel;

import java.util.Date;
import java.util.List;

public interface CustomEcentaNotificationsDAO {
    public List<EcentaNotificationModel> findAllNotificationsOlderThanSpecifiedDays(final Date oldDate);
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomer(final B2BCustomerModel b2BCustomer);
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomerAndPriority(final B2BCustomerModel b2BCustomer, final NotificationPriorityEnum priorityEnum);
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomerAndType(final B2BCustomerModel b2BCustomer, final NotificationTypeEnum typeEnum);
}
