package org.training.core.interceptors.EcentaNotification;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.training.core.model.EcentaNotificationModel;

public class EcentaNotificationPrepareInterceptor implements PrepareInterceptor {
    @Override
    public void onPrepare(Object o, InterceptorContext interceptorContext) throws InterceptorException {
        if (o instanceof EcentaNotificationModel) {
            EcentaNotificationModel model = (EcentaNotificationModel) o;
            if (model.getRead()) {
                model.setDeleted(true);
            } else if (!model.getRead()){
                model.setDeleted(false);
            } else {
                model.setDeleted(null);
            }
            interceptorContext.registerElementFor(model, PersistenceOperation.SAVE);
        }
    }
}