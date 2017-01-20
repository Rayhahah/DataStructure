package com.rayhahah;

/**
 * ����ת������
 */
public class TranslateDemo {
	public static void main(String[] args) {
		translateTest();
	}
	 	//��Ҫת����Ŀ�����
		public final static int BINARY = 2;
		public final static int OCTONABRY = 8;
		public final static int HEXADECIMAL = 16;

		/**
		 * ջ�ڽ���ת���е�Ӧ��
		 * 
		 * ����ת����
		 * �̳�����
		 * 	10����ת����8����Ϊ���ӣ�
		 * 	
		 * 	num     num  / 8      num % 8	
		 *  263      32              7
		 * 	32        4              0
		 *  4         0              4
		 *  
		 *  ���ս���� 263ת��Ϊ�˽��ƾ�   = 407;
		 *  ����ת��Ҳ��һ���ĵ���
		 */
		public static void translateTest() {
			//Ϊ������16����9�Ժ��ABCDEF
			String[] nums = { "0", "1", "2", "3", "4", "5", "6",
					"7", "8", "9", "A", "B", "C", "D", "E", "F" };
			//Ŀ������
			int num = 263;
			MyStark<Integer> myStark = new MyStark<Integer>(30) {
				@Override
				public void onTraverse(Integer t) {
					//�õ���ÿһ���������ӡ������������
					System.out.print(nums[t]);
				}
			};
			//�̳�����ʵ���߼�
			while (num != 0) {
				//����������ջ��
				myStark.push(num % OCTONABRY);
				//�̲�Ϊ��ͼ���ѭ��
				num = num / OCTONABRY;
			}
			//����ջ���õ����
			myStark.traverseStark(false);
		}

}
