package exercise_sort_count;
import exercise_sort_impl.Sort;
/**
 * ��������
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
		// �ҳ� array �ķ�Χ
		int min = array[0];
		int max = array[0];
		for (int i = 0; i < n; i++) {
			max = Math.max(max, array[i]);
			min = Math.min(min, array[i]);
		}
		// ������������
		int[] countArray = new int[max - min + 1];
		// ��ԭ�����е�ֵ�Ž���Ӧ���������е�λ��
		for (int i = 0; i < n; i++) {
			countArray[array[i] - min]++;
		}
		// �Ӽ���������ȡ����Ӧ��Ŵ������±꣬�� array ����
		int index = 0;
		for (int i = 0; i < countArray.length; i++) {
			while (countArray[i]-- > 0) {
				array[index++] = i + min;
			}
		}
		
	}
}
