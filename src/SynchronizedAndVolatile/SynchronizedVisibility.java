package SynchronizedAndVolatile;

public class SynchronizedVisibility {

    private static Object object = null;

    /* Synchronized keyword works on a monitor object,

    If any thread has entered a synchronized block, no other thread can enter any synchronized block synced on the same
    monitor object.

    Similar to volatile flushing/fetching to/from main memory, when a thread enters a synced block, it fetches the
    fields visible to it from the main memory, and before exiting the synced block, it flushes them to the main memory.

    Similar to re-ordering restrictions for the volatile keyword, instructions inside the synced block remain inside the
    synced block, they are not reordered by the JVM such that they are moved out of that block, because it might impact
    the visibility of fields for other threads, if not properly synced with the main memory.

     */

    // These static funcs are synced on the .class of the class implicitly
    private static synchronized void setObject(Object o){
        object = o;
    }

    private static synchronized Object getObject(){
        return object;
    }


    // These static funcs are also synced on the same .class but explicitly. They work exactly same as the above two.
    private static void setObj(Object o){
        synchronized (SynchronizedVisibility.class){
            object = o;
        }
    }

    private static Object getObj(){
        synchronized (SynchronizedVisibility.class){
            return object;
        }
    }
}
