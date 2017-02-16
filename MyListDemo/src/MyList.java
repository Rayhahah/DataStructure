/**
 * ���Ա� ˳������飩
 * 
 * MyList(int size) ���캯��ָ����С 
 * void destory() ����˳������ 
 * void clear() ���˳�����Ԫ��
 * boolean isEmpty() �п� 
 * boolean isFull() ���� 
 * int getLength() ��ȡ��ǰ˳����� 
 * T get(int position) ����λ�û�ȡ˳�����Ԫ�ض��� 
 * int getPosition(T t) ���� Ԫ�ض����ȡ˳���λ�� 
 * T prior(T t)��ȡ����ǰ�� 
 * T next(T t) ��ȡ������
 * 
 * boolean insert(T t) / insert(int position, T t) 
 * ��˳��������󣬲���λ�þ�Ĭ���������룬����!����!�ڲ�����insert(int position, T t)
 * 
 * boolean delete(T t) / delete(int position) 
 * ���ݶ������λ��ɾ��˳��� ��Ԫ��
 * 
 * void traverse(int position) 
 * ����˳��� 
 * 
 * abstract void onTraverse()
 * ����˳���õ�����ľ������
 * @author Rayhahah
 *
 * @param <T> ��ǰ˳����е�Ԫ�ض�������
 */
public abstract class MyList<T> {
	private int mCapacity;
	private Object[] mList;
	private int mLength;

	/**
	 * ���캯��
	 * 
	 * @param size
	 *            ָ��˳�������
	 */
	public MyList(int size) {
		mCapacity = size;
		mList = new Object[mCapacity];
	}

	/**
	 * �ݻٵ�ǰ˳���
	 */
	public void destory() {
		clear();
		mCapacity = 0;
		mList = null;
		System.gc();
	}

	/**
	 * ���˳��� ֻ��Ҫ��������Ϊ0�Ϳ�����
	 *  ��Ϊ��ȡ�������ݵ�ʱ�򣬶���Ҫ��length���ж�
	 */
	public void clear() {
		mLength = 0;
	}

	/**
	 * �жϵ�ǰ˳����Ƿ�Ϊ��
	 * 
	 * @return �գ�true�� �ǿգ�false
	 */
	public boolean isEmpty() {
		return mLength == 0;
	}

	/**
	 * �жϵ�ǰ˳����Ƿ�Ϊ��
	 * 
	 * @return ����true�� δ����false
	 */
	public boolean isFull() {
		return mLength == mCapacity;
	}

	/**
	 * ��ȡ��ǰ ˳���ĳ��� ע�ⲻ������
	 * 
	 * @return
	 */
	public int getLength() {
		return mLength;
	}

	/**
	 * ���������ȡ˳����Ԫ��
	 * 
	 * @param position
	 *            ����
	 * @return ˳���Ԫ��
	 */
	public T get(int position) {
		// �����㶼����null
		if (position < 0 || position >= mLength || mList == null) {
			return null;
		}

		return (T) mList[position];
	}

	/**
	 * ���ݴ���Ԫ�ط���Ԫ����˳����е����� 
	 * �ж������� Ԫ�صĵ�ַ
	 * 
	 * @param t
	 * @return Ԫ����������
	 */
	public int getPosition(T t) {
		if (isEmpty()) {
			return -1;
		}

		for (int i = 0; i < mLength; i++) {
			if (t == mList[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * ��ȡ����Ԫ�ص�ǰ�� �ж�����Ԫ�صĵ�ַ
	 * 
	 * @param t
	 * @return
	 */
	public T prior(T t) {
		if (isEmpty()) {
			return null;
		}
		for (int i = 1; i < mLength; i++) {
			if (t == mList[i]) {
				return (T) mList[i - 1];
			}
		}
		return null;
	}

	/**
	 * ��ȡ����Ԫ�صĺ�� �ж����� Ԫ�صĵ�ַ
	 * 
	 * @param t
	 * @return
	 */
	public T next(T t) {
		if (isEmpty()) {
			return null;
		}
		for (int i = 0; i < mLength; i++) {
			if (t == mList[i]) {
				return (T) mList[i + 1];
			}
		}
		return null;
	}

	/**
	 * ����Ԫ�أ���ָ��λ��Ĭ�ϲ�����˳������� 
	 * ���˳����Ѿ����ˣ��ͷ���false ����ɹ�����true
	 * 
	 * @param t
	 * @return
	 */
	public boolean insert(T t) {
		if (isFull()) {
			return false;
		}
		mList[mLength] = t;
		mLength++;
		return true;
	}

	/**
	 * ��ָ��λ�ò���Ԫ�أ�����Ԫ�������һλ
	 * 
	 * @param position
	 * @param t
	 * @return
	 */
	public boolean insert(int position, T t) {
		T tar = t;
		T temp = null;
		// �����Ժ󳤶Ȳ��ٱ仯
		if (!isFull()) {
			mLength++;
		}
		for (int i = position; i < mLength; i++) {
			if (temp != null) {
				tar = temp;
			}
			temp = (T) mList[i];
			mList[i] = tar;
		}
		return true;
	}

	/**
	 * ɾ��˳����е�ָ��Ԫ��
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(T t) {
		if (isEmpty()) {
			return false;
		}
		T temp = null;
		boolean flag = false;
		for (int i = 0; i < mLength; i++) {
			//�ҵ�ɾ��Ԫ���Ժ�Ϳ�ʼ������Ԫ��ǰ��
			if (t == mList[i]) {
				mLength--;
				if (i == mLength) {
					return true;
				}
				flag = true;
			}
			if (i != mLength) {
				temp = (T) mList[i + 1];
			}
			if (flag) {
				mList[i] = temp;
				if (i == mLength) {
					return true;
				}

			}
		}
		return false;
	}

	/**
	 * ɾ��˳����е�ָ��λ�õ�Ԫ��
	 * 
	 * @param position
	 * @return
	 */
	public boolean delete(int position) {
		if (isEmpty() || position >= mLength || position < 0) {
			return false;
		}
		for (int i = position; i < mLength; i++) {
			System.out.println(i);
			if (i + 1 >= mLength) {
				mLength--;
				return true;
			}
			mList[i] = mList[i + 1];
			System.out.println(mList[i]);
		}
		return true;
	}

	/**
	 * Ĭ�ϱ���Ϊ��������˳���
	 */
	public void traverse() {
		traverse(0);
	}

	/**
	 * ָ����ʼ������λ��
	 * 
	 * @param position
	 */
	public void traverse(int position) {
		for (int i = position; i < mLength; i++) {
			onTraverse((T) mList[i]);
		}
	}

	/**
	 * �����õ�Ԫ������Ҫ�ľ������
	 *  ���ظ��û��Լ�ȷ��
	 * 
	 * @param t
	 */
	public abstract void onTraverse(T t);

}
