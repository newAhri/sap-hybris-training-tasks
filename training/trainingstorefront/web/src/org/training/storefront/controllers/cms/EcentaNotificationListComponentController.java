package org.training.storefront.controllers.cms;


import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;
import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.core.crud.impl.DefaultEcentaNotificationRepositoryImpl;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.model.components.EcentaNotificationListComponentModel;
import org.training.core.service.EcentaNotificationFindByService;
import org.training.facades.custom.EcentaNotificationFacade;
import org.training.facades.notification.data.EcentaNotificationData;
import org.training.storefront.controllers.ControllerConstants;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller("EcentaNotificationListComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.EcentaNotificationListComponent)
public class EcentaNotificationListComponentController
        extends AbstractCMSComponentController<EcentaNotificationListComponentModel> {

    @Resource(name = "ecentaNotificationFacade")
    private EcentaNotificationFacade ecentaNotificationFacade;
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "defaultEcentaNotificationFindByService")
    private EcentaNotificationFindByService ecentaNotificationFindByService;
    @Resource(name = "defaultEcentaNotificationRepositoryImpl")
    private DefaultEcentaNotificationRepositoryImpl repository;
    private static Logger LOG = LoggerFactory.getLogger(EcentaNotificationListComponentController.class);

    @Override
    protected void fillModel(HttpServletRequest request, Model model, EcentaNotificationListComponentModel component) {

        UserModel currentUserModel = userService.getCurrentUser();
        if (!userService.isAnonymousUser(currentUserModel)) {
            List<EcentaNotificationModel> ecentaNotificationModelList = ecentaNotificationFindByService
                    .getAllEcentaNotificatonsByB2BCustomer((B2BCustomerModel) currentUserModel);

            List<EcentaNotificationData> ecentaNotificationDataList = ecentaNotificationModelList.stream()
                    .map(ecentaNotificationModel -> ecentaNotificationFacade.getEcentaNotificationData(ecentaNotificationModel))
                    .collect(Collectors.toList());
            /*List<EcentaNotificationData> ecentaNotificationDataList = new ArrayList<>();
            for (int i = 0; i < ecentaNotificationModelList.size(); i++) {
                ecentaNotificationDataList.add(ecentaNotificationFacade.getEcentaNotificationData(ecentaNotificationModelList.get(i)));
                System.out.println();*/
            model.addAttribute("ecentaNotificationDataList", ecentaNotificationDataList);
        }
    }





    @Override
    protected String getView(EcentaNotificationListComponentModel component) {
        LOG.info("getView method;");
        return ControllerConstants.Views.Cms.ComponentPrefix + getTypeCode(component).toLowerCase();
    }

}
