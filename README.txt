Project description
-------------------


文件介绍
-------------------
bin目录下是运行脚本
src目录下是源文件
doc目录下是文档

Run Requirements
------------
  * Java >= 1.6 (OpenJDK and Sun have been tested)
  * Google App Engine for Java(optional if you want to run on it)

  
Getting started
---------------
Windows下运行本地版本
  * 打开bin文件夹,运行install.bat安装。期间会自动下载库文件，约20mb
  * 打开bin文件夹,运行start.bat运行。运行时注意要保证8080端口可用
  * 打开浏览器,建议非IE内核浏览器,输入http://localhost:8080可以运行
  * 具体使用方式可以参考界面上的"关于"按钮
  * 注意事项
      * 由于要获取网络信息且运算复杂，运行会比较慢，请您耐心等待。
	  * 目前还不甚完善，最好运行"关于"页面中提供的示例
------
Linux下运行本地版本
  * 打开bin文件夹,运行install.sh安装。期间会自动下载库文件，约20mb
  * 打开bin文件夹,运行start.sh运行。运行时注意要保证8080端口可用
  * 打开浏览器,建议非IE内核浏览器,输入http://localhost:8080可以运行
  * 具体使用方式可以参考界面上的"关于"按钮
  * 注意事项
      * 由于要获取网络信息且运算复杂，运行会比较慢，请您耐心等待。
	  * 目前还不甚完善，最好运行"关于"页面中提供的示例
------
运行Google App Engine版本
  * Google App Engine是Google提供的云计算设施，可以通过输入http://weaving-gae.appspot.com来运行
  * 注意事项
      * 由于Google App Engine在国外，有部分信息被屏蔽。您可以运行bin目录下的fuckGFW.bat来翻墙。需要将浏览器代理设置为localhost:7070
	  * 目前还不甚完善，最好运行"关于"页面中提供的示例
	  
	  
	  
	  
Develop Requirement
--------------
  * Java >= 1.6 (OpenJDK and Sun have been tested)
  * Maven >= 2.0
  * Google App Engine for Java(optional if you want to develop gae) 
  
  
  
  
部署
---------------
  * Google App Engine
     运行make deploy-gae
  * 本地版本
     下载http://weaving.googlecode.com/files/weaving-local.war
	 直接部署在tomcat上
 
 
 
 
卸载
----------------
Weaving是绿色的，但是会在本地保留下数据库文件。你只要删除{userhome}/.jsa4j目录就可以了。
当然也可以运行bin/uninstall.bat