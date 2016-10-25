package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.GroupService;
import com.sport.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping(value = "/group/")
public class A_GroupController {

    @Autowired
    @Qualifier("groupService")
    private GroupService groupService;

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @RequestMapping(value = "/ShowGroupPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showForm(){

        A_PersonsController personsController;

        List<Group> groupsList = groupService.getAll();
        List<Student> studentsList=studentService.getAll();



        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("studentList", studentsList);
        modelAndView.addObject("groupsList", groupsList);

        modelAndView.setViewName("A_small_fitness_group");
        return modelAndView;

    }

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
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        return "A_add_to_group_Student";
    }

    @PostMapping("/saveStudentToGroup")
    public  String saveStudentToGroup(@ModelAttribute("student") Student theStudent, @ModelAttribute("groups") Group group){
        System.out.println("group id " +group.getId());

        System.out.println(" in method save");
        System.out.println(theStudent.getPhone()+"-----Phoneees");
        studentService.addStudent(theStudent);
        long id=0;

        List<Student> studentsList= studentService.getAll();

        for (Student s: studentsList){
            if(studentsList.size()==studentsList.size()){
                id=s.getId();
            }
        }
        System.out.println("Student id="+id);

      //  groupService.saveIdsToStudent_Group(id,id);
        return "redirect:/group/addStudentToGroupForm";

    }


}

