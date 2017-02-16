import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * MyLinkedList() ���캯��
 * void clearList() �����������
 * 
 * boolean isEmpty() �����п�
 * int getLength() ����ĵ�ǰ����
 * 
 * T get(int position) ���������ȡ�����е�Ԫ��
 * int getPosition(T t) �������ݶ����ȡ�������е�λ������
 * 
 * boolean insert(T t) / insert(int position,T t) 
 * ������ĩβ�������ݶ��� / ��ָ��λ�ò������ݶ���
 * 
 * boolean delete(T t) / delete (int position) 
 * ɾ���������еĴ������ݶ��� / ɾ��ָ��λ�õĽڵ�
 * 
 * void traverse(int position) 
 * ������������
 * abstract void onTraverse() 
 * ����˳���õ�����ľ������
 * 
 * @author Rayhahah
 *
 * @param <T>
 *            ����������ݶ�������
 */
public abstract class MyLinkedList<T> {
	private MyNode<T> first;
	private int mLength;

	public MyLinkedList() {
		first = new MyNode<T>(null, null);
		mLength = 0;
	}

	/**
	 * �п�
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return mLength == 0;
	}

	/**
	 * �������
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
	 * �ڵ��Ƿ�Ϊ��
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
	 * ������������ڵ�
	 * 
	 * @param t
	 * @return
	 */
	public boolean insert(T t) {
		return insert(mLength, t);
	}

	/**
	 * ��ָ��λ�ò��뼰�ڵ�
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
		//����λ����ͷ�ڵ�����
		if (position == 0) {
			MyNode<T> newNode = new MyNode<T>(t, first);
			first = newNode;
			return true;
		}
		for (int i = 0; i < position; i++) {
			currentNodeBefore = currentNode;
			currentNode = currentNode.next;
		}
		//ָ���ڵ�
		MyNode<T> newNode = new MyNode<>(t, currentNode);
		//ǰ�ڵ�ָ���½ڵ�͵��ڲ���
		currentNodeBefore.next = newNode;
		return true;
	}

	/**
	 * ��������ɾ���ڵ�
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
		//��Ҫɾ���Ľڵ��ǰ�ڵ�ָ��  Ҫɾ���Ľڵ�ĺ�ڵ�
		//ʧȥ����ϵ�ڵ�͵��ڱ�ɾ����
		currentNodeBefore.next = currentNode.next;
		return true;
	}

	/**
	 * ���ͷ�ڵ�����
	 * 
	 * @param node
	 * @return
	 */
	private boolean deleteFirst(MyNode<T> node) {
		first = node;
		return true;
	}

	/**
	 * ɾ�������и����ݶ���Ľڵ�����
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(T t) {
		if (isEmpty()) {
			return false;
		}

		mLength--;
		// ���ڽڵ�
		MyNode<T> currentNode = first;
		// ǰ�ڵ�
		MyNode<T> currentNodeBefore = null;
		while (currentNode.t != null) {
			if (currentNode.t == t) {
				// ͷ�ڵ�
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
	 * �������귵�����ݶ���
	 * 
	 * @param position
	 *            ����
	 * @return ���ݶ���
	 */
	public T get(int position) {
		if (position < 0 || position >= mLength) {
			return null;
		}
		MyNode<T> currentNode = first;
		// �ƶ���position�Ϳ����ҵ���Ҫ�����ݶ�����
		for (int i = 0; i < position; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.t;
	}

	/**
	 * ���ݴ���Ԫ�ػ�ȡ�������е�����
	 * 
	 * @param t
	 *            ��Ҫ��������Ķ���
	 * @return ����
	 */
	public int getPosition(T t) {
		if (isEmpty()) {
			return -1;
		}
		int count = 0;// ��ȡ��ǰ���ҵ�������
		MyNode<T> currentNode = first;
		while (currentNode != null) {
			// �ҵ�Ԫ�ؾͷ���
			if (currentNode.t == t) {
				return count;
			}
			count++;
			currentNode = currentNode.next;
		}
		return -1;
	}

	/**
	 * ������������
	 */
	public void traverse() {
		MyNode<T> currentNode = first;
		while (currentNode.t != null) {
			onTraverse(currentNode.t);
			currentNode = currentNode.next;
		}
	}

	/**
	 * ����ʱ��ÿ��Ԫ�ؾ���Ĳ���
	 * 
	 * @param t
	 */
	public abstract void onTraverse(T t);

}
