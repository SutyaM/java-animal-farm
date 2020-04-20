public class FarmMain {
    public static void main(String[] args) {

        Creature[] creatures = generateFarm(100);
        while (stillAlive(creatures)) {
            nextEvent(creatures);
        }
    }

    private static boolean stillAlive(Creature[] creatures) {
        if (wolfAlive(creatures) && notWolfAlive(creatures)) return true;
        return false;
    }

    private static boolean wolfAlive(Creature[] creatures) {
        for (Creature creature : creatures) {
            if (creature instanceof Wolf && creature.isAlive()) return true;
        }
        return false;
    }

    private static boolean notWolfAlive(Creature[] creatures) {
        for (Creature creature : creatures) {
            if (!(creature instanceof Wolf)&& creature.isAlive()) return true;
        }
        return false;
    }

    private static int randomCreature(int length) {
        return (int)(Math.random() * length);
    }

    private static int selectLiveAttacker(Creature[] creatures) {
        int max = creatures.length;
        int i = randomCreature(max);
        while (!(creatures[i] instanceof Wolf && creatures[i].isAlive())) {
            i = randomCreature(max);
        }
        return i;
    }

    private static int selectLiveVictim(Creature[] creatures) {
        int max = creatures.length;
        int i = randomCreature(max);
        while (!(!(creatures[i] instanceof Wolf) && creatures[i].isAlive())) {
            i = randomCreature(max);
        }
        return i;
    }

    public static void nextEvent(Creature[] creatures) {
        int attacker = selectLiveAttacker(creatures);
        int victim = selectLiveVictim(creatures);
        fight((Wolf) creatures[attacker], (Animal) creatures[victim], creatures);
    }

    public static Creature[] generateFarm(int numOfCreatures) {
        Creature[] creatures = new Creature[numOfCreatures];
        for (int i = 0; i < numOfCreatures; i++) {
            double random = Math.random();
            if (random <= 0.05) {
                creatures[i] = new Turkey(2, 80);
            } else if (random <= 0.1) {
                creatures[i] = new Cat(3, 70);
            } else if (random <= 0.2) {
                creatures[i] = new Dog(4, 100);
            } else if (random <= 0.4) {
                creatures[i] = new Wolf(5, 120);
            } else if (random > 0.4) {
                creatures[i] = new Chicken(1, 30);
            }
        }
        return creatures;
    }

    private static Dog[] getDogs(Creature[] creatures) {
        int dogCount = 0;
        for (Creature creature : creatures) {
            if (creature instanceof Dog && creature.isAlive()) {
                dogCount++;
            }
        }
        Dog[] dogs = new Dog[dogCount];
        dogCount = 0;
        for (Creature creature : creatures) {
            if (creature instanceof Dog && creature.isAlive()) {
                dogs[dogCount] = (Dog) creature;
                dogCount++;
            }
        }
        return dogs;
    }

    private static void alertDogs(Wolf attacker, Dog defender, Creature[] creatures) {
        Dog[] dogs = getDogs(creatures);
        for (Dog dog : dogs) {
            if (defender == dog) {
                continue;
            }
            if (attacker.getHp() > 0) {
                System.out.println("Voof! ");
                attacker.setHp(attacker.getHp() - dog.getAttackerScore());
            }
        }
    }

    private static void fight(Wolf attacker, Animal victim, Creature[] creatures) {
        while (attacker.isAlive() && victim.isAlive()) {
            attacker.sayHello();
            victim.sayHello();
            victim.setHp(victim.getHp() - attacker.getAttackerScore());
            if (victim instanceof AttackerInterface) {
                if (victim.isAlive()) {
                    AttackerInterface defender = (AttackerInterface) victim;
                    attacker.setHp(attacker.getHp() - defender.getAttackerScore());
                    if (defender instanceof Dog) {
                        System.out.println("ARH-WOOOOOOOOOO!");
                        Dog dog = (Dog) defender;
                        alertDogs(attacker, dog, creatures);
                    }
                }
            }
        }
        System.out.println("------------------------------");
    }
}
