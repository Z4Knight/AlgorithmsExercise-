package exercise_sort_impl;
/**
 * 排序接口，目的是为了测试方便
 * @author Z4Knight
 *
 */
public interface Sort {

	/**
	 * 子类实现 sort（）目的是为了通过多态的特性，来实现测试代码复用
	 * @param 待排序数组
	 */
	public void sort(int[] array);
}
