package SynchronizedAndVolatile;

/*
Even if multiple threads are working on same instance of a class, although the fields will be common and will be stored in the main
memory, but each thread creates its own copy of that field in the CPU registers and the cache.

So, even after a thread updates a common field, it is possible that the other thread that tries to access the common field
does not get the updated value, because we can not be sure about how often the field is synced with the main memory.

There comes the volatile keyword.
-> When a field is marked volatile, every read of this value will be fetched from the main memory, and
every write to it will be flushed to the main memory instantly.

Along with the volatile field, other non-volatile fields visible to the thread are also flushed/read to/from main-memory
but only when the volatile field is flushed/read.

Plus, JVM behind the scenes can reorder some instructions in order to optimize the execution time, but it can impact the fields'
visibility. So to prevent that, Java has some re-ordering restrictions -

1. Any writes before write to a volatile field will remain before that only. Those writes above the volatile field write can be re-ordered among themselves.
2. Any reads after the read of a volatile field will remain after that only. Those reads below the volatile field write can be re-ordered among themselves.

*/

public class VolatileVisibility {
    private volatile int count;
    private boolean hasNewCount;

    public VolatileVisibility(int count){
        hasNewCount = false;
        this.count = count;
    }

    public int getCount() {
        hasNewCount = false;
        return count;
    }

    public void setCount(int count) {
        hasNewCount = true;
        this.count = count;
    }
}
