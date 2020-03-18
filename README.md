# springboot-uncode-schedule

spring boot 集成uncode-schedule注意事项:
    1.需要添加依赖
        <dependency>
            <groupId>cn.uncode</groupId>
            <artifactId>uncode-schedule</artifactId>
            <version>1.1.0-SNAPSHOT</version>
        </dependency>
        如果是http交互还需要添加
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    
    2.spring boot启动类需要添加扫描注解
    @ComponentScan({"cn.uncode.schedule", "com.change"})
        cn.uncode.schedule:需要扫描uncode-schedule jar中的bean,必须加,不然在启动或创建任务时会出现各种bean =null
        com.change:spring boot 项目的目录结构,根据项目目录自己修改
    
    3.spring boot 建议使用.properties文件生成配置文件,因为在uncode-schedule jar的使用的application.properties文件配置,
        根据spring boot的配置文件yml和properties文件加载的优先级,properties>yml,如果你在spring boot 中使用yml配置文件,其中
        配有服务端口和uncode-schedule的配置,会被cucode-schedule中的配置先加载,yml中的相关配置将不会生效;如果启动后台日志提示端口 3000和连接zk的
        地址是10.1.43.101:2181,就说明遇到了我说的问题,
        解决办法:
            1.在本地spring boot 项目resource下新建properties配置
            2.如果想使用yml,在本地spring boot 项目resource下新建config/application.yml ,根据配置文件优先级来处理
            优先级
            config/application.yml>application.properties>application.yml
            
    spring boot 配置文件集合: 
            https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/html/common-application-properties.html
     
    相关学习文档:
        源码地址:https://gitee.com/uncode/uncode-schedule
        Uncode-Schedule框架源码分析: https://www.jianshu.com/p/4a7eb40f6852
