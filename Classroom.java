import java.util.*;

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
			
	public static void main(String[] args) {
		boolean check = false;
		Classroom class1 = new Classroom();
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the class name: ");
		class1.className = input.nextLine();
		
		System.out.print("Please enter the number of chairs: ");
		class1.chairs = input.nextInt();
		
		class1.desks = class1.chairs;
		
		System.out.print("Please enter the number of students: ");
		class1.students = input.nextInt();
		
		check = checkCapacity(class1.chairs, class1.students);		
		if (check == true)
			System.out.print(offerSoln(class1.chairs, class1.students));
		
		
		input.close();
	}

}
