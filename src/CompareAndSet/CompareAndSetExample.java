package CompareAndSet;

public class CompareAndSetExample {

    /*

    Compare and set refers to checking a particular variable's value, and if it equals the expected value, then setting
    it to something else.

    If the variable being checked is not synchronized, then it is possible that two threads at the same time check the value
    and find it to be equal to the expected value and then set it to some value. This might result in a race condition.

    In order to stop that, we can either have the code reside in a synchronized block, or use Atomic variables.
    Atomic Variables synchronization is supported at OS level. Only one thread at a time can modify the value of
    atomic variable.

    This can be used in scenarios like Ticket Booking, where two users should not end up booking the same ticket.

     */

    public static void main(String[] args) {

    }
}
