
public class Guest {
	
	private int guestId; 
	private String fName,lName,email,phoneNumber; 
	
	public Guest(int guestId,String fName,String lName,String email,String phoneNumber) {
		this.guestId = guestId; 
		this.fName = fName; 
		this.lName = lName; 
		this.email = email; 
		this.phoneNumber = phoneNumber; 
	}

	public int getGuestId() {
		return guestId;
	}

	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "\n=== GUEST INFORMATION ==="+ 
				"\nguestId: " + guestId +
				"\nfirst name: " + fName +
				"\nLast name: " + lName + 
				"\nemail: " + email
				+ "\n phoneNumber:" + phoneNumber ;
	}
	

}
