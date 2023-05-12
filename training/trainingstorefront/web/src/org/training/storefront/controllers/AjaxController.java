package org.training.storefront.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.training.core.crud.impl.DefaultEcentaNotificationRepositoryImpl;
import org.training.core.model.EcentaNotificationModel;
import org.training.core.service.EcentaNotificationFindByService;

import javax.annotation.Resource;

@Controller
public class AjaxController {

    @Resource(name = "defaultEcentaNotificationFindByService")
    private EcentaNotificationFindByService ecentaNotificationFindByService;
    @Resource(name = "defaultEcentaNotificationRepositoryImpl")
    private DefaultEcentaNotificationRepositoryImpl repository;

    @RequestMapping(value = "/getRefreshedList"
            , method = RequestMethod.POST
            , consumes = MediaType.APPLICATION_JSON_VALUE
            , produces = MediaType.APPLICATION_JSON_VALUE)
    protected @ResponseBody
    String getRefreshedList(
            @RequestParam(value = "id") final String id
    ) {
        EcentaNotificationModel model = (ecentaNotificationFindByService.getEcentaNotificationByID(id))
                .get(0);
        repository.deleteEcentaNotification(model);

        return String.valueOf(HttpStatus.OK);
    }
}
