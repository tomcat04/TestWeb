/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.wms.util.test;

import java.io.FileNotFoundException;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**
 * junit集成log4j测试
 * @author chengangxiong
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner{

    static {  
        try {  
            Log4jConfigurer.initLogging("classpath:log4j.properties");  
        } catch (FileNotFoundException ex) {  
            System.err.println("Cannot Initialize log4j");  
        }  
    }  
    
    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
    
}
