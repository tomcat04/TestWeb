/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.forward.controller;

import java.util.Date;
import java.util.concurrent.Callable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 *
 * @author cgx1844568
 * @date 2014-11-13
 * @time 9:05:55
 *
 */
@Controller
@RequestMapping("/async")
public class CallableController {
    @RequestMapping("/response-body")
    public @ResponseBody Callable<String> callable() {
        System.out.println("线程名称1："+Thread.currentThread().getName());
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("线程名称2："+Thread.currentThread().getName());
                Thread.sleep(2000);
                return "Callable result . current time :" + new Date().getTime();
            }
        };
    }
  
    @RequestMapping("/view")
    public Callable<String> callableWithView(final Model model) {
        model.addAttribute("s", "apple1111");
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
//                Thread.sleep(2000);
                model.addAttribute("foo", "bar");
                model.addAttribute("s", "apple");
                return "material/materialList";
            }
        };
    }
  
    @RequestMapping("/exception")
    public @ResponseBody Callable<String> callableWithException(
            final @RequestParam(required=false, defaultValue="true") boolean handled) {
  
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                if (handled) {
                    // see handleException method further below
                    throw new IllegalStateException("Callable error");
                }
                else {
                    throw new IllegalArgumentException("Callable error");
                }
            }
        };
    }
  
    @RequestMapping("/custom-timeout-handling")
    public @ResponseBody WebAsyncTask<String> callableWithCustomTimeoutHandling() {
  
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Callable result";
            }
        };
  
        return new WebAsyncTask<>(1000, callable);
    }
  
    @ExceptionHandler
    @ResponseBody
    public String handleException(IllegalStateException ex) {
        return "Handled exception: " + ex.getMessage();
    }
  
}