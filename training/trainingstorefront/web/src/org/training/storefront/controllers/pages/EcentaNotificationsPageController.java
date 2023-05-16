package org.training.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.training.core.service.EcentaNotificationFindByService;
import org.training.facades.custom.EcentaNotificationFacade;

import javax.annotation.Resource;

@Controller
@Scope("tenant")
@RequestMapping("/ecenta-notifications")
public class EcentaNotificationsPageController extends AbstractPageController
{
    private static final String ECENTA_NOTIFICATIONS_CMS_PAGE = "ecentaNotificationsCMSPage";
    @Resource(name = "ecentaNotificationFacade")
    private EcentaNotificationFacade ecentaNotificationFacade;
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "defaultEcentaNotificationFindByService")
    private EcentaNotificationFindByService ecentaNotificationFindByService;

    @RequestMapping(method = RequestMethod.GET)
    public String getEcentaNotifications(final Model model) throws CMSItemNotFoundException
    {
        final ContentPageModel ecentaNotificationsCMSPage = getContentPageForLabelOrId(ECENTA_NOTIFICATIONS_CMS_PAGE);
        storeCmsPageInModel(model, ecentaNotificationsCMSPage);
        setUpMetaDataForContentPage(model, ecentaNotificationsCMSPage);
        return getViewForPage(model);
    }

}