import java.util.*;
import java.io.*;

public class Classroom {
	
	public String className;
	public int students;
	public int chairs;
	public int desks;
	
	public static boolean checkCapacity(int chairs, int students) {
		boolean overfilled = false; 
		
		if (chairs < students)
			overfilled = true;
		
		return overfilled;
	}
	
	public static String offerSoln(int chairs, int students) {
		int difference = students - chairs;
		String solution = difference + " students must be dropped.";
		if ((students - 15) >= chairs)
			solution = "Please create another class for the remaining students.";
		
		return solution;
	}
	
	public static void createDatabase(String className, int numChair, int numStudents, int numDesk) throws IOException {
		PrintWriter outputFile = new PrintWriter(className);
		outputFile.println("Class Name: " + className);
		outputFile.println("Number of Desks: " + numDesk);
		outputFile.println("Number of Chairs: " + numChair);
		outputFile.println("Number of Students: " + numStudents);
		outputFile.close();
	}
			
	public static void main(String[] args) throws IOException {
		boolean check = false;
		Classroom class1 = new Classroom();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter number of classrooms: ");
		int numClassroom = input.nextInt();
		input.nextLine();
		for (int i = 1; i <= numClassroom; i++) {
			System.out.print("Please enter the class name for class " + i + ": ");
			class1.className = input.nextLine();
		
			System.out.print("Please enter the number of chairs in "+ class1.className + ": ");
			class1.chairs = input.nextInt();
			input.nextLine();
			
			while (class1.chairs < 0) {
				System.out.println("Error: Invalid input.");
				System.out.print("Please enter the number of chairs in " + class1.className + ": ");
				class1.chairs = input.nextInt();
				input.nextLine();
			}
		
			class1.desks = class1.chairs;
		
			System.out.print("Please enter the number of students in " + class1.className + ": ");
			class1.students = input.nextInt();
			input.nextLine();
			
			while (class1.students < 0) {
		    	System.out.println("Error: Invalid Input.");
		    	System.out.print("Please enter the number of students in " + class1.className + ": ");
			    class1.students = input.nextInt();
			    input.nextLine();
		    }
		
		    check = checkCapacity(class1.chairs, class1.students);		
		    if (check == true)
			    System.out.println(offerSoln(class1.chairs, class1.students));
		}
	}
}
