package web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
* @ClassName: PropertiesUtil
* @Description: 封装连接数据库的信息
* @author 李勇超
* @date 2018年12月27日下午7:26:56
*
*/
public class PropertiesUtil {

	public static String getValue(String key){
		Properties prop=new Properties();
		InputStream in=new PropertiesUtil().getClass().getResourceAsStream("/db.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
