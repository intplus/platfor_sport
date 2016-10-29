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

import java.text.SimpleDateFormat;
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

     //create list student and group for add data to the jsp page
        List<Group> groupsList = groupService.getAll();
        List<Student> studentsList=studentService.getAll();
        //param for identifying locations is ->String chooseGroup
        int groupId = Integer.parseInt(String.valueOf(idGroup));
        String chooseGroup= groupsList.get(groupId-1).getName();



        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", studentsList);
        modelAndView.addObject("groupsList", groupsList);
        modelAndView.addObject("shooseNewGroup", chooseGroup );
        //add to page model list of day in current month
        modelAndView.addObject("listOfMonth", ListOfDayInMonth());
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
    public String saveGroup(@ModelAttribute("group") Group group) {
        //add group to DB
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
        //create new student for add form
        Student theStudent = new Student();
        //transfer student to "A_add_to_group_Student" form
        theModel.addAttribute("student", theStudent);
        return "A_add_to_group_Student";
    }



    @RequestMapping("saveStudentToGroup")
    public  String saveStudentToGroup(@ModelAttribute("student") Student theStudent){
        System.out.println("in method save st to group");
        //add new student to the DB
        studentService.addStudent(theStudent);
        // get back needed student from DB, with right id
        List<Student> studentList =studentService.getAll();
        for(int i=0;i<studentList.size(); i++) {
            //needed student it's the last student in DB
            theStudent = studentList.get(i);
        }
        // take group where we naw, and where we will write new student
        Group theGroup = groupService.getGroup(idGroup);

        //save this data
        groupService.saveIdsToStudent_Group(theStudent,theGroup);
        return "redirect:/group/addStudentToGroupForm";

    }

    @RequestMapping("/takeIdGroup")
    public String TakeIdGroup(@RequestParam("groupId") long theId ) {
        //take id group, where we now, and write it in to global variable->idGroup
        idGroup = theId;
        //return to showGroup page for fow all data on the  page
        return "redirect:/group/ShowGroupPage";
    }

    private List<String> ListOfDayInMonth() {
        Calendar calendar = Calendar.getInstance();
        int iYear = calendar.get(Calendar.YEAR);
        int iMonth = calendar.get(Calendar.MONTH);
        int iDay = 1;
// Create a calendar object and set year and month
        Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);
// Get the number of days in that month
        List<String> listDayOfMonth = new ArrayList<>();
        String curentDate = null;
        int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= daysInMonth; i++) {
            curentDate = i + "." + iMonth + "." + iYear;
            listDayOfMonth.add(curentDate);

        }
        return listDayOfMonth;
    }

}

