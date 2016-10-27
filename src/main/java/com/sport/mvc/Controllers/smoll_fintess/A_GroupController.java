package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.GroupService;
import com.sport.mvc.services.StudentService;
import org.hibernate.annotations.SourceType;
import org.hibernate.dialect.Sybase11Dialect;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/group/")
public class A_GroupController {

    @Autowired
    @Qualifier("groupService")
    private GroupService groupService;

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

//variable for taking the group id, when some group will by in use.
    private  Long idGroup;

    @RequestMapping(value = "/ShowGroupPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showForm(){

      // String theId = request.getParameter("idd");




        List<Group> groupsList = groupService.getAll();
        List<Student> studentsList=studentService.getAll();



        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("studentList", studentsList);
        modelAndView.addObject("groupsList", groupsList);

        modelAndView.setViewName("A_small_fitness_group");
        return modelAndView;

    }


//    @RequestMapping("/selectGroup")
//    public String Select(@RequestParam("option") String option){
//
//
//        List<Student> students =new ArrayList<>();
//        //new modelAndView for return to jsp listStudent with the selected parameters
//        ModelAndView modelAndView = new ModelAndView();
//        if (option.equals("ageAfterSixteen")) {
//
//            students = studentService.getStudentAgeAfterSixteen();
//        }
//
//        List<Group> groupsList = groupService.getAll();
//        List<Student> studentsList=studentService.getAll();
//
//
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.addObject("studentList", studentsList);
//        modelAndView.addObject("groupsList", groupsList);
//
//        modelAndView.setViewName("A_small_fitness_group");
//        return modelAndView;
//
//    }

    @RequestMapping("/showFormForAddGroup")
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





    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("groupId") long theId, Model theModel) {
        // get customer from database
        Group group = groupService.getGroup(theId);
        // set customer as model attribute to pre-populate the form
        theModel.addAttribute("group", group);
        return "A_small_fitness_add_group";
    }

    @RequestMapping("/deleteGroup")
    public  void deleteGrout(){
      //  groupService.deleteListOfGroup();
    }

    @RequestMapping("/addStudentToGroupForm")
    public  String addStudentToGroup(Model theModel){
        System.out.println("in method shou ato student to group");
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "A_add_to_group_Student";
    }


   // @PostMapping("/saveStudentToGroup")
    @RequestMapping("saveStudentToGroup")
    public  String saveStudentToGroup(@ModelAttribute("student") Student theStudent){
        System.out.println("in method save st to group");

        studentService.addStudent(theStudent);
        List<Student> studentList =studentService.getAll();
        for(int i=0;i<studentList.size(); i++) {
            theStudent = studentList.get(i);
        }
        Group theGroup = groupService.getGroup(idGroup);



        groupService.saveIdsToStudent_Group(theStudent,theGroup);
        return "redirect:/group/addStudentToGroupForm";

    }



    @RequestMapping("/takeIdGroup")
    public String TakeIdGroup(@RequestParam("groupId") long theId ) {
        idGroup = theId;
        System.out.println("take group id iy oo "+theId);
        return "redirect:/group/ShowGroupPage";
    }


}

