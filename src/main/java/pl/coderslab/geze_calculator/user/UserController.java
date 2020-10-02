package pl.coderslab.geze_calculator.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute @Valid User user,
                          BindingResult bindResult) {
        if(bindResult.hasErrors())
            return "user/form";
        else {
            userService.addWithDefaultRole(user);
            return "user/registerSuccess";
        }
    }

    @GetMapping("/admin")
    public String registerAdmin(Model model) {
        model.addAttribute("user", new User());
        return "user/admin";
    }

    @PostMapping("/admin")
    public String addAdmin(@ModelAttribute @Valid User user,
                           BindingResult bindResult) {
        if(bindResult.hasErrors()) {
            return "user/admin";
        }
        userService.addAdmin(user);
        return "user/registerSuccess";

    }

    @GetMapping("/all")
    public String findAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "user/all";
    }


    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable long id,
                                   Model model) {
        Optional<User> user = userService.findUserById(id);
        if (!user.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono użytkownika");
            return "error";
        }
        model.addAttribute("user", user.get());
        return "user/form";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedUser(@Valid User user,
                                 BindingResult result,
                                 @PathVariable long id,
                                 Model model) {
        if (result.hasErrors()) {
            return "user/form";
        }
        if (user.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        userService.addWithDefaultRole(user);
        return "redirect:/user/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        Optional<User> user = userService.findUserById(id);
        if (!user.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono użytkownika");
            return "error";
        }
        model.addAttribute("user", user.get());
        return "user/confirm";
    }

    @PostMapping("/confirm/{id}")
    public String deleteUser(@Valid User user,
                             BindingResult result,
                             @PathVariable long id,
                             Model model) {
        if (result.hasErrors()) {
            return "user/confirm";
        }
        if (user.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        userService.deleteUser(user);
        return "redirect:/user/all";
    }



}
