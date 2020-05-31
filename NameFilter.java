public class NameFilter implements ContactSelector{

	private final String keyWord;
	public NameFilter(String keyWord){
		this.keyWord = keyWord;
	}
	
	@Override
	public boolean testContact(Contact contact){
		return contact.nameMatch(keyWord);
	}
}