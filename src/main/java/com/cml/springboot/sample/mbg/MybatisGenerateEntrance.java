package com.cml.springboot.sample.mbg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MybatisGenerateEntrance {
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 读取配置文件generatorConfig.xml
		File configFile = new File("src/main/resources/mbg/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);

		Configuration config = cp.parseConfiguration(configFile);

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);

		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		for (String s : warnings) {
			System.out.println(s);
		}
	}
}
