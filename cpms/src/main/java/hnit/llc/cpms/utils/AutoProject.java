package hnit.llc.cpms.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * 自动生成bean dao service mapper
 */
public class AutoProject {
    @Test
    public void AutoEnvironmental(){
        //全局配置
        GlobalConfig gg = new GlobalConfig();
        gg.setActiveRecord(true)
                .setAuthor("llc")
                .setOutputDir("D:\\Study\\javaSrc\\cpms\\src\\main\\java")
                .setFileOverride(false)
                .setIdType(IdType.UUID)
                .setServiceName("%sService")
                .setBaseResultMap(false)
                .setBaseColumnList(false)
                .setSwagger2(true);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/cpms");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);

        //策略设置
        StrategyConfig sc = new StrategyConfig();
        sc.setCapitalMode(true).setNaming(NamingStrategy.underline_to_camel);


        //包设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("hnit.llc.cpms")
                .setMapper("dao")
                .setService("service")
                .setController("web")
                .setEntity("bean")
                .setXml("mapper");

        //生成器配置
        AutoGenerator ag = new AutoGenerator();
        ag.setGlobalConfig(gg).setDataSource(dsc).setStrategy(sc).setPackageInfo(pc).execute();
    }
}
