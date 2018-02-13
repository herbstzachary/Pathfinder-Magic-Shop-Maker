import java.util.Scanner;

enum Settlement{
	THORP, HAMLET, VILLAGE, SMALLTOWN, LARGETOWN, SMALLCITY, LARGECTIY, METROPOLIS
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
        
		// Determine how many Minor, Medium, Major items (rand() based on settlement)
		
		// Determine what items are available (Random Magic Item Generation Table)
		
		// Create specific items based on which items are going to be available
		
		// Import NPC from NPC Creator (TBD)
		
	}
}
