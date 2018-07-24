/**
 * 总结：
 * 1.静态内部类可以有静态成员(方法，属性)，而非静态内部类则不能有静态成员(方法，属性)。
 * 2.静态内部类只能够访问外部类的静态成员,而非静态内部类则可以访问外部类的所有成员(方法，属性)。
 * 3.实例化一个非静态的内部类的方法：
 * a.先生成一个外部类对象实例
 * OutClassTest oc1 = new OutClassTest();
 * b.通过外部类的对象实例生成内部类对象
 * OutClassTest.InnerClass no_static_inner = oc1.new InnerClass();
 * 4.实例化一个静态内部类的方法：
 * a.不依赖于外部类的实例,直接实例化内部类对象
 * OutClassTest.InnerStaticClass inner = new OutClassTest.InnerStaticClass();
 * b.调用内部静态类的方法或静态变量,通过类名直接调用
 * OutClassTest.InnerStaticClass.static_value
 * OutClassTest.InnerStaticClass.getMessage()
 */

package com.kshi.simple.concurrent.volatiletest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleVolatileTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Status status = new Status();

        executorService.execute(() -> {
            int i = 0;
            while (i++ < 1000) {
                System.out.println(System.currentTimeMillis() + " - Thread1 - set status as ready.");
                status.setStatus(true);
            }
        });

        executorService.execute(() -> {
            while (status.getStatus()) {
                System.out.println(System.currentTimeMillis() + " - Thread2 - ready to run :" + status.getStatus());
            }
        });

    }

    /**
     * 只有static类型的内部类才能够被main方法加载到
     */
    public static class Status {
        public Status() {
        }

        private  boolean status;

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

}
