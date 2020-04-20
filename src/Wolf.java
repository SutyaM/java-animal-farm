public class Wolf extends Animal implements AttackerInterface {
    private int attackerScore;
    public Wolf(int age, int hp) {
        super(age, hp, true, "WOLF", false, false, false, false);
        attackerScore = 70;
    }
    @Override
    public int getAttackerScore() {
        return attackerScore;
    }

    @Override
    public void getDeathScream() {
        setAlive(false);
        System.out.println("I'm a dead wolf!");
    }

    @Override
    public void sayHello() {
        System.out.println("Oooooooowhooo,  I'm a WOLF");
    }
}
