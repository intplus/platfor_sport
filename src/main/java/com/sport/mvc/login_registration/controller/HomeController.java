package com.sport.mvc.login_registration.controller;

//@Controller
//public class HomeController {
//
//    private static final Logger log = LoggerFactory.getLogger(HomeController.class);
//
//    @Autowired
//    UserService userservice;
//
//    @Autowired
//    HttpSession response;
//
//    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
//    public String home(Locale locale, Model model) {
//
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            String username = ((UserDetails) principal).getUsername();
//            User user = userservice.getUserByUsername(username);
//            response.setAttribute("user", user);
//        }
//        log.info("Welcome home! ");
//        return "home";
//    }
//
//    @RequestMapping(value = "/hello")
//    public String hello(){
//        return "hello";
//    }
//
//}

