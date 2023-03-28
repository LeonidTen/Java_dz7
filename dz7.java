//Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин. 
//На базе описания персонажей описать простейшую иерархию классов. В основной программе создать по одному экземпляру каждого класса.

public abstract class Character {
    private String name;
    private int health;
    private int strength;

    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void attack(Character enemy) {
        enemy.takeDamage(this.strength);
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println(this.name + " уже умер.");
        }
    }
}

public class Mage extends Character {
    private int mana;

    public Mage(String name, int health, int strength, int mana) {
        super(name, health, strength);
        this.mana = mana;
    }

    public void castSpell(Character enemy) {
        if (this.mana >= 10) {
            enemy.takeDamage(this.getStrength() * 2);
            this.mana -= 10;
        } else {
            System.out.println(this.getName() + " не хватает маны для произнесения заклинания.");
        }
    }
}

public class Monk extends Character {
    private int chi;

    public Monk(String name, int health, int strength, int chi) {
        super(name, health, strength);
        this.chi = chi;
    }

    public void heal() {
        if (this.chi >= 5) {
            this.health += 10;
            this.chi -= 5;
        } else {
            System.out.println(this.getName() + " не хватает ци для лечения.");
        }
    }
}

public class Rogue extends Character {
    private int energy;

    public Rogue(String name, int health, int strength, int energy) {
        super(name, health, strength);
        this.energy = energy;
    }

    public void backstab(Character enemy) {
        if (this.energy >= 5) {
            enemy.takeDamage(this.getStrength() * 3);
            this.energy -= 5;
        } else {
            System.out.println(this.getName() + " не хватает энергии для удара в спину.");
        }
    }
}

public class Spearman extends Character {
    private int stamina;

    public Spearman(String name, int health, int strength, int stamina) {
        super(name, health, strength);
        this.stamina = stamina;
    }

    public void thrust(Character enemy) {
        if (this.stamina >= 10) {
            enemy.takeDamage(this.getStrength() * 2);
            this.stamina -= 10;
        } else {
            System.out.println(this.getName() + " не хватает выносливости для броска.");
        }
    }
}

public class Sniper extends Character {
    private int ammo;

    public Sniper(String name, int health, int strength, int ammo) {
        super(name, health, strength);
        this.ammo = ammo;
    }

    public void shoot(Character enemy) {
        if (this.ammo >= 1) {
            enemy.takeDamage(this.getStrength() * 4);
            this.ammo -= 1;
        } else {
            System.out.println(this.getName() + " закончились патроны.");
        }
    }
}

public class Crossbowman extends Character {
    private int bolts;

    public Crossbowman(String name, int health, int strength, int bolts) {
        super(name, health, strength);
        this.bolts = bolts;
    }

    public void fireBolt(Character enemy) {
        if (this.bolts >= 1)