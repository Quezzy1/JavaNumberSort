/**
 * 
 */
package java_project;

/**
 * @author Siphokazi.Nene
 *
 */
import java.util.*;
import number_range_summarizer_implementer.NumberRangeImplementer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberRangeImplementer sorted_list = new NumberRangeImplementer();  // Create a list object
		
		//test list1
	    ArrayList<Integer> list1 = new ArrayList<>(sorted_list.collect("1,2,3,4"));
		System.out.println(list1);
		System.out.println("Output: " + sorted_list.summarizeCollection(sorted_list.collect("1,2,3,4")));
		
		//test list 2
		ArrayList<Integer> list2 = new ArrayList<>(sorted_list.collect("1,3,4,5,6,12,13,21"));
		System.out.println(list2);
		System.out.println("Output: " + sorted_list.summarizeCollection(sorted_list.collect("1,3,4,5,6,12,13,21")));
		
		//test list 3
		ArrayList<Integer> list3 = new ArrayList<>(sorted_list.collect("-1,-2,1,3,4,5,6,12,13,21"));
		System.out.println(list3);
		System.out.println("Output: " + sorted_list.summarizeCollection(sorted_list.collect("-1,-2,1,3,4,5,6,12,13,21")));
	
	
	}
}
