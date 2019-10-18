package io.erercise;

import java.io.Serializable;

/**
 * Person 需要满足如下要求，方可序列化
 * 1、需要实现接口：Serializable
 * 2、当前类提供一个全局常量serialVersionUID
 * 3、除了当前Person类需要实现Serializable接口外，还必须保证内部所有属性都必须可序列化。（基本数据类型都默认可以序列化）
 */

public class Person implements Serializable {

    /**
     * Java序列化机制是通过在运行时判断类的serialVersionUID来验证版本的一致性。
     * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，如果相同则认为是一致的，可以进行反序列化。
     * 如果不一致就会出现序列化版本不一致的异常(InvalidCastException)
     */
    public static final long serialVersionUID = 4756343425L;

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }
}
