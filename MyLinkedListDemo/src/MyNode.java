/**
 * �ڵ���
 * 
 * pior ǰ�ڵ�
 * next ��ڵ�
 * T �����нڵ���崢�������
 * 
 * @author Rayhahah
 */
public class MyNode<T> {
	public MyNode pior;
	public T t;
	public MyNode next;
	
	public MyNode(MyNode pior, T t, MyNode next) {
		super();
		this.next = next;
		this.pior = pior;
		this.t = t;
	}
	
	
}
