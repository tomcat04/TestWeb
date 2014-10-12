/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


Ext.define('App.controller.UserController', {
    extend: 'Ext.app.Controller',
    views:[
        'UserView'
    ],
    init: function() {
        console.log('UserController init.');
        this.control({'viewport > panel': {
                render: this.onPanelRendered
            }
        });
    },
    onPanelRendered:function(){
        console.log('UserController render');
    }
});