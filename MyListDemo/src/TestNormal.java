
public class TestNormal {
	public static void main(String[] args) {
		MyList<People> list = new MyList<People>(10) {
			@Override
			public void onTraverse(People t) {
				System.out.println(t.toString());
			}
		};

		for (int i = 0; i < 15; i++) {
			People p = new People("hello" + i, i, "hobby" + i);
			list.insert(p);
		}
		People peo = new People("insert1", 10, "hobby insert");
		boolean flag = list.insert(3, peo);
//		System.out.println(flag);
		list.delete(peo);
		list.delete(7);
		list.traverse();
	}
}
