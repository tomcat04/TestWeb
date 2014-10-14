/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.ma.bean;

/**
 *
 * @author cgx1844568
 * @date 2014-10-25
 * @time 11:33:39
 *
 */
public class MaterialSrcBean {

    /**
     * 物料号
     */
    private String materialCode;
    
    /**
     * 物料描述
     */
    private String materialDesc;
    
    /**
     * 物料来源
     */
    private String materialSrc;

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialDesc() {
        return materialDesc;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    public String getMaterialSrc() {
        return materialSrc;
    }

    public void setMaterialSrc(String materialSrc) {
        this.materialSrc = materialSrc;
    }
    
}
