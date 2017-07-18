package exercise_sort_insertion;

import exercise_sort_impl.Sort;
/**
 * 插入排序（升序）
 * @author Z4Knight
 *
 */
public class Insertion implements Sort{

	@Override
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			// 向后遍历，注意是从下标 1 开始，因为插入排序并不需要从第一个元素开始插入
			for (int j = i; j > 0; j--) {
				// 将 array[i] 插入到 array[i-1]、array[i-2]、array[i-3] ... 中
				// 如果后面的数更小就插入到前面
				if (array[j] < array[j - 1]) {
					// 交换
					int t = array[j];
					array[j] = array[j - 1];
					array[j - 1] = t;
				}
			}
		}
	}
}
