package com.guohong.spring.utils;


import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.SneakyThrows;

/**
 * @author guohong
 * nacos 连接工具类
 */
public class NacosUtils {
    private NamingService naming;
    private String serverAddr;
    private String serverIp;
    private int serverPort;
    private String serviceName;
    private boolean healthy;

    public NacosUtils(String serverAddr, String serverIp, int serverPort, String serviceName, boolean healthy) {
        this.serverAddr = serverAddr;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.serviceName = serviceName;
        this.healthy = healthy;
    }

    @SneakyThrows
    public void upNacos(){
        Instance instance = new Instance();
        //IP
        instance.setIp(serverIp);
        //端口
        instance.setPort(serverPort);
        //服务名
        instance.setServiceName(serviceName);
        //true: 上线 false: 下线
        instance.setEnabled(true);
        //健康状态
        instance.setHealthy(healthy);
        //权重
        instance.setWeight(1.0);
        //元数据
        instance.addMetadata("nacos-sdk-java-discovery", "true");
        NamingService namingService = NamingFactory.createNamingService(serverAddr);
        namingService.registerInstance(serviceName, instance);

    }


}
