import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

public class AwesomeAdressBook extends AdressBook{

	public HashMap<String, ArrayList<Contact>> contactsGroup = new HashMap<>();

	public AwesomeAdressBook(File file){
		super(file);
	}

	public void addContactWithinGroup(Contact contact, String groupName){
		super.addContact(contact);
		if(contactsGroup.containsKey(groupName))
			contactsGroup.get(groupName).add(contact);
		else{
			ArrayList<Contact> array = new ArrayList<Contact>();
			array.add(contact);
			contactsGroup.put(groupName, array);	
		}
	}
	public ArrayList<Contact> getContactsFromGroup(String groupName){
		ArrayList<Contact> array = new ArrayList<Contact>();
		if(contactsGroup.containsKey(groupName))
			array = contactsGroup.get(groupName);
		Contact.orderContacts(array);
		return array;
	}

	public static void main(String[] args){
		File file = new File("contactList.txt");
		AwesomeAdressBook aB = new AwesomeAdressBook(file);
		System.out.println((aB.searchByWord("Fisher")));
		aB.addContactWithinGroup(new Contact("Daniel B", 13489213), "group1");
		aB.addContactWithinGroup(new Contact("Ana Rita", 14358613), "group1");
		aB.addContactWithinGroup(new Contact("Marie Courie", 99112344), "group1");
		aB.addContactWithinGroup(new Contact("Rachel Sermani"), "group2");
		aB.addContactWithinGroup(new Contact("Margarida PAPA"), "group2");
		System.out.println(aB.contactsGroup);
		System.out.println(aB.contactsGroup.size());
		System.out.println(aB.getContactsFromGroup("group1"));
		System.out.println(aB.getContactsFromGroup("gr"));
	}
}