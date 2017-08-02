package exercise_test;

import exercise_sort_bubble.Bubble;
import exercise_sort_heap.Heap;
import exercise_sort_impl.Sort;
import exercise_sort_insertion.Insertion;
import exercise_sort_merge.Merge;
import exercise_sort_quick.Quick;
import exercise_sort_quick.Quick3way;
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
		int [] array = {9,5,7,75,8,4,3,8,7,6,15,45};

//		test(new Selection(), array);
//		test(new Insertion(), array);
//		test(new Bubble(), array);
//		test(new Shell(), array);
//		test(new Merge(), array);
//		test(new Heap(), array);
//		test(new Quick(), array);
		test(new Quick3way(), array);
	}
}
