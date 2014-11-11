/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.forward.controller;

import com.wms.ma.bean.MaterialSrcBean;
import com.wms.ma.service.MaterialSrcManageService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
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
        MaterialSrcBean msb = materialSrcManageService.querySingleMaterial("123");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("material/materialList");
        mav.addObject("s", msb.getMaterialDesc());
        return mav;
    }
}
