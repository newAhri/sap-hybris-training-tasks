package org.training.facades.populators;

import de.hybris.platform.b2b.model.B2BUnitModel;
import de.hybris.platform.b2bcommercefacades.company.data.B2BUnitData;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.training.core.model.EcentaNotificationModel;
import org.training.facades.notification.data.EcentaNotificationData;

public class EcentaNotificationPopulator implements Populator<EcentaNotificationModel, EcentaNotificationData> {

    private Converter<UserModel, CustomerData> customerConverter;
    private Converter<B2BUnitModel, B2BUnitData> b2BUnitConverter;

    @Override
    public void populate(EcentaNotificationModel source, EcentaNotificationData target) throws ConversionException {
        target.setId(source.getId());
        target.setDate(source.getDate());
        target.setType(source.getType());
        target.setMessage(source.getMessage());
        target.setPriority(source.getPriority());
        target.setRead(source.getRead());
        target.setDeleted(source.getDeleted());
        target.setTitle(source.getTitle());
        target.setB2bCustomer(customerConverter.convert(source.getB2bCustomer()));
        target.setB2bUnit(b2BUnitConverter.convert(source.getB2bUnit()));
    }

    public Converter<UserModel, CustomerData> getCustomerConverter() {
        return customerConverter;
    }

    public void setCustomerConverter(Converter<UserModel, CustomerData> customerConverter) {
        this.customerConverter = customerConverter;
    }

    public Converter<B2BUnitModel, B2BUnitData> getB2BUnitConverter() {
        return b2BUnitConverter;
    }

    public void setB2BUnitConverter(Converter<B2BUnitModel, B2BUnitData> b2BUnitConverter) {
        this.b2BUnitConverter = b2BUnitConverter;
    }



}
