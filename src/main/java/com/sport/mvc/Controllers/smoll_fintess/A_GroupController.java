package com.sport.mvc.Controllers.smoll_fintess;


import com.sport.mvc.models.CategoryGroup;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.CategoryGroupService;
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

    @Autowired
    @Qualifier("categoryGroupService")
    private CategoryGroupService categoryService;


//variable for taking the group id, when some group will by in use.
    private  Long idGroup;

    private Long idCategory;

    @RequestMapping(value = "/ShowGroupPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showForm(){

     //create list student and group for add data to the jsp page
        List<CategoryGroup> categoryGroupList = categoryService.getAll();
        List<Group> groupsList = groupService.getAll();
        List<Student> studentsList=studentService.getAll();
        //param for identifying locations is ->String chooseGroup

        String chooseGroup = groupService.getGroup(idGroup).getName();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList", studentsList);
        modelAndView.addObject("groupsList", groupsList);
       modelAndView.addObject("chooseNewGroup", chooseGroup );
        modelAndView.addObject("categoryList",categoryGroupList);

        if(idCategory!=null) {
            String chooseCategory = categoryService.getCategoryGroup(idCategory).getName();
            modelAndView.addObject("chooseNewCategory", chooseCategory );
        }

        //add to page model list of day in current month from method List<String> ListOfDayInMonth()
        modelAndView.addObject("listOfMonth", ListOfDayInMonth());
        modelAndView.setViewName("A_small_fitness_group");
        return modelAndView;

    }

    @RequestMapping( value = "/showFormForAddGroup", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView  FormForAddGroup() {
        // create model attribute to bind form data
        Group group = new Group();
        List<CategoryGroup> categoryGroupList = categoryService.getAll();
        List<String> stringList = new ArrayList<>();
        for(CategoryGroup category: categoryGroupList){
            stringList.add(category.getName());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categoryList" ,categoryGroupList);
        modelAndView.addObject("group", group);
        modelAndView.setViewName("A_small_fitness_add_group");
      //  return "A_small_fitness_add_group";
        return  modelAndView;
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group,@RequestParam("option") String categoryName) {
        //add group to DB
        boolean flag = false;
        CategoryGroup categoryGroup = new CategoryGroup();
        categoryGroup.setName(categoryName);
        for(CategoryGroup category: categoryService.getAll()) {
            if(category.getName().equals(categoryGroup.getName())) {
                group.setCategoryGroup(category);
                groupService.addGroup(group);
                break;
            }
        }
//        Set<Group> groups = new HashSet<>();
//        groups.add(group);
//        categoryGroup.setGroups(groups);
//        for(CategoryGroup category: categoryService.getAll()){
//            System.out.println(category.getName()+" its all");
//            if(category.getName().equals(categoryGroup.getName())){
//                System.out.println(category.getName()+" from db");
//                System.out.println(categoryGroup.getName()+" new cat");
//                CategoryGroup cat = categoryService.getCategoryGroup(category.getId());
//                cat.setGroups(groups);
//                categoryService.updateCategoryGroup(cat);
//
//                break;
//            }
//            flag=true;
//
//        }
//        System.out.println(flag+" flag");
//        if (flag==true) {
//            System.out.println("after");
          //  categoryService.addCategoryGroup(categoryGroup);
 //       }
//        System.out.println(group.getName()+"  "+ group.getCategoryGroup().getName());
        return "redirect:/group/showFormForAddGroup";
    }
    @RequestMapping("/showFormForAddCategory")
    public String showFormForAddCategory(Model theModel) {
        // create model attribute to bind form data
        CategoryGroup category = new CategoryGroup();
        theModel.addAttribute("category", category);
        return "A_small_fitness_add_category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") CategoryGroup category) {
        //add group to DB
        categoryService.addCategoryGroup(category);
        return "redirect:/group/showFormForAddCategory";
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
//        theStudent.setGroups();
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

    @RequestMapping("/takeIdCategory")
    public String TakeIdCategory(@RequestParam("categoryId") long theId ) {
        //take id group, where we now, and write it in to global variable->idGroup
        idCategory = theId;
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

