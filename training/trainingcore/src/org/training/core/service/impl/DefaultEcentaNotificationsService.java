package org.training.core.service.impl;

import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.training.core.dao.CustomEcentaNotificationsDAO;
import org.training.core.dao.impl.CustomEcentaNotificationsDAOImpl;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.service.EcentaNotificationsService;

import java.util.Date;
import java.util.List;

public class DefaultEcentaNotificationsService implements EcentaNotificationsService {
    private CustomEcentaNotificationsDAO customEcentaNotificationsDAO;

    @Override
    public List<EcentaNotificationModel> getOldEcentaNotifications(Date oldDate) throws UnknownIdentifierException {
        final List<EcentaNotificationModel> ecentaNotificationModelList = getEcentaNotificationsDAO()
                .findAllNotificationsOlderThanSpecifiedDays(oldDate);
        if (ecentaNotificationModelList.isEmpty()){
            throw new UnknownIdentifierException("No old notifications were found");
        }
        return ecentaNotificationModelList;
    }

    private CustomEcentaNotificationsDAO getEcentaNotificationsDAO() {
        return customEcentaNotificationsDAO;
    }

    public void setCustomEcentaNotificationsDAO(CustomEcentaNotificationsDAOImpl customEcentaNotificationsDAO) {
        this.customEcentaNotificationsDAO = customEcentaNotificationsDAO;
    }
}