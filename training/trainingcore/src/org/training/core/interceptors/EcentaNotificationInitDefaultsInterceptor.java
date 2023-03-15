package org.training.core.interceptors;

import de.hybris.platform.servicelayer.interceptor.InitDefaultsInterceptor;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.keygenerator.impl.PersistentKeyGenerator;
import org.training.core.model.EcentaNotificationModel;

public class EcentaNotificationInitDefaultsInterceptor implements InitDefaultsInterceptor {
    private PersistentKeyGenerator uniqueAlphanumericIDKeyGenerator;

    @Override
    public void onInitDefaults(Object o, InterceptorContext interceptorContext) throws InterceptorException {
        if (o instanceof EcentaNotificationModel){
            EcentaNotificationModel model = (EcentaNotificationModel) o;
            model.setId((String) uniqueAlphanumericIDKeyGenerator.generate());
            interceptorContext.registerElementFor(model, PersistenceOperation.SAVE);
        }
    }

    public PersistentKeyGenerator getUniqueAlphanumericIDKeyGenerator() {
        return uniqueAlphanumericIDKeyGenerator;
    }

    public void setUniqueAlphanumericIDKeyGenerator(PersistentKeyGenerator uniqueAlphanumericIDKeyGenerator) {
        this.uniqueAlphanumericIDKeyGenerator = uniqueAlphanumericIDKeyGenerator;
    }
}
