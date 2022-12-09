package simplilearn1;

import java.io.File;
import java.util.Scanner;
import java.util.TreeSet;



class Operations {
	
	static Scanner sc = new Scanner(System.in);
	public static int a;
	public static String c;
	public static String d;
	public static String e;
	public static String Path="C:\\Users\\Laurel\\Desktop\\Project";

	public static void display() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Welcome to LockedMe.com");
		System.out.println("If you want to retrieve file names in ascending order type 1 ");
		System.out.println("If u want to add a file type 2");
		System.out.println("If u want to delete a file type 3");
		System.out.println("If u want to search for a specified file from the folder type 4");
		System.out.println("If u want to stop or terminate type 5");
		a = sc.nextInt();
	}

	public static void view() {
		System.out.println("----------------------------------------------------------------");
		File f = new File(Path);
		File[] arr = f.listFiles();
		//adding elemnets to TreeSet... Tresset will sort values for me
		TreeSet<String> abc = new TreeSet<String>();
		for (int i = 0; i <= arr.length - 1; i++) {
			abc.add(arr[i].getName());
		}
		// using sorting methods
		// TreeSet abc = new TreeSet();
		System.out.println(abc);

	}

	public static void add() throws Exception {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Please enter name of file");
		c = sc.next();
		File f = new File(Path + c + ".txt");
		File f1 = new File(Path);
		File[] arr = f1.listFiles();
		
		// System.out.println(arr.length);
		TreeSet<String> abc = new TreeSet<String>();
		for (int i = 0; i <= arr.length - 1; i++) {
			abc.add(arr[i].getName());
		}
		// using sorting methods
			if (abc.contains(c + ".txt")) {
			System.out.println(c + " file is already present");
			System.out.println("So cannot create file with same name. Please try with different name");
			Thread.sleep(2000);
		} else {
			if (f.createNewFile() == true) {
				System.out.println(" File is Created");
			} else {
				System.out.println(" File is Not created");
			}
		}
	}

	public static void Delete() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Please enter name of file to be deleted");
		
		d = sc.next();

		File f = new File(Path + d + ".txt");
		if (f.exists() == true) {
			if (f.delete() == true) {
				System.out.println("File is Deleted Successfully");
			} else {
				System.out.println("File is Not Deleted");
			}

		} else {
			System.out.println("No such file of " + d + " exists");
		}

	}

	public static void Search() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Please enter name of file you want to search");
		
		e = sc.next();

		File f = new File(Path + e + ".txt");
		if (f.exists() == true) {
			System.out.println("File is found");
		} else {
			System.out.println("No such file of " + e + " exists");
		}

	}

	public static void terminate() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("This app is closed or terminated");
	}
}

public class Project extends Operations {

	public static void main(String[] args) throws Exception {
		Operations obj = new Operations();
		int i = 1;
		while (i > 0) {
			Thread.sleep(3000);
			obj.display();
			if (a == 1) {
				obj.view();
			} else if (a == 2) {
				obj.add();
			} else if (a == 3) {
				obj.Delete();
			} else if (a == 4) {
				obj.Search();
			}

			else if (a == 5) {
				obj.terminate();
				break;
			}
		}
	}

}
