package Inheritance;

// multiLevel Inheritance

class bookStore{
	public void book() {
		System.out.println("The class contains all type of book ");
	}
}

class fiction extends bookStore{
	public void novel() {
		System.out.println("The fiction class contain all the type of fiction books");
	}
}

class RichDadPoorDad extends fiction{
	public void bookName() {
		System.out.println("The book name is Rich Dad Poor Dad which is fiction and available in bookstore");
	}
}

public class p3_multiLevel {
  public static void main(String[] args) {
	  RichDadPoorDad rp = new RichDadPoorDad();
	  rp.book();
	  rp.novel();
	  rp.bookName();
} 
}
