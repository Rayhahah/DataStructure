/**
 * �ڵ���
 * 
 * pior ǰ�ڵ� next ��ڵ� T �����нڵ���崢�������
 * 
 * @author Rayhahah
 */
public class MyNode<T> {
	public T t;
	public MyNode next;

	public MyNode(T t, MyNode next) {
		super();
		this.next = next;
		this.t = t;
	}

}
