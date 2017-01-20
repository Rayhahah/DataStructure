package com.rayhahah;

public class TestDemo {

	public static void main(String[] args) {
		 normalTest();
	}
	
	/**
	 * 使用测试
	 */
	public static void normalTest() {
		MyStark<People> myStark = new MyStark<People>(4) {

			@Override
			public void onTraverse(People t) {
				System.out.println(t.toString());
			}
		};
		People p1 = new People("Tom", 10);
		People p2 = new People("Jerry", 12);
		People p3 = new People("Hello", 14);
		People p4 = new People("Mike", 16);
		People p5 = new People("Ray", 18);
		myStark.push(p1);
		myStark.push(p2);
		myStark.push(p3);
		myStark.push(p4);
		myStark.push(p5);
		myStark.traverseStark(false);

		System.out.println("--------分割线-----------");
		myStark.pop();
		myStark.push(p5);
		myStark.traverseStark(false);
	}

}
