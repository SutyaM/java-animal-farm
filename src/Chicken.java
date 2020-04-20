public class Chicken extends Animal{
    public Chicken(int age, int hp) {
        super(age, hp, true, "CHICKEN", true, true, false, false);
    }

    @Override
    public void getDeathScream() {
        setAlive(false);
        System.out.println("I'm a dead chicken!");
    }

    @Override
    public void sayHello() {
        System.out.println("Tiktik,  I'm a CHICKEN");
    }
}
