package geekbrains.lessons.lessonone.lessonFive;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
         firstRun();
         secondRun();

    }


    private static void firstRun(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);



    }

    private static void secondRun(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long a = System.currentTimeMillis();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, 0, a1, 0, h);
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5)
                            * Math.cos(0.2f + i / 5)
                            * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a1, 0, arr, 0, h);

            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.arraycopy(arr, h, a2, 0, h);
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5)
                            * Math.cos(0.2f + i / 5)
                            * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a2, 0, arr, h, h);

            }
        };
        r1.run();
        r2.run();
        System.out.println(System.currentTimeMillis() - a);


    }




}
