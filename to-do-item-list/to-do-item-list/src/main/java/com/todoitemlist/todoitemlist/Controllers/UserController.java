package com.todoitemlist.todoitemlist.Controllers;


import com.todoitemlist.todoitemlist.Entities.TodoEntity;
import com.todoitemlist.todoitemlist.Entities.UserEntity;
import com.todoitemlist.todoitemlist.Models.LoginCredentials;
import com.todoitemlist.todoitemlist.Models.UserStaticClass;
import com.todoitemlist.todoitemlist.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService _userService;

    public UserController(UserService userService) {
        this._userService = userService;
    }


    @PostMapping("/signup")
    public String saveUser(@RequestBody UserEntity user) {
        String msg="";
        try{
            user.setDateCreated(Instant.now());
            user.setDateModified(Instant.now());
            _userService.saveUser(user);
            UserStaticClass.setUserId(user.getId());
            msg = user.getId()>0?"user created with Id "+ user.getId() +".":"user not created.";
        }catch(Exception e){
            msg=e.getMessage();
        }
        return msg;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> Signin(@RequestBody LoginCredentials user) {
        String msg="";
        List<UserEntity> u = _userService.FindByEmail(user.getEmail());
        UserEntity dbUser = u.get(0);

        if(dbUser.getEmail().equals(user.getEmail()) && dbUser.getPassword().equals(user.getPassword())){
            msg = "successfully logged in. UserId: "+dbUser.getId()+".";
            UserStaticClass.setUserId(dbUser.getId());
        }else{
//            msg = "Invalid login credentials";
            msg =user.getEmail()+ " "+user.getPassword() +" "+dbUser.getEmail()+ " "+dbUser.getPassword();
        }
        return ok(msg);
    }
//    @PutMapping("/changePassword")
//    public Map<String, Object> ChangePassword(@RequestBody UserEntity user) {
//        Map<String, Object> rtn= new LinkedHashMap<>();
//        long Id = UserStaticClass.getUserId();
//        if(Id > 0){
//            user.setDateCreated(Instant.now());
//            _userService.UpdateUserPassword(user.getEmail(),user.getDateModified(),user.getPassword());
//            rtn.put("response", "updated successfully.");
//        }else{
//            rtn.put("response", "You are not logged in.");
//        }
//        return rtn;
//    }
}
