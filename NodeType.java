public class NodeType {
	public ItemType info;
	public NodeType next;
	
	public NodeType(int val) {
		ItemType obj = new ItemType();
		obj.initialize(val);
		this.info = obj; 
	}
	
	public NodeType(ItemType obj) {
		this.info = obj; 
	}
	
	public NodeType() {
	}
}
