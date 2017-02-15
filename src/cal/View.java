package cal;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {
	private GridLayout layout;
	private JPanel pane;
	private JTextField text;
	private String names[]={"  "," ","log","y√x","←","CE","C","±","√","sinh","sin","x²","7","8","9","/","mod","cosh","cos","x³","4","5","6","*","1/x","tanh","tan","x^y","1","2","3","-","10^x","Int","n!","³√x","0",".","+","="};
	public  int length=names.length;
	private final JButton [] b1;
    public View()
    {
	    //
		super("layout managre");
		//
		pane=new JPanel();
		pane.setLayout(new GridLayout(5,8));
		b1=new JButton[names.length];
		for(int count=0;count<names.length;count++)
		{
			b1[count]=new JButton(names[count]);
			//b1[count].addActionListener(this);
			pane.add(b1[count]);
		}
		//
		text=new JTextField ("0");
		text.setHorizontalAlignment(JTextField.RIGHT);
		Font font=new Font("SanSerif",Font.BOLD,20);
		text.setFont(font);
		text.setEditable(false);
		add(text,BorderLayout.NORTH);
		add(pane,BorderLayout.CENTER);
		setSize(530,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
    public void setCalSolution(String result)
    {
    	text.setText(result);
    }
    public JButton getB(int count)
    {
    	return b1[count];
    }
	 void addCalculationListener(ActionListener  event ,int count)
	 {
		 b1[count].addActionListener(event);
	 }
	  
	 public void setResult(String Result)
	 {
		 text.setText(Result);
	 }
}
