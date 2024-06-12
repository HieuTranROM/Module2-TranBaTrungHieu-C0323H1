package DemoThread;

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " - MyThread: " + i);
            try {
                Thread.sleep(500); // Dừng lại 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start(); // Bắt đầu thread t1
        t2.start(); // Bắt đầu thread t2
    }
}

