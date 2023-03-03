package org.training.core.job;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.util.CollectionUtils;
import org.training.core.enums.NotificationPriorityEnum;
import org.training.core.enums.NotificationTypeEnum;
import org.training.core.model.EcentaNotificationFindByCronJobModel;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.service.impl.DefaultEcentaNotificationsFindByService;
import org.training.core.dao.queries.EcentaNotificationQueriesConstants;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

public class EcentaNotificationsFindByJobPerformable extends AbstractJobPerformable<EcentaNotificationFindByCronJobModel> {

    @Resource
    private DefaultEcentaNotificationsFindByService defaultEcentaNotificationsFindByService;
    @Resource
    private FlexibleSearchService flexibleSearchService;
    private B2BCustomerModel b2BCustomerModel;

    @Override
    public PerformResult perform(EcentaNotificationFindByCronJobModel ecentaNotificationFindByCronJobModel) {
        getB2BCustomer();
        try {
            getAndPrintEcentaNotificationsByB2BCustomer(b2BCustomerModel);
            getAndPrintEcentaNotificationsByB2BCustomerAndPriority(b2BCustomerModel, NotificationPriorityEnum.HIGH);
            getAndPrintEcentaNotificationsByB2BCustomerAndType(b2BCustomerModel, NotificationTypeEnum.ORDERMANAGEMENT);
            getAndPrintEcentaNotificationsByB2BCustomerAndType(b2BCustomerModel, NotificationTypeEnum.NEWS);
            getAndPrintEcentaNotificationsByB2BCustomerAndType(b2BCustomerModel, NotificationTypeEnum.SERVICETICKETS);
            getAndPrintEcentaNotificationsByB2BCustomerAndType(b2BCustomerModel, NotificationTypeEnum.WORKFLOW);
        } catch (final Exception ex) {
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.ABORTED);
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    public void getAndPrintEcentaNotificationsByB2BCustomer(B2BCustomerModel b2BCustomer) {
        final List<EcentaNotificationModel> modelList = defaultEcentaNotificationsFindByService
                .getAllEcentaNotificatonsByB2BCustomer(b2BCustomer);
        printEcentaNotificationModelList(modelList, "B2BCustomer");
    }

    public void getAndPrintEcentaNotificationsByB2BCustomerAndPriority(B2BCustomerModel b2BCustomer
            , NotificationPriorityEnum priorityEnum) {
        final List<EcentaNotificationModel> modelList = defaultEcentaNotificationsFindByService
                .getAllEcentaNotificatonsByB2BCustomerAndPriority(b2BCustomer, priorityEnum);
        printEcentaNotificationModelList(modelList, "B2BCustomer and Priority." + priorityEnum.toString());
    }

    public void getAndPrintEcentaNotificationsByB2BCustomerAndType(B2BCustomerModel b2BCustomer
            , NotificationTypeEnum typeEnum) {
        final List<EcentaNotificationModel> modelList = defaultEcentaNotificationsFindByService
                .getAllEcentaNotificatonsByB2BCustomerAndType(b2BCustomer, typeEnum);
        printEcentaNotificationModelList(modelList, "B2BCustomer and Type." + typeEnum.toString());
    }

    public void printEcentaNotificationModelList(List<EcentaNotificationModel> modelList
            , final String byParameter) {
        if (!CollectionUtils.isEmpty(modelList)) {
            System.out.println("\n\n\n\n\nFound notifications by " + byParameter + ":\n");
            System.out.printf("%5s| %15s| %30s|\n", "ID", "PK", "Date");
            for (EcentaNotificationModel model : modelList) {
                System.out.printf("%5d| %15s| %30s|\n"
                        , model.getId()
                        , model.getPk().toString()
                        , model.getDate().toString());
            }
            System.out.println("\n\n\n\n");
        }
    }

    private void getB2BCustomer() {
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(EcentaNotificationQueriesConstants.SELECT_ONE_ECENTA_NOTIF);
        searchQuery.setResultClassList(Collections.singletonList(EcentaNotificationModel.class));
        final SearchResult<EcentaNotificationModel> searchResult = flexibleSearchService.search(searchQuery);
        List<EcentaNotificationModel> result = searchResult.getResult();
        EcentaNotificationModel enm = result.get(0);
        b2BCustomerModel = enm.getB2bCustomer();
    }



    public DefaultEcentaNotificationsFindByService getDefaultEcentaNotificationsFindByService() {
        return defaultEcentaNotificationsFindByService;
    }

    public void setDefaultEcentaNotificationsFindByService(DefaultEcentaNotificationsFindByService defaultEcentaNotificationsFindByService) {
        this.defaultEcentaNotificationsFindByService = defaultEcentaNotificationsFindByService;
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
