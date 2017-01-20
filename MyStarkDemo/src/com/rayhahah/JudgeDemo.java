package com.rayhahah;
/**
 * ����ƥ��Ӧ�ò���
 */
public class JudgeDemo {
	public static void main(String[] args) {
		String str = "{[(aa)]nb}";
		boolean b = judgeTest(str);
		System.out.println(b);
	}

	/**
	 * ջ������ƥ���е�Ӧ��
	 * ��: {([[aa]]bb)c}, ��ƥ�䣬
	 * 	  {([[aa]]bb)c}}}, ��ƥ��
	 * 
	 * ����:��ǰ�ַ��������ţ���������ջ��
	 * 			����Ҫ�������ţ������ų�ջ
	 * 			�ǲ���Ҫ�������ţ����ز�ƥ��
	 * 			�����ַ�����������
	 * ���:��������ջΪ�յ�ʱ�򣬾ͷ���ƥ��
	 * 
	 * @return ƥ�䣺true�� ����false
	 */
	public static boolean judgeTest(String str) {
		//���صı�־
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
		//Ŀ��ƥ�������
		String strNeeded = "";
		//ȥ���ո�
		str = str.trim();
		
		for (int i = 0; i < str.length(); i++) {
			//�ֶ����ɨ��
			String strTemp = str.substring(i, i + 1);
			
			if (!strTemp.equals(strNeeded)) {
				//��ǰ�ַ�����Ŀ�����ţ����������žͳɶ���ջ
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
					//����Ҫ�������ţ��Ͳ�ƥ��
					return false;
				default:
					break;
				}
			} else {
				//��Ҫ��������
				//��ǰջ�������ų�ջ
				//��ȡ������ջ��һ����Ϊ��Ҫ��������
				needStark.pop();
				strNeeded = myStark.pop();
				strNeeded = needStark.pop();
				needStark.push(strNeeded);
			}
		}
		//������ж�
		if (myStark.isEmpty() && flag) {
			return true;
		} else {
			return false;
		}
	}

}
