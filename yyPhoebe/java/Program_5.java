
public class Program_5 {

	private String str;

	public Program_5(String s) {
		str = s;
	}

	public boolean getSubstring() {

		int len = str.length();
		boolean flag = false;
		String subStr;

		label: for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j <= len - 1; j++) {
				subStr = str.substring(i, j); // 获取字串
				if (((len % (j - i)) == 0) && ((j - i) <= len / 2)) { //長度能夠整除str，小於一半長度
					flag = judgesubString(subStr, str);
					if (flag == true) {
						System.out.println(str + "可由" + subStr + "重复组成");
						break label;
					}
				}
			}
		}

		return flag;
	}

	public boolean judgesubString(String subStr, String str) {

		boolean flag = true;
		label:
		for (int i = 0; i <= str.length() - subStr.length(); i += subStr.length()) {
			for (int j = 0; j < subStr.length(); j++) {
				// System.out.println("judge" + i + "," + j);
				// System.out.println(str.charAt(i + j) + "," + subStr.charAt(j));
				if (str.charAt(i + j) != subStr.charAt(j)) {
					flag = false;
					break label;
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {

		Program_5 s = new Program_5("aadaaada");
		System.out.println(s.getSubstring());

	}
}
