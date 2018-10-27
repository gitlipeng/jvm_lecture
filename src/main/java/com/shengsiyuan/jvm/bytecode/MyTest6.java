package com.shengsiyuan.jvm.bytecode;

/*
    方法的动态分派

    方法的动态分配涉及到一个重要概念：方法接收者

    invokevirtual字节码指令的多态查找流程

    1. 找到操作数栈顶的第一个元素
    2. 它所指向的这个对象的实际类型（Apple类型）如果在这个实际类型中找到与常量池中的方法描述符
    以及方法名称都完全相同的方法（<com/shengsiyuan/jvm/bytecode/Fruit.test>）
    3. 如果找到了并且权限校验通过，就直接调用（符号引用转换为了直接引用），如果找不到，就按照继承的乘次关系，依次查找，一直到找到


    比较方法重载和方法重，我们可以得到这样一个结论

    方法重载是静态的，是编译器行为；方法重写是动态的，是运行期行为

    所以Java中的多态和方法重载没关系，和方法重写有关系

 */
public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();

        apple = new Orange();
        apple.test();


    }
}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    public void test() {
        System.out.println("Orange");
    }
}





