package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.models.Student;
import com.sport.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/registerPerson/")
public class A_PersonsController {

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;


    @RequestMapping(value = "/general_registration_form")
    public String showForm(Model model){

     //   RegisterPerson theRegisterPerson= new RegisterPerson();

     //   model.addAttribute("registerPersonDate", theRegisterPerson);

        return "general_registration_formRegistry";

    }

    @RequestMapping(value = "/showFirstWorkPage", method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView workPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAll();

        modelAndView.addObject("students", students);
        modelAndView.setViewName("A_small_fitness_first_work_Page");

        return modelAndView;
    }
}
