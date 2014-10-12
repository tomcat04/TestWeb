/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.opera.wms.basic.actions;

import com.wms.core.domain.Material;
import com.wms.core.service.MaterialService;
import java.util.ArrayList;
import java.util.List;
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
	private MaterialService materialService;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public ModelAndView Test(){
		List<String> list = new ArrayList<>();
		list.add("10003579-00");
		list.add("10017370-00");
		list.add("10017437-00");
		list.add("10027552-00");
		List<Material> materials = materialService.selectListFromList(list);
		System.out.println(materials.size());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("material/materialList");
		mav.addObject("materials", materials);
		return mav;
	}
}