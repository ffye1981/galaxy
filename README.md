# galaxy a homework of ThoughtWorks
=============================================
程序及运行说明：
1、使用了maven工具进行包依赖管理
2、除去maven相关的插件和jdk1.8外，没有引入外部库
3、程序运行：
       先执行build\1-build.bat编译打包生成galaxy-1.0-SNAPSHOT.jar
       再执行build\2-start.bat启动galaxy-1.0-SNAPSHOT.jar
4、程序测试数据位于可执行程序galaxy-1.0-SNAPSHOT.jar/input.txt

==================================================
基本的设计思路：
根据题目要求可知，该题目要解决一下几个问题：
1、罗马字母的校验规则：RomanGroup 类中的 roman2Number方法。 主要包括：IXCM不能连续重复
超过3次，DLV不能重复以及不能当被减数等规则。
2、罗马字母和阿拉伯字母的对应关系： Roman 类的 findBySymbolfangfa
3、罗马字母和别名的映射关系：RomanParser类中处理
4、商品于单价的计算： PriceParser类中处理
5、关于问题的解析放在question包中，exception包为自定义异常，以及util包中字符串解析
和文件解析的工具类