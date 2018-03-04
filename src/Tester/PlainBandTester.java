package Tester;



import java.util.List;
import java.util.Scanner;

import Controller.BandsHelper;
import Model.Bands;  


public class PlainBandTester {
	static Scanner in = new Scanner(System.in);
	static BandsHelper bh = new BandsHelper();
	
	private static void addBand() {
		// TODO Auto-generated method stub
		//if we want to force the cost
		//Bands toAdd = new Bands(50,"Hawks","Woodward",50.00,2); 
		
		//if we want bands to calculate the cost
		Bands toAdd = new Bands(32,"Wildcats","Carlisle",1); 
		bh.insertBands(toAdd);
	}
	
	private static void viewBands() {
		// TODO Auto-generated method stub
		List<Bands> allBands = bh.showAllBands();
		for (Bands li : allBands) {
			System.out.println(li.returnBandDetails());
		}
	}
	
	private static void deleteBands() {
		// TODO Auto-generated method stub

		Bands toDelete = new Bands(7);
		bh.deleteBands(toDelete);

	}
	
	private static void editBands() {
		// TODO Auto-generated method stub
			viewBands();
			
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			in.nextLine();

			Bands toEdit = bh.searchForBandById(idToEdit); 
			System.out.println("1 : Update Band Name");
			System.out.println("2 : Update Number of Members");
			System.out.println("3 : Update Location"); 
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Band Name: ");
				String newBandName = in.nextLine();
				toEdit.setNameOfBand(newBandName);
			} else if (update == 2) {
				System.out.print("Updated number of members: ");
				int newMemberNumber = in.nextInt();
				in.nextLine();
				toEdit.setNumberOfMembers(newMemberNumber);
			}else if (update == 3) {
				System.out.print("New Location: ");
				String newLocation = in.nextLine();
				toEdit.setLocationOfBand(newLocation); 
			}

			bh.updateBands(toEdit);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addBand();
		viewBands();
		//deleteBands();
		//editBands();
	}

}
