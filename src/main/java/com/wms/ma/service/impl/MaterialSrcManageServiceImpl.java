/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.service.impl;

import com.wms.ma.bean.MaterialSrcBean;
import com.wms.ma.service.MaterialSrcManageService;
import org.springframework.stereotype.Service;

/**
 *
 * @author cgx1844568
 * @date 2014-10-25
 * @time 11:35:46
 *
 */
@Service
public class MaterialSrcManageServiceImpl implements MaterialSrcManageService{

    @Override
    public MaterialSrcBean querySingleMaterial(String materialCode) {
        MaterialSrcBean msb = new MaterialSrcBean();
        msb.setMaterialCode("123444-00");
        msb.setMaterialDesc("hei,我是一个物料描述");
        return msb;
    }

}
