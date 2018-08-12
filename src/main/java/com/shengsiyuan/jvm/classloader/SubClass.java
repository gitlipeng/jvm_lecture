package com.shengsiyuan.jvm.classloader;
class ParentClass {
    private String privateField = "父类变量--private";

    /* friendly */String friendlyField = "父类变量--friendly";

    protected String protectedField = "父类变量--protected";

    public String publicField = "父类变量--public";

    // private的变量无法直接访问，因此我们给他增加了一个访问方法
    public String getPrivateFieldValue() {
        return privateField;
    }
}

public class SubClass extends ParentClass {
    private String privateField = "子类变量--private";

    String friendlyField = "子类变量--friendly";

    protected String protectedField = "子类变量--protected";

    public String publicField = "子类变量--public";

    // private的变量无法直接访问，因此我们给他增加了一个访问方法
    public String getPrivateFieldValue() {
        return privateField;
    }

    public static void main(String[] args) {
        // 为了便于查阅，我们统一按照private、friendly、protected、public的顺序
        // 输出下列三种情况中变量的值

        // ParentClass类型，ParentClass对象
        ParentClass parentClass = new ParentClass();
        System.out.println("ParentClass parentClass = new ParentClass();");
        System.out.println(parentClass.getPrivateFieldValue());
        System.out.println(parentClass.friendlyField);
        System.out.println(parentClass.protectedField);
        System.out.println(parentClass.publicField);

        System.out.println();

        // ParentClass类型，SubClass对象
        ParentClass subClass = new SubClass();
        System.out.println("ParentClass subClass = new SubClass();");
        System.out.println(subClass.getPrivateFieldValue());
        System.out.println(subClass.friendlyField);
        System.out.println(subClass.protectedField);
        System.out.println(subClass.publicField);

        System.out.println();

        // SubClass类型，SubClass对象
        SubClass subClazz = new SubClass();
        System.out.println("SubClass subClazz = new SubClass();");
        System.out.println(subClazz.getPrivateFieldValue());
        System.out.println(subClazz.friendlyField);
        System.out.println(subClazz.protectedField);
        System.out.println(subClazz.publicField);
    }
}
