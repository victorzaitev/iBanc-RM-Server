/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.controllers.mvc;

import javax.servlet.http.HttpServletRequest;
import md.ibanc.rm.entities.SingInOutSessions;
import md.ibanc.rm.spring.service.SingInOutSessionsService;
import md.ibanc.rm.util.SendMailNewDevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Zaițev.Victor
 */
@Controller
public class MultiActionControllers {

    @Autowired
    @Qualifier(value = "singInOutSessionsService")
    private SingInOutSessionsService singInOutSessionsService;

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "redirect:login";
    }

    //----------------------- Orders Page ----------------------------------------------------
    @RequestMapping(value = "/login")
    public String getLogin(Model model) {

        return "login";
    }

    @RequestMapping(value = "/sendMail")
    public String sendMail(HttpServletRequest request) {
        String str = request.getRealPath("/");
        System.out.println(" SaveDevicesDetailsThread string =  " + str);
        SingInOutSessions singInOutSessions = singInOutSessionsService.findById(57);
       // SendMailNewDevices sendMailNewDevices = new SendMailNewDevices(singInOutSessions, str);
        //sendMailNewDevices.sendMail();
        return "";
    }
}
