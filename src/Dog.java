public class Dog extends Animal implements AttackerInterface {
    private int attackerScore;
    public Dog(int age, int hp) {
        super(age, hp, true, "DOG", true, false, true, true);
        attackerScore = 50;
    }

    @Override
    public int getAttackerScore() {
        return attackerScore;
    }

    @Override
    public void getDeathScream() {
        setAlive(false);
        System.out.println("I'm a dead dog!");
    }

    @Override
    public void sayHello() {
        System.out.println("Voof,  I'm a DOG");
    }
}
