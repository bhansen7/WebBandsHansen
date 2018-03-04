package Tester;

import java.util.List;
import java.util.Scanner;


import Controller.MarchingBandHelper;
import Model.MarchingBand;

public class MarchingBandTester {
	static Scanner in = new Scanner(System.in);
	static MarchingBandHelper mh = new MarchingBandHelper();
	private static void addMarchingBand() {
		// TODO Auto-generated method stub
		//tester when we were forcing cost and # of busses
		//MarchingBand toAdd = new MarchingBand(25,"Hawkettes","Granger",45.67,2,"chairs",3,true); 
		
		MarchingBand toAdd = new MarchingBand(60,"Grand Marchers","Grand City",2,"chairs",true); 
		mh.insertMarchingBand(toAdd);
	}
	private static void viewMarchingBand() {
		// TODO Auto-generated method stub
		List<MarchingBand> allMarchingBand = mh.showAllMarchingBand();
		for (MarchingBand li : allMarchingBand) {
			//System.out.println(li.returnMarchingBandDetails()); 
			System.out.println(li.bandReport());
		}
	}
	
	private static void deleteMarchingBand() {
		// TODO Auto-generated method stub

		MarchingBand toDelete = new MarchingBand(26);
		mh.deleteMarchingBand(toDelete);
	}
	
	private static void editMarchingBand() {
		// TODO Auto-generated method stub
			viewMarchingBand();
			
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			in.nextLine();

			MarchingBand toEdit = mh.searchForBandById(idToEdit); 
			System.out.println("1 : Update Type of Props being brought");
			//System.out.println("2 : Update Number of Members");
			//System.out.println("3 : Update Location"); 
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Props: ");
				String newTypesOfProps = in.nextLine();
				toEdit.setTypesOfProps(newTypesOfProps);
			
			}

			mh.updateBands(toEdit);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//addMarchingBand();
		//deleteMarchingBand();
		viewMarchingBand();
		//editMarchingBand();
	}
	
	

}
