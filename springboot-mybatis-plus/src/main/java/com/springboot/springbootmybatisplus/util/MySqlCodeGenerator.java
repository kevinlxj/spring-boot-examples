package com.springboot.springbootmybatisplus.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class MySqlCodeGenerator {


    public static final String PROJECT_PATH = System.getProperty("user.dir") + "/springboot-mybatis-plus";
    public static final String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/demo1?useUnicode=true&useSSL=false&characterEncoding=utf8";
    public static final String DB_USERNAME = "demo1";
    public static final String DB_PASSWORD = "root";
    public static final String PACKAGE_NAME = "123456";
    //生成时是否覆盖文件,默认false
    public static final boolean IS_ETFILE_OVERRIDE = true;
    //要生成的表名
    private static String[] table_names= {"city","student","test"};
    //table前缀
    private static String table_prefix="t_";



    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置，定义项目路径、注释的作者等
        GlobalConfig gc = new GlobalConfig();
        // 获取当前项目路径
        //String projectPath = System.getProperty("user.dir");
        System.out.println(PROJECT_PATH);
        gc.setOutputDir(PROJECT_PATH + "/src/main/java");
        gc.setAuthor("lxj");
        // 是否覆盖文件,默认false
        gc.setFileOverride(IS_ETFILE_OVERRIDE);
        // 是否打开输出目录s
        gc.setOpen(false);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置，通过该配置，指定需要生成代码的具体数据库
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(DB_DRIVER_NAME);
        dsc.setUrl(DB_URL);
        // dsc.setSchemaName("public");
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(DB_PASSWORD);
        mpg.setDataSource(dsc);

        // 包名配置，通过该配置，指定生成代码的包路径
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent(PACKAGE_NAME);
        mpg.setPackageInfo(pc);

        // 注入配置，通过该配置，可注入自定义参数等操作以实现个性化操作
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 定义xml文件输出路径和格式
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
//                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                if (pc.getModuleName() == null) {
                    return PROJECT_PATH + "/src/main/resources/mapper/"
                            + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                } else {
                    return PROJECT_PATH + "/src/main/resources/mapper/" + pc.getModuleName()
                            + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置, 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表。从数据库表到文件的命名策略
        StrategyConfig strategy = new StrategyConfig();
        //【实体】是否为lombok模型
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        //表名生成策略, 下划线变为驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //表列明名生成策略, 不做任何改变, 原样输出
        strategy.setColumnNaming(NamingStrategy.nochange);
        // 需要生成的表
//        strategy.setInclude(scanner("表名"));
        strategy.setInclude(table_names);
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 排除生成的表
        //strategy.setExclude(new String[]{"test"});
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.tout.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类 默认BaseMapper
        //strategy.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper");
        //strategy.setSuperEntityColumns("id");
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        //strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}