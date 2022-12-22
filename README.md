# employ

#### 介绍
JSP_Servlet上机测试题，自做答案。内附有sql文件，有原题。

#### 软件架构
软件架构说明：
最外层根目录下有.sql数据库文件，和.word原题文件。
原题主要内容也将附在本文末。

#### 安装教程
需要软件
1.mysql8.0
2.idea


#### 使用说明

1. 通过idea打开项目，文件-项目结构-模块，导入pom.xml文件
2. 编辑运行配置，选tomcat-本地，选【部署】的时候注意选择war exploded而不是war，war不能热部署
![1](https://foruda.gitee.com/images/1671728219281432256/ae0711d6_10574276.png "屏幕截图")
![2](https://foruda.gitee.com/images/1671728238969339806/ad6098bc_10574276.png "屏幕截图")

#### 题目

1、创建两个数据库表: 部门Dept及员工Employee，表定义如下,同时创建各自ID的序列号。将创建的SQL语句保存在sql文件中(5分)

部门表Dept
字段说明	字段名	数据类型	数据长度	允许空	默认值	备注
部门ID	ID	Int	4	否		PK,自增长
部门名称	Name	VarChar	100	否		

员工表Employee
字段说明	字段名	数据类型	数据长度	允许空	默认值	备注
员工ID	ID	Int	4	否		PK,自增长
部门ID	DeptID	Int	4	否		
员工名称	Name	VarChar	100	否		
出生日期	birthday	date				


2、使用SQL语句为数据库表初始化如下数据，将SQL语句保存在sql文件中:（5分）
ID　name
1　D3
2　D2
3　D1
4　D4

为数据库表Employee初始化如下数据:
Name  DeptID   birthday
E4　   1        1991-1-12 
E6     2        1991-1-13 
E3     1        1991-1-14 
E2     2        1991-1-15 
E1     2        1991-1-16 
E5     4        1991-1-17 

3、正确创建工程，配置好运行环境，创建DBConnection类，联接数据库正确，有测试代码（5）    

4、设计并实现两个实体类Employee及Dept，用来表示员工与部门。（10分） 

5、创建类EmployeeDao，并使用JDBC实现如下方法，（15分）
	(1)实现getAllDepts方法，获得所有部门对象集合.(5分)
	(2)实现save方法，以保存一个员工对象（5分）
(3)实现getEmployeesByDeptID根据部门ID获得该部门下的所有员工(5分)
以上方法均应有测试代码。

	
6、完成增加员工信息页面，增加员工信息页面如下图所示（注意，所有请求都以Servlet发出）：(35分)

![输入图片说明](https://foruda.gitee.com/images/1671728313745039675/0791f54a_10574276.png "屏幕截图")

1)请求及Servlet配置正确       6分      
2） Servlet中的方法正确          6分
3）增加页面显示正确，部门数据为从数据库中获得的动态数据  6分
4) 客户端验证员工名称不为空,日期格式正确                 5分
4）能正确保存员工信息                                    7分
5）完成success.jsp页面，显示所成功增加的员工信息        5分
	
7、实现根据所选择的部门显示该部门的员工信息的功能：如图所示  （25分）
![输入图片说明](https://foruda.gitee.com/images/1671728327961500058/7bcda925_10574276.png "屏幕截图")
1) 请求及Servlet配置正确      5分      
2）Servlet方法正确             5分
3）页面显示正确                15分

完成合请打包提交给项目组长，再提交给室长，再上传到SVN，谢谢！

 
