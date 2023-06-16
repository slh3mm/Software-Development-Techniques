import jdk.swing.interop.SwingInterOpUtils;

/**
 * <p>This is the class you will complete - fill in all the missing method implementations</p>
 *
 *  * <p>All the classes have been created for you, you must implement the ActorTree class methods.
 * If your BST works correctly, searches made against it should return in almost no time at all.</p>
 *
 * @author Your friendly CS professors
 *
 */
public class ActorTree {
	/**
	 * ActorTree has only one property, the root node
	 */
	Node root;

	/**
	 * Initialize the root node in the default constructor
	 */
	public static void main(String[] args){
	//Overloaded Constructor
		Actor testActor = new Actor("spenny");
		Actor ac1 = new Actor("matt");
		Actor ac2 = new Actor("joe");
		Actor ac3 = new Actor("zach");
		Actor ac4 = new Actor("nate");

		Actor testActor2 = new Actor("winston");
		Actor ac6 = new Actor("xander");
		Actor ac7 = new Actor("tyler");
		Actor ac8 = new Actor("chris");

		Actor testActor3 = new Actor();

		ActorTree testAT = new ActorTree();
		ActorTree testAT2 = new ActorTree();
		ActorTree testAT3 = new ActorTree();

	//Insert
		testAT.insert(testActor);
		testAT.insert(ac1);
		testAT.insert(ac2);
		testAT.insert(ac3);
		testAT.insert(ac4);

		testAT2.insert(testActor2);
		testAT2.insert(ac6);
		testAT2.insert(ac7);
		testAT2.insert(ac8);

		testAT3.insert(testActor3);

	//Size, find, isEmpty, height, and inOrder
		System.out.println(testAT.size());
		System.out.println(testAT.find("joe"));
		System.out.println(testAT.find(null));
		System.out.println(testAT.isEmpty());
		System.out.println(testAT.height());
		System.out.println(testAT.inOrder());
		System.out.println();

		System.out.println(testAT2.size());
		System.out.println(testAT2.find("winston"));
		System.out.println(testAT2.find(null));
		System.out.println(testAT2.isEmpty());
		System.out.println(testAT2.height());
		System.out.println(testAT2.inOrder());

		System.out.println(testAT3.size());
		System.out.println(testAT3.find(""));
		System.out.println(testAT3.find(null));
		System.out.println(testAT3.isEmpty());
		System.out.println(testAT3.height());
		System.out.println(testAT3.inOrder());
	}
	public ActorTree() {
		root = new Node();
	}

	/**
	 *
	 * @param name
	 *            - the name to find
	 * @return the matching Actor object
	 */
	public Actor find(String name) {
		return root.find(name);
	}

	/**
	 *
	 * @return an int representing 1 for each node in the tree
	 *
	 */
	public int size() {
		return root.size();
	}

	/**
	 *
	 * @return an int representing the maximum height of any branch
	 */
	public int height() {
		return root.height();
	}

	/**
	 * an empty tree is one with no data
	 *
	 * @return boolean - True if the tree is empty
	 */
	public boolean isEmpty() {
		return root.size() == 0;
	}

	/**
	 *
	 * @param a
	 *            - an Actor object
	 * @return boolean - True if the element was inserted
	 */
	public boolean insert(Actor a) {
		return root.insert(a);
	}

	/**
	 * In order Traversal
	 *
	 * @return a String representing the in-order traversal of this tree
	 */
	public String inOrder() {
		return root.inOrder();
	}

	/**
	 * The Node class is an inner class of the ActorTree This is a Binary Search
	 * Tree, so each Node will have left and right children
	 *
	 * @author Your friendly CS Professors
	 *
	 */
	class Node {
		Actor actor;
		Node left;
		Node right;

		/**
		 * default constructor
		 */
		public Node() {
			actor = new Actor();
		}

		/**
		 * Constructor that takes an Actor object
		 *
		 * @param a
		 *            - an Actor left and right children are initialized to null
		 */
		public Node(Actor a) {
			actor = a;
		}

		/**
		 * The size method is recursive
		 *
		 * @return an int to represent a count of all nodes
		 */
		public int size() {
			if (this.actor.getPrimaryName() == null){
				return 0;
			}
			if (left == null && right == null){
				return 1;
			}
			if (left == null){
				return 1 + right.size();
			}
			if (right == null){
				return left.size() + 1;
			}

			return 1 + left.size() + right.size();
		}

		/**
		 * The height method is recursive
		 *
		 * @return an int to represent the maximum height of right or left child nodes,
		 *         plus 1 for the current node
		 */
		public int height() {
			if (this.actor.getPrimaryName() == null){
				return 0;
			}
			if (left == null && right == null){
				return 1;
			}
			if (left == null){
				return 1 + right.height();
			}
			if (right == null){
				return left.height() + 1;
			}

			return Math.max(left.height(), right.height()) + 1;
		}

		/**
		 * The insert method finds the best place to insert the Actor argument
		 *
		 * @param a
		 *            - an Actor to insert
		 * @return boolean - True if the Actor argument was added, false otherwise
		 */
		public boolean insert(Actor a) {
			if (this.actor.getPrimaryName() == null){
				this.actor = a;
				return true;
			}
			int returnComp = a.compareTo(this.actor);

			if (returnComp <= 0 && this.left == null){
				this.left = new Node(a);
				return true;
			}
			if (returnComp <= 0){
				return this.left.insert(a);
			}
			if (returnComp > 0 && this.right == null){
				this.right = new Node(a);
				return true;
			}
			if (returnComp > 0){
				return this.right.insert(a);
			}
			return false;
		}

		/**
		 * The find method returns an Actor object with a matching name
		 *
		 * @param name
		 *            - the name to search for
		 * @return the searched for Actor, or null
		 */
		public Actor find(String name) {
			if (name == null || this.actor.getPrimaryName() == null){
				return null;
			}

			int returnFind = name.compareTo(this.actor.getPrimaryName());

			if (returnFind == 0){
				return actor;
			}
			if (returnFind < 0 && this.left != null){
				return this.left.find(name);
			}
			if (returnFind > 0 && this.right != null){
				return this.right.find(name);
			}
			return null;
		}


		/**
		 * In order Traversal
		 *
		 * @return a String representing the in-order traversal of the subtree rooted at this node
		 */
		public String inOrder() {
			if (this.left == null && this.right == null){
				return this.actor.toString() + "\n";
			}
			if (this.left == null){
				return this.actor.toString() + "\n"  + this.right.inOrder();
			}
			if (this.right == null){
				return this.left.inOrder() + this.actor.toString() + "\n";
			}
			return this.left.inOrder() + this.actor.toString() + "\n" + this.right.inOrder();
		}
	}

}
