package com.rayhahah;

/**
 * 栈结构Demo
 * 
 * MyStark(int capacity) 构造方法，指定栈的大小
 * destoryStark() 销毁栈 
 * clearStark() 清空栈内元素
 * isFull() 判满
 * isEmpty() 判空 
 * push(T t) 入栈 
 * pop() 出栈 
 * traverseQueue(boolean isFromBottom) 遍历栈(是否从底部开始) 
 * abstract onTraverse(T t) 遍历的元素具体业务逻辑
 * 
 * @author Rayhahah
 *
 * @param <T> 栈元素类型
 * 因为存放进队列的元素我们是未知的 
 * 但是可以确定的是一个队列里面的元素基本是固定的
 * 所以这里使用了泛型，让用户真正使用的时候才去确定
 */
public abstract class MyStark<T> {

	// 栈对象
	// 使用Object数组和泛型是为了让队列可以兼容各种类型的对象
	private Object[] mStark;
	// 栈容量
	private int mCapacity;
	// 当前栈顶位置
	private int mTop;

	/**
	 * 构造方法
	 * 
	 * @param capacity
	 *            栈的容量（大小）
	 */
	public MyStark(int capacity) {
		mCapacity = capacity;
		mStark = new Object[capacity];
		clearStark();
	}

	/**
	 * 销毁栈 及时释放资源
	 */
	public void destoryStark() {
		clearStark();
		mStark = null;
		System.gc();
	}

	/**
	 * 清空栈内元素
	 */
	public void clearStark() {
		mTop = 0;
	}

	/**
	 * 判断当前栈是否已经满了
	 * 
	 * @return 满：true, 否则 ：false
	 */
	public boolean isFull() {
		return mTop == mCapacity;
	}

	/**
	 * 判断当前栈是否为空
	 * 
	 * @return 空：true, 否则 ：false
	 */
	public boolean isEmpty() {
		return 0 == mTop;
	}

	/**
	 * 将元素添加到栈中(入栈)
	 * 
	 * @param t 需要入栈的元素
	 * @return 入栈是否成功
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
	 * 出栈操作
	 * 
	 * @return 返回当前出栈的元素
	 */
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		//需要注意的是
		//因为在入栈的时候mTop++了，所以在这里应该先--，再出栈否则出栈为null;
		mTop--;
		return (T) mStark[mTop];
	}

	/**
	 * 遍历栈内元素
	 * @param isFromBottom 是否从栈底开始遍历
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
	 * 对于遍历的元素所需要做的具体逻辑
	 * @param t 当前遍历到的元素
	 * 具体处理队列对象的方法
	 * 这里使用抽象方法因为：
	 * 对于对象的具体处理逻辑各不相同，所以具体实现交给用户自己去完成
	 */
	public abstract void onTraverse(T t);
}
