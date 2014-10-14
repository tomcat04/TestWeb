/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.service;

import com.wms.ma.bean.MaterialSrcBean;

/**
 * 物料数据源管理接口
 * @author cgx1844568
 * @date 2014-10-25
 * @time 11:32:07
 *
 */
public interface MaterialSrcManageService {

    /**
     * 单个查询
     * @param materialCode 料号
     * @return 物料信息
     */
    public MaterialSrcBean querySingleMaterial(String materialCode);
}
