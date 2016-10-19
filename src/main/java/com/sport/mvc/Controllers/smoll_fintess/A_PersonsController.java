package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.Phone;

import com.sport.mvc.models.Student;
import com.sport.mvc.models.User;
import com.sport.mvc.services.PhoneService;
import com.sport.mvc.services.StudentService;

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


    private long ids;

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;


    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;


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



    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        //format of date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "A_small_fitness_add_student";
    }


    @PostMapping("/saveStudent")
    public String saveCustomer(@ModelAttribute("student") Student theStudent) {

       // studentService.saveStudent(theStudent);

        return "redirect:/registerPerson/showFirstWorkPage";
    }


    @RequestMapping("/delete")
    public String deleteListOfUsers(Model model, @RequestParam(value = "case", required = false) Long id) {
        if (id!=null)
            System.out.println(id+"  id in delete method");
        studentService.deleteListOfStudents(id);


        return "redirect:/registerPerson/showFirstWorkPage";
    }




    @RequestMapping("/takeIndex")
    public String takeIndex(Model model, @RequestParam(value = "case", required = false) Long id) {
        if (id!=null)
            System.out.println(id+"  id in it index");

      ids=id;

        return "redirect:/registerPerson/showFirstWorkPage";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") long theId, Model theModel) {

     //   logger.info("showing form for update");
        System.out.println(theId+" the id in update form");
        // get customer from database
        Student theStudent = studentService.getStudent(theId);

        // set customer as model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        return "A_small_fitness_add_student";
    }

//    @PostMapping("/sendMail")
//    public String sendMail(@ModelAttribute("student") Student theStudent){
//
//        System.out.println("in mail");
//        System.out.println(theStudent.getName()+"-----"+theStudent.getSurname());
//
//        sendMailService.sendMailTo("artyrgetman@gmail.com",theStudent.getName(),theStudent.getSurname());
//
//        return "redirect:/registerPerson/showFirstWorkPage";
//
//    }



    @RequestMapping("/showMailForm")
    public String showMailForm(Model theModel){
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "A_send_Mail_form";
    }


}
