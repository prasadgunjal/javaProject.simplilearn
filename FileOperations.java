import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to lockersMe.com");
		fileOperators();
	}
	
	static void fileOperators() throws IOException {
		System.out.println("Enter 1 for list down all files");
		System.out.println("Enter 2 Business level operaton");
		System.out.println("Enter 3 if you want to exit");
		System.out.println("Enter your choice:");
		int choice = scanner.nextInt();
		
		if (choice == 1) {
			listAllFiles();
			fileOperators();
		}else if (choice == 2) {
			businessLevelOperations();
		}else if (choice == 3) {
			exit();
		}else {
			System.out.println("Enter correct input");
			fileOperators();
		}
	}
	
	static void exit() {
		System.out.println("Thanks for using lockersMe.com!");
	}
	
	static void listAllFiles() {
		File folder = new File("D:\\");
		File fileList[] = folder.listFiles();
		Arrays.sort(fileList);
		for(File file:fileList) {
			System.out.println(file.getName());
		}
	}
	
	static void deleteFile() {
		listAllFiles();
		System.out.println("Enter file name which you want to delete:");
		String fileName = scanner.next();
		File fo = new File("D:"+fileName+".txt");
		if (fo.delete()) {
			System.out.println("File deleted successfully");
		}
	}
	
	static void addFile() throws IOException {
		System.out.println("Enter file name:");
		String fileName = scanner.next();
		File fo = new File("D:"+fileName+".txt");
		if(fo.createNewFile()) {
			System.out.println("File "+fileName+ " created");
		} else {
			System.out.println("File " + fileName+ " already exist");
		}
	}
	
	static void searchFile() {
		File directory = new File("D:\\");
		String[]flist = directory.list();
		System.out.println("Enter file name which you want to search:");
		String fileName= scanner.next();
		boolean fileExist = false;
		for(int i=0;i<flist.length-1;i++) {
			if(flist[i].equals(fileName)) {
				System.out.println(fileName + " file name exist");
				fileExist=true;
			}
		}
		if (!fileExist) {
			System.out.println(fileName+" file name is not exist");
		}
	}

	static void businessLevelOperations() throws IOException {
		System.out.println("Enter 2.1  to add file");
		System.out.println("Enter 2.2  to delete file");
		System.out.println("Enter 2.3 to search file");
		System.out.println("Enter 2.4 for move to parent");
		System.out.println("Enter your choice:");
		float ch = scanner.nextFloat();
		if(Float.compare(ch,(float) 2.1) == 0) {
			addFile();
			fileOperators();
		} else if(Float.compare(ch, (float) 2.2) == 0) {
			deleteFile();
			fileOperators();
		} else if(Float.compare(ch, (float) 2.3) == 0) {
			searchFile();
			fileOperators();
		} else if(Float.compare(ch, (float) 2.4) == 0) {
			fileOperators();
		} else {
			System.out.println("Enter correct input:");
			fileOperators();
		}
	}
}
