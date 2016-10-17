package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.models.Student;
import com.sport.mvc.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/group/")
public class A_GroupController {

    @Autowired
    @Qualifier("groupService")
    private GroupService groupService;

    @RequestMapping(value = "/ShowGroupPage")
    public String showForm(Model model){

        //   RegisterGroup
        return "A_small_fitness_group";

    }
}
