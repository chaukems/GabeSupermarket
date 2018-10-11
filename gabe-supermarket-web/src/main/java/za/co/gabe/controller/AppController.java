package za.co.gabe.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @Autowired
    Gson gson;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String appointmentPage(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "/";
        } else {
            return "welcome";
        }
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String reorderPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "/";
        } else {
            return "members";
        }
    }

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String loginPage() {
        return "/login";
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutPage() {
        return "/login";
    }

}
