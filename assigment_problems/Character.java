public class Character {
    // Private field for current health so it cannot be set directly
    private int health;
    // Final field for max health, fixed when the character is created
    private final int maxHealth;

    // Constructor sets maximum health and initializes current health to full
    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    // Reduces health, clamping it to a minimum of 0
    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }

    // Increases health, clamping it to a maximum of maxHealth
    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    // Read-only getter for current health (no setter provided)
    public int getHealth() {
        return this.health;
    }

    // Read-only getter for max health
    public int getMaxHealth() {
        return this.maxHealth;
    }

    // Main method demonstrating expected behavior from sample input/output
    public static void main(String[] args) {
        Character c = new Character(100);

        // Takes 30 damage -> health becomes 70
        c.takeDamage(30);
        System.out.println("Health after 30 damage: " + c.getHealth());

        // Heal 50 -> capped at 100
        c.heal(50);
        System.out.println("Health after 50 heal: " + c.getHealth());

        // Takes 150 damage -> floored at 0
        c.takeDamage(150);
        System.out.println("Health after 150 damage: " + c.getHealth());
    }
}