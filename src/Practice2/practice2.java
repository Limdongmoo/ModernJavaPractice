package Practice2;

public class practice2 {

    public static void process(Runnable r){
        r.run();
    }

    public static void main(String[] args){
        Runnable r1 = () -> System.out.println("HelloWorld 1");
        Runnable r2 = new Runnable(){
            public void run(){
                System.out.println("Helloworld 2");
            }
        };
        process(r1);
        process(r2);
        process(()->System.out.println("Helloworld 3"));

    }
}
