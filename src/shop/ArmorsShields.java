package shop;
import java.util.Map;
import java.util.Random;

public class ArmorsShields {
	
	public Equipment armorShield;
	
	public class Equipment{
		public String name;
		public int cost; //in gp
		private int totalEchantmentBonus = 0;// use this to determine cost of enchantments
		
		Equipment(String name, int cost){
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
	
	private Equipment[] baseArmorList = new Equipment[] {
		   new Equipment("Padded", 5),
		   new Equipment("Leather", 10),
		   new Equipment("Studded Leather", 25),
		   new Equipment("Chain Shirt", 20),
		   new Equipment("Hide", 15),
		   new Equipment("Scale Mail", 50),
		   new Equipment("Breastplate", 200),
		   new Equipment("Chainmail", 150),
		   new Equipment("Banded Mail", 250),
		   new Equipment("Splint Mail", 200),
		   new Equipment("Half-Plate", 600),
		   new Equipment("Full Plate", 1500)
	};
   
	private Equipment[] baseShieldList = new Equipment[] {
		   new Equipment("Buckler", 5),
		   new Equipment("Light Steel Shield", 9),
		   new Equipment("Light Wooden Shield", 3),
		   new Equipment("Heavy Steel Shield", 20),
		   new Equipment("Heavy Wooden Shield", 7),
		   new Equipment("Tower Shield", 30)
	};
	
	private Enchantment[] baseEnchantments = new Enchantment[] {
			new Enchantment("+1", 1, 0),
			new Enchantment("+2", 2, 0),
			new Enchantment("+3", 3, 0),
			new Enchantment("+4", 4, 0),
			new Enchantment("+5", 5, 0)
	};
	
	private Enchantment[] armorEnchantmentsLevel1 = new Enchantment[] {
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
   
	private Enchantment[] armorEnchantmentsLevel2 = new Enchantment[] {
		   new Enchantment("Glamered", 2, 2700),
		   new Enchantment("Jousting", 2, 3750),
		   new Enchantment("Shadow", 2, 3750),
		   new Enchantment("Slick", 2, 3750),
		   new Enchantment("Expeditious", 2, 4000),
		   new Enchantment("Creeping", 2, 5000),
		   new Enchantment("Rallying", 2, 5000),
		   new Enchantment("Spell Resistance (13)", 2, 0)
	};
   
	private Enchantment[] armorEnchantmentsLevel3 = new Enchantment[] {
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
   
	private Enchantment[] armorEnchantmentsLevel4 = new Enchantment[] {
		   new Enchantment("Harmonizing", 4, 15000),
		   new Enchantment("Improved Shadow", 4, 15000),
		   new Enchantment("Improved Slick", 4, 15000),
		   new Enchantment("Energy Resistance", 4, 18000),
		   new Enchantment("Martyring", 4, 18000),
		   new Enchantment("Spell Resistance (17)", 4, 0)
	};
 
	private Enchantment[] armorEnchantmentsLevel5 = new Enchantment[] {
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
   
	private Equipment[] lesserMinorSpecificMagicArmor = new Equipment[] {
		   new Equipment("Mithral Shirt", 1100)
		   
		   //Masterwork? special quality?
	};
   
	private Equipment[] greaterMinorSpecificMagicArmor = new Equipment[] {
		   new Equipment("Mistmail", 2250),
		   new Equipment("Otyugh Hide", 2565),
		   new Equipment("Dragonhide Plate", 3300)
	};
   
	private Equipment[] lesserMediumSpecificMagicArmor = new Equipment[] {
		   new Equipment("Elven Chain", 5150),
		   new Equipment("Rhino Hide", 5165),
		   new Equipment("Morlock Hide", 8910)
	};
   
	private Equipment[] greaterMediumSpecificMagicArmor = new Equipment[] {
		   new Equipment("Adamantine Breastplate", 10200),
		   new Equipment("Soothsayer's Raiment", 10300),
		   new Equipment("Equestrian Plate", 10650),
		   new Equipment("Enchanted Eelskin", 11160),
		   new Equipment("Boneless Leather", 12160),
		   new Equipment("Murderer's Blackcloth", 12405),
		   new Equipment("Folding Plate", 12650),
		   new Equipment("Breastplate of Vanishing", 15200)
	};
   
	private Equipment[] lesserMajorSpecificMagicArmor = new Equipment[] {
		   new Equipment("Equipment of Insults", 16175),
		   new Equipment("Dwarven Plate", 16500),
		   new Equipment("Banded Mail of Luck", 18900),
		   new Equipment("Catskin Leather", 18910),
		   new Equipment("Celestial Equipment", 22400),
		   new Equipment("Buccaneer's Breastplate", 23850),
		   new Equipment("Plate Equipment of the Deep", 24650)
	};
   
	private Equipment[] greaterMajorSpecificMagicArmor = new Equipment[] {
		   new Equipment("Breastplate of Command", 25400),
		   new Equipment("Forsaken Banded Mail", 25400),
		   new Equipment("Mithral Full Plate of Speed", 26500),
		   new Equipment("Warden of the Woods", 29350),
		   new Equipment("Scarab Breastplate", 32350),
		   new Equipment("Giant-Hide Equipment (Ogre)", 39165),
		   new Equipment("Hamatula Hide", 44215),
		   new Equipment("Giant-Hide Equipment (Hill Giant)", 46665),
		   new Equipment("Demon Equipment", 52260),
		   new Equipment("Giant-Hide Equipment (Stone, Fire, or Frost Giant)", 54165),
		   new Equipment("Giant-Hide Equipment (Troll)", 59165),
		   new Equipment("Mail of Malevolence", 61300),
		   new Equipment("Giant-Hide Equipment (Cloud Giant)", 69165),
		   new Equipment("Giant-Hide Equipment (Storm Giant)", 76665),
		   new Equipment("Daystar Half-Plate", 81250),
		   new Equipment("Invincible Equipment", 137650),
		   new Equipment("Prismatic Plate", 160650)				   
	};

	private Enchantment[] shieldEnchantmentsLevel1 = new Enchantment[] {
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
   
	private Enchantment[] shieldEnchantmentLevel2 = new Enchantment[]{
		   new Enchantment("Rallying", 2, 5000),
		   new Enchantment("Wyrmsbreath", 2, 5000),
		   new Enchantment("Animated", 2, 0),
		   new Enchantment("Arrow Deflection", 2, 0),
		   new Enchantment("Merging", 2, 0),
		   new Enchantment("Spell Resistance (13)", 2, 0)
	};
   
	private Enchantment[] shieldEnchantmentLevel3 = new Enchantment[]{
		   new Enchantment("Hosteling", 3, 7500),
		   new Enchantment("Radiant", 3, 7500),
		   new Enchantment("Fortification (moderate)", 3, 0),
		   new Enchantment("Ghost Touch", 3, 0),
		   new Enchantment("Spell Resistance (15)", 3, 0),
		   new Enchantment("Wild", 3, 0)
	};
   
	private Enchantment[] shieldEnchantmentLevel4 = new Enchantment[]{
		   new Enchantment("Energy Resistance", 4, 18000),
		   new Enchantment("Spell Resistance (17)", 4, 0)
	};
   
	private Enchantment[] shieldEnchantmentLevel5 = new Enchantment[]{
		   new Enchantment("Determination", 5, 30000),
		   new Enchantment("Improved Energy Resistance", 5, 42000),
		   new Enchantment("Undead Controlling", 5, 49000),
		   new Enchantment("Greater Energy Resistance", 5, 66000),
		   new Enchantment("Fortification (heavy)", 5, 0),
		   new Enchantment("Reflecting", 5, 0),
		   new Enchantment("Spell Resistance (19)", 5, 0)
	};
   
	private Equipment[] lesserMinorSpecificMagicShields = new Equipment[] {
		   new Equipment("Living Steel Heavy Shield", 120),
		   new Equipment("Darkwood Buckler", 203),
		   new Equipment("Darkwood Shield", 257),
		   new Equipment("Mithral Heavy Shield", 1020)
	};
   
	private Equipment[] greaterMinorSpecificMagicShields = new Equipment[] {
		   new Equipment("Zombie Skin Shield", 2159),
		   new Equipment("Caster's Shield", 3153),
		   new Equipment("Burglar's Buckler", 4655)
	};
   
	private Equipment[] lesserMediumSpecificMagicShields = new Equipment[] {
		   new Equipment("Spined Shield", 5580),
		   new Equipment("Dragonslayer's Shield", 7170),
		   new Equipment("Collapsible Tower", 8170),
		   new Equipment("Lion's Shield", 9170)
	};
   
	private Equipment[] greaterMediumSpecificMagicShields = new Equipment[] {
		   new Equipment("Greater Caster's Shield", 10153),
		   new Equipment("Celestial Shield", 13170),
		   new Equipment("Maelstrom Shield", 14170),
		   new Equipment("Volcanic Shield", 14170),
		   new Equipment("Tempest Shield", 15170)
	};
   
	private Equipment[] lesserMajorSpecificMagicShields = new Equipment[] {
		   new Equipment("Battlement Shield", 16180),
		   new Equipment("Winged Shield", 17257),
		   new Equipment("Avalanche Shield", 19170),
		   new Equipment("Fortress Shield", 19180),
		   new Equipment("Wyrmslayer's Shield", 20170)
	};
   
	private Equipment[] greaterMajorSpecificMagicShields = new Equipment[] {
		   new Equipment("Spell Ward Tower Shield", 25810),
		   new Equipment("Quick Block Buckler", 36155),
		   new Equipment("Belligerent Shield", 36170),
		   new Equipment("Force Tower", 46030),
		   new Equipment("Absorbing Shield", 50170),
		   new Equipment("Elysian Shield", 52620)
	};
   
	public ArmorsShields(Rarity type) {
		
	   Random randGenerator = new Random();
	   int d;
	   
	   boolean isShield = false;
	   if (randGenerator.nextInt(2) == 0) {
		   isShield = true;
		   armorShield = baseShieldList[randGenerator.nextInt(baseShieldList.length)];
	   }
	   else {
		   armorShield = baseArmorList[randGenerator.nextInt(baseArmorList.length)];
	   }
	   
		// add costs (bonus cost is (bonus * 1k)^2)
	   if (type == Rarity.MINOR) {
		   if (randGenerator.nextInt(2) == 0) {
			   //Lesser
			   d = randGenerator.nextInt(100) + 1;
			   if (d <= 80) {
				   //+1 Equipment
				   addEnchantmentsToArmorShield(new Enchantment[] {baseEnchantments[0]});
			   }
			   else {
				   //lesser minor specific
				   if (isShield) {
					   armorShield = lesserMinorSpecificMagicShields[(randGenerator.nextInt(lesserMinorSpecificMagicShields.length))];
				   }
				   else {
					   armorShield = lesserMinorSpecificMagicArmor[(randGenerator.nextInt(lesserMinorSpecificMagicArmor.length))];
				   }
			   }
		   }
		   else {
			   //Greater
			   d = randGenerator.nextInt(100) + 1;
			   if (d <= 26) {
				   //+1
				   addEnchantmentsToArmorShield(new Enchantment[] {baseEnchantments[0]});
			   }
			   else if (d <= 53) {
				   //+2
				   addEnchantmentsToArmorShield(new Enchantment[] {baseEnchantments[1]});
			   }
			   else if (d <= 80) {
				   //+1 with +1 ability
				   if (isShield) {
					   addEnchantmentsToArmorShield(new Enchantment[] {shieldEnchantmentsLevel1[(randGenerator.nextInt(shieldEnchantmentsLevel1.length))], baseEnchantments[0]});
				   }
				   else {
					   addEnchantmentsToArmorShield(new Enchantment[] {armorEnchantmentsLevel1[(randGenerator.nextInt(armorEnchantmentsLevel1.length))], baseEnchantments[0]});
				   }
			   }
			   else {
				   //greater minor
				   armorShield = greaterMinorSpecificMagicArmor[(randGenerator.nextInt(greaterMinorSpecificMagicArmor.length))];
			   }
		   }
	   }
	   else if (type == Rarity.MEDIUM) {
		   if (randGenerator.nextInt(2) == 0) {
			   //Lesser 
		   }
		   else {
			   //Greater
		   }
	   }
	   else if (type == Rarity.MAJOR) {
		   if (randGenerator.nextInt(2) == 0) {
			   //Lesser 
		   }
		   else {
			   //Greater
		   }
	   }
	}
	
	private void addEnchantmentsToArmorShield(Enchantment[] enchantments) {
		for (int i = 0; i < enchantments.length; i++) {
			armorShield.name = enchantments[i].name + " " + armorShield.name;
			armorShield.totalEchantmentBonus +=  enchantments[i].bonus;
			armorShield.cost += enchantments[i].additionalCost;
		}
		armorShield.cost += Math.pow(armorShield.totalEchantmentBonus, 2) * 1000;
	}
}


