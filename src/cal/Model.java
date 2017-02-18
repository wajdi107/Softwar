package cal;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Model
{
	private int           state=0;
	private String        result="";
	private String        names[]={"  "," ","log","y√x","←","CE","C","±","√","sinh","sin","x²","7","8","9","/","mod","cosh","cos","x³","4","5","6","*","1/x","tanh","tan","x^y","1","2","3","-","10^x","Int","n!","³√x","0",".","+","="};
	private Stack<String> stack=new Stack<String>();	;
	public  void          input        (String key,int count)
	{
		String value="";
	    String value1="";
	    String value2="";
		//is digit
		if(count==12||count==13||count==14||count==20||count==21||count==22||count==28||count==29||count==30||count==36||count==37)
		{
			if(stack.empty())
					{stack.push(key);}
			else 
				if(stack.peek()=="0")
				{
					stack.pop();
				    stack.push(key);
				}
				else
					if(stack.peek()=="*"||stack.peek()=="/"||stack.peek()=="-"||stack.peek()=="+"||stack.peek()=="mod"||stack.peek()=="y√x"||stack.peek()=="x^y")
				{
					stack.push(key);
				}
					else 
				{
						if(nonflag==true)
						{
							stack.pop();
							
							stack.push(key);
						}
						else
						{
							value=stack.peek();
							stack.pop();
					        stack.push(concat(value,key));
						}
				}
			
			result=stack.peek();
		}//end check digit
		nonflag=false;
		//is two value operator 
		if(count==15||count==23||count==31||count==38||count==3||count==16||count==27)//||count==29||count==30||count==36||count==37)
		{
			String ff="";
			{
			if(stack.empty())
				
			{
				stack.push("0");
			    stack.push(key);
			   
			}
			
		
			else 
				if(stack.peek()=="*"||stack.peek()=="/"||stack.peek()=="-"||stack.peek()=="+"||stack.peek()=="mod"||stack.peek()=="y√x"||stack.peek()=="x^y")
			{
				stack.pop();			
				stack.push(key);
			}
				
				else 
				{
					value=stack.peek();
					stack.pop();	
					 if(!stack.empty())
					{
					value1=stack.peek();
					stack.pop();
					value2=stack.peek();
					stack.pop();
					stack.push(evalution(value1,value2,value));		
					}
					 else 
						{stack.push(value);
								}	 
			     	    stack.push(key);
			}
			}
			ff=stack.peek();
			stack.pop();
	        result=stack.peek();
			stack.push(ff);
		}//end tow value operator 
		if(count==9||count==17||count==18||count==10||count==8||count==24||count==33||count==35||count==19||count==11||count==2||count==34||count==25||count==26||count==7||count==32)
		{
			String ff="";
			{
			if(stack.empty())
			{
				
				stack.push(evalution(key,"0","0"));	
			}
			else 
				if(stack.peek()=="*"||stack.peek()=="/"||stack.peek()=="-"||stack.peek()=="+"||stack.peek()=="mod"||stack.peek()=="y√x"||stack.peek()=="x^y")
		         	{
					value=stack.peek();
				    stack.pop();
				    value1=stack.peek();
				    stack.push(value);
				    
				    stack.push(evalution(key,value1,"0"));
				    value2=stack.peek();
					stack.pop();					
					stack.pop();
					stack.pop();
					
					stack.push(evalution(value,value1,value2));		
					}
					 else 
						{
						 value=stack.peek();
					     stack.pop();
					     
					     stack.push(evalution(key,value,"0"));	
						}	     	    
			}
			result=stack.peek();
		}//end one value operator
		if(count==39)
		{
			if(stack.empty())
			{
				stack.push("0");	
			}
			else 
				if(stack.peek()=="*"||stack.peek()=="/"||stack.peek()=="-"||stack.peek()=="+"||stack.peek()=="mod"||stack.peek()=="y√x"||stack.peek()=="x^y")
		         	{
					value=stack.peek();
				    stack.pop();
				    value1=stack.peek();
				    stack.pop();	
				    
				    stack.push(evalution(value,value1,value1));	
					}
					 else 
						{value=stack.peek();
					    stack.pop();
					    if(stack.empty())
					    	stack.push(value);
					    else{
					    value1=stack.peek();
					    stack.pop();	
					    value2=stack.peek();
					    stack.pop();	
					    
					    stack.push(evalution(value1,value2,value));
					    }	
					    
						}
			result=stack.peek();
			nonflag=true;
		}
		
		if(count==4)
		{
			if(stack.empty()||stack.peek().length()==0||stack.peek()=="0")
			{
				
				result="0";
			} else if(stack.peek()=="*"||stack.peek()=="/"||stack.peek()=="-"||stack.peek()=="+"||stack.peek()=="mod"||stack.peek()=="y√x"||stack.peek()=="x^y"){}
			else
			{
					value=stack.peek();
					stack.pop();
					StringBuilder string=new  StringBuilder(value);
					string.deleteCharAt(string.length()-1);
					value=String.valueOf(string);
					if(value.length()==0)
					{ stack.push("0");System.out.print("oo");}
					else
					    stack.push(value);
					   
					    result=stack.peek();
			}			
		}
		if(count==5)
		{
			if(stack.empty()||stack.peek().length()==0||stack.peek()=="0")
			{
				
				result="0";
			} else if(stack.peek()=="*"||stack.peek()=="/"||stack.peek()=="-"||stack.peek()=="+"||stack.peek()=="mod"||stack.peek()=="y√x"||stack.peek()=="x^y"){}
			else
			{				
					stack.pop();
					if(value.length()==0)
					{ stack.push("0");System.out.print("oo");}
					   
					    result="0";
			}				
		}
		if(count==6)
		{			while(!stack.empty())
					{stack.pop();}			   
					    result="0";	
		}
			
	}
	public  String        evalution    (String z,String o,String p)
	{
		
		///
		state=0;
		String check="";
		if(o.charAt(o.length()-1)=='.')
			o=o+"0";
		if(p.charAt(p.length()-1)=='.')
			p=p+"0";
		///
		double l=0.0;
		double y=0.0;
		l=Double.parseDouble(o);
		y=Double.parseDouble(p);
		if(names[3]==z)
		{	check=String.valueOf((float)Math.pow(y,1/ l));
			if(check=="NaN"||check=="-NaN")
			{
				state=1;
			    check="0";
			}
		}		
		if(names[2]==z)
			{
			check=String.valueOf((float)Math.log(l));
			if(check=="NaN"||check=="-NaN")
			{
				state=1;
			    check="0";
			}
			
			}
		if(names[15]==z)
			if(y!=0)
			check=String.valueOf((float)l/y);
			else 
			{
				check="0";
				state=3;
			}
		if(names[23]==z)
			check=String.valueOf((float)l*y);
		if(names[31]==z)
			check=String.valueOf((float)l-y);
		if(names[38]==z)
			check=String.valueOf((float)l+y);
		if(names[16]==z)
		{
			if(y!=0)
			{int x=(int) (l/y);
			double c=l-(y*x);
			check=String.valueOf((float)c);}
			else
			{
				check="0";
				state=4;
			}
		}
		if(names[27]==z)
			check=String.valueOf((float)Math.pow(l, y));
		////
		////
		if(names[10]==z)
			check=String.valueOf((float)Math.sin(l));
		if(names[18]==z)
			check=String.valueOf((float)Math.cos(l));
		if(names[26]==z)
			check=String.valueOf((float)Math.tan(l));
		if(names[9]==z)
			check=String.valueOf((float)Math.sinh(l));
		if(names[17]==z)
			check=String.valueOf((float)Math.cosh(l));
		if(names[25]==z)
			check=String.valueOf((float)Math.tanh(l));
		if(names[33]==z)
			check=String.valueOf((int)(l));
		if(names[24]==z)
			if(l!=0)
			{check=String.valueOf((float)(1/l));}
			else
			{
				check="0";
				state=3;
			}
		if(names[8]==z)
		{
			check=String.valueOf((float)Math.sqrt(l));
			if(check=="NaN"||check=="-NaN")
			{
			    check="0";
			    state=1;
			}
			}
		if(names[19]==z)
			check=String.valueOf((float)Math.pow(l,3));
		if(names[32]==z)
			check=String.valueOf((float)Math.pow(10,l));
		if(names[7]==z)
			check=String.valueOf((float)(-1*l));
		if(names[34]==z)
		{int sum=1;
		int m=(int)l;
		    for(int i=1;i<=m;i++)
		    	sum*=i;
			check=String.valueOf((float)(sum));}
		if(names[11]==z)
			check=String.valueOf((float)Math.pow(l,2));
		if(names[35]==z)
		{
			check=String.valueOf((float)Math.pow(l,1/3.0));
			if(check=="NaN"||check=="-NaN")
			{
			    check="0";
			    state=1;
			}
		}
		if(check=="NaN")
		{
		    check="0";
		    state=5;
		}
		if(check=="-NaN")
		{
		    check="0";
		    state=1;
		}
		if(check=="-Infinity")
			state=1;
		if(check=="Infinity")
		{
		    check="0";
		    state=5;
		}	
		return check;
	}
	public  void          setMassage   (int state)
    {
    	
    	switch(state)
    	{
    	case 1:
    		result="invalid input";
    		break;
    	case 3:
    		result="Cann't divide by zero";
    		break;
    	case 4:
    		result="Cann't modulate by zero";
    		break;
    	case 5:
    		result="overflow";
    		break;
        default:;
    	}
    }
	private boolean       nonflag=false;
	public  boolean       checkDecimal (String z)
	{
		
		boolean flag=true;
		char c;int v=0;
		for(int i=0;i<z.length()&&flag;i++)
		{
			c=z.charAt(i);
			if(!((c>='0'&&c<='9')||c=='.'))
				{
				flag=false;
				return flag;
				}
			if(c=='.')
				v++;
			if(v>1)
				{
				flag=false;
				return flag;
				}
		}
		return flag;
	}
	public  String        concat       (String x,String y)
	{
		String z=x+y;
		if(checkDecimal(z))
			return z;
		else 
			return x;
		
	}
    public  String        getResult    ()
    {
    	setMassage(getState());
    	return result;
    }
	public  int           getState     ()
	{return state;}

}
