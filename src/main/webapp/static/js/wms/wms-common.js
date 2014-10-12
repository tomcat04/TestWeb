console.info("js start work!");
//function testAjax(){
//    console.info("testAjax");
//    $.ajax( {  
//        type : "post",  
//        url : document.URL+"/materials/ajax",  
//        dataType:"json",  
//        success : function(data) {
//            console.info("data.materials : " + data.materials);  
//            console.info(data.materials[1].materialDesc);
//        },
//        error:function(xhr,textStatus,errorThrown){
//            alert(errorThrown);
//        }
//    }); 
//}
Ext.onReady(function() {
    var pnNorth = Ext.create('Ext.Panel',{
        title: 'title test',
        autoWidth: true,
        heigth: 300,
        split: true,
        //frame: true,
        region: 'north',
        html: '这里放置页头内容'
    });
    var pnWest = Ext.create('Ext.Panel',{
        id:'pnWest',
        title: '菜单项',
        width: 300,
        heigth: 'auto',
        split: true, //显示分隔条
        region: 'west',
        collapsible: false, //收拢按钮
        html: '这里放置页头内容'

    });
    var pnCenter = Ext.create('Ext.TabPanel', {
        region: 'center',
        activeTab: 0,
        deferredRender: true,//是否在显示每个标签的时候再渲染标签中的内容.默认true     
        tabPosition: 'top',//表示TabPanel头显示的位置,只有两个值top和bottom.默认是top.
        enableTabScroll: true,//当Tab标签过多时,出现滚动条
        items: [
            {
                title: '收件箱',
                authHeight: true,
                closable: true, //是否可关闭
                html: '<div>divPanel</div>',
                listeners: {render:function(){//为每个Tab标签添加监听器.当标签渲染时触发     
                    console.info("tab1");
                }}
            },
            {
                title: 'Tab 3',     
                autoLoad:'/index.html',     
                closable: true,
                listeners: {render:function(){//为每个Tab标签添加监听器.当标签渲染时触发     
                    console.info("tab3");    
                }}
            },
            {
                title: 'Tab 2',     
                autoLoad:{url:document.URL+"/materials/ajax",script:true},
                closable: true,
                listeners: {render:function(){//为每个Tab标签添加监听器.当标签渲染时触发     
                    console.info("tab2");
                }}
            }
        ]
    });
    
    var store = Ext.create('Ext.data.TreeStore', {
        root: {
            expanded: true,
            children: [{
                    text: '应用程序管理',
                    expanded: false,
                    children: [{
                            text: '应用程序管理',
                            id: 'appManage',
                            leaf: true
                        }]
                }, {
                    text: '页面配置管理',
                    expanded: false,
                    children: [{
                            text: '页面配置管理',
                            id: 'configManage',
                            leaf: true
                        }, {
                            text: ' 页面按钮配置',
                            id: 'buttonManage',
                            leaf: true
                        }]
                }, {
                    text: '用户管理',
                    expanded: false,
                    children: [{
                            text: '用户管理',
                            id: 'userManage',
                            leaf: true
                        }, {
                            text: '权限管理',
                            id: 'rowManage',
                            leaf: true
                        }]
                }, {
                    text: '任务管理',
                    expanded: false,
                    children: [{
                            text: '任务管理',
                            id: 'taskMange',
                            leaf: true
                        }]
                }]
        }
    });
    var treePanelApp = Ext.create('Ext.tree.Panel', {
        id: 'tree-panel',
        title: '菜单',
        region: 'west',
        collapsible: false,
        split: true,
        heigth: 'auto',
        width: 280,
        rootVisible: false,
        store: store
    });
    Ext.create('Ext.Viewport', {
        layout: "border",
        items: [
            pnNorth,
//            pnWest,
            treePanelApp,
            pnCenter
        ]
    });
    
    var pnRow1=new Ext.Panel({  
        border:false,  
        layout:'column',  
        items:[  
            new Ext.Panel({  
                columnWidth:.5,  
                layout:'form',  
                border:false,  
                labelWidth:40,  
                labelAlign:'right',  
                items:[  
                    {  
                        xtype:'textfield',  
                        fieldLabel:'姓名',  
                        name:'uname',  
                        anchor:'95%'  
                    }  
                ]  
            }),  
            new Ext.Panel({  
                columnWidth:.3,  
                layout:'form',  
                border:false,  
                labelWidth:40,  
                labelAlign:'right',  
                items:[  
                    {  
                        xtype:'radio',  
                        fieldLabel:'性别',  
                        boxLabel:'男',  
                        name:'sex',  
                        inputValue:'男',  
                        checked:true,  
                        anchor:"95%"  
                    }  
                ]  
            }),  
            new Ext.Panel({  
                columnWidth:.2,  
                layout:'form',  
                border:false,  
                labelWidth:1,  
                items:[  
                    {  
                        xtype:'radio',  
                        boxLabel:'女',  
                        name:'sex',  
                        inputValue:'女',  
                        labelSeparator:'',  
                        anchor:"95%"  
                    }  
                ]  
            })  
        ]  
    });  
    var tb = new Ext.FormPanel({  
        title:"个人信息录入",  
        width:600,  
        bodyStyle:'padding:10px',  
        layout:"form",  
        items:[  
            pnRow1
        ]  
    });
});