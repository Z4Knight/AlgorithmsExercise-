package exercise_sort_bubble;

import exercise_sort_impl.Sort;
/**
 * ð������
 * @author Z4Knight
 *
 */

public class Bubble implements Sort{

	@Override
	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			// ��������������
			for (int j = 0; j < array.length - i - 1; j++) {
				// ���� a[j] �� a[array,length - i - 1]��˳��
				// ÿ�αȽ�ǰ����������ǰһ�����Ⱥ�һ�����󣬾������ƶ������λ��Ϊ������
				if (array[j] > array[j + 1]) {
					int t = array[j];
					array[j] = array[j + 1];
					array[j + 1] = t;
				}
			}
		}
		
	}
}
