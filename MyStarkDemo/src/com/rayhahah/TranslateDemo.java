package com.rayhahah;

/**
 * 进制转换测试
 */
public class TranslateDemo {
	public static void main(String[] args) {
		translateTest();
	}
	 	//需要转换的目标进制
		public final static int BINARY = 2;
		public final static int OCTONABRY = 8;
		public final static int HEXADECIMAL = 16;

		/**
		 * 栈在进制转换中的应用
		 * 
		 * 进制转换：
		 * 短除法：
		 * 	10进制转换成8进制为例子：
		 * 	
		 * 	num     num  / 8      num % 8	
		 *  263      32              7
		 * 	32        4              0
		 *  4         0              4
		 *  
		 *  最终结果： 263转换为八进制就   = 407;
		 *  其他转换也是一样的道理
		 */
		public static void translateTest() {
			//为了适配16进制9以后的ABCDEF
			String[] nums = { "0", "1", "2", "3", "4", "5", "6",
					"7", "8", "9", "A", "B", "C", "D", "E", "F" };
			//目标数字
			int num = 263;
			MyStark<Integer> myStark = new MyStark<Integer>(30) {
				@Override
				public void onTraverse(Integer t) {
					//得到的每一个结果都打印出来，不换行
					System.out.print(nums[t]);
				}
			};
			//短除法的实现逻辑
			while (num != 0) {
				//将余数放入栈中
				myStark.push(num % OCTONABRY);
				//商不为零就继续循环
				num = num / OCTONABRY;
			}
			//遍历栈，得到结果
			myStark.traverseStark(false);
		}

}
