public class ThreadCS extends Thread{
    
    @Override
    public void run(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
