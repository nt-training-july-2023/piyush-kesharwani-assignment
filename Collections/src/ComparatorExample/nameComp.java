package ComparatorExample;

import java.util.Comparator;

public class nameComp implements Comparator<Employee>{
	public int compare(Employee e1,Employee e2) {
		return e1.name.compareTo(e2.name);
	}

}
