package ComparatorExample;

import java.util.Comparator;

public class salaryComp implements Comparator<Employee> {
	public int compare(Employee e3,Employee e4) {
		if(e3.salary>e4.salary) {
			return 1;
		}
		else if(e3.salary<e4.salary) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
