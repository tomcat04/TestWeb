/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

Ext.application({
    name:'App',
    appFolder:'static/app',
    controllers:['UserController'],
    launch:function(){
        Ext.create('Ext.container.Viewport',{
            layout:'border',
            items:['UserView']
        });
    }
});