package ThreadLocal;

/*

ThreadLocal in Java is another way to achieve thread-safety apart from writing immutable classes.
Thread local can be considered as a scope of access like session scope or request scope.
In thread local, you can set any object and this object will be local and global to the
specific thread which is accessing this object. Java ThreadLocal class provides thread-local variables.
It enables you to create variables that can only be read and write by the same thread.
If two threads are executing the same code and that code has a reference to a
ThreadLocal variable then the two threads can't see the local variable of each other.

 */
public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

        Thread thread1 = new Thread(() -> {
            stringThreadLocal.set("thread 1's value");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(stringThreadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            stringThreadLocal.set("thread 2's value");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(stringThreadLocal.get());
        });
        thread1.start();
        thread2.start();
    }
}
