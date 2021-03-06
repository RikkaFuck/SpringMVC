package com.lu.springboot.controller;

import com.lu.springboot.entity.User;
import com.lu.threadpool.spring.annotation.TimeCounter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * <pre>
 * <b>描述信息</b>
 * <b>Description:</b>
 *
 * <b>Author:</b> Luyongjia
 * <b>Date:</b> 2017年03月08日  11:15
 * <b>Copyright:</b> Copyright ©2016 tempus.cn. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                             Author                Detail
 *   ----------------------------------------------------------------------
 *   0.1   2017年03月08日  11:15   Luyongjia
 *         new file.
 * </pre>
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @Value(value = "Hello World")
    private String message;

    @TimeCounter
    @RequestMapping("{view_name}")
    public ModelAndView modelAndView(@PathVariable("view_name") String view_name, ModelAndView modelAndView) {
        modelAndView.setViewName(view_name);
        return modelAndView;
    }

    @TimeCounter
    @RequestMapping("auto-insert")
    public ResponseEntity AutoInsert(User user) {
        return ResponseEntity.ok(user);
    }

    @TimeCounter
    @RequestMapping("accept-message")
    public ResponseEntity acceptMessage(@RequestHeader("accept") String accept, @RequestHeader("user-agent") String userAgent) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("accept", accept);
        hashMap.put("user-agent", userAgent);
        return ResponseEntity.ok(hashMap);
    }

    @TimeCounter
    @RequestMapping("accept-array")
    public ResponseEntity acceptArray(@RequestParam("ids[]") List<String> ids, @RequestParam("names[]") List<String> names) {
        return ResponseEntity.ok(Arrays.asList(ids, names));
    }
}
