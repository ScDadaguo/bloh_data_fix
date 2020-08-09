---
layout: post
title: 自定义spring.factories，实现自己的自动化装配
category:Java
tags: [Java]
keywords: Java
---
#《Java 多线程编程核心技术》学习笔记及总结/n## 第一章 —— Java 多线程技能

线程技术点：

+ 线程的启动
+ 如何使线程暂停
+ 如何使线程停止
+ 线程的优先级
+ 线程安全相关问题
<!-- more -->
### 进程和线程的概念及多线程的优点

进程：比如我们电脑运行的 QQ.exe 程序，是操作系统管理的基本运行单元

线程：在进程中独立运行的子任务，比如 QQ.exe 进程中就有很多线程在运行，下载文件线程、发送消息线程、语音线程、视频线程等。

多线程优点：我们电脑可以同时操作不同的软件，边听着歌，敲着代码，查看 pdf 文档，浏览网页等，CPU 在这些任务之间不停的切换，切换非常快，所以我们就觉得他们是在同时运行的。

### 使用多线程

#### 继承 Thread 类

JDK 源码注释（Thread.java）如下：

```java
One is to declare a class to be a subclass(子类) of <code>Thread</code>. This subclass should override the <code>run</code> method of class <code>Thread</code>. An instance of the subclass can then be allocated and started. For example, a thread that computes primes
larger than a stated value could be written as follows:
//继承 Thread 类
class PrimeThread extends Thread {
         long minPrime;
         PrimeThread(long minPrime) {
          this.minPrime = minPrime;
         }

         public void run() {
             // compute primes larger than minPrime
             重写 Thread 类的 run 方法
          }
     }

The following code would then create a thread and start it running:
//开启线程
    PrimeThread p = new PrimeThread(143);
    p.start();
```

#### 实现 Runnable 接口

JDK 源码注释（Thread.java）如下：

```java
The other way to create a thread is to declare a class that implements the <code>Runnable</code> interface. That class then implements the <code>run</code> method. An instance of the class can then be allocated, passed as an argument when creating
<code>Thread</code>, and started. The same example in this other style looks like the following:
//实现 Runnable 接口
    class PrimeRun implements Runnable {
        long minPrime;
        PrimeRun(long minPrime) {
            this.minPrime = minPrime;
         }

         public void run() {
            // compute primes larger than minPrime
            //重写 run 方法
        }
    }

The following code would then create a thread and start it running:
//开启线程
     PrimeRun p = new PrimeRun(143);
     new Thread(p).start();
```



### currentThread() 方法

该方法返回代码段正在被哪个线程调用的信息。

### isAlive() 方法

判断当前线程是否处于活动状态（已经启动但未终止）

### sleep() 方法

在指定的毫秒数内让当前“正在执行的线程（this.currentThread() 返回的线程）”休眠（暂停执行）。

### getId() 方法

获取线程的唯一标识

### 停止线程

可以使用 <del>Thread.stop()</del> 方法，但最好不要用，因为这个方法是不安全的，已经弃用作废了。

大多数停止一个线程是使用 Thread.interrupt() 方法

#### 判断线程是否是停止状态

+    interrupted()
```java
     //测试当前线程是否已经中断了，这个线程的中断状态会被这个方法清除。
     //换句话说，如果连续两次调用了这个方法，第二次调用的时候将会返回 false ，
     public static boolean interrupted() {
             return currentThread().isInterrupted(true);
     }
```

+    isInterrupted()

```java
        //测试线程是否已经中断了，线程的状态不会受这个方法的影响
        //线程中断被忽略，因为线程处于中断下不处于活动状态的线程由此返回false的方法反映出来
         public boolean isInterrupted() {
                return isInterrupted(false);
        }
        /**
     * Tests if some Thread has been interrupted.  The interrupted state
     * is reset or not based on the value of ClearInterrupted that is
     * passed.
     */
     private native boolean isInterrupted(boolean ClearInterrupted);
```

#### 在沉睡中停止

```java
public class MyThread2 extends Thread
{
    @Override
    public void run() {
        try {
            System.out.println("run start");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("run catch "+this.isInterrupted());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            MyThread2 t2 = new MyThread2();
            t2.start();
            Thread.sleep(200);
            t2.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
```

运行结果：

```java
run start
main end
run catch false
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.zhisheng.thread.thread1.MyThread2.run(MyThread2.java:12)
```

从运行结果来看，如果在 sleep 状态下停止某一线程，会进入 catch 语句，并清除停止状态值，使之变成 false。

#### 在停止中沉睡

```java
public class MyThread3 extends Thread
{
    @Override
    public void run() {
        try {
            System.out.println("run start");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("run catch "+this.isInterrupted());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
            MyThread3 t3 = new MyThread3();
            t3.start();
            t3.interrupt();
    }
}
```

运行结果：

```java
run start
run catch false
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at com.zhisheng.thread.thread1.MyThread3.run(MyThread3.java:12)
```

#### 能停止的线程 —— 暴力停止

使用 stop() 方法停止线程

### 暂停线程

可使用 suspend 方法暂停线程，使用 resume() 方法恢复线程的执行。

#### suspend 和 resume 方法的使用

```java
public class MyThread4 extends Thread
{
    private int i;
    public int getI() {
        return i;
    }
    public void setI(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread4 t4 = new MyThread4();
        t4.start();
        System.out.println("A----- " + System.currentTimeMillis() + " ---- " + t4.getI());
        Thread.sleep(2000);
        System.out.println("A----- " + System.currentTimeMillis() + " ---- " + t4.getI());
        t4.suspend();
        Thread.sleep(2000);
        t4.resume();
        System.out.println("B----- " + System.currentTimeMillis() + " ---- " + t4.getI());
        Thread.sleep(2000);
        System.out.println("B----- " + System.currentTimeMillis() + " ---- " + t4.getI());
    }
}
```

从运行结果来看，线程的确能够暂停和恢复。

但是 suspend 和 resume 方法的缺点就是：**不同步**，因为线程的暂停导致数据的不同步。

### yield 方法

```java
/**
     * A hint to the scheduler that the current thread is willing to yield
     * its current use of a processor. The scheduler is free to ignore this
     * hint.
     *
     * <p> Yield is a heuristic attempt to improve relative progression
     * between threads that would otherwise over-utilise a CPU. Its use
     * should be combined with detailed profiling and benchmarking to
     * ensure that it actually has the desired effect.
     *
     * <p> It is rarely appropriate to use this method. It may be useful
     * for debugging or testing purposes, where it may help to reproduce
     * bugs due to race conditions. It may also be useful when designing
     * concurrency control constructs such as the ones in the
     * {@link java.util.concurrent.locks} package.
     */
    //暂停当前正在执行的线程对象，并执行其他线程。暂停的时间不确定。
    public static native void yield();
```

```java
public class MyThread5 extends Thread
{
    @Override
    public void run() {
        double start = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            //yield();//暂停的时间不确定
            i++;
        }
        double end = System.currentTimeMillis();
        System.out.println("time is "+(end - start));
    }
    public static void main(String[] args) {
        MyThread5  t5 = new MyThread5();
        t5.start();
    }
}
```

### 线程的优先级

设置优先级的方法：setPriority() 方法

```java
public final void setPriority(int newPriority) {
        ThreadGroup g;
        checkAccess();
        if (newPriority > MAX_PRIORITY || newPriority < MIN_PRIORITY) {
            throw new IllegalArgumentException();
        }
        if((g = getThreadGroup()) != null) {
            if (newPriority > g.getMaxPriority()) {
                newPriority = g.getMaxPriority();
            }
            setPriority0(priority = newPriority);
        }
    }
```

不一定优先级高的线程就先执行。

### 守护线程

当进程中不存在非守护线程了，则守护线程自动销毁。垃圾回收线程就是典型的守护线程，当进程中没有非守护线程了，则垃圾回收线程也就没有存在的必要了，自动销毁。

```java
 /**
     * Marks this thread as either a {@linkplain #isDaemon daemon} thread
     * or a user thread. The Java Virtual Machine exits when the only
     * threads running are all daemon threads.
     *
     * <p> This method must be invoked before the thread is started.
     *
     * @param  on
     *         if {@code true}, marks this thread as a daemon thread
     * @throws  IllegalThreadStateException
     *          if this thread is {@linkplain #isAlive alive}
     * @throws  SecurityException
     *          if {@link #checkAccess} determines that the current
     *          thread cannot modify this thread
     */
    public final void setDaemon(boolean on) {
        checkAccess();
        if (isAlive()) {
            throw new IllegalThreadStateException();
        }
        daemon = on;
    }
```





## 第二章 —— 对象及变量的并发访问

技术点：

+ synchronized 对象监视器为 Object 时的使用
+ synchronized 对象监视器为 Class 时的使用
+ 非线程安全是如何出现的
+ 关键字 volatile 的主要作用
+ 关键字 volatile 与 synchronized 的区别及使用情况

### synchronized 同步方法

#### 方法内的变量为线程安全

“非线程安全”问题存在于“实例变量”中，如果是方法内部的私有变量，则不存在“非线程安全”问题，所得结果也就是“线程安全”了。

#### 实例变量非线程安全

如果多线程共同访问一个对象中的实例变量，则有可能出现“非线程安全”问题。

在两个线程访问同一个对象中的同步方法时一定是线程安全的。

#### 脏读

发生脏读的情况是在读取实例变量时，此值已经被其他线程更改过了。

如下例子就可以说明，如果不加 synchronized 关键字在 setValue 和 getValue 方法上，就会出现数据脏读。

```java
class VarName
{
    private String userName = "A";
    private String password = "AA";
    synchronized public void setValue(String userName, String password) {
        try {
            this.userName = userName;
            Thread.sleep(500);
            this.password = password;
            System.out.println("setValue method Thread name is :  " + Thread.currentThread().getName() + " userName = " + userName + " password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //synchronized
    public void getValue() {
        System.out.println("getValue method Thread name is :  " + Thread.currentThread().getName() + " userName = " + userName + " password = " + password);
    }
}

class Thread1 extends Thread
{
    private VarName varName;
    public Thread1(VarName varName) {
        this.varName = varName;
    }
    @Override
    public void run() {
        varName.setValue("B", "BB");
    }
}

public class Test
{
    public static void main(String[] args) throws InterruptedException {
        VarName v = new VarName();
        Thread1 thread1 = new Thread1(v);
        thread1.start();
        Thread.sleep(200);//打印结果受睡眠时间的影响
        v.getValue();
    }
}
```

#### synchronized 锁重入

关键字 synchronized 拥有锁重入的功能，也就是在使用 synchronized 时，当一个线程得到一个对象锁后，再次请求此对象锁是可以再次得到该对象的锁的。这也证明了在一个 synchronized 方法/块的内部调用本类的其他 synchronized 方法/块时，是永远可以得到锁的。

```java
class Service
{
    synchronized public void service1() {
        System.out.println("service 1");
        service2();
    }
    synchronized public void service2() {
        System.out.println("service 2");
        service3();
    }
    synchronized public void service3() {
        System.out.println("service 3");
    }
}

class Thread2 extends Thread
{
    @Override
    public void run() {
        Service s = new Service();
        s.service1();
    }
}

public class Test2
{
    public static void main(String[] args) {
        Thread2 t2 = new Thread2();
        t2.start();
    }
}
```

运行结果：

```
service 1
service 2
service 3
```

#### 同步不具有继承性

同步不可以继承。

### synchronized 同步语句块

#### synchronized 代码块间的同步性

当一个线程访问 object 的一个 synchronized(this) 同步代码块时，其他线程对同一个 object 中所有其他 synchronized(this) 同步代码块的访问将被阻塞，这说明 synchronized 使用的 “对象监视器” 是一个。

#### 将任意对象作为对象监视器

多个线程调用同一个对象中的不同名称的 synchronized 同步方法或者 synchronized(this) 同步代码块时，调用的效果就是按顺序执行，也就是同步的，阻塞的。

#### 静态同步 synchronized 方法与  synchronized(class) 代码块

关键字 synchronized 还可以应用在 static 静态方法上，如果这样写就是对当前的 *.java 文件对应的 Class 类进行加锁。而 synchronized 关键字加到非 static 静态方法上就是给对象加锁。

#### 多线程的死锁



### volatile 关键字

作用：使变量在多个线程间可见。

通过使用 volatile 关键字，强制的从公共内存中读取变量的值。使用 volatile 关键字增加了实例变量在多个线程之间的可见性，但 volatile 关键字最致命的缺点就是不支持原子性。

关键字 synchronized 和 volatile 比较：

+ 关键字 volatile 是线程同步的轻量实现，所以 volatile 性能肯定要比 synchronized 要好，并且 volatile 只能修饰于变量，而 synchronized 可以修饰方法，以及代码块。

+ 多线程访问 volatile 不会发生阻塞，而 synchronized 会出现阻塞。

+ volatile 能保证数据的可见性，但不能保证原子性；而 synchronized 可以保证原子性，也可以间接保证可见性，因为它会将私有内存和公有内存中的数据做同步。

+ 关键字 volatile 解决的是变量在多个线程之间的可见性；而 synchronized 关键字解决的是多个线程之间访问资源的同步性。

  ​



## 第三章 —— 线程间通信

技术点：

+ 使用 wait/notify 实现线程间的通信
+ 生产者/消费者模式的实现
+ 方法 join 的使用
+ ThreadLocal 类的使用


### 等待/通知机制

wait 使线程停止运行，notify 使停止的线程继续运行。

关键字 synchronized 可以将任何一个 Object 对象作为同步对象看待，而 Java 为每个 Object 都实现了 wait() 和 notify() 方法，他们必须用在被 synchronized 同步的 Object 的临界区内。通过调用 wait 方法可以使处于临界区内的线程进入等待状态，同时释放被同步对象的锁。而 notify 操作可以唤醒一个因调用了 wait 方法而处于阻塞状态的线程，使其进入就绪状态。被重新唤醒的线程会试图重新获得临界区的控制权，继续执行临界区内 wait 之后的代码。

wait 方法可以使调用该方法的线程释放共享资源的锁，从运行状态退出，进入等待状态，直到再次被唤醒。

notify() 方法可以随机唤醒等待对列中等待同一共享资源的一个线程，并使该线程退出等待状态，进入可运行状态。

notifyAll() 方法可以随机唤醒等待对列中等待同一共享资源的所有线程，并使这些线程退出等待状态，进入可运行状态。

#### 线程状态示意图：

![](http://ohfk1r827.bkt.clouddn.com/thread-state.jpg)

+ 新创建一个线程对象后，在调用它的 start() 方法，系统会为此线程分配 CPU 资源，使其处于 Runnable（可运行）状态，如果线程抢占到 CPU 资源，此线程就会处于 Running （运行）状态

+ Runnable 和 Running 状态之间可以相互切换，因为线程有可能运行一段时间后，有其他优先级高的线程抢占了 CPU 资源，此时线程就从 Running 状态变成了 Runnable 状态。

  线程进入 Runnable 状态有如下几种情况：

  + 调用 sleep() 方法后经过的时间超过了指定的休眠时间
  + 线程调用的阻塞 IO 已经返回，阻塞方法执行完毕
  + 线程成功的获得了试图同步的监视器
  + 线程正在等待某个通知，其他线程发出了通知
  + 处于挂状态的线程调用了 resume 恢复方法

+ Blocked 是阻塞的意思，例如线程遇到一个 IO 操作，此时 CPU 处于空闲状态，可能会转而把 CPU 时间片分配给其他线程，这时也可以称为 “暂停”状态。Blocked 状态结束之后，进入 Runnable 状态，等待系统重新分配资源。

  出现阻塞状态的有如下几种情况：

  + 线程调用 sleep 方法，主动放弃占用的处理器资源
  + 线程调用了阻塞式 IO 方法，在该方法返回之前，该线程被阻塞
  + 线程试图获得一个同步监视器，但该同步监视器正在被其他线程所持有
  + 线程等待某个通知
  + 程序调用了 suspend 方法将该线程挂起

+ run 方法运行结束后进入销毁阶段，整个线程执行完毕。

#### 生产者/消费者模式实现

一个生产者，一个消费者

存储值对象：

```java
package com.zhisheng.thread.thread5;

/**
 * Created by 10412 on 2017/6/3.
 * 存储值对象
 */
public class ValueObject
{
    public static String value = "";
}
```

生产者：

```java
package com.zhisheng.thread.thread5;

/**
 * Created by 10412 on 2017/6/3.
 * 生产者
 */
public class Product
{
    private String lock;

    public Product(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        synchronized (lock) {
            if (!ValueObject.value.equals("")) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String value = System.currentTimeMillis() + "_" + System.nanoTime();
            System.out.println("生产者 set 的值是：" + value);
            ValueObject.value = value;
            lock.notify();
        }
    }
}
```

消费者：

```java
package com.zhisheng.thread.thread5;

/**
 * Created by 10412 on 2017/6/3.
 * 消费者
 */
public class Resume
{
    private String lock;

    public Resume(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        synchronized (lock) {
            if (ValueObject.value.equals("")) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者 get 的值：" + ValueObject.value);
            ValueObject.value = "";
            lock.notify();
        }
    }
}
```

生产者线程：

```java
package com.zhisheng.thread.thread5;

/**
 * Created by 10412 on 2017/6/3.
 * 生产者线程
 */
public class ProductThread extends Thread
{
    private Product p;

    public ProductThread(Product p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
```

消费者线程：

```java
package com.zhisheng.thread.thread5;

/**
 * Created by 10412 on 2017/6/3.
 * 消费者线程
 */
public class ResumeThread extends Thread
{
    private Resume r;

    public ResumeThread(Resume r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.getValue();
        }
    }
}
```

主函数：

```java
package com.zhisheng.thread.thread5;

/**
 * Created by 10412 on 2017/6/3.
 * 一个生产者一个消费者测试
 */
public class Test
{
    public static void main(String[] args) {
        String str = new String("");
        Product p = new Product(str);
        Resume r = new Resume(str);;
        ProductThread pt = new ProductThread(p);
        ResumeThread rt = new ResumeThread(r);
        pt.start();
        rt.start();
    }
}
```

题目：创建20个线程，其中10个线程是将数据备份到数据库A，另外10个线程将数据备份到数据库B中去，并且备份数据库A和备份数据库B是交叉进行的。

工具类：

```java
package com.zhisheng.thread.thread6;

/**
 * Created by 10412 on 2017/6/3.
 * 创建20个线程，其中10个线程是将数据备份到数据库A，另外10个线程将数据备份到数据库B中去，并且
 * 备份数据库A和备份数据库B是交叉进行的
 */
public class DBTools
{
    volatile private boolean prevIsA = false;

    //确保A备份先进行
    synchronized public void backA() {
        while (prevIsA == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("AAAAA");
        }
        prevIsA = true;
        notifyAll();
    }

    synchronized public void backB() {
        while (prevIsA == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("BBBBB");
        }
        prevIsA = false;
        notifyAll();
    }
}
```

备份A先线程：

```java
package com.zhisheng.thread.thread6;

/**
 * Created by 10412 on 2017/6/3.
 */
public class ThreadA extends Thread
{
    private DBTools dbTools;

    public ThreadA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backA();
    }
}
```

备份B线程：

```java
package com.zhisheng.thread.thread6;

/**
 * Created by 10412 on 2017/6/3.
 */
public class ThreadB extends Thread
{
    private DBTools dbTools;

    public ThreadB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backB();
    }
}
```

测试：

```java
package com.zhisheng.thread.thread6;

/**
 * Created by 10412 on 2017/6/3.
 */
public class Test
{
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            ThreadB tb = new ThreadB(dbTools);
            tb.start();
            ThreadA ta = new ThreadA(dbTools);
            ta.start();
        }
    }
}
```



### Join 方法的使用

作用：等待线程对象销毁

join 方法具有使线程排队运行的作用，有些类似同步的运行效果。join 与 synchronized 的区别是：join 在内部使用 wait() 方法进行等待，而 synchronized 关键字使用的是 “对象监视器” 原理做为同步。

在 join 过程中，如果当前线程对象被中断，则当前线程出现异常。

方法 join(long) 中的参数是设定等待的时间。

```java
/**
     * 等待该线程终止的时间最长为 millis 毫秒。超时为 0 意味着要一直等下去。
     * Waits at most {@code millis} milliseconds for this thread to
     * die. A timeout of {@code 0} means to wait forever.
     *
     * <p> This implementation uses a loop of {@code this.wait} calls
     * conditioned on {@code this.isAlive}. As a thread terminates the
     * {@code this.notifyAll} method is invoked. It is recommended that
     * applications not use {@code wait}, {@code notify}, or
     * {@code notifyAll} on {@code Thread} instances.
     *
     * @param  millis
     *         the time to wait in milliseconds
     *
     * @throws  IllegalArgumentException
     *          if the value of {@code millis} is negative
     *
     * @throws  InterruptedException
     *          if any thread has interrupted the current thread. The
     *          <i>interrupted status</i> of the current thread is
     *          cleared when this exception is thrown.
     */
    public final synchronized void join(long millis)
    throws InterruptedException {
        long base = System.currentTimeMillis();
        long now = 0;
        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        if (millis == 0) {
            while (isAlive()) {
                wait(0);
            }
        } else {
            while (isAlive()) {
                long delay = millis - now;
                if (delay <= 0) {
                    break;
                }
                wait(delay);
                now = System.currentTimeMillis() - base;
            }
        }
    }
```

### 类  ThreadLocal  的使用

该类提供了线程局部 (thread-local) 变量。这些变量不同于它们的普通对应物，因为访问某个变量（通过其 get 或
set 方法）的每个线程都有自己的局部变量，它独立于变量的初始化副本。ThreadLocal 实例通常是类中的
private static 字段，它们希望将状态与某一个线程（例如，用户 ID 或事务 ID）相关联。

#### get() 方法

```java
public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        return setInitialValue();
    }
```

返回此线程局部变量的当前线程副本中的值。如果变量没有用于当前线程的值，则先将其初始化为调用 initialValue() 方法返回的值。

### InheritableThreadLocal 类的使用

该类扩展了 ThreadLocal，为子线程提供从父线程那里继承的值：在创建子线程时，子线程会接收所有可继承的线程局部变量的初始值，以获得父线程所具有的值。通常，子线程的值与父线程的值是一致的；但是，通过重写这个类中的 childValue 方法，子线程的值可以作为父线程值的一个任意函数。

当必须将变量（如用户 ID 和 事务 ID）中维护的每线程属性（per-thread-attribute）自动传送给创建的所有子线程时，应尽可能地采用可继承的线程局部变量，而不是采用普通的线程局部变量。



## 第四章 ——  Lock 的使用

### 使用 ReentrantLock 类

一个可重入的互斥锁 Lock，它具有与使用 `synchronized` 方法和语句所访问的隐式监视器锁相同的一些基本行为和语义，但功能更强大。

`ReentrantLock` 将由最近成功获得锁，并且还没有释放该锁的线程所*拥有*。当锁没有被另一个线程所拥有时，调用 `lock` 的线程将成功获取该锁并返回。如果当前线程已经拥有该锁，此方法将立即返回。可以使用 `isHeldByCurrentThread()`和 `getHoldCount()`方法来检查此情况是否发生。

此类的构造方法接受一个可选的*公平* 参数。当设置为 `true` 时，在多个线程的争用下，这些锁倾向于将访问权授予等待时间最长的线程。否则此锁将无法保证任何特定访问顺序。与采用默认设置（使用不公平锁）相比，使用公平锁的程序在许多线程访问时表现为很低的总体吞吐量（即速度很慢，常常极其慢），但是在获得锁和保证锁分配的均衡性时差异较小。不过要注意的是，公平锁不能保证线程调度的公平性。因此，使用公平锁的众多线程中的一员可能获得多倍的成功机会，这种情况发生在其他活动线程没有被处理并且目前并未持有锁时。还要注意的是，未定时的 `tryLock`方法并没有使用公平设置。因为即使其他线程正在等待，只要该锁是可用的，此方法就可以获得成功。

建议*总是* 立即实践，使用 `lock` 块来调用 `try`，在之前/之后的构造中，最典型的代码如下：

```java
class X {
   private final ReentrantLock lock = new ReentrantLock();
   // ...

   public void m() {
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
   }
 }
```

### Condition

Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用，为每个对象提供多个等待 set（wait-set）。其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替代了 Object 监视器方法的使用。

假定有一个绑定的缓冲区，它支持 put 和 take 方法。如果试图在空的缓冲区上执行 take 操作，则在某一个项变得可用之前，线程将一直阻塞；如果试图在满的缓冲区上执行 put 操作，则在有空间变得可用之前，线程将一直阻塞。我们喜欢在单独的等待 set 中保存 put 线程和 take 线程，这样就可以在缓冲区中的项或空间变得可用时利用最佳规划，一次只通知一个线程。可以使用两个 Condition 实例来做到这一点。

```java
class BoundedBuffer {
   final Lock lock = new ReentrantLock();
   final Condition notFull  = lock.newCondition();
   final Condition notEmpty = lock.newCondition();

   final Object[] items = new Object[100];
   int putptr, takeptr, count;

   public void put(Object x) throws InterruptedException {
     lock.lock();
     try {
       while (count == items.length)
         notFull.await();
       items[putptr] = x;
       if (++putptr == items.length) putptr = 0;
       ++count;
       notEmpty.signal();
     } finally {
       lock.unlock();
     }
   }

   public Object take() throws InterruptedException {
     lock.lock();
     try {
       while (count == 0)
         notEmpty.await();
       Object x = items[takeptr];
       if (++takeptr == items.length) takeptr = 0;
       --count;
       notFull.signal();
       return x;
     } finally {
       lock.unlock();
     }
   }
 }
```

### 正确使用 Condition 实现等待/通知

MyService.java

```java
package com.zhisheng.thread.Thread9;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 10412 on 2017/6/4.
 */
public class MyService
{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        lock.lock();
        try {
            System.out.println("await A");
            condition.await();//使当前执行的线程处于等待状态 waiting
            System.out.println("await B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("释放锁");
        }
    }

    public void signal() {
        lock.lock();
        System.out.println("signal A");
        condition.signal();
        System.out.println("signal B");
        lock.unlock();
    }
}
```

ThreadA.java

```java
package com.zhisheng.thread.Thread9;

/**
 * Created by 10412 on 2017/6/4.
 */
public class ThreadA extends Thread
{
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
```

Test.java

```java
package com.zhisheng.thread.Thread9;

/**
 * Created by 10412 on 2017/6/4.
 */
public class Test
{
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA ta = new ThreadA(service);
        ta.start();
        Thread.sleep(5000);
        service.signal();
    }
}
```

运行结果：

```java
await A
signal A
signal B
await B
释放锁
```

Object 类中的 wait() 方法相当于 Condition 类中 await() 方法

Object 类中的 wait(long time) 方法相当于 Condition 类中 await(long time, TimeUnit unit) 方法

Object 类中的 notify() 方法相当于 Condition 类中 signal() 方法

Object 类中的 notifyAll() 方法相当于 Condition 类中 signalAll() 方法



题目：实现生产者与消费者  一对一交替打印

MyService.java

```java
package com.zhisheng.thread.thread10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 10412 on 2017/6/4.
 * 实现生产者与消费者  一对一·交替打印
 */
public class MyService
{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private  boolean flag = false;

    public void setValue() {
        lock.lock();
        while (flag == true) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("SetValue  AAAAAA");
        flag = true;
        condition.signal();
        lock.unlock();
    }

    public void getValue() {
        lock.lock();
        while (flag == false) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("GetValue BBBB");
        flag = false;
        condition.signal();
        lock.unlock();
    }
}
```

ThreadA.java

```java
package com.zhisheng.thread.thread10;

/**
 * Created by 10412 on 2017/6/4.
 */
public class ThreadA extends Thread
{
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.setValue();
        }
    }
}
```

ThreadB.java

```java
package com.zhisheng.thread.thread10;

/**
 * Created by 10412 on 2017/6/4.
 */
public class ThreadB extends Thread
{
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.getValue();
        }
    }
}
```

Test.java

```java
package com.zhisheng.thread.thread10;

/**
 * Created by 10412 on 2017/6/4.
 */
public class Test
{
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA ta = new ThreadA(service);
        ThreadB tb = new ThreadB(service);
        ta.start();
        tb.start();
    }
}
```



getHoldCount() 查询当前线程保持此锁定的个数，也就是调用 lock() 的方法

getQueueLength() 返回正等待获取此锁定的线程估计数

getWaitQueueLength() 返回等待与此锁定相关的给定条件 Condition 的线程估计数

hasQueuedThread() 查询指定的线程是否正在等待获取此锁定

hasQueuedThreads() 查询是否有线程正在等待获取此锁定

hasWaiters() 查询是否有线程正在等待与此锁定有关的 condition 条件

isFair() 判断是否是公平锁（默认下 ReentrantLock类使用的是非公平锁）

isHeldByCurrentThread() 查询当前线程是否保持此锁定

isLocked() 查询此锁定是否由任意线程保持

lockInterruptibly() 如果当前线程未被中断，则获取锁定，如果已经被中断则出现异常

tryLock() 仅在调用时锁定未被另一个线程保持的情况下，才获取该锁定

tryLock(long time, TimeUtil util) 如果锁定在给定的等待时间内没有被另一个线程保持，且当前线程未被中断，则获取该锁定。

### 使用 ReentrantReadWriteLock 类

读写互斥：

MyService.java

```java
package com.zhisheng.thread.Thread11;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by 10412 on 2017/6/4.
 */
public class MyService
{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " Read AAA  " + System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.readLock().unlock();
    }

    public void write() {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " write BBB " + System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.writeLock().unlock();
    }
}
```

ThreadA.java

```java
package com.zhisheng.thread.Thread11;

/**
 * Created by 10412 on 2017/6/4.
 */
public class ThreadA extends Thread
{
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
```

ThreadB.java

```java
package com.zhisheng.thread.Thread11;

/**
 * Created by 10412 on 2017/6/4.
 */
public class ThreadB extends Thread
{
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
```

Test.java

```java
package com.zhisheng.thread.Thread11;

/**
 * Created by 10412 on 2017/6/4.
 */
public class Test
{
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA ta = new ThreadA(service);
        ta.setName("A");
        ta.start();
        Thread.sleep(1000);
        ThreadB tb = new ThreadB(service);
        tb.setName("B");
        tb.start();
    }
}
```

运行结果：

```
A Read AAA  1496556770402
B write BBB 1496556780402
```





## 第六章 —— 单例模式与多线程

推荐文章 [《深入浅出单实例Singleton设计模式》](http://blog.csdn.net/tzs_1041218129/article/details/51246419)

### 立即加载模式 / “饿汉模式”

立即加载：使用类的时候已经将对象创建完毕，new 实例化

```java
public class MyObject
{
    private static MyObject object = new MyObject();
    private MyObject() {
    }
    public static MyObject getInstance() {
        return object;
    }
}
```

### 延迟加载 / “ 懒汉模式 ”

就是在调用 get 的时候实例才被创建。在 get() 方法中进行 new 实例化。

```java
public class MyObject
{
    private  static  MyObject object;
    private MyObject() {
    }
    public static MyObject getInstance() {
        if (object != null) {
        } else {
            object = new MyObject();
        }
        return object;
    }
}
```

使用 DCL 双重检查锁，解决“懒汉模式”遇到的多线程问题

```java
public class MyObject
{
    private  volatile static  MyObject object;
    private MyObject() {
    }
    //synchronized
    public static MyObject getInstance() {
        if (object != null) {
        } else {
            synchronized (MyObject.class) {
                if (object == null) {
                    object = new MyObject();
                }
            }
        }
        return object;
    }
}
```

### 使用静态内部类实现单例模式

```java
public class MyObject
{
    private static class MyObjectHandler
    {
        private static MyObject object = new MyObject();
    }
    private MyObject() {
    }
    public static MyObject getInstance() {
        return MyObjectHandler.object;
    }
}
```

### 序列化与反序列化的单例模式实现

MyObject.java

```java
package com.zhisheng.thread.thread15;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by 10412 on 2017/6/4.
 */
public class MyObject implements Serializable
{
    private static final long serialVersionUID =  888L;
    private static class MyObjectHandler
    {
        private static final MyObject object = new MyObject();
    }
    private MyObject() {
    }
    public static  MyObject getInstance() {
        return MyObjectHandler.object;
    }
    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MyObjectHandler.object;
    }
}
```

SaveAndRead.java

```java
package com.zhisheng.thread.thread15;

import java.io.*;

/**
 * Created by 10412 on 2017/6/4.
 */
public class SaveAndRead
{
    public static void main(String[] args) {
        try {
            MyObject object = MyObject.getInstance();
            FileOutputStream fos = new FileOutputStream(new File("fos.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
            fos.close();
            System.out.println(object.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(new File("fos.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            MyObject o = (MyObject) ois.readObject();
            ois.close();
            fis.close();
            System.out.println(o.hashCode());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

这里主要要指出 MyObject.java 中 readResolve 方法

```java
 protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MyObjectHandler.object;
    }
```

方法 readResolve 允许 class 在反序列化返回对象前替换、解析在流中读出来的对象。实现 readResolve 方法，一个 class 可以直接控制反序化返回的类型和对象引用。

方法 readResolve 会在 ObjectInputStream 已经读取一个对象并在准备返回前调用。ObjectInputStream 会检查对象的 class 是否定义了 readResolve 方法。如果定义了，将由 readResolve 方法指定返回的对象。返回对象的类型一定要是兼容的，否则会抛出 ClassCastException 。

### 使用 static 代码块实现单例模式

```java
package com.zhisheng.thread.thread16;

/**
 * Created by 10412 on 2017/6/4.
 */
public class MyObject
{
    private static MyObject instance = null;
    private MyObject() {
    }
    static {
        instance = new MyObject();
    }
    public static MyObject getInstance() {
        return instance;
    }
}
```

ThreadA.java

```java
package com.zhisheng.thread.thread16;

/**
 * Created by 10412 on 2017/6/4.
 */
public class ThreadA extends Thread
{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject.getInstance().hashCode());
        }
    }
}
```

Test.java

```java
package com.zhisheng.thread.thread16;

/**
 * Created by 10412 on 2017/6/4.
 */
public class Test
{
    public static void main(String[] args) {
        ThreadA ta1 = new ThreadA();
        ThreadA ta2 = new ThreadA();
        ThreadA ta3 = new ThreadA();
        ta1.start();
        ta2.start();
        ta3.start();
    }
}
```

### 使用枚举数据类型实现单例模式

在使用枚举类时，构造方法会被自动调用，也可以应用这个特性实现单例模式。

```java
public class MyObject {
    private enum MyEnumSingleton{
        INSTANCE;
        private Resource resource;
        private MyEnumSingleton(){
            resource = new Resource();
        }
        public Resource getResource(){
            return resource;
        }
    }
    public static Resource getResource(){
        return MyEnumSingleton.INSTANCE.getResource();
    }
}
```

测试：

```java
import test.MyObject;

public class Run {
    class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(MyObject.getResource().hashCode());
            }
        }
    }
    public static void main(String[] args) {
        Run.MyThread t1 = new Run().new MyThread();
        Run.MyThread t2 = new Run().new MyThread();
        Run.MyThread t3 = new Run().new MyThread();
        t1.start();
        t2.start();
        t3.start();

    }
}
```

这里再推荐一篇 stackoverflow 上的一个问题回答： [What is an efficient way to implement a singleton pattern in Java?](https://stackoverflow.com/questions/70689/what-is-an-efficient-way-to-implement-a-singleton-pattern-in-java)



## 总结

本篇文章是我读 《Java多线程编程核心技术》 的笔记及自己的一些总结，觉得不错，欢迎点赞和转发。


