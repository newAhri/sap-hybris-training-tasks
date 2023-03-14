package org.training.core.dao;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.training.core.dao.impl.CustomEcentaNotificationDAOImpl;
import org.training.core.model.EcentaNotificationModel;

import java.util.List;

@UnitTest
public class CustomEcentaNotificationsDAOImplTest extends ServicelayerTransactionalBaseTest {

    @Mock
    private FlexibleSearchService flexibleSearchService;
    @Mock
    private B2BCustomerModel b2BCustomerModel;

    private CustomEcentaNotificationDAOImpl dao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        dao = new CustomEcentaNotificationDAOImpl();
        dao.setFlexibleSearchService(flexibleSearchService);
    }

    @Test
    public void testfindAllNotificationsByB2BCustomer() {
        List<EcentaNotificationModel> resultList = dao.findAllNotificationsByB2BCustomer(b2BCustomerModel);
        Assert.assertNotNull(resultList);
    }
}
