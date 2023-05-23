package com.igchesno.CrudSpringBoot.controller;

import com.igchesno.CrudSpringBoot.model.User;
import com.igchesno.CrudSpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/showUsersAll") //связываем url страници с методом контроллера
    public String showUsers(Model model){
        //добавляем в модель атрибут list содержащий всех работников List<User>
        model.addAttribute("list", userService.getAllUsers( ));
        //определяем возвращаемую страницу
        return "users_list";
    }

    @GetMapping (value = "/addNewUser") //связываем url страници с методом контроллера
    public String showAddUsers(Model model){
        //добавляем в модель атрибут user содержащий объект User
        model.addAttribute("user", new User());
        //определяем возвращаемую страницу
        return "users_add";
    }

    @GetMapping (value = "/{id}/editUser") //связываем url страници с методом контроллера
    public String showEditUsers(Model model,  @PathVariable(value = "id", required = true) long id){
        User user = userService.readUser(id);
        //добавляем в модель атрибут user содержащий объект User
        model.addAttribute("user",user);
        //определяем возвращаемую страницу
        return "users_add";
    }

    @GetMapping (value = "/saveUser") //связываем url страници с методом контроллера
    public String saveUsers(@ModelAttribute("user") User user){
        userService.createOrUpdateUser(user);
        //определяем возвращаемую страницу
        return "redirect:/showUsersAll";
    }

    @GetMapping ("/deleteUser") //связываем url страници с методом контроллера
    public String deleteUser(@RequestParam(value = "id") long id){
        userService.deleteUser(id);
        //определяем возвращаемую страницу
        return "redirect:/showUsersAll";
    }
}