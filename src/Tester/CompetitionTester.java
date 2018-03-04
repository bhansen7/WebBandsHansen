package Tester;

import java.util.List;
import java.util.Scanner;

import Controller.CompetitionHelper;
import Model.Bands;
import Model.Competition;

public class CompetitionTester {
	static Scanner in = new Scanner(System.in);
	static CompetitionHelper ch = new CompetitionHelper();

	private static void addBandToCompetition() {
		// TODO Auto-generated method stub

		Competition toAdd = new Competition(2, 31);
		ch.insertBands(toAdd);
	}

	private static void viewCompetition() {
		// TODO Auto-generated method stub
		List<Competition> allCompetition = ch.showAllCompetition();
		for (Competition li : allCompetition) {
			System.out.println(li.returnCompetitionDetails());
		}
	}

	//not implementing delete for competition at this time
	// private static void deleteBandFromCompetition() {
	 // TODO Auto-generated method stub

	// Competition toDelete = new Competition(1,17);
	// ch.deleteBandFromCompetition(toDelete);
	//}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// addBandToCompetition();
		// deleteBandFromCompetition();
		viewCompetition();
	}

}
