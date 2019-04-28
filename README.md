# springboot-base

 - 本项目是基于springboot-2.1.3的后台快速开发框架，适用于试水型中小型业务项目的后台数据快速开发。
 

 - 集成了什么？
 
    - 1、数据库连接池Druid；
    
      https://github.com/alibaba/druid

      本项目启动后的Druid监控台地址：http://localhost:7777/druid/datasource.html 
       
          账号：admin  密码：123
  
    - 2、mybatis通用mapper，对于基础的单表增删查改不再需要手动写sql；
        
      就开发效率而言，使用通用mapper并合理使用resultType后并不比spring-data-jpa要慢~
       
      https://github.com/abel533/Mybatis-Spring
          
    - 3、mybatis分页插件，快速开发移动端分页查询接口、后台数据分页查询接口；
       
      https://github.com/pagehelper/Mybatis-PageHelper
            
    - 4、util工具包
       
      https://github.com/looly/hutool
          
            
       
 
 
  - 快速开发工具
  
      - 1、mybatis-generator，代码快速生成工具，可直接生成数据库表对应的orm实体、dao和xml文件，稍作修改即可直接使用；
      
          https://github.com/mybatis/generator
      
          下面这个也很好用~
      
          https://github.com/zouzg/mybatis-generator-gui
      
      - 2、maven，部署方式推荐使用jar包部署，maven打包命令：

        ```
            cd 项目文件夹

            mvn clean

            mvn install -Dts -Dtest
        
        ```
        
       - 3、lombok，正如lombok的宣传一样，给代码加点料~ 
       
            使用lombok可以减少很多冗余的代码，让代码更优雅，传送门：
            
            
            https://github.com/rzwitserloot/lombok
       
       
   - 提供了什么demo？
   
      - 为了更贴合项目开发进度，项目内已提供：
      
         1、适用于移动端上下拉刷新加载的分页接口demo；
         
         2、适用于后台数据表格分页查询接口的demo；
         
         3、新增编辑接口；
         
       - 后台数据开发的重点将转移到业务设计和表结构设计，开发将有更多时间去和产品经理打架了~   
          
