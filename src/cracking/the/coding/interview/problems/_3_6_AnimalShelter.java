package cracking.the.coding.interview.problems;

import java.util.LinkedList;
import java.util.Queue;

/*
    3.6
    Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
    out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
    or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
    that type). They cannot select which specific animal they would like. Create the data structures to
    maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
    and dequeueCat. You may use the built-in Linkedlist data structure.
*/

public class _3_6_AnimalShelter {
    public static class Animal {
        int arrivalTime = 0;

        Animal() {
        }

    }

    public static class Cat extends Animal {
        Cat() {
            super();
        }

        @Override
        public String toString() {
            return "Cat - " + super.arrivalTime;
        }
    }

    public static class Dog extends Animal {
        Dog() {
            super();
        }

        @Override
        public String toString() {
            return "Dog - " + super.arrivalTime;
        }
    }

    public static class AnimalShelter {
        private Queue<Dog> dogs = new LinkedList<>();
        private Queue<Cat> cats = new LinkedList<>();
        private static int order;

        /*
            Time: O(1)
        */

        public void enqueue(Animal animal) {
            animal.arrivalTime = order++;
            if (animal instanceof Cat) {
                cats.add((Cat) animal);
            } else if (animal instanceof Dog) {
                dogs.add((Dog) animal);
            } else {
                try {
                    throw new Exception("Animal type not supported");
                } catch (Exception e) {
                }
            }
        }

        /*
            Time: O(1)
        */

        public Animal dequeueAny() {

            if (cats.isEmpty() && dogs.isEmpty()) {
                try {
                    throw new Exception("There is no animals to return");
                } catch (Exception e) {
                    return null;
                }
            } else if (!cats.isEmpty() && !dogs.isEmpty()) {
                if (cats.peek().arrivalTime < dogs.peek().arrivalTime) {
                    return cats.poll();
                } else {
                    return dogs.poll();
                }
            } else if (dogs.isEmpty()) {
                return cats.poll();
            } else {
                return dogs.poll();
            }
        }

        /*
            Time: O(1)
        */

        public Dog dequeueDog() {
            try {
                return dogs.poll();
            } catch (Exception e) {
                return null;
            }
        }

        /*
            Time: O(1)
        */

        public Cat dequeueCat() {
            try {
                return cats.poll();
            } catch (Exception e) {
                return null;
            }
        }
    }


    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Cat());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Cat());
        shelter.enqueue(new Dog());
        shelter.enqueue(new Cat());

        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueAny());
        System.out.println(shelter.dequeueDog());
        System.out.println(shelter.dequeueCat());

    }


}
