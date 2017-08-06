package exercise_sort_count;
import exercise_sort_impl.Sort;
/**
 * 计数排序
 * @author Z4Knight
 *
 */
public class Count implements Sort{
	@Override
	public void sort(int[] array) {
		// TODO Auto-generated method stub
		int n = array.length;
		if (n < 2 || array == null) {
			return;
		}
		// 找出 array 的范围
		int min = array[0];
		int max = array[0];
		for (int i = 0; i < n; i++) {
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
		}
		// 创建计数数组
		int[] countArray = new int[max - min + 1];
		// 将原数组中的值放进对应计数数组中的位置
		for (int i = 0; i < n; i++) {
			countArray[array[i] - min]++;
		}
		// 从计数数组中取出对应存放次数与下标，即 array 有序
		int index = 0;
		for (int i = 0; i < countArray.length; i++) {
			while (countArray[i]-- > 0) {
				array[index++] = i + min;
			}
		}
		
	}
}
