import java.util.ArrayList;
import java.util.Collections;


public class Main {

	public static void main(String[] args) {
		// initialize arraylist to hold elements to add
		ArrayList<Element> list = new ArrayList<Element>();
		
		// initialize binary search trees
		Tree<Element> tree = new Tree<Element>();
		Tree<Element> treeRand = new Tree<Element>();  //random tree
		
		// add Elements to ArrayList
		for (int i = 0; i < 1023; i++) {
			list.add(new Element(i));
		}
		
		System.out.println("");
		
		// insert elements from array list into the BST to generate balanced tree
		System.out.print("Creating balanced tree... ");
		tree.treeCreate(list);
		System.out.println("");
		
		// Balanced Tree
		System.out.print("Balanced Tree: ");
		tree.printTree();
		System.out.println("");
		System.out.println("Size: " + tree.getSize());
		System.out.println("Depth: " + tree.treeDepth());
		System.out.println("Shuffling list... ");
		Collections.shuffle(list);
		System.out.println("Deleting... ");
		for (int i = 0; i < 125; i++) {
			System.out.print(" " + list.get(i).getNum());
			tree.treeDelete(list.get(i));
		}
		System.out.println("");
		System.out.println("Re-inserting...");
		for (int i = 0; i < 60; i++) {
			System.out.print(" " + list.get(i).getNum());
			tree.treeInsert(list.get(i));
		}
		System.out.println("");
		//System.out.println("New Depth: " + tree.treeDepth());
		System.out.println("Done with balanced tree.");
		System.out.println("");
		
		// insert integers from array list into the BST
		System.out.print("Creating random tree: ");
		treeRand.treeCreate(list);
		System.out.println("");
		
		System.out.print("randTree: ");
		treeRand.printTree();
		System.out.println("");
		System.out.println("Size: " + treeRand.getSize());
		System.out.println("Depth: " + treeRand.treeDepth());
		System.out.print("Deleting: ");
		for (int i = 0; i < 150; i++) {
			System.out.print(" "+ list.get(i).getNum());
			treeRand.treeDelete(list.get(i));	
		}
		System.out.println("");
		System.out.print("Re-Inserting: ");
		for (int i = 0; i < 60; i++) {
			System.out.print(" " + list.get(i).getNum());
			treeRand.treeInsert(list.get(i));
		}
		System.out.println("");
		System.out.println("New Depth: " + treeRand.treeDepth());
		System.out.println("Done with random tree.");
		System.out.println("");
		
	}

}
