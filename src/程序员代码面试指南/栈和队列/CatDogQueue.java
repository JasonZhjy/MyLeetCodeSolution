package 程序员代码面试指南.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class CatDogQueue {
    public class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue (Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet () {
            return pet;
        }

        public long getCount () {
            return count;
        }

        public String getPetType () {
            return this.pet.getType();
        }
    }

    public class DogCatQueue {
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private long count;

        public DogCatQueue () {
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
            count = 0;
        }

        public void add (Pet pet) {
            if ("dog".equals(pet.getType())) {
                dogQueue.add(new PetEnterQueue(pet, this.count++));
            } else if ("cat".equals(pet.getType())) {
                catQueue.add(new PetEnterQueue(pet, this.count++));
            } else {
                throw new RuntimeException("error, no cat or dog");
            }
        }

        public Pet pollAll () {
            Pet pet;
            if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
                if (dogQueue.peek().count < catQueue.peek().count) {
                    pet = dogQueue.poll().getPet();
                } else {
                    pet = catQueue.poll().getPet();
                }
            } else if (!dogQueue.isEmpty()) {
                pet = dogQueue.poll().getPet();
            } else {
                pet = catQueue.poll().getPet();
            }

            return pet;
        }
    }

}

class Pet {
    private String type;

    public Pet (String type) {
        this.type = type;
    }

    public String getType () {
        return type;
    }
}

class Dog extends Pet {

    public Dog () {
        super("dog");
    }
}

class Cat extends Pet {

    public Cat () {
        super("cat");
    }
}
