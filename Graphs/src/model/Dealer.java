package model;

public class Dealer implements Comparable<Dealer> {
	
	private String id;
	private String name;
	private String password;
	
	public Dealer(String id, String name, String password ) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isPassword(String passWord) {
		
		if (password.equals(passWord) == true) {
			return  true;
		}
		
		return false;
	}

	@Override
	public int compareTo(Dealer o) {

		if(o.getId().compareTo(this.id) == 0) {
			return 0;
		}
		else if(o.getId().compareTo(this.id) < 0) {
			return -1;
		}else {
			return 1;
		}
	}
	
	
	
}
