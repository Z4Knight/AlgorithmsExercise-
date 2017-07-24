package exercise_test;

import exercise_sort_bubble.Bubble;
import exercise_sort_heap.Heap;
import exercise_sort_impl.Sort;
import exercise_sort_insertion.Insertion;
import exercise_sort_merge.Merge;
import exercise_sort_quick.Quick;
import exercise_sort_selection.Selection;
import exercise_sort_shell.Shell;
/**
 * À„∑®≤‚ ‘≥Ã–Ú
 * @author Z4Knight
 *
 */
public class Test {
	public static void printArray(int[] array) {
		StringBuilder b = new StringBuilder();
		b.append("[");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				b.append(array[i] + "]");
			} else {
				b.append(array[i] + ", ");
			}
		}
		System.out.println(b.toString());
	}
	
	public static void test (Sort sort, int[] array) {
		System.out.println("Before sort: ");
		printArray(array);
		sort.sort(array);
		System.out.println("After sort: ");
		printArray(array);
	}
	
	public static void main(String[] args) {
		int [] array = {1,5,7,15,9,10,5,3,4,7,8,9,45,10};
		
//		test(new Selection(), array);
//		test(new Insertion(), array);
//		test(new Bubble(), array);
//		test(new Shell(), array);
//		test(new Merge(), array);
//		test(new Heap(), array);
		test(new Quick(), array);
	}
}
