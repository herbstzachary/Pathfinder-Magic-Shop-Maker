enum Settlement{
	THORP, HAMLET, VILLAGE, SMALLTOWN, LARGETOWN, SMALLCITY, LARGECTIY, METROPOLIS
}

public class ShopGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Ask for Settlement type from list
		// 1. Thorp
		// 2. Hamlet
		// 3. Village
		// 4. Small Town
		// 5. Large Town
		// 6. Small City
		// 7. Large City
		// 8. Metropolis
		
		System.out.println("Please select a settlement type: \n"
				+ Settlement.valueOf("THORP") + ". Thorp \n"
				+ Settlement.valueOf("HAMLET") + ". Hamlet \n"
				+ Settlement.valueOf("VILLAGE") + ". Village \n"
				+ Settlement.valueOf("SMALLTOWN") + ". Small Town \n"
				+ Settlement.valueOf("LARGETOWN") + ". Large Town \n"
				+ Settlement.valueOf("SMALLCITY") + ". Small City \n"

				);
		
		
		// Determine how many Minor, Medium, Major items (rand() based on settlement)
		
		// Determine what items are available (Random Magic Item Generation Table)
		
		// Create specific items based on which items are going to be available
		
		// Import NPC from NPC Creator (TBD)
		
	}

}
