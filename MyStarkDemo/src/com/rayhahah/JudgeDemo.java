package com.rayhahah;
/**
 * 括号匹配应用测试
 */
public class JudgeDemo {
	public static void main(String[] args) {
		String str = "{[(aa)]nb}";
		boolean b = judgeTest(str);
		System.out.println(b);
	}

	/**
	 * 栈在括号匹配中的应用
	 * 如: {([[aa]]bb)c}, 则匹配，
	 * 	  {([[aa]]bb)c}}}, 则不匹配
	 * 
	 * 流程:当前字符是左括号，左括号入栈。
	 * 			是需要的右括号，左括号出栈
	 * 			是不需要的右括号，返回不匹配
	 * 			其他字符，不作处理
	 * 最后:当左括号栈为空的时候，就返回匹配
	 * 
	 * @return 匹配：true， 否则：false
	 */
	public static boolean judgeTest(String str) {
		//返回的标志
		boolean flag = true;
		MyStark<String> myStark = new MyStark<String>(30) {
			@Override
			public void onTraverse(String t) {

			}
		};
		MyStark<String> needStark = new MyStark<String>(30) {

			@Override
			public void onTraverse(String t) {

			}
		};
		//目标匹配的括号
		String strNeeded = "";
		//去除空格
		str = str.trim();
		
		for (int i = 0; i < str.length(); i++) {
			//字段逐个扫描
			String strTemp = str.substring(i, i + 1);
			
			if (!strTemp.equals(strNeeded)) {
				//当前字符不是目标括号，且是左括号就成对入栈
				switch (strTemp) {
				case "[":
					strNeeded = "]";
					myStark.push(strTemp);
					needStark.push(strNeeded);
					break;
				case "{":
					strNeeded = "}";
					myStark.push(strTemp);
					needStark.push(strNeeded);
					break;
				case "(":
					strNeeded = ")";
					myStark.push(strTemp);
					needStark.push(strNeeded);
					break;
				case "}":
				case "]":
				case ")":
					//不需要的右括号，就不匹配
					return false;
				default:
					break;
				}
			} else {
				//需要的右括号
				//当前栈顶左括号出栈
				//获取右括号栈下一个作为需要的右括号
				needStark.pop();
				strNeeded = myStark.pop();
				strNeeded = needStark.pop();
				needStark.push(strNeeded);
			}
		}
		//最后结果判断
		if (myStark.isEmpty() && flag) {
			return true;
		} else {
			return false;
		}
	}

}
