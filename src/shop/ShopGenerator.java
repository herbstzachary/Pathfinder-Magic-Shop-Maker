package shop;
import java.util.Random;
import java.util.Scanner;

import shop.ArmorsShields;

enum Settlement{
	THORP, HAMLET, VILLAGE, SMALLTOWN, LARGETOWN, SMALLCITY, LARGECTIY, METROPOLIS
}

enum Rarity{
	MINOR, MEDIUM, MAJOR
}

public class ShopGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Settlement[] settlementArray = Settlement.values();
		// Ask for Settlement type from list
		// 1. Thorp
		// 2. Hamlet
		// 3. Village
		// 4. Small Town
		// 5. Large Town
		// 6. Small City
		// 7. Large City
		// 8. Metropolis
		
        Scanner in = new Scanner(System.in);
        int settlementSelect = -1;
		do {
			System.out.println("Please select a settlement type (number):");
			int i = 0; //counter for output of settlements, input from user later
			for (Settlement settlement : settlementArray) {
				System.out.println( i + ". " + settlement);
				i++;
			}
			
			settlementSelect = in.nextInt();
			if (settlementSelect >= settlementArray.length || settlementSelect < 0) {
				System.out.println("Please select a valid settlement number.");
			}

		}while(settlementSelect >= settlementArray.length || settlementSelect < 0);
		        
        Settlement settlementType = settlementArray[settlementSelect];
        
		Random randGenerator = new Random();
		
		// Determine how many Minor, Medium, Major items (rand() based on settlement)
		int numMinorItems = 0, numMediumItems = 0, numMajorItems = 0;
		if (settlementType == Settlement.THORP) {
			numMinorItems = randGenerator.nextInt(4) + 1;
		} 
		else if (settlementType == Settlement.HAMLET) {
			numMinorItems = randGenerator.nextInt(6) + 1;
		}
		else if (settlementType == Settlement.VILLAGE) {
			numMinorItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMediumItems = randGenerator.nextInt(4) + 1;
		}
		else if (settlementType == Settlement.SMALLTOWN) {
			numMinorItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMediumItems = randGenerator.nextInt(6) + 1;
		}
		else if (settlementType == Settlement.LARGETOWN) {
			numMinorItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMediumItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMajorItems = randGenerator.nextInt(4) + 1;
		}
		else if (settlementType == Settlement.SMALLCITY) {
			numMinorItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMediumItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMajorItems = randGenerator.nextInt(6) + 1;
		}
		else if (settlementType == Settlement.LARGECTIY) {
			numMinorItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMediumItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMajorItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
		}
		else if (settlementType == Settlement.METROPOLIS) {
			numMediumItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
			numMajorItems = (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1) + (randGenerator.nextInt(4) + 1);
		}
		
		System.out.println("Your shop has " + numMinorItems + " minor items, " + numMediumItems + " medium items, " + numMajorItems + " major items.");
		
		// Determine what items are available (Random Magic Item Generation Table)
		// Create generic object type that all equipment can inherit from
		ArmorsShields[] minorItems = new ArmorsShields[numMinorItems];
		ArmorsShields[] mediumItems = new ArmorsShields[numMediumItems];
		ArmorsShields[] majorItems = new ArmorsShields[numMajorItems];

		// Create specific items based on which items are going to be available
		for (int i = 0; i < numMinorItems; i++) {
			ArmorsShields test = new ArmorsShields(Rarity.MINOR);
			System.out.println("Name: " + test.armorShield.name);
			System.out.println("Cost: " + test.armorShield.cost);
		}
		
		for (int i = 0; i < numMediumItems; i++) {
			ArmorsShields test = new ArmorsShields(Rarity.MEDIUM);
			System.out.println("Name: " + test.armorShield.name);
			System.out.println("Cost: " + test.armorShield.cost);
		}
		
		for (int i = 0; i < numMajorItems; i++) {
			ArmorsShields test = new ArmorsShields(Rarity.MAJOR);
			System.out.println("Name: " + test.armorShield.name);
			System.out.println("Cost: " + test.armorShield.cost);
		}
		
		// Import NPC from NPC Creator (TBD)
		
	}
}
