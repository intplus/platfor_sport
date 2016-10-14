package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.models.User;
import com.sport.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/registerPerson/")
public class A_PersonsController {

/*    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;*/

    @Autowired
    UserService userService;
    @RequestMapping(value = "/general_registration_form")
    public String showForm(Model model){

        //   RegisterPerson theRegisterPerson= new RegisterPerson();

        //   model.addAttribute("registerPersonDate", theRegisterPerson);

        return "general_registration_formRegistry";

    }

    @RequestMapping(value = "/showFirstWorkPage", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView workPage(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getAll();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("A_small_fitness_first_work_Page");

        return modelAndView;
    }

    //add new user method
    //returns model of new user and enables form fields
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "A_small_fitness_add_user";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addNewUser(Model model, @ModelAttribute("newUser") User user) {
        System.out.print(user.getName());
        userService.addUser(user);
        return "redirect:/registerPerson/addUser";
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
}
