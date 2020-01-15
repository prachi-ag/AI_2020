import java.util.*;
import java.io.*;

enum Position 
{
	RIGHT, 
	LEFT
}

class Node
{
	int cl;
	int ml; 
	Position boat;
	int cr;
	int mr;
	Node parent;
	int level;
	public Node(int cl, int ml, Position boat,int cr, int mr,Node parent,int level)
	{
		this.cl = cl;
		this.ml = ml;
		this.boat = boat;
		this.cr= cr;
		this.mr = mr;
		this.parent=parent;
		this.level=level;
	}
	public String pos(Position x){
		if(x==Position.LEFT)
			return Integer.toString(cl)+Integer.toString(ml)+Integer.toString(cr)+Integer.toString(mr)+"L";
		else
			return Integer.toString(cl)+Integer.toString(ml)+Integer.toString(cr)+Integer.toString(mr)+"R";
	}
	public boolean isValid() 
	{
		if (this.ml >= 0 && this.mr >= 0 && this.cl >= 0 && this.cr >= 0 && (this.ml == 0 || this.ml >= this.cl) 
			&& (this.mr == 0 || this.mr >= this.cr)) {
			return true;
		}
		return false;
	}
	public boolean isGoal() {
		return (cl == 0 && ml == 0 && cr==3 && mr==3);
	}
	
	
}

public class MCdfs
{

	public static void main(String [] args)
	{
		ArrayList<String> exp = new ArrayList();
		Stack<Node> st=new Stack<Node>();
		Node start=new Node(3,3,Position.LEFT,0,0,null,0);
		st.push(start);
		int c=1;
		while(!st.empty())
		{
			//System.out.println(Arrays.toString(st.toArray()));
			Node succ=st.pop();
			exp.add(succ.pos(succ.boat));
			c++;
			System.out.println("cl "+succ.cl+" ml "+succ.ml+" cr "+succ.cr+" mr "+succ.mr);
			
			if (succ.isGoal())
			{
				System.out.println(succ.level);
				break;
			}
			else
			{				
				if (succ.boat == Position.LEFT) 
				{	
					Node s1=new Node(succ.cl, succ.ml-2,Position.RIGHT,succ.cr, succ.mr + 2,succ,succ.level+1);  // Two missionaries cross left to right.
					Node s2=new Node(succ.cl-2,succ.ml, Position.RIGHT,succ.cr+2,succ.mr,succ,succ.level+1);    // Two cannibals cross left to right.
					Node s3=new Node(succ.cl-1,succ.ml-1, Position.RIGHT,succ.cr+1,succ.mr+1,succ,succ.level+1); // One missionary and one cannibal cross left to right.
					Node s4=new Node(succ.cl,succ.ml-1, Position.RIGHT,succ.cr,succ.mr+1,succ,succ.level+1);     // One missionary crosses left to right.
					Node s5=new Node(succ.cl-1,succ.ml, Position.RIGHT,succ.cr + 1, succ.mr,succ,succ.level+1);  // One cannibal crosses left to right.
					if (s1.isValid() && exp.contains(s1.pos(s1.boat))==false)	
						st.push(s1);
					
					if (s2.isValid()&& exp.contains(s2.pos(s2.boat))==false)
						st.push(s2);
					
					if (s3.isValid()&& exp.contains(s3.pos(s3.boat))==false)
						st.push(s3);
					
					if (s4.isValid()&& exp.contains(s4.pos(s4.boat))==false)
						st.push(s4);
		
					if (s5.isValid()&& exp.contains(s5.pos(s5.boat))==false)	
						st.push(s5);
					
				}	
				
				if (succ.boat == Position.RIGHT) 
				{	
					Node s1=new Node(succ.cl, succ.ml+2,Position.LEFT,succ.cr, succ.mr - 2,succ,succ.level+1);  // Two missionaries cross right to left.
					Node s2=new Node(succ.cl+2, succ.ml, Position.LEFT,succ.cr-2,succ.mr,succ,succ.level+1);    // Two cannibals cross right to left.
					Node s3=new Node(succ.cl+1,succ.ml+1, Position.LEFT,succ.cr-1,succ.mr-1,succ,succ.level+1); // One missionary and one cannibal cross right to left.
					Node s4=new Node(succ.cl,succ.ml+1, Position.LEFT,succ.cr,succ.mr-1,succ,succ.level+1);     // One missionary crosses right to left.
					Node s5=new Node(succ.cl+1,succ.ml, Position.LEFT,succ.cr-1, succ.mr,succ,succ.level+1);  // One cannibal crosses right to left.
					
					if (s1.isValid()&& exp.contains(s1.pos(s1.boat))==false)	
						st.push(s1);
					
					if (s2.isValid()&& exp.contains(s2.pos(s2.boat))==false)
						st.push(s2);
					
					if (s3.isValid()&& exp.contains(s3.pos(s3.boat))==false)
						st.push(s3);
					
					if (s4.isValid()&& exp.contains(s4.pos(s4.boat))==false)
						st.push(s4);
		
					if (s5.isValid()&& exp.contains(s5.pos(s5.boat))==false)	
						st.push(s5);
					
				}	
				
				
			}
			
		} 
		System.out.println(c);
	}
}
