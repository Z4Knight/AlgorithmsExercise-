package exercise_sort_shell;

import exercise_sort_impl.Sort;
/**
 * 希尔排序
 * @author Z4Knight
 *
 */
public class Shell implements Sort{

	// 通过在插入排序的基础之上，增加间隔 h 有序的思想
	@Override
	public void sort(int[] array) {
		int n = array.length;
		// 定义步进长度
		int h = 1;
		// 创建一个递增序列
		while (h < n/3) {
			h = 3*h + 1;// 1，4，13，40，121，364，1093，...
		}
		
		while (h >= 1) {
			// 通过插入排序，将数组变为 h 有序
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h; j -= h) {
					if (array[j] < array[j - h]) {
						int t = array[j];
						array[j] = array[j - h];
						array[j - h] = t;
					}
				}
			}
			
			h = h/3;
		}
	}
}
