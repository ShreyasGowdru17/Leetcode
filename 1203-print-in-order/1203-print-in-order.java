class Foo {
    private int turn;
    private Object lock;
    public Foo() {
        this.turn=1;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        while(turn!=1) wait();
        turn=2;
        notifyAll();
        printFirst.run();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(turn!=2) wait();
        turn=3;
        notifyAll();
        printSecond.run();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(turn!=3) wait();
        turn=1;
        notifyAll();
        printThird.run();
    }
}