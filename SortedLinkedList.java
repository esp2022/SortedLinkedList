public class SortedLinkedList {
	private NodeType head;
	private NodeType currentPos;

	SortedLinkedList() {

	}

	public NodeType getHead() {
		return head;
	}

	public void setHead(NodeType head) {
		this.head = head;
	}

	public NodeType getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(NodeType currentPos) {
		this.currentPos = currentPos;
	}

	void push(int new_data) {
		NodeType new_node_type = new NodeType(new_data);
		new_node_type.next = head;
		head = new_node_type;
	}
	
	//Will insert the item in the correct node and check for null
	void insertItem(ItemType item) {
		NodeType curr = head;
		while (curr != null) {
			if (curr.info.compareTo(item) == 0) {
				System.out.print("\nItem already exists");
				break;
			}
			curr = curr.next;
		}
		if (curr == null) {
			NodeType new_node_type = new NodeType(item);
			new_node_type.next = head;
			head = new_node_type;
		}
		head = mergeSort(head);
	}//insetItem
	
	//Will print the list
	void printList(NodeType headref) {
		while (headref != null) {
			System.out.print(headref.info.getValue() + " ");
			headref = headref.next;
		}
	}//printList
	
	//Will find the middle position of a node
	public static NodeType getMiddle(NodeType head) {
		if (head == null) {
			return head;
		}
		NodeType slow_node = head, fast_node = head;
		while (fast_node.next != null && fast_node.next.next != null) {
			slow_node = slow_node.next;
			fast_node = fast_node.next.next;
		}
		return slow_node;
	}//getMiddle

	//Will merge the two nodes
	NodeType sortedMerge(NodeType nxt_node, NodeType curr_node) {
		NodeType result = null;
		if (nxt_node == null) {
			return curr_node;
		}
		if (curr_node == null) {
			return nxt_node;
		}
		if (nxt_node.info.compareTo(curr_node.info) < 0) {
			result = nxt_node;
			result.next = sortedMerge(nxt_node.next, curr_node);
		} else {
			result = curr_node;
			result.next = sortedMerge(nxt_node, curr_node.next);
		}
		return result;
	}//sortedMerge

	//Will sort the merged list
	NodeType mergeSort(NodeType head_node) {
		if (head_node == null || head_node.next == null) {
			return head_node;
		}
		NodeType middle = getMiddle(head_node);
		NodeType nextofmiddle = middle.next;
		middle.next = null;
		NodeType left = mergeSort(head_node);
		NodeType right = mergeSort(nextofmiddle);
		NodeType sortedlist = sortedMerge(left, right);
		return sortedlist;
	}//mergeSort

	//Will remove duplicates from the node
	void removeDuplicates() {
		NodeType curr = head;
		while (curr != null) {
			NodeType temp = curr;
			while (temp != null && temp.info.getValue() == curr.info.getValue()) {
				temp = temp.next;
			}
			curr.next = temp;
			curr = curr.next;
		}
	}//removeDuplicates

	//Will get the length of the node
	int getLength() {
		int length = 0;
		NodeType curr = head;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		return length;
	}//getLength

	//Will getthe next item and check if the list is empty
	ItemType getNextItem() {
		ItemType obj = null;
		NodeType curr = currentPos;
		if (curr != null) {
			obj = curr.info;
			currentPos = curr.next;
		}
		else { 
			System.out.println("The list is empty");
		}
		return obj;
	}//getNextItem
	
	//Will reset the list
	void resetList() {
		currentPos = head;
	}//resetList

	//Will search the nodes for a specific index
	int searchItem(ItemType item) {
		boolean flag = false;
		int index = -1;
		NodeType curr = head;
		if (curr != null) {
			index++;
			while (curr != null) {
				index++;
				if (curr.info.getValue() == item.getValue()) {
					flag = true;
					break;
				}
				curr = curr.next;
			}
		}
		if (!flag) {
			index = 0;
		}
		return index;
	}//searchItem

	//Will delete an integer from the node
	void deleteItem(ItemType item) {
		NodeType curr_node = head, prev_node = null;

		if (curr_node != null && curr_node.info.getValue() == item.getValue()) {
			head = curr_node.next;
		} else {
			while (curr_node != null && curr_node.info.getValue() != item.getValue()) {
				prev_node = curr_node;
				curr_node = curr_node.next;
			}
			if (curr_node != null) {
				prev_node.next = curr_node.next;
			}
			if (curr_node == null) {
				System.out.println(item.getValue() + " The item is not present in the list");
			}
		}
	}//deleteItem

	//Will delete an alternate from a list
	void deleteAlternate() {
		if (head == null) {
			System.out.println("The list is empty");
			return;
		}
		NodeType node = head;
		while (node != null && node.next != null) {
			node.next = node.next.next;
			node = node.next;
		}
	}//deleteAlternate

	//Will merge both lists
	NodeType mergeTwoLists(NodeType l1, NodeType l2) {
		NodeType result = new NodeType(-1);
		NodeType p = result;

		while (l1 != null && l2 != null) {
			if (l1.info.getValue() <= l2.info.getValue()) {
				p.next = l1;
				l1 = l1.next;
			}

			else {
				p.next = l2;
				l2 = l2.next;
			}

			p = p.next;
		}

		if (l1 == null) {
			p.next = l2;
		}

		else if (l2 == null) {
			p.next = l1;
		}

		return result.next;
	}//mergeTwoLists

	//Will get the intersection values of the nodes
	NodeType getIntersectionNode(NodeType head1, NodeType head2) {
		while (head2 != null) {
			NodeType temp = head1;
			while (temp != null) {
				if (temp.info.getValue() == head2.info.getValue()) {
					return head2;
				}
				temp = temp.next;
			}
			head2 = head2.next;
		}
		return null;
	}//getIntersectionNode
}//SortedLinkedList
