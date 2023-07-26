package Inheritance;

// hierarchical inheritance

class Books {
	public void store() {
		System.out.println("The store have all types of book");
	}
}

class fictions extends Books{
	public void ficbook() {
		System.out.println("One side of store have fiction books");
	}
	
}

class NonFiction extends Books{
	public void nonfic() {
		System.out.println("The other side of store have non fiction books ");
	}
}

public class p3_hierarchical {
   public static void main(String[] args) {
	fictions f =  new fictions();
	NonFiction nf = new NonFiction();
	
	f.store();
	f.ficbook();
	nf.nonfic();
	
}
}
