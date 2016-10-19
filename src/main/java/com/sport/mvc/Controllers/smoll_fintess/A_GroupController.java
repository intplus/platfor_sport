package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
/*
@RequestMapping(value = "/showFirstWorkPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView workPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAll();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("A_small_fitness_first_work_Page");

        return modelAndView;
    }
 */
