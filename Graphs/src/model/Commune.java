package model;

public class Commune {

	private Neighborhood[] neigh;
	private String name;

	public Commune(String name, int size) {
		this.name = name;
		neigh = new Neighborhood[size];

	}

	public Neighborhood[] getNeigh() {
		return neigh;
	}

	public void setNeigh(Neighborhood[] neigh) {
		this.neigh = neigh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addNeighB(String nameN, String code,double x, double y){

		Neighborhood add = new Neighborhood(nameN, code);
		add.setX(x);
		add.setY(y);

		boolean added = false;
		
		int i = 0;
		while(added == false && i < neigh.length) {
			if(neigh[i] == null) {
				neigh[i] = add;
				added = true;
			}
			i++;
			
		}
			
		

	}
	
	public boolean isElement(String name) {
		
		boolean is = false;
		
		for (int i = 0; i < neigh.length; i++) {
			
			if(neigh[i].getName().equals(name) == true) {
			
				is = true;
			}	
		}
		
		return is;
	}
	
	public Neighborhood search(String name) {
		
		Neighborhood n = null;
		boolean is = false;
		int i = 0;
		
		if (isElement(name) == true) {
			while (is == false && i < neigh.length) {
				
				if (neigh[i].getName().equals(name)) {
					is = true;
					n =  neigh[i];
				}
				i++;
			}		
		}
		
		return n;
	}
	
	public String toString() {
		String c ="";
		
		for (int i = 0; i < neigh.length; i++) {
			c += neigh[i].getName()+"	";
		}
		
		return c; 
		
	}
	

	public static void main(String[] args)  {

		Commune d = new Commune("2", 2);
//		
//		d.addNeighB("calipso", 2, 2);
//		d.addNeighB("flora", 1, 1);
//		
//		System.out.println(d.isElement("flora"));
//		System.out.println(d.toString());
//		System.out.println(d.search("flora"));
//		
		
	}

}
