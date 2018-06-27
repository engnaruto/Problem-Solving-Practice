package data.structures.implementations.hash.map;

public class Pair {

    public int key;
    public int value;


    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }


    @Override
//    public String toString() {
//        return "Key = " + key + " - Value = " + value;
//    }
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    @Override
    public int hashCode() {
        return ((key * 31 + 23) * 31) % (Integer.MAX_VALUE - 1);
    }


}
