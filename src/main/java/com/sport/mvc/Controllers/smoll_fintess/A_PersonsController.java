package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.User;
import com.sport.mvc.services.impl.StudentServiceImpl;
import com.sport.mvc.socialAdvertisement.SendMailService;

import com.sport.mvc.models.Student;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/registerPerson/")
public class A_PersonsController {

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;




    @Autowired
    @Qualifier("phoneService")
    private PhoneService phoneService;

    @Autowired
    @Qualifier("mail")
    private SendMailService sendMailService;




    @RequestMapping(value = "/general_registration_form")
    public String showForm(Model model){

        //   RegisterPerson theRegisterPerson= new RegisterPerson();
        //   model.addAttribute("registerPersonDate", theRegisterPerson);
        return "general_registration_formRegistry";

    }

    @RequestMapping(value = "/showFirstWorkPage",method = {RequestMethod.GET, RequestMethod.POST})
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
        studentService.addStudent(theStudent);
        return "redirect:/registerPerson/showFormForAdd";
    }

    @RequestMapping("/delete")
    public String deleteListOfUsers(@RequestParam(value = "deletee", required = false) String deletee,
                                    @RequestParam(value = "send_email", required = false) String sendEmail, Model model,
                                    @RequestParam(value = "case", required = false) List <Long> ids,
                                    RedirectAttributes ra) {


        if(deletee!=null){
            if (ids!=null)

                for (int i =0; i < ids.size();i++) {
                    System.out.println("in method A_controller del " + ids );
                    studentService.deleteListOfStudents(ids.get(i));
                }
        }
        else if(sendEmail!=null){
            //redirect our ids to the send message page
            ra.addFlashAttribute("id", ids);
            return "redirect:/registerPerson/showMailForm";


        }

        return "redirect:/registerPerson/showFirstWorkPage";
    }

    @PostMapping("/saveStudentAfterUpdate")
    public String saveCustomerAfterUpdate(@ModelAttribute("student") Student theStudent) {
        studentService.updateStudent(theStudent);
        return "redirect:/registerPerson/showFirstWorkPage";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") long theId, Model theModel) {

        //   logger.info("showing form for update");
        System.out.println(theId);
        // get customer from database
        Student theStudent = studentService.getStudent(theId);
        // set customer as model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        return "A_small_fitness_update_student";
    }
    //create empty array list in order to fill it in the showMailForm method
    List<String> studenEmail = new ArrayList<String>();
    @PostMapping("/sendMail")
    public String sendMail(HttpServletRequest request){
        //get the topic and body of the message
        String body = request.getParameter("body");
        String topic = request.getParameter("topic");
        for (int i=0; i<studenEmail.size(); i++) {
            if (studenEmail.get(i)!=null || !studenEmail.get(i).equals(""));
            sendMailService.sendMailTo(studenEmail.get(i), topic, body);

        }
        return "redirect:/registerPerson/showFirstWorkPage";
//
    }


    @RequestMapping("/showMailForm")
    public String showMailForm(Model theModel, @ModelAttribute("id") List<Long> ids){
    //get our ids and get user name, and email
        //add received emails to the arrauList
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i<ids.size(); i++) {
            students.add(studentService.getStudent(ids.get(i)));
            String email = students.get(i).getEmail();
            studenEmail.add(email);
        }
        theModel.addAttribute("id", ids);
        theModel.addAttribute("students", students);
        return "A_send_mail_form";
        //
    }

 //   sorts students by age(after 16, befor 16 and select all student
    @RequestMapping("/sort")
    public ModelAndView sortMethod(Model model, @RequestParam("option") String option) {
        List<Student> students =new ArrayList<>();
        //new modelAndView for return to jsp listStudent with the selected parameters
        ModelAndView modelAndView = new ModelAndView();
        if (option.equals("ageAfterSixteen")) {

             students = studentService.getStudentAgeAfterSixteen();
        }
       else if (option.equals("ageBeforeSixteen")){
           students = studentService.getStudentAgeBeforSixteen();

        }

        else  if(option.equals("getUnknownStudent")){
            students =studentService.getStudentByOnlyUnknownStudent();
        }

        else if(option.equals("allStudent")){
            students = studentService.getAll();

        }

            modelAndView.addObject("students", students);
            modelAndView.setViewName("A_small_fitness_first_work_Page");
            return modelAndView;


    }


}
