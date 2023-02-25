package org.training.core.handlers;

import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import org.training.core.model.EcentaNotificationModel;

public class EcentaNotificationB2BUnitHandler implements DynamicAttributeHandler<B2BUnitModel, EcentaNotificationModel> {

    private ModelService modelService;

    @Override
    public void set(EcentaNotificationModel model, B2BUnitModel b2BUnit) {
        {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public B2BUnitModel get(EcentaNotificationModel model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        B2BCustomerModel b2BCustomerModel = model.getB2bCustomer();
        if (b2BCustomerModel == null) {
            throw new UnsupportedOperationException();
        }
        B2BUnitModel b2BUnitModel = b2BCustomerModel.getDefaultB2BUnit();
        return b2BUnitModel;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
