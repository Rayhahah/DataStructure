import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * MyLinkedList() 构造函数
 * void clearList() 清空链表数据
 * 
 * boolean isEmpty() 链表判空
 * int getLength() 链表的当前长度
 * 
 * T get(int position) 根据坐标获取链表中的元素
 * int getPosition(T t) 根据数据对象获取在链表中的位置坐标
 * 
 * boolean insert(T t) / insert(int position,T t) 
 * 向链表末尾插入数据对象 / 向指定位置插入数据对象
 * 
 * boolean delete(T t) / delete (int position) 
 * 删除在链表中的传入数据对象 / 删除指定位置的节点
 * 
 * void traverse(int position) 
 * 启动遍历链表
 * abstract void onTraverse() 
 * 遍历顺序表得到对象的具体操作
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
		first = new MyNode<T>(null, null);
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
		if (myNode.next == null && myNode.t == null) {
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
		MyNode<T> currentNodeBefore = null;
		//插入位置是头节点的情况
		if (position == 0) {
			MyNode<T> newNode = new MyNode<T>(t, first);
			first = newNode;
			return true;
		}
		for (int i = 0; i < position; i++) {
			currentNodeBefore = currentNode;
			currentNode = currentNode.next;
		}
		//指向后节点
		MyNode<T> newNode = new MyNode<>(t, currentNode);
		//前节点指向新节点就等于插入
		currentNodeBefore.next = newNode;
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
		MyNode<T> currentNodeBefore = null;
		for (int i = 0; i < position; i++) {
			currentNodeBefore = currentNode;
			currentNode = currentNode.next;
		}
		//将要删除的节点的前节点指向  要删除的节点的后节点
		//失去了联系节点就等于被删除了
		currentNodeBefore.next = currentNode.next;
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
		// 现在节点
		MyNode<T> currentNode = first;
		// 前节点
		MyNode<T> currentNodeBefore = null;
		while (currentNode.t != null) {
			if (currentNode.t == t) {
				// 头节点
				if (currentNodeBefore == null) {
					first = currentNode.next;
				} else {
					currentNodeBefore.next = currentNode.next;
				}
				return false;
			}
			currentNodeBefore = currentNode;
			currentNode = currentNode.next;
		}
		return false;
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
