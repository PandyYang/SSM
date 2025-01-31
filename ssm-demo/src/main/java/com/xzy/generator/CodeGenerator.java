package com.xzy.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

//演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

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
 private static String output="E:\\自动生成代码";
 private static String mapperoutput="E:\\自动生成代码\\";
 public static void main(String[] args) {
     // 代码生成器
     AutoGenerator mpg = new AutoGenerator();
   
     // 全局配置
     GlobalConfig gc = new GlobalConfig();
    
     gc.setOutputDir(output);
     gc.setAuthor("admin");
     gc.setOpen(false);
     mpg.setGlobalConfig(gc);

     // 数据源配置
     DataSourceConfig dsc = new DataSourceConfig();
     dsc.setUrl("jdbc:mysql://localhost:3306/cakeshop?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT");
     // dsc.setSchemaName("public");
     dsc.setDriverName("com.mysql.jdbc.Driver");
     dsc.setUsername("root");
     dsc.setPassword("root");
     mpg.setDataSource(dsc);

     // 包配置
     PackageConfig pc = new PackageConfig();
     pc.setModuleName(scanner("模块名"));
     pc.setParent("com.xzy");
     mpg.setPackageInfo(pc);

     // 自定义配置
     InjectionConfig cfg = new InjectionConfig() {
         @Override
         public void initMap() {
             // to do nothing
         }
     };

     // 如果模板引擎是 freemarker
    // String templatePath = "/templates/mapper.xml.ftl";
     // 如果模板引擎是 velocity
     String templatePath = "/templates/mapper.xml.vm";

     // 自定义输出配置
     List<FileOutConfig> focList = new ArrayList<>();
     // 自定义配置会被优先输出
     focList.add(new FileOutConfig(templatePath) {
         @Override
         public String outputFile(TableInfo tableInfo) {
             // 自定义输出文件名
             return mapperoutput+ pc.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
         }
     });

     cfg.setFileOutConfigList(focList);
     mpg.setCfg(cfg);

     // 配置模板
     TemplateConfig templateConfig = new TemplateConfig();

     // 配置自定义输出模板
     // templateConfig.setEntity();
     // templateConfig.setService();
     // templateConfig.setController();
     
     templateConfig.setXml(null);
     mpg.setTemplate(templateConfig);

     // 策略配置
     StrategyConfig strategy = new StrategyConfig();
     strategy.setNaming(NamingStrategy.underline_to_camel);
     strategy.setColumnNaming(NamingStrategy.underline_to_camel);
     strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
     strategy.setEntityLombokModel(true);
     strategy.setRestControllerStyle(true);
     strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
    // strategy.setInclude(scanner("表名"));
     strategy.setSuperEntityColumns("id");
     strategy.setControllerMappingHyphenStyle(true);
     strategy.setTablePrefix(pc.getModuleName() + "_");
     mpg.setStrategy(strategy);
     mpg.setTemplateEngine(new FreemarkerTemplateEngine());
     mpg.execute();
 }

}