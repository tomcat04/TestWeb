/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.mapper;

import com.wms.ma.bean.MaterialSrcBean;
import java.util.List;

/**
 *
 * @author cgx1844568
 * @date 2014-10-15
 * @time 14:17:50
 *
 */
public interface MaterialSrcMapper {

    public List<MaterialSrcBean> selectAll();
}
