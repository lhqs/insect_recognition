package cn.lhqs.common;

import java.io.*;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-25 10:04
 * description : 七牛上传工具类
 * version : 1.0
 */
public class PropertiesUtil {

	private static Map<String,Properties> propMap = new HashMap<String,Properties>();

	/*设置默认配置文件为config.properties*/
	public static final String DEFAULT_PROPERTIES_FILE="config.properties";

	/**
	 * 根据file及key获取属性值
	 * @param file
	 * @param key
	 * @return
	 */
	public static Object getProperty(String file,String key){
		Properties prop = getProperties(file);
		if(prop != null && prop.get(key) != null){
			return prop.get(key);
		}
		return null;
	}

	/**
	 * getProperties
	 * @param file
	 * @return
	 */
    public static Properties getProperties(String file){
    	try {
    		if(propMap.get(file) == null){
    			Properties prop = new Properties();
    			prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(file));
    			propMap.put(file,prop);
    			return prop;
    		}else{
    			return propMap.get(file);
    		}
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return null;
    }

	/**
	 * 更新配置
	 * @param prop
	 * @param filePath
	 */
	public static void updateProperties(Properties prop,String filePath){

    	FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
        	URI fileUri = PropertiesUtil.class.getClassLoader().getResource(filePath).toURI();
        	File file = new File(fileUri);

        	Properties tmpProp = new Properties();
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            tmpProp.load(bis);

            FileOutputStream fos = new FileOutputStream(file);
            for(Object key : prop.keySet()){
            	tmpProp.setProperty(String.valueOf(key),String.valueOf(prop.get(key)));
            }
            tmpProp.store(fos, null);
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 从默认配置文件中获取config.properties
     * @return
     */
    public static Properties getDefaultProperties(){
    	return getProperties(DEFAULT_PROPERTIES_FILE);
    }

    /**
     * 从默认配置文件中获取配置项
     * @param key
     * @return
     */
    public static String getProperty(String key){
    	Properties prop = getDefaultProperties();
		if(prop != null && prop.get(key) != null){
			return prop.getProperty(key);
		}
		return null;
    }
    
}
