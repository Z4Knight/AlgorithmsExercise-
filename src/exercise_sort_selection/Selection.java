package exercise_sort_selection;

import exercise_sort_impl.Sort;

/**
 * ѡ����������
 * @author Z4Knight
 *
 */
public class Selection implements Sort {

	public  void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			// ���𽻻���Сֵ����������������һλ��ͬʱ������
			// �赱ǰ����Ϊ��Сֵ����
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				// �����¼δ������������Сֵ������ֵ
				if (a[min] > a[j]) {
					// ��¼��Сֵ����
					min = j;
				}
			}
			// ����
			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}
}
