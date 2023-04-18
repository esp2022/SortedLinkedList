import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LinkedListDriver {
	public static void main(String[] args) {

		SortedLinkedList li = new SortedLinkedList();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(args[0]));
			String line;
			while (null != (line = reader.readLine())) {
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					li.push(Integer.parseInt(st.nextToken()));
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File not found !!");
			System.exit(0);
		}

		li.setHead(li.mergeSort(li.getHead()));

		li.removeDuplicates();
		li.setCurrentPos(li.getHead());

		System.out.println("Commands:");
		System.out.println("(i) - Insert value");
		System.out.println("(d) - Delete value");
		System.out.println("(s) - Search value");
		System.out.println("(n) - Print next iterator value");
		System.out.println("(r) - Reset iterator");
		System.out.println("(a) - Delete alternate nodes");
		System.out.println("(m) - Merge lists");
		System.out.println("(t) - Find intersection");
		System.out.println("(p) - Print list");
		System.out.println("(l) - Print length");
		System.out.println("(q) - Quit program");

		Scanner scanner = new Scanner(System.in); 
		try {
			char input = '0';
			boolean flag = true;
			do {
				if (flag) {
					System.out.print("\nEnter a Command: ");
				} else {
					System.out.print("\nInvalid command try again: ");
				}
				flag = true;
				scanner = new Scanner(System.in);
				input = scanner.findInLine(".").charAt(0);
 				switch (input) {
					case 'i':
						System.out.print("\nEnter a number to insert: ");
						scanner = new Scanner(System.in);
						int value_insert = scanner.nextInt();
						ItemType item_insert = new ItemType();
						item_insert.initialize(value_insert);
						System.out.print("\nOrginal list: ");
						li.printList(li.getHead());
						li.insertItem(item_insert);
						System.out.print("\nNew List: ");
						li.printList(li.getHead());
						break;

					case 'd':
						System.out.print("\nEnter a number to delete: ");
						scanner = new Scanner(System.in);
						int value_delete = scanner.nextInt();
						ItemType item_delete = new ItemType();
						item_delete.initialize(value_delete);
						System.out.print("\nOrginal list: ");
						li.printList(li.getHead());
						li.deleteItem(item_delete);
						System.out.print("\nNew List: ");
						li.printList(li.getHead());
						break;

					case 's':
						System.out.print("\nEnter a number to search: ");
						scanner = new Scanner(System.in);
						int value_search = scanner.nextInt();
						ItemType item_search = new ItemType();
						item_search.initialize(value_search);
						int index = li.searchItem(item_search);
						System.out.print("\nOrginal list: ");
						li.printList(li.getHead());
						if (index == 0) {
							System.out.print("\nItem is not present in the list");
						} else if (index == -1) {
							System.out.print("\nThe list is empty");
						} else {
							System.out.print("\nThe item is present at index " + index);
						}
						break;

					case 'n':
						ItemType item_next = li.getNextItem();
						if (null != item_next)
							System.out.print("\n" + item_next.getValue());
						else
							System.out.print("\nThe end of the list has been reached");
						break;

					case 'r':
						li.resetList();
						System.out.println("Iterator is reset");
						break;

					case 'p':
						System.out.print("\nThe list is: ");
						li.printList(li.getHead());
						break;

					case 'l':
						System.out.print("\nThe length of the list is " + li.getLength());
						break;

					case 'a':
						System.out.print("\nOriginal list: ");
						li.printList(li.getHead());
						li.deleteAlternate();
						System.out.print("\nNew List: ");
						li.printList(li.getHead());
						break;

					case 'm':
						System.out.print("\nEnter the length of the new list: ");
						scanner = new Scanner(System.in);
						// int value_merge_length = scanner.nextInt();
						scanner.nextInt();
						System.out.print("\nEnter the numbers: ");
						scanner = new Scanner(System.in);
						String value_merge = scanner.nextLine();
						StringTokenizer st = new StringTokenizer(value_merge, " ");
						NodeType node_2 = null;
						while (st.hasMoreTokens()) {
							NodeType temp_node = new NodeType(Integer.parseInt(st.nextToken()));
							temp_node.next = node_2;
							node_2 = temp_node;
						}
						System.out.print("\nList 1: ");
						li.printList(li.getHead());

						System.out.print("\nList 2: ");
						li.printList(node_2);

						NodeType merged_node = li.mergeTwoLists(li.getHead(), node_2);
						li.setHead(li.mergeSort(merged_node));
						li.removeDuplicates();
						System.out.print("\nMerged list: ");
						li.printList(li.getHead());

						break;

					case 't':
						System.out.print("\nEnter the length of the new list: ");
						scanner = new Scanner(System.in);
						// int value_intersection_length = scanner.nextInt();
						scanner.nextInt();
						System.out.print("\nEnter the numbers: ");
						scanner = new Scanner(System.in);
						String value_intersection = scanner.nextLine();
						StringTokenizer string_intersection = new StringTokenizer(value_intersection, " ");
						NodeType node_intersection = null;
						while (string_intersection.hasMoreTokens()) {
							NodeType temp_node = new NodeType(Integer.parseInt(string_intersection.nextToken()));
							temp_node.next = node_intersection;
							node_intersection = temp_node;
						}
						System.out.print("\nList 1: ");
						li.printList(li.getHead());

						System.out.print("\nList 2: ");
						li.printList(node_intersection);

						NodeType intersectioned_node = li.getIntersectionNode(li.getHead(), node_intersection);
						System.out.print("\nIntersection of lists: ");
						if (null != intersectioned_node) {
							li.printList(intersectioned_node);
						}

						break;
					case 'q':
						System.out.println("Exiting the program...");
						break;

					default:
						flag = false;
						break;
				}
			} while (input != 'q');
		} finally {
			scanner.close();
		}

	}

}
