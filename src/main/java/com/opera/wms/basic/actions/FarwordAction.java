package com.opera.wms.basic.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("materials")
public class FarwordAction {

//	@Resource
//	private MaterialService materialService;
	
	@RequestMapping(value={"/","/list"},method=RequestMethod.GET)
	public ModelAndView Test(){
		List<String> list = new ArrayList<>();
		list.add("10003579-00");
		list.add("10017370-00");
		list.add("10017437-00");
		list.add("10027552-00");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("material/materialList");
                mav.addObject("s",list.size());
		return mav;
	}
	@RequestMapping(value = "t")
	public String Test2(){
		return "welcome";
	}
	@RequestMapping("all")
	public String Test3(){
		return "welcome";
	}
	@RequestMapping("insert")
	public String Test4(){
		return "welcome";
	}
	//ParamRequestΪurl?xxx=1111 GET��ʽ
	@RequestMapping(value= "/{materialId}",method=RequestMethod.GET)
	public String Test5(@PathVariable("materialId") String materialId,Model	model){
                return "material/materialDetail";
	}
	@ResponseBody	
	@RequestMapping(value={"ajax"},method=RequestMethod.DELETE)
	public JSONObject Test6(){
		List<String> list = new ArrayList<>();
		list.add("10003579-00");
		list.add("10017370-00");
		list.add("10017437-00");
		list.add("10027552-00");
		list.add("10024634-00");
		Map<String, Object> map = new HashMap<>();
                JSONObject res = JSONObject.fromObject(map);
		return res;
	}
	@RequestMapping(value= "/lov")
	public String Test7(){
		return "lov/lov";
	}
}
