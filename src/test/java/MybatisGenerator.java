import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.cglib.beans.BeanMap.Generator;


public class MybatisGenerator {
	
	
	public static void main(String[] args)  {

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = null;
		try {
			config = cp.parseConfiguration(
                    Generator.class.getResourceAsStream("/generator/generatorConfig.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);


		MyBatisGenerator myBatisGenerator = null;
		try {
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
		try {
			myBatisGenerator.generate(new ProgressCallback() {

                @Override
                public void startTask(String taskName) {
                    System.out.println("开始生成:"+taskName);

                }

                @Override
                public void saveStarted(int totalTasks) {
                    System.out.println("savaStarted:"+totalTasks);

                }

                @Override
                public void introspectionStarted(int totalTasks) {
                    System.out.println("introspectionStarted:"+totalTasks);

                }

                @Override
                public void generationStarted(int totalTasks) {

                    //开始之后

                    System.out.println("generationStarted:"+totalTasks);

                }

                @Override

                public void done() {
                    System.out.println("生成完成");

                }

                @Override
                public void checkCancel() throws InterruptedException {
                    System.out.println("checkCancel");

                }
            });
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
