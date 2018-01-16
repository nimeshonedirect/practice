package com.gradle.sample.controller;


import com.gradle.sample.model.Result;
import com.gradle.sample.model.User;
import com.gradle.sample.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String openLogin(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result handleLogin(@RequestParam String username, @RequestParam String password){
        //password=bCryptPasswordEncoder.encode(password);
        User user = loginService.validateUser(username,password);
        //System.out.println(username+" and "+password);
        Result result = new Result("","fail");
        try{
            if(user.getName()==null)
                return result;
            result.setName(user.getName());
            result.setResult("success");
            return result;
        }catch (NullPointerException e){
            return result;
        }
    }
//@RequestMapping(value = "/login",method = RequestMethod.POST)
//@ResponseBody
//    public Result handleLogin(@RequestBody User userbody,@RequestParam String username,@RequestParam String password){
//        System.out.println(userbody);
////        String username = userbody.getUsername();
////        String password= userbody.getPassword();
//        User user = loginService.validateUser(username,password);
//        Result result = new Result("","fail");
//        try{
//            if(user.getName()==null)
//                return result;
//            result.setName(user.getName());
//            result.setResult("success");
//            return result;
//        }catch (NullPointerException e){
//            return result;
//        }
//    }

}