package cal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Controller 
{
	private Model objM;
	private View objV;
	
	public Controller(View objV,Model objM)
	{
		this.objM=objM;
		this.objV=objV;
		
		for(int count=0;count<objV.length;count++)
		 {
			this.objV.addCalculationListener(new CalculateListener(),count );
		 }
		
	}
////method to check operation
    class  CalculateListener implements ActionListener{
	private String names[]={"  "," ","log","y√x","←","CE","C","±","√","sinh","sin","x²","7","8","9","/","mod","cosh","cos","x³","4","5","6","*","1/x","tanh","tan","x^y","1","2","3","-","10^x","Int","n!","³√x","0",".","+","="};
    
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int count=0;
		for(;count<40;count++)
		{
			if(names[count]==((JButton)e.getSource()).getText())
				break;
		}
		String key=names[count];
		objM.input(key,count);
		objV.setResult(objM.getResult());
	}
}

	

}
