/**
 * 环形队列Demo
 * 简单环形队列的构建
 * 
 * MyQueue(int capacity) 构造方法（队列大小）
 * clearQueue() 清空队列
 * destoryQueue() 销毁队列对象
 * isEmpty() 队列判空 
 * isFull() 队列判满
 * EnQueue(T t) 入队
 * DeQueue() 出队，返回队列的元素
 * traverseQueue() 遍历队列
 * doSomething(T t) 具体实现逻辑,让用户具体实现
 * 
 * @author Rayhahah
 * 
 * @param <T> 队列元素
 * 因为存放进队列的元素我们是未知的
 * 但是可以确定的是一个队列里面的元素基本是固定的
 * 所以这里使用了泛型，让用户真正使用的时候才去确定
 * 		
 */
public abstract class MyQueue<T extends Object> {
	
	//队列对象
	//使用Object数组和泛型是为了让队列可以兼容各种类型的对象 
	private Object[] mQueue;
	//队列当前长度
	private int mLength;
	//队列容量
	private int mCapacity;
	//队头，出队时出队的位置
	private int mHead;
	//队尾，入队时入队的位置
	private int mEnd;

	/**
	 * 构造方法 
	 * @param capacity 队列的容量大小
	 * 
	 */
	public MyQueue(int capacity) {
		mCapacity = capacity;
		//初始化参数
		mQueue = new Object[mCapacity];
		clearQueue();
	}

	/**
	 * 清空队列内的参数
	 */
	public void clearQueue() {
		mLength = 0;
		mHead = 0;
		mEnd = 0;
	}

	/**
	 * 销毁队列
	 * 及时释放资源
	 */
	public void destoryQueue() {
		clearQueue();
		mQueue = null;
		System.gc();
	}

	/**
	 * 判断当前队列是否为空
	 * 空：true  否则： false
	 * @return 
	 */
	public boolean isEmpty() {
		return mLength == 0;
	}

	/**
	 * 判断当前队列是否已经满了
	 * 满：true， 否则：false
	 * @return
	 */
	private boolean isFull() {
		return mLength == mCapacity;
	}

	/**
	 * 获取当前队列长度
	 * @return
	 */
	public int getLength() {
		return mLength;
	}

	/**
	 * 添加元素到队列当中（入队）
	 * 从队尾开始入队
	 * @param t 需要入队的对象
	 * @return 入队是否成功
	 */
	public boolean EnQueue(T t) {
		if (isFull()) {
			return false;
		}
		mQueue[mEnd] = t;
		mEnd++;
		mLength++;
		
		/**
		 * 因为是环形队列模型，所以当队头出队以后
		 * 就会空出位置，队尾自然就可以往空位置上移动
		 * 所以这里使用 % 来处理循环
		 */
		mEnd = mEnd % mCapacity;

		return true;
	}

	/**
	 * 返回队头位置的元素对象（出队）
	 * 
	 * @return 队头对象
	 */
	public T DeQueue() {
		if (isEmpty()) {
			return null;
		}
		T t = (T) mQueue[mHead];
		mHead++;
		mLength--;
		//这里使用的原理和出队是一样的可以看一下上面:)
		mHead = mHead % mCapacity;
		return t;
	}
	
	/**
	 * 遍历当前队列全部对象
	 */
	public void traverseQueue(){
		for (int i = mHead; i < mHead + mLength; i++) {
			doSomething((T) mQueue[i%mCapacity]);
		}
	}
	
	/**
	 * 具体处理队列对象的方法
	 * 这里使用抽象方法因为：
	 * 对于对象的具体处理逻辑各不相同，所以具体实现交给用户自己去完成
	 * @param t
	 */
	public abstract void doSomething(T t);

}
