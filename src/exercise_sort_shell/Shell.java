package exercise_sort_shell;

import exercise_sort_impl.Sort;
/**
 * ϣ������
 * @author Z4Knight
 *
 */
public class Shell implements Sort{

	// ͨ���ڲ�������Ļ���֮�ϣ����Ӽ�� h �����˼��
	@Override
	public void sort(int[] array) {
		int n = array.length;
		// ���岽������
		int h = 1;
		// ����һ����������
		while (h < n/3) {
			h = 3*h + 1;// 1��4��13��40��121��364��1093��...
		}
		
		while (h >= 1) {
			// ͨ���������򣬽������Ϊ h ����
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
