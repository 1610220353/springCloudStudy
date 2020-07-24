package com.guohong.spring.utils;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author guohong
 * 操作yaml文件的工具类
 */
public class YmlUtils {


    private final static DumperOptions OPTIONS = new DumperOptions();

    private String path;

    private String profile;
    static {
        //将默认读取的方式设置为块状读取
        OPTIONS.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    }

    public YmlUtils(String path) {

        this.path = path;

        Properties props = System.getProperties();
        this.profile = "dev";

    }
    public boolean updateYml(){
        NacosUtil nacosUtil = new NacosUtil();

        //获取yml中的数据
        try {
            Map<String, Object> map = getYmlMap(path);
            Map<String,String> o = (Map<String, String>) ((Map<String,Object>)map.get("spring")).get("datasource");

            String url1 = getPattern(o.get("url"));
            if (url1 != null){
                String url = nacosUtil.getNaCosValue("test.properties","DEFAULT_GROUP",url1);
                map.put("spring.datasource.url", url);
            }
            String username1 = getPattern(o.get("username"));
            if (username1 != null) {
                String username = nacosUtil.getNaCosValue("test.properties","DEFAULT_GROUP",username1);
                map.put("spring.datasource.username", username);
            }

            String password1 = getPattern(o.get("password"));
            if (password1 != null) {
                String password = nacosUtil.getNaCosValue("test.properties","DEFAULT_GROUP",password1);

                map.put("spring.datasource.password", password);
            }

            map = initMap(map);

            addIntoYaml("E:/springCloudStudy/cloud-auth/target/classes/application.yml", map);
        } catch (Exception e) {
            e.printStackTrace();
        }

return false;
    }
    /**
     * 初始化map，将map中属性包含.的形成多级map结构，方便保存
     *
     * @param map 需要初始化的map
     * @author hongweidong
     */


    public static Map<String, Object> initMap(Map<String, Object> map) {
        Map<String, Object> result = new LinkedHashMap();
        result.putAll(map);
        for (String s : map.keySet()) {
            if (map.get(s) == null) {
                map.put(s, "");
            }
            if (s.split("\\.").length > 1) {
                String key[] = s.split("\\.");
                Map<String, Object> tarMap = new LinkedHashMap<String, Object>();
                for (int i = 0; i < key.length; i++) {
                    if (i == key.length - 1) {
                        //最后一位
                        tarMap.put(key[i], map.get(s));
                    } else {
                        if (result.get(key[i]) != null) {
                            tarMap = (Map<String, Object>) result.get(key[i]);
                        } else {
                            tarMap = (Map<String, Object>) tarMap.get(key[i]);
                        }
                    }
                }
                result.remove(s);
            }
        }
        return result;
    }


    public static void addIntoYaml(String dest, Map<String, Object> map) throws IOException {
        map = YmlUtils.initMap(map);
        Yaml yaml = new Yaml(OPTIONS);
        //载入当前yml文件
        LinkedHashMap<String, Object> dataMap = yaml.load(new FileReader(dest));
        //如果yml内容为空,则会引发空指针异常,此处进行判断
        if (null == dataMap) {
            dataMap = new LinkedHashMap();
        }
        dataMap.putAll(map);
        //将数据重新写回文件
        yaml.dump(dataMap, new FileWriter(dest));
    }


    public static LinkedHashMap<String, Object> getYmlMap(String path) {
        File source = new File(path);
        Yaml yaml = new Yaml(OPTIONS);
        //载入文件
        LinkedHashMap<String, Object> dataMap = null;
        try {
            dataMap = yaml.load(new FileReader(source));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //获取当前key下的值(如果存在多个节点,则value可能为map,自行判断)
        return dataMap;
    }

    private  String getPattern(String key){
        try{
            Pattern regex = Pattern.compile("\\$\\{([^}]*)\\}");
            Matcher matcher = regex.matcher(key);
            while(matcher.find()) {
                return matcher.group(1);
            }

        }catch (Exception e) {
            return null;
        }
       return null;
    }

}

