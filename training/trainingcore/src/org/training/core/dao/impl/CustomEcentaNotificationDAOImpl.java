package org.training.core.dao.impl;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.training.core.dao.CustomEcentaNotificationDAO;
import org.training.core.dao.queries.EcentaNotificationQueriesConstants;
import org.training.core.enums.NotificationPriorityEnum;
import org.training.core.enums.NotificationTypeEnum;
import org.training.core.model.EcentaNotificationModel;

import javax.annotation.Resource;
import java.util.*;

public class CustomEcentaNotificationDAOImpl extends AbstractItemDao implements CustomEcentaNotificationDAO {

    @Resource
    private FlexibleSearchService flexibleSearchService;

    protected <T> FlexibleSearchQuery createSearchQuery(final String query
            , final Map<String, Object> params
            , final Class<T> resultClass) {

        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(query);
        if (params != null) {
            searchQuery.addQueryParameters(params);
        }
        searchQuery.setResultClassList(Collections.singletonList(resultClass));
        return searchQuery;
    }

    protected <T> List<T> doSearch(final String query
            , final Map<String, Object> params
            , final Class<T> resultClass) {

        final SearchResult<T> searchResult = flexibleSearchService.search(createSearchQuery(query, params, resultClass));
        return searchResult.getResult();
    }

    @Override
    public List<EcentaNotificationModel> findAllNotificationsOlderThanSpecifiedDays(final Date oldDate) {
        final Map<String, Object> params = new HashMap<>();
        params.put("oldDate", oldDate);
        return doSearch(EcentaNotificationQueriesConstants.SELECT_OLD_ECENTA_NOTIF
                , params
                , EcentaNotificationModel.class);
    }

    @Override
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomer(final B2BCustomerModel b2BCustomer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("b2BCustomer", b2BCustomer);
        return doSearch(EcentaNotificationQueriesConstants.SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER
                , params
                , EcentaNotificationModel.class);
    }

    @Override
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomerAndPriority(final B2BCustomerModel b2BCustomer
            , final NotificationPriorityEnum priorityEnum) {

        final Map<String, Object> params = new HashMap<>();
        params.put("b2BCustomer", b2BCustomer);
        params.put("priority", priorityEnum.getCode());
        return doSearch(EcentaNotificationQueriesConstants.SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_PRIORITY
                , params
                , EcentaNotificationModel.class);
    }

    @Override
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomerAndType(final B2BCustomerModel b2BCustomer
            , final NotificationTypeEnum typeEnum) {

        final Map<String, Object> params = new HashMap<>();
        params.put("b2BCustomer", b2BCustomer);
        params.put("type", typeEnum.getCode());
        return doSearch(EcentaNotificationQueriesConstants.SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_TYPE
                , params
                , EcentaNotificationModel.class);
    }

    @Override
    public List<EcentaNotificationModel> findNotificationByID(String id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return doSearch(EcentaNotificationQueriesConstants.SELECT_ECENTA_NOTIF_BY_ID
                , params
                , EcentaNotificationModel.class);
    }

    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }
}