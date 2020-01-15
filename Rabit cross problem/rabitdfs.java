import java.util.*;
import java.io.*;

class Node
{
	String state;
	Node parent;
	int level;
	public Node(String s, Node p,int level)
	{
		this.state=s;
		this.parent=p;
		this.level=level;
	}
}

public class rabitdfs
{
	public static void main(String [] args)
	{
		Stack<Node> st=new Stack<Node>();
		String goal="LLL_RRR";
		Node start=new Node("RRR_LLL",null,0);
		st.push(start);
		int c=0;
		while(!st.empty())
		{
			Node succ=st.pop();
			c++;
			if (succ.state.equals(goal))
			{
				System.out.println(succ.level);
				break;
			}
			else
			{
				int index=0;
				for(int i=0;i<succ.state.length();i++)
				{
					if (succ.state.charAt(i)=='_')
					{	
						index=i;
						break;
					}
				}
				if(index-1>=0 && succ.state.charAt(index-1)=='R')
				{
					StringBuilder sb=new StringBuilder(succ.state);
					sb.setCharAt(index-1,succ.state.charAt(index));
					sb.setCharAt(index,succ.state.charAt(index-1));
					Node temp=new Node(sb.toString(),succ,succ.level+1);
					st.push(temp);
				}
				
				if(index-2>=0 && succ.state.charAt(index-2)=='R')
				{
					StringBuilder sb=new StringBuilder(succ.state);
					sb.setCharAt(index-2,succ.state.charAt(index));
					sb.setCharAt(index,succ.state.charAt(index-2));
					Node temp=new Node(sb.toString(),succ,succ.level+1);
					st.push(temp);
				}
				
				if(index+1<succ.state.length() && succ.state.charAt(index+1)=='L')
				{
					StringBuilder sb=new StringBuilder(succ.state);
					sb.setCharAt(index+1,succ.state.charAt(index));
					sb.setCharAt(index,succ.state.charAt(index+1));
					Node temp=new Node(sb.toString(),succ,succ.level+1);
					st.push(temp);
				}
				if(index+2<succ.state.length() && succ.state.charAt(index+2)=='L')
				{
					StringBuilder sb=new StringBuilder(succ.state);
					sb.setCharAt(index+2,succ.state.charAt(index));
					sb.setCharAt(index,succ.state.charAt(index+2));
					Node temp=new Node(sb.toString(),succ,succ.level+1);
					st.push(temp);
				}
				
				
			}
			
			
			
		}
		
		
	System.out.println(c);
		
	}
}
