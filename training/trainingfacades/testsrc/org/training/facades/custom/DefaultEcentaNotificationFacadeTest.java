package org.training.facades.custom;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;
import org.training.core.model.EcentaNotificationModel;

import javax.annotation.Resource;

@IntegrationTest
public class DefaultEcentaNotificationFacadeTest extends ServicelayerTransactionalBaseTest {

    @Resource
    private ModelService modelService;

    /*@Test
    public void testFacade(){
        EcentaNotificationModel model = modelService.get(PK.parse())
    }*/
}
