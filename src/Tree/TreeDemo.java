package Tree;

import java.util.Scanner;
/**
 * �ڵ�
 * @author wsz
 * @date 2018��1��17��
 */
class TreeNode{
	String data;
	TreeNode left;
	TreeNode right;
}
/**
 * @author wsz
 * @date 2018��1��17��
 */
public class TreeDemo {
	static Scanner s = new Scanner(System.in);
	static int SIZE = 30;
	
	//��ʼ����
	TreeNode intTree(){
		TreeNode node = new TreeNode();
		if(node != null) {
			System.out.println("������ڵ�����:");
			node.data = s.next();
			node.left = null;
			node.right = null;
		}
		return node;
	}
	/**
	 * ��ӽڵ�
	 * @param node ����ӽڵ����
	 */
	void AddTreeNode(TreeNode node) {
		TreeNode pnode,parent;
		String data;
		if((pnode = new TreeNode()) != null) {
			System.out.println("����������ڵ�����:");
			pnode.data = s.next();
			pnode.left = null;
			pnode.right = null;
			System.out.println("���븸�ڵ�����:");
			data = s.next();
			parent = findTreeNode(node,data);
			if(parent == null)
				System.out.println("û���ҵ����ڵ�");
			
			System.out.println("1:��ӵ������� 2:��ӵ�������");
			int select = s.nextInt();
			do {
				switch(select) {
					case 1 :
						if(parent.left != null) {
							System.out.println("��ڵ㲻Ϊ��");
						}else {
							parent.left = pnode;
						}
						break;
					case 2 :
						if(parent.right != null) {
							System.out.println("�ҽڵ㲻Ϊ��");
						}else {
							parent.right = pnode;
						}
						break;
					default :
						System.out.println("������Ч");
				}
			}while(select != 1 && select !=2);
		}
	}
	
	/**
	 * ��������ĳһ�ڵ�
	 * @param node root��
	 * @param data �ڵ������
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
	 * ��ȡ��ǰ�ڵ���ҽڵ�
	 * @param node
	 * @return
	 */
	TreeNode treeRightNode(TreeNode node) {
		if(node != null)
			return node.right;
		return null;
	}
	
	/**
	 * ��ȡ��ǰ�ڵ����ڵ�
	 * @param node
	 * @return
	 */
	TreeNode treeLeftNode(TreeNode node) {
		if(node != null)
			return node.left;
		return null;
	}
	/**
	 * ��ȡ�������
	 * @param node root��
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
	 * �����
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
	//�������
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
	//�������
	void firstTree(TreeNode node) {
		if(node != null) {
			showData(node);
			firstTree(node.left);
			firstTree(node.right);
		}
	}
	//�������
	void secodeTree(TreeNode node) {
		if(node != null) {
			secodeTree(node.left);
			showData(node);
			secodeTree(node.right);
		}
	}
	//�������
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
			System.out.println("0:�˳� 1����ӽڵ�");
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
		
		System.out.println("���:"+td.treeDeep(root));
		td.levelTree(root);
		System.out.println("");
		td.firstTree(root);
		System.out.println("");
		td.threeTree(root);
	}

}
