package com.shengsiyuan.jvm.bytecode;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("From real subject");
    }

    @Override
    public String getName(String id) {
        System.out.println("getName id is:" + id);
        return "lipeng";
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("dddd");
        return super.equals(obj);
    }


}
