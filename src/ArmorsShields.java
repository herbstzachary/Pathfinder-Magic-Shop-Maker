import java.util.Map;

public class ArmorsShields {
	
	private class Armor{
		public String name;
		public int cost; //in gp
		//search for shield in name
		
		Armor(String name, int cost){
			this.name = name;
			this.cost = cost;
		}
	}
	
	private class Enchantment{
		public String name;
		public int bonus;
		public int additionalCost;//only relevant for some, 0 if none listed
		
		Enchantment(String name, int bonus, int cost){
			this.name = name;
			this.bonus = bonus;
			this.additionalCost = cost;
		}
	}
	
	//Lists of items, use rand(1,100) % arraySize
	
   Armor[] baseArmorList = new Armor[] {
		   new Armor("Leather", 10),
		   new Armor("Hide shirt", 20),
		   new Armor("Studded Leather", 25)
   };
   
   Armor[] baseShieldList = new Armor[] {
		   new Armor("Light Steel Shield", 9),
		   new Armor("Heavy Steel Shield", 20)
   };
	
   Enchantment[] armorEnchantmentsLevel1 = new Enchantment[] {
		   new Enchantment("Benevolent", 1, 2000),
		   new Enchantment("Poison-resistant", 1, 2250),
		   new Enchantment("Balanced", 1, 0),
		   new Enchantment("Bitter", 1, 0),
		   new Enchantment("Bolstering", 1, 0),
		   new Enchantment("Brawling", 1, 0),
		   new Enchantment("Champion", 1, 0),
		   new Enchantment("Dastard", 1, 0),
		   new Enchantment("Deathless", 1, 0),
		   new Enchantment("Defiant", 1, 0),
		   new Enchantment("Fortification (light)", 1, 0),
		   new Enchantment("Grinding", 1, 0),
		   new Enchantment("Impervious", 1, 0),
		   new Enchantment("Mirrored", 1, 0),
		   new Enchantment("Spell Storing", 1, 0),
		   new Enchantment("Stanching", 1, 0),
		   new Enchantment("Warding", 1, 0),
   };
   
   Enchantment[] armorEnchantmentsLevel2 = new Enchantment[] {
		   new Enchantment("Glamered", 2, 2700),
		   new Enchantment("Jousting", 2, 3750),
		   new Enchantment("Shadow", 2, 3750),
		   new Enchantment("Slick", 2, 3750),
		   new Enchantment("Expeditious", 2, 4000),
		   new Enchantment("Creeping", 2, 5000),
		   new Enchantment("Rallying", 2, 5000),
		   new Enchantment("Spell Resistance (13)", 2, 0)
   };
   
   Enchantment[] armorEnchantmentsLevel3 = new Enchantment[] {
		   new Enchantment("Adhesive", 3, 7000),
		   new Enchantment("Hosteling", 3, 7500),
		   new Enchantment("Radiant", 3, 7500),
		   new Enchantment("Delving", 3, 10000),
		   new Enchantment("Putrid", 3, 10000),
		   new Enchantment("Fortification (moderate)", 3, 0),
		   new Enchantment("Ghost Touch", 3, 0),
		   new Enchantment("Invulnerability", 3, 0),
		   new Enchantment("Spell Resistance (15)", 3, 0),
		   new Enchantment("Titanic", 3, 0),
		   new Enchantment("Wild", 3, 0)
   };
   
   Enchantment[] armorEnchantmentsLevel4 = new Enchantment[] {
		   new Enchantment("Harmonizing", 4, 15000),
		   new Enchantment("Improved Shadow", 4, 15000),
		   new Enchantment("Improved Slick", 4, 15000),
		   new Enchantment("Energy Resistance", 4, 18000),
		   new Enchantment("Martyring", 4, 18000),
		   new Enchantment("Spell Resistance (17)", 4, 0)
   };
 
   Enchantment[] armorEnchantmentsLevel5 = new Enchantment[] {
		   new Enchantment("Righteous", 5, 27000),
		   new Enchantment("Unbound", 5, 27000),
		   new Enchantment("Unrighteous", 5, 27000),
		   new Enchantment("Vigilant", 5, 27000),
		   new Enchantment("Determination", 5, 30000),
		   new Enchantment("Greater Shadow", 5, 33750),
		   new Enchantment("Greater Slick", 5, 33750),
		   new Enchantment("Improved Energy Resistance", 5, 42000),
		   new Enchantment("Etherealness", 5, 49000),
		   new Enchantment("Greater Energy Resistance", 5, 66000),
		   new Enchantment("Fortification (heavy)", 5, 0),
		   new Enchantment("Spell Resistance (19)", 5, 0)
   };
   
   Armor[] lesserMinorSpecificMagicArmor = new Armor[] {
		   new Armor("Mithral Shirt", 1100)
		   
		   //Masterwork? special quality?
   };
   
   Armor[] greaterMinorSpecificMagicArmor = new Armor[] {
		   new Armor("Mistmail", 2250),
		   new Armor("Otyugh Hide", 2565),
		   new Armor("Dragonhide Plate", 3300)
   };
   
   Armor[] lesserMediumSpecificMagicArmor = new Armor[] {
		   new Armor("Elven Chain", 5150),
		   new Armor("Rhino Hide", 5165),
		   new Armor("Morlock Hide", 8910)
   };
   
   Armor[] greaterMediumSpecificMagicArmor = new Armor[] {
		   new Armor("Adamantine Breastplate", 10200),
		   new Armor("Soothsayer's Raiment", 10300),
		   new Armor("Equestrian Plate", 10650),
		   new Armor("Enchanted Eelskin", 11160),
		   new Armor("Boneless Leather", 12160),
		   new Armor("Murderer's Blackcloth", 12405),
		   new Armor("Folding Plate", 12650),
		   new Armor("Breastplate of Vanishing", 15200)
   };
   
   Armor[] lesserMajorSpecificMagicArmor = new Armor[] {
		   new Armor("Armor of Insults", 16175),
		   new Armor("Dwarven Plate", 16500),
		   new Armor("Banded Mail of Luck", 18900),
		   new Armor("Catskin Leather", 18910),
		   new Armor("Celestial Armor", 22400),
		   new Armor("Buccaneer's Breastplate", 23850),
		   new Armor("Plate Armor of the Deep", 24650)
   };
   
   Armor[] greaterMajorSpecificMagicArmor = new Armor[] {
		   new Armor("Breastplate of Command", 25400),
		   new Armor("Forsaken Banded Mail", 25400),
		   new Armor("Mithral Full Plate of Speed", 26500),
		   new Armor("Warden of the Woods", 29350),
		   new Armor("Scarab Breastplate", 32350),
		   new Armor("Giant-Hide Armor (Ogre)", 39165),
		   new Armor("Hamatula Hide", 44215),
		   new Armor("Giant-Hide Armor (Hill Giant)", 46665),
		   new Armor("Demon Armor", 52260),
		   new Armor("Giant-Hide Armor (Stone, Fire, or Frost Giant)", 54165),
		   new Armor("Giant-Hide Armor (Troll)", 59165),
		   new Armor("Mail of Malevolence", 61300),
		   new Armor("Giant-Hide Armor (Cloud Giant)", 69165),
		   new Armor("Giant-Hide Armor (Storm Giant)", 76665),
		   new Armor("Daystar Half-Plate", 81250),
		   new Armor("Invincible Armor", 137650),
		   new Armor("Prismatic Plate", 160650)				   
   };

   Enchantment[] shieldEnchantmentsLevel1 = new Enchantment[] {
		   new Enchantment("Poison-resistant", 1, 2250),
		   new Enchantment("Arrow Catching", 1, 0),
		   new Enchantment("Bashing", 1, 0),
		   new Enchantment("Binding",1, 0),
		   new Enchantment("Clangorous", 1, 0),
		   new Enchantment("Defiant", 1, 0),
		   new Enchantment("Fortification (light)", 1, 0),
		   new Enchantment("Grinding", 1, 0),
		   new Enchantment("Impervious", 1, 0),
		   new Enchantment("Mirrored", 1, 0),
		   new Enchantment("Ramming", 1, 0)
   };
   
   Enchantment[] shieldEnchantmentLevel2 = new Enchantment[]{
		   new Enchantment("Rallying", 2, 5000),
		   new Enchantment("Wyrmsbreath", 2, 5000),
		   new Enchantment("Animated", 2, 0),
		   new Enchantment("Arrow Deflection", 2, 0),
		   new Enchantment("Merging", 2, 0),
		   new Enchantment("Spell Resistance (13)", 2, 0)
   };
   
   Enchantment[] shieldEnchantmentLevel3 = new Enchantment[]{
		   new Enchantment("Hosteling", 3, 7500),
		   new Enchantment("Radiant", 3, 7500),
		   new Enchantment("Fortification (moderate)", 3, 0),
		   new Enchantment("Ghost Touch", 3, 0),
		   new Enchantment("Spell Resistance (15)", 3, 0),
		   new Enchantment("Wild", 3, 0)
   };
   
   Enchantment[] shieldEnchantmentLevel4 = new Enchantment[]{
		   new Enchantment("Energy Resistance", 4, 18000),
		   new Enchantment("Spell Resistance (17)", 4, 0)
   };
   
   Enchantment[] shieldEnchantmentLevel5 = new Enchantment[]{
		   new Enchantment("Determination", 5, 30000),
		   new Enchantment("Improved Energy Resistance", 5, 42000),
		   new Enchantment("Undead Controlling", 5, 49000),
		   new Enchantment("Greater Energy Resistance", 5, 66000),
		   new Enchantment("Fortification (heavy)", 5, 0),
		   new Enchantment("Reflecting", 5, 0),
		   new Enchantment("Spell Resistance (19)", 5, 0)
   };
   
   Armor[] lesserMinorSpecificMagicShields = new Armor[] {
		   new Armor("Living Steel Heavy Shield", 120),
		   new Armor("Darkwood Buckler", 203),
		   new Armor("Darkwood Shield", 257),
		   new Armor("Mithral Heavy Shield", 1020)
   };
   
   Armor[] greaterMinorSpecificMagicShields = new Armor[] {
		   new Armor("Zombie Skin Shield", 2159),
		   new Armor("Caster's Shield", 3153),
		   new Armor("Burglar's Buckler", 4655)
   };
   
   Armor[] lesserMediumSpecificMagicShields = new Armor[] {
		   new Armor("Spined Shield", 5580),
		   new Armor("Dragonslayer's Shield", 7170),
		   new Armor("Collapsible Tower", 8170),
		   new Armor("Lion's Shield", 9170)
   };
   
   Armor[] greaterMediumSpecificMagicShields = new Armor[] {
		   new Armor("Greater Caster's Shield", 10153),
		   new Armor("Celestial Shield", 13170),
		   new Armor("Maelstrom Shield", 14170),
		   new Armor("Volcanic Shield", 14170),
		   new Armor("Tempest Shield", 15170)
   };
   
   Armor[] lesserMajorSpecificMagicShields = new Armor[] {
		   new Armor("Battlement Shield", 16180),
		   new Armor("Winged Shield", 17257),
		   new Armor("Avalanche Shield", 19170),
		   new Armor("Fortress Shield", 19180),
		   new Armor("Wyrmslayer's Shield", 20170)
   };
   
   Armor[] greaterMajorSpecificMagicShields = new Armor[] {
		   new Armor("Spell Ward Tower Shield", 25810),
		   new Armor("Quick Block Buckler", 36155),
		   new Armor("Belligerent Shield", 36170),
		   new Armor("Force Tower", 46030),
		   new Armor("Absorbing Shield", 50170),
		   new Armor("Elysian Shield", 52620)
   };
   
   // add costs (bonus cost is (bonus * 1k)^2)
	
}


