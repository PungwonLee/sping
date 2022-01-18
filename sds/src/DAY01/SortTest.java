package DAY01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 2, 3);
        Item item2 = new Item(2, 2, 3);
        Item item3 = new Item(1, 3, 1);
        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);
    }
}

class Item implements Comparable<Item> {
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Item{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    // 양수 :  Swap
    // 0과 음수 : 변화X

    @Override
    public int compareTo(Item o) {
        int compare1 = Integer.compare(a, o.a);
        if (compare1 == 0) {
            return Integer.compare(b, o.b);
        } else {
            return compare1;
        }
        /*  if (a > o.a) {
            return -1;
        } else if (a == o.a) {
            return 0;
        } else {
            return 1;
        }*/
    }
}