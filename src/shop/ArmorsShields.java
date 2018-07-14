package shop;
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
		
		Enchantment(String name, int bonus){
			this.name = name;
			this.bonus = bonus;
			this.additionalCost = 0;
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
			new Enchantment("+1", 1),
			new Enchantment("+2", 2),
			new Enchantment("+3", 3),
			new Enchantment("+4", 4),
			new Enchantment("+5", 5)
	};
	
	private Enchantment[] armorEnchantmentsLevel1 = new Enchantment[] {
		   new Enchantment("Benevolent", 1, 2000),
		   new Enchantment("Poison-resistant", 1, 2250),
		   new Enchantment("Balanced", 1),
		   new Enchantment("Bitter", 1),
		   new Enchantment("Bolstering", 1),
		   new Enchantment("Brawling", 1),
		   new Enchantment("Champion", 1),
		   new Enchantment("Dastard", 1),
		   new Enchantment("Deathless", 1),
		   new Enchantment("Defiant", 1),
		   new Enchantment("Fortification (light)", 1),
		   new Enchantment("Grinding", 1),
		   new Enchantment("Impervious", 1),
		   new Enchantment("Mirrored", 1),
		   new Enchantment("Spell Storing", 1),
		   new Enchantment("Stanching", 1),
		   new Enchantment("Warding", 1),
	};
   
	private Enchantment[] armorEnchantmentsLevel2 = new Enchantment[] {
		   new Enchantment("Glamered", 2, 2700),
		   new Enchantment("Jousting", 2, 3750),
		   new Enchantment("Shadow", 2, 3750),
		   new Enchantment("Slick", 2, 3750),
		   new Enchantment("Expeditious", 2, 4000),
		   new Enchantment("Creeping", 2, 5000),
		   new Enchantment("Rallying", 2, 5000),
		   new Enchantment("Spell Resistance (13)", 2)
	};
   
	private Enchantment[] armorEnchantmentsLevel3 = new Enchantment[] {
		   new Enchantment("Adhesive", 3, 7000),
		   new Enchantment("Hosteling", 3, 7500),
		   new Enchantment("Radiant", 3, 7500),
		   new Enchantment("Delving", 3, 10000),
		   new Enchantment("Putrid", 3, 10000),
		   new Enchantment("Fortification (moderate)", 3),
		   new Enchantment("Ghost Touch", 3),
		   new Enchantment("Invulnerability", 3),
		   new Enchantment("Spell Resistance (15)", 3),
		   new Enchantment("Titanic", 3),
		   new Enchantment("Wild", 3)
	};
   
	private Enchantment[] armorEnchantmentsLevel4 = new Enchantment[] {
		   new Enchantment("Harmonizing", 4, 15000),
		   new Enchantment("Improved Shadow", 4, 15000),
		   new Enchantment("Improved Slick", 4, 15000),
		   new Enchantment("Energy Resistance", 4, 18000),
		   new Enchantment("Martyring", 4, 18000),
		   new Enchantment("Spell Resistance (17)", 4)
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
		   new Enchantment("Fortification (heavy)", 5),
		   new Enchantment("Spell Resistance (19)", 5)
	};
   
	private Equipment[] lesserMinorSpecificMagicArmor = new Equipment[] {
		   new Equipment("Mithral Shirt", 1100)
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
		   new Enchantment("Arrow Catching", 1),
		   new Enchantment("Bashing", 1),
		   new Enchantment("Binding",1),
		   new Enchantment("Clangorous", 1),
		   new Enchantment("Defiant", 1),
		   new Enchantment("Fortification (light)", 1),
		   new Enchantment("Grinding", 1),
		   new Enchantment("Impervious", 1),
		   new Enchantment("Mirrored", 1),
		   new Enchantment("Ramming", 1)
	};
   
	private Enchantment[] shieldEnchantmentsLevel2 = new Enchantment[]{
		   new Enchantment("Rallying", 2, 5000),
		   new Enchantment("Wyrmsbreath", 2, 5000),
		   new Enchantment("Animated", 2),
		   new Enchantment("Arrow Deflection", 2),
		   new Enchantment("Merging", 2),
		   new Enchantment("Spell Resistance (13)", 2)
	};
   
	private Enchantment[] shieldEnchantmentsLevel3 = new Enchantment[]{
		   new Enchantment("Hosteling", 3, 7500),
		   new Enchantment("Radiant", 3, 7500),
		   new Enchantment("Fortification (moderate)", 3),
		   new Enchantment("Ghost Touch", 3),
		   new Enchantment("Spell Resistance (15)", 3),
		   new Enchantment("Wild", 3)
	};
   
	private Enchantment[] shieldEnchantmentsLevel4 = new Enchantment[]{
		   new Enchantment("Energy Resistance", 4, 18000),
		   new Enchantment("Spell Resistance (17)", 4)
	};
   
	private Enchantment[] shieldEnchantmentsLevel5 = new Enchantment[]{
		   new Enchantment("Determination", 5, 30000),
		   new Enchantment("Improved Energy Resistance", 5, 42000),
		   new Enchantment("Undead Controlling", 5, 49000),
		   new Enchantment("Greater Energy Resistance", 5, 66000),
		   new Enchantment("Fortification (heavy)", 5),
		   new Enchantment("Reflecting", 5),
		   new Enchantment("Spell Resistance (19)", 5)
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
   
	private Random randGenerator;
	
	public ArmorsShields(Rarity type) {
		
	   randGenerator = new Random();
	   
	   int dPercent	= randGenerator.nextInt(100) + 1;
	   boolean isLesser = (randGenerator.nextInt(2) == 0);
	   
	   boolean isShield = (randGenerator.nextInt(2) == 0);
	   if (isShield) {
		   armorShield = baseShieldList[randGenerator.nextInt(baseShieldList.length)];
	   }
	   else {
		   armorShield = baseArmorList[randGenerator.nextInt(baseArmorList.length)];
	   }
	   
	   if (type == Rarity.MINOR) {
		   if (isLesser) {
			   //Lesser
			   if (dPercent <= 80) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 0, 0, isShield));
			   } else {
				   if (isShield) {
					   armorShield = lesserMinorSpecificMagicShields[(randGenerator.nextInt(lesserMinorSpecificMagicShields.length))];
				   } else {
					   armorShield = lesserMinorSpecificMagicArmor[(randGenerator.nextInt(lesserMinorSpecificMagicArmor.length))];
				   }
			   }
		   }
		   else {
			   //Greater
			   if (dPercent <= 26) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 0, 0, isShield));
			   } else if (dPercent <= 53) {
				   addEnchantmentsToArmorShield(getEnchantments(2, 0, 0, isShield));
			   } else if (dPercent <= 80) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 1, 1, isShield));
			   } else {
				   if (isShield) {
					   armorShield = greaterMinorSpecificMagicShields[(randGenerator.nextInt(greaterMinorSpecificMagicShields.length))];
				   } else {
					   armorShield = greaterMinorSpecificMagicArmor[(randGenerator.nextInt(greaterMinorSpecificMagicArmor.length))];
				   }
			   }
		   }
	   }
	   else if (type == Rarity.MEDIUM) {
		   if (isLesser) {
			   //Lesser 
			   if (dPercent <= 10) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 0, 0, isShield));
			   } else if (dPercent <= 20) {
				   addEnchantmentsToArmorShield(getEnchantments(2, 0, 0, isShield));
			   } else if (dPercent <= 32) {
				   addEnchantmentsToArmorShield(getEnchantments(3, 0, 0, isShield));
			   } else if (dPercent <= 44){
				   addEnchantmentsToArmorShield(getEnchantments(1, 1, 1, isShield));
			   } else if (dPercent <= 56) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 1, 2, isShield));
			   } else if (dPercent <= 68) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 2, 1, isShield));
			   } else if (dPercent <= 80) {
				   addEnchantmentsToArmorShield(getEnchantments(2, 1, 1, isShield));
			   } else {
				   if (isShield) {
					   armorShield = lesserMediumSpecificMagicShields[(randGenerator.nextInt(lesserMediumSpecificMagicShields.length))];
				   } else {
					   armorShield = lesserMediumSpecificMagicArmor[(randGenerator.nextInt(lesserMediumSpecificMagicArmor.length))];
				   }
			   }
		   }
		   else {
			   //Greater
			   if (dPercent <= 10) {
				   addEnchantmentsToArmorShield(getEnchantments(2, 0, 0, isShield));
			   } else if (dPercent <= 22) {
				   addEnchantmentsToArmorShield(getEnchantments(3, 0, 0, isShield));
			   } else if (dPercent <= 32) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 1, 1, isShield));
			   } else if (dPercent <= 44){
				   addEnchantmentsToArmorShield(getEnchantments(1, 2, 1, isShield));
			   } else if (dPercent <= 56) {
				   addEnchantmentsToArmorShield(getEnchantments(2, 1, 1, isShield));
			   } else if (dPercent <= 68) {
				   addEnchantmentsToArmorShield(getEnchantments(2, 2, 1, isShield));
			   } else if (dPercent <= 80) {
				   addEnchantmentsToArmorShield(getEnchantments(3, 1, 1, isShield));
			   } else {
				   if (isShield) {
					   armorShield = greaterMediumSpecificMagicShields[(randGenerator.nextInt(greaterMediumSpecificMagicShields.length))];
				   } else {
					   armorShield = greaterMediumSpecificMagicArmor[(randGenerator.nextInt(greaterMediumSpecificMagicArmor.length))];
				   }
			   }
		   }
	   }
	   else if (type == Rarity.MAJOR) {
		   if (isLesser) {
			   //Lesser
			   if (dPercent <= 10) {
				   addEnchantmentsToArmorShield(getEnchantments(3, 0, 0, isShield));
			   } else if (dPercent <= 22) {
				   addEnchantmentsToArmorShield(getEnchantments(4, 0, 0, isShield));
			   } else if (dPercent <= 32) {
				   addEnchantmentsToArmorShield(getEnchantments(1, 2, 1, isShield));
			   } else if (dPercent <= 44){
				   addEnchantmentsToArmorShield(getEnchantments(1, 3, 1, isShield));
			   } else if (dPercent <= 56) {
				   addEnchantmentsToArmorShield(getEnchantments(2, 2, 1, isShield));
			   } else if (dPercent <= 68) {
				   addEnchantmentsToArmorShield(getEnchantments(3, 1, 1, isShield));
			   } else if (dPercent <= 80) {
				   addEnchantmentsToArmorShield(getEnchantments(4, 1, 1, isShield));
			   } else {
				   if (isShield) {
					   armorShield = lesserMajorSpecificMagicShields[(randGenerator.nextInt(lesserMajorSpecificMagicShields.length))];
				   } else {
					   armorShield = lesserMajorSpecificMagicArmor[(randGenerator.nextInt(lesserMajorSpecificMagicArmor.length))];
				   }
			   }
		   }
		   else {
			   //Greater
			   if (dPercent <= 10) {
				   addEnchantmentsToArmorShield(getEnchantments(4, 0, 0, isShield));
			   } else if (dPercent <= 20) {
				   addEnchantmentsToArmorShield(getEnchantments(5, 0, 0, isShield));
			   } else if (dPercent <= 30) {
				   addEnchantmentsToArmorShield(getEnchantments(4, 1, 1, isShield));
			   } else if (dPercent <= 38){
				   addEnchantmentsToArmorShield(getEnchantments(4, 2, 1, isShield));
			   } else if (dPercent <= 46) {
				   addEnchantmentsToArmorShield(getEnchantments(4, 3, 1, isShield));
			   } else if (dPercent <= 51) {
				   addEnchantmentsToArmorShield(getEnchantments(4, 4, 1, isShield));
			   } else if (dPercent <= 59) {
				   addEnchantmentsToArmorShield(getEnchantments(5, 1, 1, isShield));
			   } else if (dPercent <= 67) {
				   addEnchantmentsToArmorShield(getEnchantments(5, 2, 1, isShield));
			   } else if (dPercent <= 71) {
				   addEnchantmentsToArmorShield(getEnchantments(5, 3, 1, isShield));
			   } else if (dPercent <= 74) {
				   addEnchantmentsToArmorShield(getEnchantments(5, 2, 2, isShield));
			   } else if (dPercent <= 77) {
				   addEnchantmentsToArmorShield(getEnchantments(5, 4, 1, isShield));
			   } else if (dPercent <= 80) {
				   addEnchantmentsToArmorShield(getEnchantments(5, 5, 1, isShield));
			   } else {
				   if (isShield) {
					   armorShield = greaterMajorSpecificMagicShields[(randGenerator.nextInt(greaterMajorSpecificMagicShields.length))];
				   } else {
					   armorShield = greaterMajorSpecificMagicArmor[(randGenerator.nextInt(greaterMajorSpecificMagicArmor.length))];
				   }
			   }
		   }
	   }
	}
	
	//Should only be called once for each item, otherwise price evaluation will be incorrect
	//TODO:Make more error proof
	private void addEnchantmentsToArmorShield(Enchantment[] enchantments) {
		for (int i = 0; i < enchantments.length; i++) {
			armorShield.name = enchantments[i].name + " " + armorShield.name;
			armorShield.totalEchantmentBonus +=  enchantments[i].bonus;
			armorShield.cost += enchantments[i].additionalCost;
		}
		
		// add costs (bonus cost is (bonus * 1k)^2)
		armorShield.cost += Math.pow(armorShield.totalEchantmentBonus, 2) * 1000;
	}
	
	private Enchantment[] getEnchantments(int baseEnchantmentBonus, int abilityEnchantmentStrength, int numAbilities, boolean isShield) {
		Enchantment[] enchantments = new Enchantment[numAbilities + 1];
		
		for (int i = 0; i < numAbilities; i++) {
			if (isShield) {
				switch (abilityEnchantmentStrength) {
				case 1:
					enchantments[i] = shieldEnchantmentsLevel1[randGenerator.nextInt(shieldEnchantmentsLevel1.length)];
					break;
				case 2:
					enchantments[i] = shieldEnchantmentsLevel2[randGenerator.nextInt(shieldEnchantmentsLevel2.length)];
					break;
				case 3:
					enchantments[i] = shieldEnchantmentsLevel3[randGenerator.nextInt(shieldEnchantmentsLevel3.length)];
					break;
				case 4:
					enchantments[i] = shieldEnchantmentsLevel4[randGenerator.nextInt(shieldEnchantmentsLevel4.length)];
					break;
				case 5:
					enchantments[i] = shieldEnchantmentsLevel5[randGenerator.nextInt(shieldEnchantmentsLevel5.length)];
					break;
				default:
					break;
				}
			} else {
				switch (abilityEnchantmentStrength) {
				case 1:
					enchantments[i] = armorEnchantmentsLevel1[randGenerator.nextInt(armorEnchantmentsLevel1.length)];
					break;
				case 2:
					enchantments[i] = armorEnchantmentsLevel2[randGenerator.nextInt(armorEnchantmentsLevel2.length)];
					break;
				case 3:
					enchantments[i] = armorEnchantmentsLevel3[randGenerator.nextInt(armorEnchantmentsLevel3.length)];
					break;
				case 4:
					enchantments[i] = armorEnchantmentsLevel4[randGenerator.nextInt(armorEnchantmentsLevel4.length)];
					break;
				case 5:
					enchantments[i] = armorEnchantmentsLevel5[randGenerator.nextInt(armorEnchantmentsLevel5.length)];
					break;
				default:
					break;
				}
			}
		}
		
		enchantments[numAbilities] = getBaseEnchantment(baseEnchantmentBonus);
		
		return enchantments;
	}
	
	private Enchantment getBaseEnchantment(int enchantmentValue) {
		return baseEnchantments[enchantmentValue - 1];
	}
}


