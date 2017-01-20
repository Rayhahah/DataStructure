public class TestDemo {
	public static void main(String[] args) {
		MyQueue<People> mq=new MyQueue<People>(5) {

			@Override
			public void doSomething(People t) {
				System.out.println(t.toString());
				
			}
		};
		People p1=new People(10,"jack");
		People p2=new People(15,"Tom");
		People p3=new People(16,"hello");
		People p4=new People(17,"Nihao");
		People p5=new People(18,"haha");
		People p6=new People(20,"Jerry");
		mq.EnQueue(p1);
		mq.EnQueue(p2);
		mq.EnQueue(p3);
		mq.EnQueue(p4);
		mq.EnQueue(p5);
		mq.EnQueue(p6);
		
		mq.traverseQueue();
		System.out.println("----------------·Ö¸îÏß-----------------");
		
		mq.DeQueue();
		mq.DeQueue();
		mq.EnQueue(p6);
				
		mq.traverseQueue();
	}
}
