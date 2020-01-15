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
	
	public boolean isValid() 
	{
		if (this.ml >= 0 && this.mr >= 0 && this.cl >= 0 && this.cr >= 0
	               && (this.ml == 0 || this.ml >= this.cl)
	               && (this.mr == 0 || this.mr >= this.cr)) {
			return true;
		}
		return false;
	}
	public boolean isGoal() {
		return cl == 0 && ml == 0;
	}
	
	
}

public class MCdfs
{

	public static void main(String [] args)
	{
		Stack<Node> st=new Stack<Node>();
		Node start=new Node(3,3,Position.LEFT,0,0,null,0);
		st.push(start);
		int c=0;
		while(!st.empty())
		{
			Node succ=st.pop();
			c++;
			System.out.println("cl"+succ.cl+"ml"+succ.ml+"cr"+succ.cr+"mr"+succ.mr);
			
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
					if (s1.isValid())	
						st.push(s1);
					
					if (s2.isValid())
						st.push(s2);
					
					if (s3.isValid())
						st.push(s3);
					
					if (s4.isValid())
						st.push(s4);
		
					if (s5.isValid())	
						st.push(s5);
					
				}	
				
				if (succ.boat == Position.RIGHT) 
				{	
					Node st1=new Node(succ.cl, succ.ml+2,Position.LEFT,succ.cr, succ.mr - 2,succ,succ.level+1);  // Two missionaries cross right to left.
					Node st2=new Node(succ.cl+2, succ.ml, Position.LEFT,succ.cr-2,succ.mr,succ,succ.level+1);    // Two cannibals cross right to left.
					Node st3=new Node(succ.cl+1,succ.ml+1, Position.LEFT,succ.cr-1,succ.mr-1,succ,succ.level+1); // One missionary and one cannibal cross right to left.
					Node st4=new Node(succ.cl,succ.ml+1, Position.LEFT,succ.cr,succ.mr-1,succ,succ.level+1);     // One missionary crosses right to left.
					Node st5=new Node(succ.cl+1,succ.ml, Position.LEFT,succ.cr-1, succ.mr,succ,succ.level+1);  // One cannibal crosses right to left.
					if (st1.isValid())	
						st.push(st1);
					
					if (st2.isValid())
						st.push(st2);
					
					if (st3.isValid())
						st.push(st3);
					
					if (st4.isValid())
						st.push(st4);
		
					if (st5.isValid())	
						st.push(st5);
					
				}	
				
				
			}
			
		}
		System.out.println(c);
	}
}
