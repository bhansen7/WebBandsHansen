package Tester;

import java.util.List;
import java.util.Scanner;

import Controller.PepBandHelper;
import Model.MarchingBand;
import Model.PepBand;



public class PepBandTester {
	static Scanner in = new Scanner(System.in);
	static PepBandHelper ph = new PepBandHelper();
	
	private static void addPepBand() {
		// TODO Auto-generated method stub
		//this was when we were forcing cost
		//PepBand toAdd = new PepBand(25,"Jayettes","Urbandale",45,2,1,"sitting"); 
		
		//allowing program to set cost and playing position
		PepBand toAdd = new PepBand(56,"Cheerers","CHeer City",2,1); 
		ph.insertPepBand(toAdd);
	}
	
	private static void viewPepBand() {
		// TODO Auto-generated method stub
		List<PepBand> allPepBand = ph.showAllPepBand();
		for (PepBand li : allPepBand) { 
			System.out.println(li.bandReport());
		}
	}
	
	private static void deletePepBand() {
		// TODO Auto-generated method stub

		PepBand toDelete = new PepBand(32);
		ph.deletePepBand(toDelete);
	}
	
	
	private static void editPepBand() {
		// TODO Auto-generated method stub
			viewPepBand();
			
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			in.nextLine();

			PepBand toEdit = ph.searchForBandById(idToEdit); 
			System.out.println("1 : Update Event");
			//System.out.println("2 : Update Number of Members");
			//System.out.println("3 : Update Location"); 
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New event: ");
				int newEvent = in.nextInt();
				in.nextLine();
				toEdit.setEventId(newEvent); 
			}

			ph.updateBands(toEdit);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addPepBand();
		viewPepBand();
		//deletePepBand();
		//editPepBand();
	}

}
