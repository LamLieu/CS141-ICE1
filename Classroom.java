import java.util.*;
import java.io.*;
public class Classroom {
	public static final String ANSI_WARNING = "\u001B[33m"; //WARNING color
	public static final String ANSI_RESET = "\u001B[0m"; // Standard ANSI text

	public String className;
	public int students;
	public int chairs;
	public int desks;
	public String suggestion;
	
	public static boolean checkCapacity(int chairs, int students) { // Compares the chairs with the students to see if there is overflowing
		boolean overfilled = false; 
		
		if (chairs < students)
			overfilled = true;
		
		return overfilled;
	}
	
	public static String offerSoln(int chairs, int students) { // Offers a solution to the overflow problem
		int difference = students - chairs;
		String solution =  difference + " students must be dropped.\n";
		if ((students - 15) >= chairs)
			solution = "Please create another class for the remaining students.\n";
		return solution;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);	
		PrintWriter file = new PrintWriter("Classrooms.txt");
		System.out.print("Welcome to ClassRoom Manager. \n");

		boolean check = false; // True if there are more students than chairs
		do{
			Classroom class1 = new Classroom();
			System.out.print("Please enter the class name (or type -1 to terminate): ");
			class1.className = input.nextLine();
			if(class1.className.equals("-1")){ // Probably a more efficient way to do this...
				input.close();
				file.close();
				System.out.println("Application terminated, your work is saved to Classrooms.txt.");
				return;}
			
			System.out.print("Please enter the number of chairs: ");
			class1.chairs = input.nextInt();
			
			class1.desks = class1.chairs;
			
			System.out.print("Please enter the number of students: ");
			class1.students = input.nextInt();
			
			check = checkCapacity(class1.chairs, class1.students);		
			if (check){	
				class1.suggestion = offerSoln(class1.chairs, class1.students);
				System.out.print(ANSI_WARNING + class1.suggestion + ANSI_RESET); }
			String output = "Class Name: " + class1.className + " - " + "Seats: " + class1.chairs + " - " + "Students: " + class1.students;
			file.println(output);
			if(class1.suggestion != null){file.println("SUGGESTION: " + class1.suggestion);}

		}while(!input.nextLine().equals("-1"));
	}

}
