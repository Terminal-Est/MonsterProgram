
/**
 * The Monster class
 *
 * Keeps all the information about the monster.
 * 
 */
public class Monster
{
   private String name;

   private int strength;
   private int defense;
   private int health;
   private int MAXHEALTH;

   private String[] Size = { "Tiny", "Small", "Regular", "Large", "Massive" };
   private String[] Creature = { "Rat", "Goblin", "Naga", "Dragon", "Demon" };

   private int sizeIdx;
   private int creatureIdx;

   public Monster(int sizeIdx, int creatureIdx, int MAXHEALTH)
   {
      this.sizeIdx = sizeIdx;
      this.creatureIdx = creatureIdx;
      this.MAXHEALTH = MAXHEALTH;

      this.name = generateName();
      this.strength = initStrength();
      this.defense = initDefense();
      this.setHealth((this.creatureIdx + 1) * (this.defense + 1));
   }

   public String getName()
   {
      return this.name;
   }

   public int getDefense()
   {
      return this.defense;
   }

   public int getStrength()
   {
      return this.strength;
   }

   public int getHealth()
   {
      return this.health;
   }

   public void setHealth(int health)
   {
      if (health < this.MAXHEALTH)
         this.health = health;
      else
         this.health = this.MAXHEALTH;
   }

   /**
    * @return the name of the monster
    */
   private String generateName()
   {
      String name = Size[sizeIdx] + " " + Creature[creatureIdx];
      return name;
   }

   /**
    * @return the initial defense of the monster
    */
   private int initDefense()
   {
      int defense = sizeIdx + 4;

      if (creatureIdx == 1)
         defense -= 1;
      else if (creatureIdx == 3)
         defense *= 2;
      else
      {
         defense *= 3;
      }

      return defense;
   }

   /**
    * Setting the initial strength of the monster depending on it's size.
    * 
    * @return the initial strength of the monster
    */
   private int initStrength()
   {
      int strength = sizeIdx + 4;

      if (creatureIdx == 1)
         strength -= 1;
      else if (creatureIdx == 3)
         strength *= 2;
      else
      {
         strength *= 3;
      }

      return strength;
   }

}
