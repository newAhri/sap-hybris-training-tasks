package org.training.facades.custom;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.ServicelayerTransactionalBaseTest;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.training.core.model.EcentaNotificationModel;
import org.training.facades.custom.impl.DefaultEcentaNotificationFacade;
import org.training.facades.notification.data.EcentaNotificationData;

import static org.mockito.BDDMockito.given;

@UnitTest
public class DefaultEcentaNotificationFacadeTest extends ServicelayerTransactionalBaseTest {

    @Mock
    private Converter<EcentaNotificationModel, EcentaNotificationData> ecentaNotificationConverter;
    @Mock
    private EcentaNotificationData ecentaNotificationData;
    @Mock
    private EcentaNotificationModel ecentaNotificationModel;

    private DefaultEcentaNotificationFacade defaultEcentaNotificationFacade;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        defaultEcentaNotificationFacade = new DefaultEcentaNotificationFacade();
        defaultEcentaNotificationFacade.setEcentaNotificationConverter(ecentaNotificationConverter);
    }

    @Test
    public void testFacade(){
        given(defaultEcentaNotificationFacade.getEcentaNotificationData(ecentaNotificationModel))
                .willReturn(ecentaNotificationData);
    }
}
