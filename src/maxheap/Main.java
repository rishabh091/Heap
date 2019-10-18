package maxheap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size;
        Scanner io=new Scanner(System.in);

        System.out.println("Enter size : ");
        size=io.nextInt();
        Maxheap maxheap=new Maxheap(size);

        for(int i=0;i<size;i++){
            maxheap.insert(i);
        }
        maxheap.display();

        maxheap.deleteMax();
        maxheap.deleteMax();
        maxheap.display();
    }
}
