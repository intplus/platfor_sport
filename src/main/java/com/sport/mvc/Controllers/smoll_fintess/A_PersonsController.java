package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.models.Student;
import com.sport.mvc.models.User;
import com.sport.mvc.services.StudentService;
import com.sport.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    //add new user method
    //returns model of new user and enables form fields
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(Model model) {
        Student newStudent = new Student();
        model.addAttribute("newStudent", newStudent);
        return "A_small_fitness_add_student";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addNewStudent(Model model, @ModelAttribute("newStudent") Student student) {
        System.out.print(student.getName());
        studentService.addStudent(student);
        return "redirect:/registerPerson/addStudent";
    }

    /*works with date format which receives from the form*/
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        //format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

    @RequestMapping("/delete")
    public String deleteListOfUsers(Model model, @RequestParam(value = "case", required = false) Long id) {
        if (id!=null)
            studentService.deleteListOfStudents(id);
        return "redirect:/registerPerson/showFirstWorkPage";
    }
}
