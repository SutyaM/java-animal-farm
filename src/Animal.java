public abstract class Animal extends Creature {
//    Animal: Creature utóda, az alábbi flag-ekkel kell hogy rendelkezzen:
//    típus, domestic, edible, forFun, forSecure + legyen egy sayHello metódusa
    private String type;
    private boolean domestic;
    private boolean edible;
    private boolean pet;
    private boolean guard;

    public Animal(int age, int hp, boolean alive, String type, boolean domestic, boolean edible, boolean pet, boolean guard) {
        super(age, hp, alive);
        this.type = type;
        this.domestic = domestic;
        this.edible = edible;
        this.pet = pet;
        this.guard = guard;
    }

    public abstract void sayHello();
}
