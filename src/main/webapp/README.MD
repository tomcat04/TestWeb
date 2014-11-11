web依赖service,service依赖orm
web,service,orm 都依赖 core(接口)

service包含内部的aop,给外部调用的ws,调用外部的ws

工具类包含普通工具类&测试工具类.异常工具类 etc.

多线程,缓存,JS