# spring boot 测试

## 打包说明
1 右侧maven--项目--Lifecycle--package

2 点击运行

生成jar包在target目录下，且会生成xxx.jar和xxx.jar.original两个包。前者是可运行jar包，后者去掉.original后缀后可以当做依赖包。

## jar包运行说明

```shell
java -jar xxx.jar
```

