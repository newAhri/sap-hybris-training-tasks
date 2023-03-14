package org.training.core.job;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.springframework.util.CollectionUtils;
import org.training.core.crud.impl.DefaultEcentaNotificationRepositoryImpl;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.model.EcentaNotificationRemovalCronJobModel;
import org.training.core.service.impl.DefaultEcentaNotificationRemovalService;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class EcentaNotificationRemovalJobPerformable extends AbstractJobPerformable<EcentaNotificationRemovalCronJobModel> {

    @Resource
    protected DefaultEcentaNotificationRemovalService defaultEcentaNotificationRemovalService;
    @Resource
    private DefaultEcentaNotificationRepositoryImpl defaultEcentaNotificationRepositoryImpl;

    private final static Logger LOG = Logger.getLogger(EcentaNotificationRemovalJobPerformable.class.getName());


    @Override
    public PerformResult perform(EcentaNotificationRemovalCronJobModel ecentaNotificationRemovalCronJobModel) {
        try {
            final int amountOfDaysOld = ecentaNotificationRemovalCronJobModel.getXDaysOld();
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, -amountOfDaysOld);
            final Date oldDate = cal.getTime();
            final List<EcentaNotificationModel> ecentaNotificationModelListToBeMarked = getDefaultEcentaNotificationRemovalService().getOldEcentaNotifications(oldDate);

            int count = 0;
            if (!CollectionUtils.isEmpty(ecentaNotificationModelListToBeMarked)) {
                for (EcentaNotificationModel ecentaNotificationModel : ecentaNotificationModelListToBeMarked) {
                    ecentaNotificationModel.setDeleted(true);
                    ecentaNotificationModel.setRead(true);
                    count++;
                }
                defaultEcentaNotificationRepositoryImpl.saveNewOrUpdateEcentaNotificationList(ecentaNotificationModelListToBeMarked);
                LOG.info("Marked Ecenta Notifications: " + count);
            } else {
                LOG.info("No EcentaNotification to be marked");
            }
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);

        } catch (final Exception ex) {
            LOG.warning("Exception");
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.ABORTED);
        }
    }

    public DefaultEcentaNotificationRemovalService getDefaultEcentaNotificationRemovalService() {
        return defaultEcentaNotificationRemovalService;
    }

    public void setDefaultEcentaNotificationRemovalService(DefaultEcentaNotificationRemovalService defaultEcentaNotificationRemovalService) {
        this.defaultEcentaNotificationRemovalService = defaultEcentaNotificationRemovalService;
    }

    public DefaultEcentaNotificationRepositoryImpl getDefaultEcentaNotificationRepositoryImpl() {
        return defaultEcentaNotificationRepositoryImpl;
    }

    public void setDefaultEcentaNotificationRepositoryImpl(DefaultEcentaNotificationRepositoryImpl defaultEcentaNotificationRepositoryImpl) {
        this.defaultEcentaNotificationRepositoryImpl = defaultEcentaNotificationRepositoryImpl;
    }
}