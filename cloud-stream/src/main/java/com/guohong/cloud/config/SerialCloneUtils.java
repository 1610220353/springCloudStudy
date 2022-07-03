package com.guohong.cloud.config;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @description: 序列化克隆工具
 * @author: guohong
 * @date: 2022/1/18
 **/
@Slf4j
public class SerialCloneUtils {

    /**
     * 使用ObjectStream序列化实现深克隆
     */
    public static <T> T deepClone(T t) {
        // 保存对象为字节数组
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
                out.writeObject(t);
            }
            // 从字节数组中读取克隆对象
            try (InputStream bin = new ByteArrayInputStream(bout.toByteArray())) {
                ObjectInputStream in = new ObjectInputStream(bin);
                return (T) in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {

            return t;
        }
    }
}
