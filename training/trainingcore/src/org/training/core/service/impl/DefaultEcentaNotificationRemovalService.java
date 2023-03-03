package org.training.core.service.impl;

import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.training.core.dao.CustomEcentaNotificationDAO;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.service.EcentaNotificationRemovalService;

import java.util.Date;
import java.util.List;

public class DefaultEcentaNotificationRemovalService implements EcentaNotificationRemovalService {

    private CustomEcentaNotificationDAO dao;

    @Override
    public List<EcentaNotificationModel> getOldEcentaNotifications(Date oldDate) throws UnknownIdentifierException {
        final List<EcentaNotificationModel> ecentaNotificationModelList = dao
                .findAllNotificationsOlderThanSpecifiedDays(oldDate);
        if (ecentaNotificationModelList.isEmpty()){
            throw new UnknownIdentifierException("No old notifications were found");
        }
        return ecentaNotificationModelList;
    }

    public CustomEcentaNotificationDAO getDao() {
        return dao;
    }

    public void setDao(CustomEcentaNotificationDAO dao) {
        this.dao = dao;
    }
}