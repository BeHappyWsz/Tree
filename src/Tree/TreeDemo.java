package Tree;

import java.util.Scanner;
/**
 * 节点
 * @author wsz
 * @date 2018年1月17日
 */
class TreeNode{
	String data;
	TreeNode left;
	TreeNode right;
}
/**
 * @author wsz
 * @date 2018年1月17日
 */
public class TreeDemo {
	static Scanner s = new Scanner(System.in);
	static int SIZE = 30;
	
	//初始化树
	TreeNode intTree(){
		TreeNode node = new TreeNode();
		if(node != null) {
			System.out.println("输入根节点数据:");
			node.data = s.next();
			node.left = null;
			node.right = null;
		}
		return node;
	}
	/**
	 * 添加节点
	 * @param node 被添加节点的数
	 */
	void AddTreeNode(TreeNode node) {
		TreeNode pnode,parent;
		String data;
		if((pnode = new TreeNode()) != null) {
			System.out.println("输入二叉树节点数据:");
			pnode.data = s.next();
			pnode.left = null;
			pnode.right = null;
			System.out.println("输入父节点数据:");
			data = s.next();
			parent = findTreeNode(node,data);
			if(parent == null)
				System.out.println("没有找到父节点");
			
			System.out.println("1:添加到左子树 2:添加到右子树");
			int select = s.nextInt();
			do {
				switch(select) {
					case 1 :
						if(parent.left != null) {
							System.out.println("左节点不为空");
						}else {
							parent.left = pnode;
						}
						break;
					case 2 :
						if(parent.right != null) {
							System.out.println("右节点不为空");
						}else {
							parent.right = pnode;
						}
						break;
					default :
						System.out.println("参数无效");
				}
			}while(select != 1 && select !=2);
		}
	}
	
	/**
	 * 查找树中某一节点
	 * @param node root树
	 * @param data 节点的数据
	 * @return
	 */
	TreeNode findTreeNode(TreeNode node,String data) {
		TreeNode ptr;
		
		if(node != null){
			if(data.equals(node.data)) {
				return node;
			}else {
				if((ptr = findTreeNode(node.left,data)) != null) {
					return ptr;
				}else if((ptr = findTreeNode(node.right,data)) != null) {
					return ptr;
				}
			}
		}
		return null;
	}
	
	/**
	 * 获取当前节点的右节点
	 * @param node
	 * @return
	 */
	TreeNode treeRightNode(TreeNode node) {
		if(node != null)
			return node.right;
		return null;
	}
	
	/**
	 * 获取当前节点的左节点
	 * @param node
	 * @return
	 */
	TreeNode treeLeftNode(TreeNode node) {
		if(node != null)
			return node.left;
		return null;
	}
	/**
	 * 获取树的深度
	 * @param node root树
	 * @return
	 */
	int treeDeep(TreeNode node) {
		int left,right;
		if(node == null) {
			return 0;
		}else {
			left  = treeDeep(node.left);
			right = treeDeep(node.right);
			if(left > right) {
				return left+1;
			}else {
				return right+1;
			}
		}
	}
	/**
	 * 清空树
	 * @param node
	 */
	void clearTree(TreeNode node) {
		if(node != null) {
			clearTree(node.left);
			clearTree(node.right);
			node = null;
		}
	}
	
	void showData(TreeNode node) {
		System.out.print(node.data+" ");
	}
	//按层遍历
	void levelTree(TreeNode node) {
		TreeNode p ;
		TreeNode[] q = new TreeNode[30];
		int head=0,tail=0;
		if(node != null) {
			tail = (tail+1)%SIZE;
			q[tail] = node;
		}
		while(head != tail) {
			head = (head+1)%SIZE;
			p = q[head];
			showData(p);
			if(p.left != null) {
				tail =(tail+1)%SIZE;
				q[tail] = p.left;
			}
			if(p.right != null) {
				tail =(tail+1)%SIZE;
				q[tail] = p.right;
			}
		}
	}
	//先序遍历
	void firstTree(TreeNode node) {
		if(node != null) {
			showData(node);
			firstTree(node.left);
			firstTree(node.right);
		}
	}
	//中序遍历
	void secodeTree(TreeNode node) {
		if(node != null) {
			secodeTree(node.left);
			showData(node);
			secodeTree(node.right);
		}
	}
	//后序遍历
	void threeTree(TreeNode node) {
		if(node != null) {
			threeTree(node.left);
			threeTree(node.right);
			showData(node);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeDemo td = new TreeDemo();
		TreeNode root = td.intTree();
		int select;
		do {
			System.out.println("0:退出 1添加子节点");
			select = s.nextInt();
			switch(select) {
				case 1:
					td.AddTreeNode(root);
					break;
				case 0:
					break;
				default:
					;
			}
		}while(select != 0);
		
		System.out.println("深度:"+td.treeDeep(root));
		td.levelTree(root);
		System.out.println("");
		td.firstTree(root);
		System.out.println("");
		td.threeTree(root);
	}

}
