


import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;





public class Main extends JFrame {
	
	public Main() {
		//create root node for tree list 
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Food");
		
		//create the children nodes for the root 
		DefaultMutableTreeNode nutNode = new DefaultMutableTreeNode("Nuts");
		DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
		DefaultMutableTreeNode vegNode = new DefaultMutableTreeNode("Vegetables");
		
		
		//now we add the child nodes to the root nodes 
		
		root.add(nutNode);
		root.add(vegNode);
		root.add(fruitNode);
		
		//adding nodes to the Nuts list 
		nutNode.add(new DefaultMutableTreeNode("Brazil"));
		nutNode.add(new DefaultMutableTreeNode("Macadamia"));
		nutNode.add(new DefaultMutableTreeNode("Pecan"));
		nutNode.add(new DefaultMutableTreeNode("Almond"));
		
		//adding nodes to the Fruits list 
		fruitNode.add(new DefaultMutableTreeNode("Apples"));
		fruitNode.add(new DefaultMutableTreeNode("Oranges"));
		fruitNode.add(new DefaultMutableTreeNode("Bananas"));
		fruitNode.add(new DefaultMutableTreeNode("Mango"));
		fruitNode.add(new DefaultMutableTreeNode("Watermelon"));
		
		//adding nodes to the Vegetables list 
		vegNode.add(new DefaultMutableTreeNode("Onion"));
		vegNode.add(new DefaultMutableTreeNode("Garlic"));
		vegNode.add(new DefaultMutableTreeNode("Tomatoes"));
		vegNode.add(new DefaultMutableTreeNode("Green Onion"));
		vegNode.add(new DefaultMutableTreeNode("Purple Cabbage"));

		// passing the root node that was created to the JTree component
		
		JTree tree = new JTree(root);
		add(tree);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("JTree Example");
		this.pack();
		this.setVisible(true);


		



		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable () {
				public void run() {
					new Main();
				}
			});
	}

}
