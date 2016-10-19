package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/group/")
public class A_GroupController {

    @Autowired
    @Qualifier("groupService")
    private GroupService groupService;

    @RequestMapping(value = "/ShowGroupPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView();
        List<Group> groups = groupService.getAll();
        modelAndView.addObject("groups", groups);
        modelAndView.setViewName("A_small_fitness_group");
        return modelAndView;

    }

    @GetMapping("/showFormForAddGroup")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Group group = new Group();
        theModel.addAttribute("group", group);
        return "A_small_fitness_add_group";
    }

    @PostMapping("/saveGroup")
    public String saveCustomer(@ModelAttribute("group") Group group) {
        groupService.addGroup(group);
        return "redirect:/group/showFormForAddGroup";
    }
}

