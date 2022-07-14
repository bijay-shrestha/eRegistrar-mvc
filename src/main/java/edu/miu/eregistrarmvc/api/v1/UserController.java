package edu.miu.eregistrarmvc.api.v1;

import edu.miu.eregistrarmvc.model.User;
import edu.miu.eregistrarmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
@Controller
@RequestMapping(value = {"secured/users","/eregistrar/secured/users/"})
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/about")
    public String displayAboutPage(){
        return "/public/about";
    }

    @GetMapping(value = "/list")
    public ModelAndView listStudents() {
        var users = userService.getAllStudents();
        var searchParam="";
        System.out.println("Users :: " + users);
        var modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);
        modelAndView.addObject("searchParam", searchParam);
        modelAndView.setViewName("secured/users/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String displayNewPublisherForm(Model model) {
        var newStudent = new User();
        model.addAttribute("student", newStudent);
        return "secured/users/new";
    }

    @PostMapping(value = {"/new"}) // PRG: Post-Redirect-Get
    public String addNewStudent(@Valid @ModelAttribute("student") User user,
                                BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", user);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/users/new";
        }
        userService.addNewStudent(user);
        return "redirect:/eregistrar/users/list";
    }

    @GetMapping(value = "/edit/{userId}")
    public String displayEditStudentForm(Model model, @PathVariable Long userId) throws IllegalArgumentException {
        var student = userService.getStudentById(userId);
        if (student != null) {
            model.addAttribute("student", student);
            return "/secured/users/edit";
        }
        return "redirect:/eregistrar/users/list";
    }

    @PostMapping(value = "/update")
    public String updateStudent(@Valid @ModelAttribute("student") User user,
                                BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("student", user);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "secured/user/edit";
        }
        userService.updateStudent(user);
        return "redirect:/eregistrar/users/list";

    }

    @GetMapping(value = "/delete/{userId}")
    public String deleteStudent(@PathVariable Long userId){
        userService.deleteStudentById(userId);
        return "redirect:/eregistrar/users/list";
    }

    @GetMapping(value = "/search")
    public String searchStudent(Model model, @RequestParam("search") String search) {
        var users = userService.searchStudent(search);
        model.addAttribute("students", users);
        return "secured/users/list";
    }

}
