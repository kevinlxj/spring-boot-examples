package com.springboot.springbootmybatisplus.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 *
 * @author 林星锦
 */


public class MySqlCodeGenerator {

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/springboot-mybatis-plus";
    private static final String DB_DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/demo1?useUnicode=true&characterEncoding=utf8";
    private static final String DB_USERNAME = "demo1";
    private static final String DB_PASSWORD = "123456";
    private static final String PACKAGE_NAME = "com.springboot.springbootmybatisplus";
    /**
     * 生成时是否覆盖文件,默认false
     */
    private static final boolean IS_ETFILE_OVERRIDE = true;
    /**
     * 要生成的表名
     * private static String[] table_names= {"city","student","test"};
     */
    private static String[] table_names= {"t_user"};

    /**
     * 读取控制台输入的内容
     *
     * @param tip  控制台输入的内容
     * @return 返回处理后的内容
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

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<TableFill> tableFillList = new ArrayList<TableFill>();
        /*自定义需要填充的字段，如每张表都有一个创建时间、修改时间，而且这基本上就是通用的了，新增时，
        创建时间和修改时间同时修改，修改时，修改时间会修改，虽然像Mysql数据库有自动更新几只，但像ORACLE的数据库就没有了，
        使用公共字段填充功能，就可以实现，自动按场景更新了。如下是配置*/
        tableFillList.add(new TableFill("gmt_create", FieldFill.INSERT));
        tableFillList.add(new TableFill("gmt_modified", FieldFill.INSERT_UPDATE));
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置，定义项目路径、注释的作者等
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_PATH + "/src/main/java");
        gc.setAuthor("林星锦");
        // 是否覆盖文件,默认false
        gc.setFileOverride(IS_ETFILE_OVERRIDE);
        // 是否打开输出目录
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
        /// dsc.setSchemaName("public");
        dsc.setUsername(DB_USERNAME);
        dsc.setPassword(DB_PASSWORD);
        mpg.setDataSource(dsc);
        // 包名配置，通过该配置，指定生成代码的包路径
        PackageConfig pc = new PackageConfig();
        ///pc.setModuleName(scanner("模块名"));
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
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(scanner("表名"));
        ///strategy.setInclude(table_names);
        ///排除生成的表
        //strategy.setExclude(new String[]{"test"});
        // 自定义需要填充的字段
        strategy.setTableFillList(tableFillList);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}