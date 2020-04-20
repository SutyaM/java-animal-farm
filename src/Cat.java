public class Cat extends Animal {
    public Cat(int age, int hp) {
        super(age, hp, true, "CAT", true, false, true, false);
    }

    @Override
    public void getDeathScream() {
        setAlive(false);
        System.out.println("I'm a dead cat!");
    }

    @Override
    public void sayHello() {
        System.out.println("Meow,  I'm a CAT");
    }
}
