package org.training.core.dao.impl;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.training.core.dao.CustomEcentaNotificationsDAO;
import org.training.core.enums.NotificationPriorityEnum;
import org.training.core.enums.NotificationTypeEnum;
import org.training.core.model.EcentaNotificationModel;

import javax.annotation.Resource;
import java.util.*;

public class CustomEcentaNotificationsDAOImpl extends AbstractItemDao implements CustomEcentaNotificationsDAO {

    @Resource
    private FlexibleSearchService flexibleSearchService;

    protected final static String SELECT_ECENTA_NOTIF_CLAUSE = "SELECT {"
            + EcentaNotificationModel.PK
            + "} ";

    protected final static String FROM_ECENTA_NOTIF_TABLE = "FROM {"
            + EcentaNotificationModel._TYPECODE
            + "} ";

    protected final static String FROM_ECENTA_NOTIF_JOIN_PRIORITY_TABLE = "FROM {"
            + EcentaNotificationModel._TYPECODE
            + " JOIN NotificationPriorityEnum ON {"
            + EcentaNotificationModel.PRIORITY
            + "} = {NotificationPriorityEnum.PK}} ";

    protected final static String FROM_ECENTA_NOTIF_JOIN_TYPE_TABLE = "FROM {"
            + EcentaNotificationModel._TYPECODE
            + " JOIN NotificationTypeEnum ON {"
            + EcentaNotificationModel.TYPE
            + "} = {NotificationTypeEnum.PK}} ";

    protected final static String OLD_ECENTA_NOTIF_CLAUSE = "{"
            + EcentaNotificationModel.DATE
            + "} <= ?oldDate";

    protected final static String SELECT_OLD_ECENTA_NOTIF = SELECT_ECENTA_NOTIF_CLAUSE
            + "WHERE "
            + OLD_ECENTA_NOTIF_CLAUSE;

    protected final static String B2BCUSTOMER_CLAUSE = "{"
            + EcentaNotificationModel.B2BCUSTOMER
            + "} = ?b2BCustomer ";

    protected final static String PRIORITY_CODE_CLAUSE = "{NotificationPriorityEnum.CODE} = ?priority ";

    protected final static String TYPE_CODE_CLAUSE = " {NotificationTypeEnum.CODE} = ?type ";

    protected final static String SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_TABLE
            + "WHERE "
            + B2BCUSTOMER_CLAUSE;

    protected final static String SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_PRIORITY = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_JOIN_PRIORITY_TABLE
            + "WHERE "
            + PRIORITY_CODE_CLAUSE
            + "AND "
            + B2BCUSTOMER_CLAUSE;

    protected final static String SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_TYPE = SELECT_ECENTA_NOTIF_CLAUSE
            + FROM_ECENTA_NOTIF_JOIN_TYPE_TABLE
            + "WHERE "
            + TYPE_CODE_CLAUSE
            + "AND "
            + B2BCUSTOMER_CLAUSE;



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
        return doSearch(SELECT_OLD_ECENTA_NOTIF
                , params
                , EcentaNotificationModel.class);
    }

    @Override
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomer(final B2BCustomerModel b2BCustomer) {
        final Map<String, Object> params = new HashMap<>();
        params.put("b2BCustomer", b2BCustomer);
        return doSearch(SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER
                , params
                , EcentaNotificationModel.class);
    }

    @Override
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomerAndPriority(final B2BCustomerModel b2BCustomer
            , final NotificationPriorityEnum priorityEnum) {

        final Map<String, Object> params = new HashMap<>();
        params.put("b2BCustomer", b2BCustomer);
        params.put("priority", priorityEnum.getCode());
        return doSearch(SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_PRIORITY
                , params
                , EcentaNotificationModel.class);
    }

    @Override
    public List<EcentaNotificationModel> findAllNotificationsByB2BCustomerAndType(final B2BCustomerModel b2BCustomer
            , final NotificationTypeEnum typeEnum) {

        final Map<String, Object> params = new HashMap<>();
        params.put("b2BCustomer", b2BCustomer);
        params.put("type", typeEnum.getCode());
        return doSearch(SELECT_ECENTA_NOTIF_BY_B2BCUSTOMER_AND_TYPE
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