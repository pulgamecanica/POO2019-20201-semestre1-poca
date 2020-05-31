import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class AdressBook {
	private final ArrayList<Contact> contactList = new ArrayList<>();

	public AdressBook(File file){
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()){
				String name =  scanner.nextLine();
				String line2 = scanner.nextLine();
				if(line2.isEmpty())
					contactList.add(new Contact(name));
				else
					contactList.add(new Contact(name, Integer.parseInt(line2)));
				//EITHER WAY!
				// if(scanner.hasNextInt()){
				// 	contactList.add(new Contact(name, scanner.nextInt()));
				// }
				// else
				// 	contactList.add(new Contact(name));
				// if(scanner.hasNextLine())
				// 	scanner.nextLine();
			}
			scanner.close();
		}catch(FileNotFoundException e){
			System.err.println("DUDE!");
		}		
	}

	public int size(){
		return contactList.size();
	}

	public void addContact(Contact newContact){
		contactList.add(newContact);
	}

	public ArrayList<Contact> searchByWord(String keyWord){
		ArrayList<Contact> resultList = new ArrayList<>();
		for(Contact x :  contactList)
			if(x.nameMatch(keyWord))
				resultList.add(x);
		Contact.orderContacts(resultList);
		return resultList;
	}

	public ArrayList<Contact> searchContactSelector(ContactSelector selector){
		ArrayList<Contact> resultList = new ArrayList<>();
		for(Contact x :  contactList)
			if(selector.testContact(x))
				resultList.add(x);
		Contact.orderContacts(resultList);
		return resultList;
	}

	public static void main(String[] args){
		File file = new File("contactList.txt");
		AdressBook aB = new AdressBook(file);
		System.out.println("***********ADD CONTACT************");
		aB.addContact(new Contact("Andre Hernandez", 911715520));
		System.out.println("***********Get all Contacts That contain 'Andre' ************");
		System.out.println(aB.searchByWord("Andre"));
		System.out.println("***********Get all Contacts For NameFilter for 'Forsyth'************");
		System.out.println(aB.searchContactSelector(new NameFilter("Forsyth")));


	}
}