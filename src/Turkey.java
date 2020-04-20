public class Turkey extends Animal implements AttackerInterface {
    private int attackerScore;
    public Turkey(int age, int hp) {
        super(age, hp, true, "TURKEY", true, true, false, false);
        attackerScore = 30;
    }

    @Override
    public int getAttackerScore() {
        return attackerScore;
    }

    @Override
    public void getDeathScream() {
        setAlive(false);
        System.out.println("I'm a dead turkey!");
    }

    @Override
    public void sayHello() {
        System.out.println("Gulugulu,  I'm a TURKEY");
    }
}
