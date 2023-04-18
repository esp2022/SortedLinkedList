	private int value;
	
	public void initialize(int num) {
		this.value = num;
	}

	public int getValue() {
		return value;
	}

	public int compareTo(ItemType item) {
		return (this.value < item.value ? -1 : (this.value == item.value ? 0 : 1));
	}
}
