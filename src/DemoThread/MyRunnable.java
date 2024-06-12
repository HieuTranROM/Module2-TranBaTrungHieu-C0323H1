package DemoThread;

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " - MyRunnable: " + i);
            try {
                Thread.sleep(500); // Dừng lại 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start(); // Bắt đầu thread t1
        t2.start(); // Bắt đầu thread t2
    }
}

