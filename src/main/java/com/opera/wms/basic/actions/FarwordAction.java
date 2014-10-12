package com.opera.wms.basic.actions;

import com.wms.core.domain.Material;
import com.wms.core.service.MaterialService;
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
	@RequestMapping(value = "t")
	public String Test2(){
		List<Material> materials = materialService.selectMaterials();
		System.out.println(materials.size());
		return "welcome";
	}
	@RequestMapping("all")
	public String Test3(){
		Material material= materialService.selectAll();
		System.out.println("------------- " + material.getMaterialDesc());
		return "welcome";
	}
	@RequestMapping("insert")
	public String Test4(){
		Material material= new Material();
		material.setMaterialDesc("1111111");
		material.setMaterialId("22222");
		materialService.insert(material);
		return "welcome";
	}
	//ParamRequestΪurl?xxx=1111 GET��ʽ
	@RequestMapping(value= "/{materialId}",method=RequestMethod.GET)
	public String Test5(@PathVariable("materialId") String materialId,Model	model){
		Material material = materialService.selectOne(materialId);
                if(material == null){
                    return "error/404";
                }else{   
                    model.addAttribute("material", material);
                    return "material/materialDetail";
                }
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
		List<Material> materials = materialService.selectListFromList(list);
		Map<String, Object> map = new HashMap<>();
		map.put("count", materials.size());
		map.put("materials", materials);
                JSONObject res = JSONObject.fromObject(map);
		return res;
	}
	@RequestMapping(value= "/lov")
	public String Test7(){
		return "lov/lov";
	}
}
