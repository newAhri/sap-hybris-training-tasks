package org.training.core.crud.impl;

import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.tx.Transaction;
import de.hybris.platform.tx.TransactionBody;
import org.training.core.crud.EcentaNotificationRepository;
import org.training.core.model.EcentaNotificationModel;

import javax.annotation.Resource;
import java.sql.Connection;
import java.util.List;

public class DefaultEcentaNotificationRepositoryImpl implements EcentaNotificationRepository {

    @Resource
    private ModelService modelService;

    @Override
    public void saveNewOrUpdateEcentaNotification(EcentaNotificationModel ecentaNotificationModel) {
        try {
            Transaction tx = Transaction.current();
            tx.setTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED);
            tx.execute(new TransactionBody() {
                @Override
                public Object execute() {
                    modelService.save(ecentaNotificationModel);
                    return null;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void saveNewOrUpdateEcentaNotificationList(List<EcentaNotificationModel> ecentaNotificationModelList) {
        try {
            Transaction tx = Transaction.current();
            tx.setTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED);
            tx.execute(new TransactionBody() {
                @Override
                public Object execute() {
                    modelService.saveAll(ecentaNotificationModelList);
                    return null;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public EcentaNotificationModel cloneEcentaNotification(EcentaNotificationModel ecentaNotificationModel){
        try {
            Transaction tx = Transaction.current();
            tx.setTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED);
            return (EcentaNotificationModel) tx.execute(new TransactionBody() {
                @Override
                public Object execute() {
                    EcentaNotificationModel model = modelService.clone(ecentaNotificationModel);
                    return model;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteEcentaNotification(EcentaNotificationModel ecentaNotificationModel) {
        try {
            Transaction tx = Transaction.current();
            tx.setTransactionIsolationLevel(Connection.TRANSACTION_READ_COMMITTED);
            tx.execute(new TransactionBody() {
                @Override
                public Object execute() {
                    modelService.remove(ecentaNotificationModel);
                    return null;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
