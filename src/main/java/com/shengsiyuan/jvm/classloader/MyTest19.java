package com.shengsiyuan.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

public class MyTest19 {
    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());

        System.out.println(MyTest19.class.getClassLoader());

        // java -Djava.ext.dirs=./ com.shengsiyuan.jvm.classloader.MyTest19
        // 将当前扩展目录修改为我们的目录,会报错 招不到Caused by: java.lang.ClassNotFoundException: com.sun.crypto.provider.AESKeyGenerator

    }
}
