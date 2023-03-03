package org.training.core.service.impl;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.training.core.dao.CustomEcentaNotificationDAO;
import org.training.core.enums.NotificationPriorityEnum;
import org.training.core.enums.NotificationTypeEnum;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.service.EcentaNotificationFindByService;

import java.util.List;

public class DefaultEcentaNotificationFindByService implements EcentaNotificationFindByService {
    private CustomEcentaNotificationDAO dao;

    @Override
    public List<EcentaNotificationModel> getAllEcentaNotificatonsByB2BCustomer(B2BCustomerModel b2BCustomerModel) {
        final List<EcentaNotificationModel> ecentaNotificationModelList = dao
                .findAllNotificationsByB2BCustomer(b2BCustomerModel);
        if (ecentaNotificationModelList.isEmpty()){
            throw new UnknownIdentifierException("No Ecenta Notification was found by B2BCustomer");
        }
        return ecentaNotificationModelList;
    }

    @Override
    public List<EcentaNotificationModel> getAllEcentaNotificatonsByB2BCustomerAndPriority(B2BCustomerModel b2BCustomerModel
            , NotificationPriorityEnum priorityEnum) {
        final List<EcentaNotificationModel> ecentaNotificationModelList = dao
                .findAllNotificationsByB2BCustomerAndPriority(b2BCustomerModel, priorityEnum);
        if (ecentaNotificationModelList.isEmpty()){
            throw new UnknownIdentifierException("No Ecenta Notification was found by B2BCustomer and Priority");
        }
        return ecentaNotificationModelList;
    }

    @Override
    public List<EcentaNotificationModel> getAllEcentaNotificatonsByB2BCustomerAndType(B2BCustomerModel b2BCustomerModel
            , NotificationTypeEnum typeEnum) {
        final List<EcentaNotificationModel> ecentaNotificationModelList = dao
                .findAllNotificationsByB2BCustomerAndType(b2BCustomerModel, typeEnum);
        if (ecentaNotificationModelList.isEmpty()){
            throw new UnknownIdentifierException("No Ecenta Notification was found by B2BCustomer and Type");
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
