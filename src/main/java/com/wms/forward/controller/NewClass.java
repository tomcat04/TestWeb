/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.forward.controller;

//import com.wms.core.domain.Material;
//import com.wms.core.service.MaterialService;
import com.wms.ma.bean.MaterialSrcBean;
import com.wms.ma.service.MaterialSrcManageService;
import com.wms.util.exception.CustomException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author chengangxiong
 */
@Controller
@RequestMapping("")
public class NewClass {

    @Resource
    private MaterialSrcManageService materialSrcManageService;

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public ModelAndView Test() {
        List<String> list = new ArrayList<>();
        list.add("10003579-00");
        list.add("10017370-00");
        list.add("10017437-00");
        list.add("10027552-00");
        MaterialSrcBean msb = materialSrcManageService.querySingleMaterial("123");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("material/materialList");
        mav.addObject("s", msb.getMaterialDesc());
        return mav;
    }
    
    @RequestMapping(value = {"/material/{materialCode}"}, method = RequestMethod.GET)
    public ModelAndView Material(@PathVariable String materialCode) {
        MaterialSrcBean msb = null;
        try {
            msb = materialSrcManageService.getMaterial(materialCode);
        } catch (CustomException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("material/materialList");
        if(msb != null)//异步之后返回值为null
            mav.addObject("s", msb.getMaterialDesc());
        return mav;
    }
    
    @RequestMapping(value = {"/m/{materialCode}"}, method = RequestMethod.GET)
    public String Material2(@PathVariable String materialCode) {
//        return "redirect:/material/" + materialCode;//地址发生变化--重定向
        return "forward:/material/" + materialCode;//地址无变化--跳转
    }
}
