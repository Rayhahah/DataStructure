/**
 * 节点类
 * 
 * pior 前节点
 * next 后节点
 * T 链表中节点具体储存的数据
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
