import java.util.*;
// import java.util.ArrayList;
public class Contact {
	private final String name;
	private int phoneNumber;
	public Contact(String name){
		if(name.split(" ").length < 2){
			System.out.println("Flag1 " + name);
			throw new IllegalArgumentException("Not a valid name");
		}
		this.name = name;
	}
	public Contact(String name, int phoneNumber){
		if(name.split(" ").length < 2){
			System.out.println("Flag2 " + name + phoneNumber);
			throw new IllegalArgumentException("Not a valid name");
		}
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName(){
		return name.split(" ")[0];
	}
	public String getLastName(){
		return name.split(" ")[1];
	}
	public boolean nameMatch(String match){
		return name.contains(match);
	}
	@Override
	public String toString(){
		return " (* " + getLastName() + " " + getFirstName() + (phoneNumber != 0 ? " - " + phoneNumber : " - NA") + " *) ";
	}


	public static void main(String[] args){
		//Contact c1 = new Contact("Andre");	//ILLEGALARGUMENT
		Contact c2 = new Contact("Wolfram Alpha");
		Contact c3 = new Contact("Johan Sebastian");

		System.out.println(c2.getFirstName());	//Maria
		System.out.println(c3.getLastName());	//Sebastian
		System.out.println(c3.nameMatch("Wolfram"));		//FALSE
		System.out.println(c2.nameMatch("Wolfram"));		//TRUE

		Contact con1 = new Contact("Wolfram Alpha", 99393816);
		Contact con2 = new Contact("Amelie Philaipe", 83702047);
		Contact con3 = new Contact("Luis Armstong", 39312040);
		Contact con4 = new Contact("Nikola Tesla");
		Contact con5 = new Contact("Clair Tutli");
		Contact con6 = new Contact("Jaqueline duPre", 911715523);
		ArrayList<Contact> contacts = new ArrayList<>();
		contacts.add(con1);
		contacts.add(con2);
		contacts.add(con3);
		contacts.add(con4);
		contacts.add(con5);
		contacts.add(con6);
		System.out.println(contacts);
		orderContacts(contacts);
		System.out.println(contacts);
		System.out.println("***********************************************************************");
	}

	public static void orderContacts(ArrayList<Contact> contacts){
		contacts.sort((contact1, contact2) -> contact1.getLastName().compareTo(contact2.getLastName()));
	}
}