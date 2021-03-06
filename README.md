# hibernate-practice
Hibernate框架学习实践

学习的第一个`Java`相关的`ORM`框架  
  
什么是Hibernate？  
  
>`Hibernate`是一个开源的`ORM`(即`Object-Relation Mapping`是对象-关系映射)框架，底层对`JDBC`进行了封装，可以使开发者更容易的运用`面向对象`思维操作数据库。  
  
Hibernate的配置文件：  
只需在`hibernate.cfg.xml`配置文件中指明需要扫描的包，`Hibernate`就会自动识别并解析`XXX.hbm.xml`关系映射文件，使`Bean类及其属性`与`数据表及其字段相对应`，并且发出`SQL`语句(可以在`hibernate.cfg.xml`配置文件中配置打印`SQL`语句)在数据库中自动创建对应的数据表(而`Mybatis`的`mbg`(`MyBatis Generator`)则相反，可以通过数据表及其字段自动创建用于生成对象的`Bean类`以及`接口`和对应的`Mapper文件`)。    
  
与Myabatis的对比：  
>相对于另一个十分受欢迎的`ORM`框架`Mybatis`，`Hibernate`拥有更高的自动化级别(可以说`Hibernate`是全自动`ORM`框架，`Mybatis`是半自动`ORM`框架，二者各有利弊，但是就面向对象而言，`Hibernate`是最好的`ORM`框架)。其自带的`HQL`(`Hibernate Query Language`是`Hibernate`自己的查询语句，它与`SQL`相似，但是`HQL`是`面向对象`的，它引用`类名`及`类的属性名`，而不是`表名`及`表的字段名`)可以让开发者不用编写`SQL`语句(但是也支持使用`SQL`语句)来对数据库进行操作。同时`Hibernate`在切换数据库上面也相较`Mybatis`更为简单，只需要在`hibernate.cfg.xml`配置文件中修改对应的方言(`hibernate.dialect`)即可。
  
`Hibernate`在使用中需要注意的问题：  
在利用`HQL`语句进行数据库操作的时候，里面的参数并不是数据表名与字段名，而是`POJO`的`类名`和`属性名`。  

优化`Hibernate`所鼓励的7大措施：  
>1.尽量使用`many-to-one`，避免使用单项`one-to-many`  
2.灵活使用单向`one-to-many`  
3.不用`one-to-one`，使用多`many-to-one`代替  
4.配置对象缓存，不使用集合缓存  
5.`one-to-many`使用Bag，`many-to-one`使用Set  
6.继承使用显示多态 `HQL:from object polymorphism="exlicit"` 避免查处所有对象  
7.消除大表，使用二级缓存  
  
JPA：  
`Hibernate`还可以使用`JPA`来减少`Dao`层的代码量，`JPA`中自带的方法满足了我们的大部分需求，同时注解形式也使我们可以不再去配置`xml`文件，使项目起来来更加的简洁。

