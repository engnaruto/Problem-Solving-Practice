package data.structures.implementations.hash.map;


import java.util.LinkedList;

public class HashMap {

    private int hashMapLength = 10;
    private LinkedList<Pair>[] map;


    public HashMap() {
        map = new LinkedList[hashMapLength];
        for (int i = 0; i < map.length; i++) {
            map[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        Pair pair = new Pair(key, value);
        int index = getHashcode(key);
        map[index].add(pair);
    }

    public int get(int key) {
        int index = getHashcode(key);
        LinkedList<Pair> list = map[index];
        for (Pair aList : list) {
            if (aList.key == key) {
                return aList.value;
            }
        }
        return Integer.MAX_VALUE;
    }

    private int getHashcode(int key) {
        return (key * 21 + 23) % hashMapLength;
    }


    public void print() {
        for (LinkedList<Pair> list : map) {
            System.out.println(list.toString());
        }
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put(1, 2);
        map.put(1100, 20);
        map.put(3654, 120);
        map.put(5684, 302);
        map.put(98765, 562);

        map.print();
        System.out.println(map.get(5684));
        System.out.println(map.get(5));
    }

}
