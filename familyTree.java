

public class FamilyTree
{
	public static class Node 
    { 
        String name; 
        Node sibling, child; 
        
        public Node(String name) 
        { 
            this.name = name; 
            sibling = child;
            child = null; 
        } 
    } 

    // Adds a sibling 
    static public Node addSibling(Node node, String name) 
    { 
        if(node == null) 
            return null; 
        //while the tree is not empty this will
        //continue to add siblings when function is called
        while(node.sibling != null) 
            node = node.sibling; 
        return(node.sibling = new Node(name)); 
    } 

    // Add child Node to the tree when function is called
    static public Node addChild(Node node,String name) 
    { 
        if(node == null) 
            return null; 

        // Check if child is not empty. 
        if(node.child != null) 
            return(addSibling(node.child,name)); 
        else
            return(node.child = new Node(name)); 
    } 

    
    static public void preorderTraversal(Node root) 
    { 
        if(root == null) 
        {
            System.out.println("Tree is empty!"); 
        }
        while(root != null) 
        { 
        	
            System.out.print(root.name + " "); 
            if(root.child != null) 
                preorderTraversal(root.child); 
            root = root.sibling; 
        } 
    } 
    
    public static void main(String args[]) 
    { 

    		System.out.println("Family Tree: \n");

        Node root = new Node("Steve"); //root
        Node node1 = addChild(root, "Aidan"); //left
        Node node2 = addChild(root,"Tristan"); //right
        Node node3 = addSibling(root,"Sterling"); //child/leaf
        Node node4 = addChild(node1,"Jeffery"); //node 3 makes it a child below
        Node node5 = addSibling(root,"Wallace"); //last child all the way to the right
        Node node6 = addChild(node2,"Jim"); //child below
        Node node7 = addChild(node3,"Haley"); //child below
        Node node8 = addSibling(node4,"Chloe"); //child below
        //traverses the tree in preorder and prints
        //the family members 
        preorderTraversal(root); 

        /*   Example look at Family Tree
         *           Steve 
         *     /    /       \       \ 
         * Aidan  Jeffrey     Chloe  Tristan
         *           |        /  | \ 
         *          Jim  Sterling Haley  Wallace     */

         // Child and siblings tree
         /*  Harry 
         *    | 
         *    Aidan - Jeffrey - Chloe - Tristan
         *              |       | 
         *            Jim    Sterling - Haley - Wallace  */
    } 
} 

