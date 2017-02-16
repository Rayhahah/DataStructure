
public class Test {
	public static void main(String[] args) {
		MyLinkedList<People> linkList = new MyLinkedList<People>() {
			@Override
			public void onTraverse(People t) {
				System.out.println(t.toString());
			}
		};

		for (int i = 0; i < 10; i++) {
			People p = new People("hello" + i, i);
			linkList.insert(p);
		}
		linkList.delete(4);
		People ple=new People("hah",100);
		linkList.insert(2,ple);
		linkList.traverse();
		System.out.println(linkList.get(8));
		System.out.println(linkList.getPosition(ple));

	}
}
