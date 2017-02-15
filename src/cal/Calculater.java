package cal;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java .awt.event.ActionEvent;
import java .awt.event.ActionListener;
import java.math.*;
import java.util.Stack;

public class Calculater 
{
	public static void main(String[] args)
	{		
		View view=new View();
		Model model=new  Model();
		Controller controller=new Controller(view,model);
	}
} 

