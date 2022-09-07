class classA extends Thread  {
    public void run(){
        System.out.println("start thread A");
        for(int i=1;i<=5;i++){
            if (i==1) yield();
            System.out.println("from thread A:i="+i);
        }
            System.out.println("exit thread A");
    }
}
class classB extends Thread {
 public void run () {
    System.out.println("start thread B");
    for (int j=1;j<=5;j++){
        System.out.println("from thread Bj="+j);
        if (j==2) stop();
    }
   System.out.println("Exit thread B");
}
}
class classC extends Thread {
    public void run(){
        System.out.println("start thread c");
        for(int k=1;k<=5;k++){
            System.out.println("from thread B:j="+k);
            if(k==3){
                try{
                    sleep(1000);
                }
                catch (Exception e){}
            }
        }
        System.out.println("exit thread c");
    }
}
 class Threadstate{
    public static void main(String args[]){
        classA t1=new classA();
        classB t2=new classB();
        classC t3=new classC();
        t1.start();
        t2.start();
        t3.start();
        System.out.println("End of execution");
    }
}