import java.util.ArrayList;
import java.util.Scanner;

public class Multithreading {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> task = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数字x：");
        int x = scanner.nextInt();
        long start = System.currentTimeMillis();
        int group = 80;//线程数
        Ans.ans = new long[group];
        long len = 1000000000 / group;
        for (long i = 0; i < group; i++) {
            task.add(new MyTask(i * len, (i + 1) * len, x, i));
        }
        for (int i = 0; i < group; i++) {
            task.get(i).start();
        }
        for (int i = 0; i < group; i++) {
            task.get(i).join();
        }
        System.out.println("计算结果为: " + Ans.sum());
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("耗时 " + elapsed + " ms");
    }
}

class Ans {
    public static long[] ans;

    public static long sum() {
        long s = 0;
        for (long i : ans) {
            s += i;
        }
        return s;
    }

    public void add(long t, int choice) {
        ans[choice] += t;
    }
}


class MyTask extends Thread {
    private final long begin, end;
    private final int x;
    private final int choice;

    MyTask(long b, long e, int xx, long c) {
        begin = b;
        end = e;
        x = xx;
        choice = (int) c;
    }

    @Override
    public void run() {
        Ans a = new Ans();
        for (long i = begin; i < end; i++) {
            if (contain(i, x)) {
                a.add(i, choice);
            }
        }
    }

    private static boolean contain(long num, int x) {
        return String.valueOf(num).contains(String.valueOf(x));
    }
}