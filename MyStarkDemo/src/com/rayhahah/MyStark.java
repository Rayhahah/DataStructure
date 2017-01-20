package com.rayhahah;

/**
 * ջ�ṹDemo
 * 
 * MyStark(int capacity) ���췽����ָ��ջ�Ĵ�С
 * destoryStark() ����ջ 
 * clearStark() ���ջ��Ԫ��
 * isFull() ����
 * isEmpty() �п� 
 * push(T t) ��ջ 
 * pop() ��ջ 
 * traverseQueue(boolean isFromBottom) ����ջ(�Ƿ�ӵײ���ʼ) 
 * abstract onTraverse(T t) ������Ԫ�ؾ���ҵ���߼�
 * 
 * @author Rayhahah
 *
 * @param <T> ջԪ������
 * ��Ϊ��Ž����е�Ԫ��������δ֪�� 
 * ���ǿ���ȷ������һ�����������Ԫ�ػ����ǹ̶���
 * ��������ʹ���˷��ͣ����û�����ʹ�õ�ʱ���ȥȷ��
 */
public abstract class MyStark<T> {

	// ջ����
	// ʹ��Object����ͷ�����Ϊ���ö��п��Լ��ݸ������͵Ķ���
	private Object[] mStark;
	// ջ����
	private int mCapacity;
	// ��ǰջ��λ��
	private int mTop;

	/**
	 * ���췽��
	 * 
	 * @param capacity
	 *            ջ����������С��
	 */
	public MyStark(int capacity) {
		mCapacity = capacity;
		mStark = new Object[capacity];
		clearStark();
	}

	/**
	 * ����ջ ��ʱ�ͷ���Դ
	 */
	public void destoryStark() {
		clearStark();
		mStark = null;
		System.gc();
	}

	/**
	 * ���ջ��Ԫ��
	 */
	public void clearStark() {
		mTop = 0;
	}

	/**
	 * �жϵ�ǰջ�Ƿ��Ѿ�����
	 * 
	 * @return ����true, ���� ��false
	 */
	public boolean isFull() {
		return mTop == mCapacity;
	}

	/**
	 * �жϵ�ǰջ�Ƿ�Ϊ��
	 * 
	 * @return �գ�true, ���� ��false
	 */
	public boolean isEmpty() {
		return 0 == mTop;
	}

	/**
	 * ��Ԫ����ӵ�ջ��(��ջ)
	 * 
	 * @param t ��Ҫ��ջ��Ԫ��
	 * @return ��ջ�Ƿ�ɹ�
	 */
	public boolean push(T t) {
		if (isFull()) {
			return false;
		}
		mStark[mTop] = t;
		mTop++;

		return true;
	}

	/**
	 * ��ջ����
	 * 
	 * @return ���ص�ǰ��ջ��Ԫ��
	 */
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		//��Ҫע�����
		//��Ϊ����ջ��ʱ��mTop++�ˣ�����������Ӧ����--���ٳ�ջ�����ջΪnull;
		mTop--;
		return (T) mStark[mTop];
	}

	/**
	 * ����ջ��Ԫ��
	 * @param isFromBottom �Ƿ��ջ�׿�ʼ����
	 */
	public void traverseStark(boolean isFromBottom) {
		if (isFromBottom) {
			for (int i = 0; i < mTop; i++) {
				onTraverse((T) mStark[i]);

			}
		} else {
			for (int i = mTop - 1; i >= 0; i--) {
				onTraverse((T) mStark[i]);
			}
		}
	}

	/**
	 * ���ڱ�����Ԫ������Ҫ���ľ����߼�
	 * @param t ��ǰ��������Ԫ��
	 * ���崦����ж���ķ���
	 * ����ʹ�ó��󷽷���Ϊ��
	 * ���ڶ���ľ��崦���߼�������ͬ�����Ծ���ʵ�ֽ����û��Լ�ȥ���
	 */
	public abstract void onTraverse(T t);
}
