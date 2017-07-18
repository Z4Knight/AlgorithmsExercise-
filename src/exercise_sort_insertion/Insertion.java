package exercise_sort_insertion;

import exercise_sort_impl.Sort;
/**
 * ������������
 * @author Z4Knight
 *
 */
public class Insertion implements Sort{

	@Override
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			// ��������ע���Ǵ��±� 1 ��ʼ����Ϊ�������򲢲���Ҫ�ӵ�һ��Ԫ�ؿ�ʼ����
			for (int j = i; j > 0; j--) {
				// �� array[i] ���뵽 array[i-1]��array[i-2]��array[i-3] ... ��
				// ������������С�Ͳ��뵽ǰ��
				if (array[j] < array[j - 1]) {
					// ����
					int t = array[j];
					array[j] = array[j - 1];
					array[j - 1] = t;
				}
			}
		}
	}
}
