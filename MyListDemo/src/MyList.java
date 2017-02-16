/**
 * 线性表 顺序表（数组）
 * 
 * MyList(int size) 构造函数指定大小 
 * void destory() 销毁顺序表对象 
 * void clear() 清空顺序表内元素
 * boolean isEmpty() 判空 
 * boolean isFull() 判满 
 * int getLength() 获取当前顺序表长度 
 * T get(int position) 根据位置获取顺序表内元素对象 
 * int getPosition(T t) 根据 元素对象获取顺序表位置 
 * T prior(T t)获取对象前驱 
 * T next(T t) 获取对象后继
 * 
 * boolean insert(T t) / insert(int position, T t) 
 * 向顺序表插入对象，不传位置就默认在最后插入，这里!不是!内部调用insert(int position, T t)
 * 
 * boolean delete(T t) / delete(int position) 
 * 根据对象或者位置删除顺序表 内元素
 * 
 * void traverse(int position) 
 * 遍历顺序表 
 * 
 * abstract void onTraverse()
 * 遍历顺序表得到对象的具体操作
 * @author Rayhahah
 *
 * @param <T> 当前顺序表中的元素对象类型
 */
public abstract class MyList<T> {
	private int mCapacity;
	private Object[] mList;
	private int mLength;

	/**
	 * 构造函数
	 * 
	 * @param size
	 *            指定顺序表容量
	 */
	public MyList(int size) {
		mCapacity = size;
		mList = new Object[mCapacity];
	}

	/**
	 * 摧毁当前顺序表
	 */
	public void destory() {
		clear();
		mCapacity = 0;
		mList = null;
		System.gc();
	}

	/**
	 * 清空顺序表 只需要将长度置为0就可以了
	 *  因为获取表中内容的时候，都需要和length做判断
	 */
	public void clear() {
		mLength = 0;
	}

	/**
	 * 判断当前顺序表是否为空
	 * 
	 * @return 空：true， 非空：false
	 */
	public boolean isEmpty() {
		return mLength == 0;
	}

	/**
	 * 判断当前顺序表是否为满
	 * 
	 * @return 满：true， 未满：false
	 */
	public boolean isFull() {
		return mLength == mCapacity;
	}

	/**
	 * 获取当前 顺序表的长度 注意不是容量
	 * 
	 * @return
	 */
	public int getLength() {
		return mLength;
	}

	/**
	 * 根据坐标获取顺序表的元素
	 * 
	 * @param position
	 *            坐标
	 * @return 顺序表元素
	 */
	public T get(int position) {
		// 不满足都返回null
		if (position < 0 || position >= mLength || mList == null) {
			return null;
		}

		return (T) mList[position];
	}

	/**
	 * 根据传入元素返回元素在顺序表中的坐标 
	 * 判断依据是 元素的地址
	 * 
	 * @param t
	 * @return 元素所在坐标
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
	 * 获取传入元素的前驱 判断依据元素的地址
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
	 * 获取传入元素的后继 判断依据 元素的地址
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
	 * 插入元素，不指定位置默认插入在顺序表的最后 
	 * 如果顺序表已经满了，就返回false 插入成功返回true
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
	 * 向指定位置插入元素，其他元素向后退一位
	 * 
	 * @param position
	 * @param t
	 * @return
	 */
	public boolean insert(int position, T t) {
		T tar = t;
		T temp = null;
		// 满了以后长度不再变化
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
	 * 删除顺序表中的指定元素
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
			//找到删除元素以后就开始将后面元素前移
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
	 * 删除顺序表中的指定位置的元素
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
	 * 默认遍历为遍历整个顺序表
	 */
	public void traverse() {
		traverse(0);
	}

	/**
	 * 指定开始遍历的位置
	 * 
	 * @param position
	 */
	public void traverse(int position) {
		for (int i = position; i < mLength; i++) {
			onTraverse((T) mList[i]);
		}
	}

	/**
	 * 遍历得到元素所需要的具体操作
	 *  交回给用户自己确定
	 * 
	 * @param t
	 */
	public abstract void onTraverse(T t);

}
