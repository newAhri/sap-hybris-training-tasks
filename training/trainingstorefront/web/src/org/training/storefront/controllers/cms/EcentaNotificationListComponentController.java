package org.training.storefront.controllers.cms;


import de.hybris.platform.b2b.model.B2BCustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

@Controller
@RequestMapping(value = ControllerConstants.Actions.Cms.EcentaNotificationListComponent)
public class EcentaNotificationListComponentController
        extends AbstractAcceleratorCMSComponentController<EcentaNotificationListComponentModel> {

    @Resource(name = "ecentaNotificationFacade")
    private EcentaNotificationFacade ecentaNotificationFacade;
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "defaultEcentaNotificationFindByService")
    private EcentaNotificationFindByService ecentaNotificationFindByService;
    @Resource(name = "defaultEcentaNotificationRepositoryImpl")
    private DefaultEcentaNotificationRepositoryImpl repository;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, EcentaNotificationListComponentModel component) {
        UserModel currentUserModel = userService.getCurrentUser();
        if (!userService.isAnonymousUser(currentUserModel)) {
            List<EcentaNotificationModel> ecentaNotificationModelList = ecentaNotificationFindByService
                    .getAllEcentaNotificatonsByB2BCustomer((B2BCustomerModel) currentUserModel);

            List<EcentaNotificationData> ecentaNotificationDataList = ecentaNotificationModelList.stream()
                    .map(ecentaNotificationModel -> ecentaNotificationFacade.getEcentaNotificationData(ecentaNotificationModel))
                    .collect(Collectors.toList());

            model.addAttribute("ecentaNotificationDataList", ecentaNotificationDataList);
        }
    }

    @RequestMapping(value = "/getRefreshedList", method = RequestMethod.GET)
    @ResponseBody
    protected List<EcentaNotificationData> getRefreshedList(
            @RequestParam("id") String id
    ) {
        UserModel currentUserModel = userService.getCurrentUser();

        EcentaNotificationModel model = (ecentaNotificationFindByService.getEcentaNotificationByID(id)).get(0);
        repository.deleteEcentaNotification(model);


        List<EcentaNotificationModel> ecentaNotificationModelList = ecentaNotificationFindByService
                .getAllEcentaNotificatonsByB2BCustomer((B2BCustomerModel) currentUserModel);

        List<EcentaNotificationData> ecentaNotificationDataList = ecentaNotificationModelList.stream()
                .map(ecentaNotificationModel -> ecentaNotificationFacade.getEcentaNotificationData(ecentaNotificationModel))
                .collect(Collectors.toList());

        return ecentaNotificationDataList;
    }
}
