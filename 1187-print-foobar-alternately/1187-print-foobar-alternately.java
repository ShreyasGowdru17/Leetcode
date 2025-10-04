class FooBar {
    private int n;
    private int turn;
    public FooBar(int n) {
        this.n = n;
        this.turn=1;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            if(turn!=1) wait();
            turn=2;
            notify();
        	printFoo.run();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            if(turn!=2) wait();
            turn=1;
            notify();
        	printBar.run();
        }
    }
}