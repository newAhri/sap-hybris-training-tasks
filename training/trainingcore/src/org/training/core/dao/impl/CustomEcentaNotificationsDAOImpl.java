package org.training.core.dao.impl;

import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.training.core.dao.CustomEcentaNotificationsDAO;
import org.training.core.model.EcentaNotificationModel;

import javax.annotation.Resource;
import java.util.*;

public class CustomEcentaNotificationsDAOImpl extends AbstractItemDao implements CustomEcentaNotificationsDAO {

    @Resource
    private FlexibleSearchService flexibleSearchService;
    protected final static String SELECT_OLD_ECENTA_NOTIF = "SELECT {"
            + EcentaNotificationModel.PK
            + "} FROM {"
            + EcentaNotificationModel._TYPECODE
            + "} WHERE {"
            + EcentaNotificationModel.DATE
            + "} <= ?oldDate";

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

    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }
}