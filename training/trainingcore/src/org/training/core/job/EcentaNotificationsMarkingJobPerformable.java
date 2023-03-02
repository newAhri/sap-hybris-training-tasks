package org.training.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.exceptions.ModelRemovalException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.tx.Transaction;
import org.springframework.util.CollectionUtils;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.model.EcentaNotificationRemovalCronJobModel;
import org.training.core.service.impl.DefaultEcentaNotificationsService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class EcentaNotificationsMarkingJobPerfomable extends AbstractJobPerformable<EcentaNotificationRemovalCronJobModel> {


    protected DefaultEcentaNotificationsService defaultEcentaNotificationsService;
    private final static Logger LOG = Logger.getLogger(EcentaNotificationsMarkingJobPerfomable.class.getName());


    @Override
    public PerformResult perform(EcentaNotificationRemovalCronJobModel ecentaNotificationRemovalCronJobModel) {
        try {
            final int amountOfDaysOld = ecentaNotificationRemovalCronJobModel.getXDaysOld();
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -amountOfDaysOld);
            final Date oldDate = cal.getTime();
            final List<EcentaNotificationModel> ecentaNotificationModelListToBeMarked = getDefaultEcentaNotificationsService().getOldEcentaNotifications(oldDate);

            if (!CollectionUtils.isEmpty(ecentaNotificationModelListToBeMarked)) {
                int count = 0;
                for (EcentaNotificationModel ecentaNotificationModel : ecentaNotificationModelListToBeMarked) {
                    ecentaNotificationModel.setDeleted(true);
                    ecentaNotificationModel.setRead(true);
                    count++;
                }
                Transaction tx = null;
                try {
                    tx = Transaction.current();
                    tx.begin();
                    getModelService().saveAll(ecentaNotificationModelListToBeMarked);
                    tx.commit();
                    LOG.fine("Number of marked EcentaNotifications: " + count);
                } catch (final ModelRemovalException ex) {
                    if (null != tx) {
                        tx.rollback();
                    }
                }
            } else {
                LOG.fine("No EcentaNotification to be marked");
            }
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        } catch (final Exception ex) {
            LOG.warning("Exception");
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.ABORTED);
        }
    }

    public ModelService getModelService() {
        return modelService;
    }

    public DefaultEcentaNotificationsService getDefaultEcentaNotificationsService() {
        return defaultEcentaNotificationsService;
    }

    public void setDefaultEcentaNotificationsService(DefaultEcentaNotificationsService defaultEcentaNotificationsService) {
        this.defaultEcentaNotificationsService = defaultEcentaNotificationsService;
    }
}