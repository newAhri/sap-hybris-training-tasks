package org.training.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.util.Config;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("tenant")
@RequestMapping("/ecenta-notifications")
public class EcentaNotificationsPageController extends AbstractPageController
{
    private static final String ECENTA_NOTIFICATIONS_CMS_PAGE = "ecentaNotificationsCMSPage";
    private static final String ECENTA_NOTIFICATIONS_SHOW_MAX = "ecenta.notifications.show.max";


    @RequestMapping(method = RequestMethod.GET)
    public String getEcentaNotifications(final Model model) throws CMSItemNotFoundException
    {
        final int maxAmountToShow = Integer.parseInt(Config.getParameter(ECENTA_NOTIFICATIONS_SHOW_MAX)) - 1;
        model.addAttribute("maxAmountToShow", maxAmountToShow);

        final ContentPageModel ecentaNotificationsCMSPage = getContentPageForLabelOrId(ECENTA_NOTIFICATIONS_CMS_PAGE);
        storeCmsPageInModel(model, ecentaNotificationsCMSPage);
        setUpMetaDataForContentPage(model, ecentaNotificationsCMSPage);
        return getViewForPage(model);
    }

}