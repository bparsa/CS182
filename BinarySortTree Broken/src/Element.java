
public class Element implements Comparable<Element> {
	private Integer num;
	
	public Element (int aNum) {
		num = aNum;
	}
	
	public Integer getNum() {
		return num;
	}
	
	public String toString() {
		return num.toString();
	}
	
	@Override
	public int compareTo(Element o) {
		if (num > o.getNum()) {
			return 1;
		}
		else if (num < o.getNum()) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
