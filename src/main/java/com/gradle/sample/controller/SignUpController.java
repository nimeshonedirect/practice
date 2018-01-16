package com.gradle.sample.controller;


import com.gradle.sample.model.Result;
import com.gradle.sample.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @ResponseBody
    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String openLogin(){
        return "signUp";
    }
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    @ResponseBody
    public Result handleLogin(@RequestParam String username, @RequestParam String password, @RequestParam String name){
        password = bCryptPasswordEncoder.encode(password);
        int res = signUpService.insert(name,username,password);
        Result result = new Result("","fail");
        try{
            if(res==0)
                return result;
            result.setName(username);
            result.setResult("success");
            return result;
        }catch (NullPointerException e){
            return result;
        }
    }

}
