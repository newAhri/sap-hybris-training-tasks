package org.training.core.interceptors.ServiceProduct;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PersistenceOperation;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.keygenerator.impl.PersistentKeyGenerator;
import org.training.core.model.ServiceProductModel;

import java.util.Date;

public class ServiceProductPrepareInterceptor implements PrepareInterceptor {

    private PersistentKeyGenerator uniqueAlphanumericIDKeyGenerator;

    @Override
    public void onPrepare(Object o, InterceptorContext interceptorContext) throws InterceptorException {
        if(o instanceof ServiceProductModel){
            ServiceProductModel model = new ServiceProductModel();
            model.setId((String)uniqueAlphanumericIDKeyGenerator.generate());
            model.setCreationDate(new Date());
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
