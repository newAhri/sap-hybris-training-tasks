package org.training.core.dao;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.training.core.model.EcentaNotificationModel;

import javax.annotation.Resource;
import java.util.List;

@IntegrationTest
public class CustomEcentaNotificationsDAOImplTest extends ServicelayerTransactionalBaseTest {

    private CustomEcentaNotificationDAO dao;
    @Resource
    private FlexibleSearchService flexibleSearchService;
    @Resource
    private UserService userService;


    /*protected final static String SELECT_ONE_ECENTA_NOTIF = "SELECT {"
            + EcentaNotificationModel.PK
            + "} FROM {"
            + EcentaNotificationModel._TYPECODE
            + "} WHERE {"
            + EcentaNotificationModel.ID
            + "} = 1";*/

    /*protected final static String SELECT_ONE_ECENTA_NOTIF = "SELECT {"
            + EcentaNotificationModel.PK
            + "} FROM {"
            + EcentaNotificationModel._TYPECODE
            + "} WHERE {"
            + EcentaNotificationModel.B2BCUSTOMER
            + "} = \"william.hunter@pronto-hw.com\" ";*/

    @Before
    public void setUp() throws Exception {
        dao = (CustomEcentaNotificationDAO) Registry.getApplicationContext().getBean("customEcentaNotificationsDAOImpl");


    }


    @Test
    public void testfindAllNotificationsByB2BCustomer() {
        B2BCustomerModel customer = getB2BCustomer();
        final List<EcentaNotificationModel> list = dao.findAllNotificationsByB2BCustomer(customer);
        Assert.assertNotNull(list);
    }

    public B2BCustomerModel getB2BCustomer(){
        userService.setCurrentUser(userService.getAdminUser());
        B2BCustomerModel customer = (B2BCustomerModel) userService.getUserForUID("william.hunter@pronto-hw.com");
        return customer;

       /* B2BCustomerModel customer;
        final FlexibleSearchQuery searchQuery = new FlexibleSearchQuery(SELECT_ONE_ECENTA_NOTIF);
        searchQuery.setResultClassList(Collections.singletonList(EcentaNotificationModel.class));

        final SearchResult<EcentaNotificationModel> searchResult = flexibleSearchService.search(searchQuery);
        List<EcentaNotificationModel> result = searchResult.getResult();
        EcentaNotificationModel enm = result.get(0);
        customer = modelService.getSource(enm.getB2bCustomer());
        return customer;*/

    }


    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
