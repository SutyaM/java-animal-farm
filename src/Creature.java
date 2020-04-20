public abstract class Creature {
//    Creature: age, hp, live adattagok és egy getDethScream metódusa.
//    Amikor a hp-ja 0 alá akar csökkeni, akkor kell a live boolean-t false-re
//    állítani és kiírni az élőlény halálhörgését
    private int age;
    private int hp;
    private boolean alive;

    public Creature(int age, int hp, boolean alive) {
        this.age = age;
        this.hp = hp;
        this.alive = alive;
    }

    public abstract void getDeathScream();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp <= 0) {
            this.hp = 0;
            getDeathScream();
        } else {
            this.hp = hp;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
