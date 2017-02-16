import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * MyLinkedList() 构造函数
 * 
 * void clearList() 清空链表数据
 * 
 * boolean isEmpty() 链表判空
 * 
 * int getLength() 链表的当前长度
 * 
 * T get(int position) 根据坐标获取链表中的元素
 * 
 * int getPosition(T t) 根据数据对象获取在链表中的位置坐标
 * 
 * T prior(T t) 根据数据对象获取 前驱数据对象
 * 
 * T next(T t) 根据数据对象获取 后继数据对象
 * 
 * boolean insert(T t) / insert(int position,T t) 向链表末尾插入数据对象 / 向指定位置插入数据对象
 * 
 * boolean delete(T t) / delete (int position) 删除在链表中的传入数据对象 / 删除指定位置的节点
 * 
 * void traverse(int position) 启动遍历链表
 * 
 * abstract void onTraverse() 遍历顺序表得到对象的具体操作
 * 
 * @author Rayhahah
 *
 * @param <T>
 *            链表储存的数据对象类型
 */
public abstract class MyLinkedList<T> {
	private MyNode<T> first;
	private int mLength;

	public MyLinkedList() {
		first = new MyNode<T>(null, null, null);
		mLength = 0;
	}

	/**
	 * 判空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return mLength == 0;
	}

	/**
	 * 清空链表
	 */
	public void clear() {
		for (MyNode<T> temp = first; temp != null;) {
			MyNode<T> next = temp.next;
			temp.next = null;
			temp.pior = null;
			temp.t = null;
			temp = next;
		}
		mLength = 0;
	}

	/**
	 * 节点是否为空
	 * 
	 * @param myNode
	 * @return
	 */
	private boolean isNodeNull(MyNode<T> myNode) {
		if (myNode.next == null && myNode.pior == null && myNode.t == null) {
			return true;
		}
		return false;
	}

	/**
	 * 向链表最后插入节点
	 * 
	 * @param t
	 * @return
	 */
	public boolean insert(T t) {
		return insert(mLength, t);
	}

	/**
	 * 向指定位置插入及节点
	 * 
	 * @param position
	 * @param t
	 * @return
	 */
	public boolean insert(int position, T t) {
		if (position < 0 || position > mLength) {
			return false;
		}
		mLength++;
		MyNode<T> currentNode = first;
		if (position == 0) {
			MyNode<T> newNode = new MyNode<T>(null, t, first.next);
			if (first.next != null) {
				first.next.pior = newNode;
			}
			first = newNode;
		}
		for (int i = 0; i < position; i++) {
			currentNode = currentNode.next;
		}
		MyNode<T> newNode = new MyNode<>(currentNode.pior, t, currentNode);
		currentNode.pior.next = newNode;
		if (currentNode.next != null) {
			currentNode.next.pior = newNode;
		}
		return true;
	}

	/**
	 * 根据坐标删除节点
	 * 
	 * @param position
	 * @return
	 */
	public boolean delete(int position) {
		if (position < 0 || position >= mLength) {
			return false;
		}
		mLength--;
		if (position == 0) {
			return deleteFirst(first.next);
		}
		MyNode<T> currentNode = first;
		for (int i = 0; i < position; i++) {
			currentNode = currentNode.next;
		}
		currentNode.pior.next = currentNode.next;
		if (currentNode.next != null) {
			currentNode.next.pior = currentNode.pior;
		}
		return true;
	}

	/**
	 * 清楚头节点数据
	 * 
	 * @param node
	 * @return
	 */
	private boolean deleteFirst(MyNode<T> node) {
		first = node;
		if (first != null) {
			first.pior = null;
		}
		return true;
	}

	/**
	 * 删除包含有该数据对象的节点数据
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(T t) {
		if (isEmpty()) {
			return false;
		}

		mLength--;
		for (MyNode<T> x = first; !isNodeNull(x);) {
			if (x.t == t) {
				//删除的节点是头结点
				if (x.pior == null) {
					return deleteFirst(x.next);
				} else {
					x.pior.next = x.next;
					if (x.next != null) {
						x.next.pior = x.pior;
					}
					return true;
				}
			}
			x = x.next;
		}
		return true;
	}

	/**
	 * 根据坐标返回数据对象
	 * 
	 * @param position
	 *            坐标
	 * @return 数据对象
	 */
	public T get(int position) {
		if (position < 0 || position >= mLength) {
			return null;
		}
		MyNode<T> currentNode = first;
		// 移动至position就可以找到需要的数据对象了
		for (int i = 0; i < position; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.t;
	}

	/**
	 * 根据传入元素获取在链表中的坐标
	 * 
	 * @param t
	 *            需要查找坐标的对象
	 * @return 坐标
	 */
	public int getPosition(T t) {
		if (isEmpty()) {
			return -1;
		}
		int count = 0;// 获取当前查找到的坐标
		MyNode<T> currentNode = first;
		while (currentNode != null) {
			// 找到元素就返回
			if (currentNode.t == t) {
				return count;
			}
			count++;
			currentNode = currentNode.next;
		}
		return -1;
	}

	/**
	 * 遍历整个链表
	 */
	public void traverse() {
		MyNode<T> currentNode = first;
		while (currentNode.t != null) {
			onTraverse(currentNode.t);
			currentNode = currentNode.next;
		}
	}

	/**
	 * 遍历时对每个元素具体的操作
	 * 
	 * @param t
	 */
	public abstract void onTraverse(T t);

}
