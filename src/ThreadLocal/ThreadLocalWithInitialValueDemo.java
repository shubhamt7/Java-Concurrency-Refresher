package ThreadLocal;

public class ThreadLocalWithInitialValueDemo {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal1 = ThreadLocal.withInitial(() -> {
            return new Object();
        });

        ThreadLocal<Object> threadLocal2 = new ThreadLocal<Object>(){
            @Override
            protected Object initialValue(){
                return new Object();
            }
        };

        Thread myThread = new Thread(() -> {
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
            threadLocal1.set(new Object());
            System.out.println(threadLocal1.get());
            System.out.println(threadLocal2.get());
        });

        myThread.start();
    }
}

/*

Read about InheritableThreadLocal

 */