package collections;

import java.util.ArrayList;

public class Tree<T> {

	private NodeTree<T> root;
	
	public Tree() {
		
	}
	
	public void add(T node, T parent) {
		
		NodeTree<T> nod = new NodeTree<T>(node);
		if(root == null) {
			root = nod;
		}else {
			addChild(root, parent, nod);
		}

	}
	
	
	public void addChild(NodeTree<T> nActu, T parent, NodeTree<T> node) {
		
		if(nActu.getElem().equals(parent)) {
			nActu.getChilds().add(node);
			node.setParent(nActu);
		}else {
			for(int i = 0; i < nActu.getChilds().size();i++) {
				addChild(nActu.getChilds().get(i), parent, node);
			}
		}
	}
	
	public ArrayList<T> print(){
		ArrayList<T> out = new ArrayList<T>();
		out.add(root.getElem());
		auxPrint(out, root);
		return out;
		
	}

	private void auxPrint(ArrayList<T> list, NodeTree<T> actu) {
		
		for(int i = 0; i < actu.getChilds().size(); i++) {
			list.add(actu.getChilds().get(i).getElem());
		}
		for(int i = 0; i < actu.getChilds().size(); i++) {
			auxPrint(list, actu.getChilds().get(i));
		}
		
	}

	public NodeTree<T> getRoot() {
		// TODO Auto-generated method stub
		return root;
	}
	
	
	
}
