package org.training.core.interceptors;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Test;
import org.training.core.model.EcentaNotificationModel;

import javax.annotation.Resource;

@IntegrationTest
public class EcentaNotificationDefaultInitInterceptorIDTest extends ServicelayerTransactionalTest {

    @Resource
    private ModelService modelService;

    @Test
    public void testInterceptor(){
        EcentaNotificationModel model = new EcentaNotificationModel();
        modelService.initDefaults(model);
        System.out.println(model.getId());
    }
}
