package com.uqam.inf5190.natation.web;

import com.uqam.inf5190.natation.dao.CoursRepository;
import com.uqam.inf5190.natation.dao.UserRepository;
import com.uqam.inf5190.natation.entities.Cours;
import com.uqam.inf5190.natation.entities.User;
import com.uqam.inf5190.natation.entities.enums.Role;
import com.uqam.inf5190.natation.service.SessionService;
import com.uqam.inf5190.natation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController

public class UserController {
 /*
    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/account", method = RequestMethod.GET)
    public String userAccount(Model model, User u){

        String pageTitle = "Compte";
        model.addAttribute("pageTitle", pageTitle);
        return "user/userAccount";
    }

    @RequestMapping(value="/history", method = RequestMethod.GET)
    public String userHistory(Model model, @RequestParam(name="id", defaultValue="") String id){
        int userId = Integer.parseInt(id);
        List<Cours> listOfCoursDone = coursRepository.findByUserIdAndStatus(userId, "FAIT");
        List<Cours> listOfCoursCurrent = coursRepository.findByUserIdAndStatus(userId, "ACTIF");
        int nbrOfCoursDone = listOfCoursDone.size();
        int nbrOfCoursActif = listOfCoursCurrent.size();
        model.addAttribute("listOfCoursFait", listOfCoursDone);
        model.addAttribute("listOfCoursCurrent", listOfCoursCurrent);
        model.addAttribute("nbrOfCoursFait", nbrOfCoursDone);
        model.addAttribute("nbrOfCoursCurrent", nbrOfCoursActif);
        return "user/userHistory";
    }
  */
 @Autowired
 private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }
}
