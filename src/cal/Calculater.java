package cal;


public class Calculater 
{
	public static void main(String[] args)
	{		
		//////
		View view=new View();
		Model model=new  Model();
		Controller controller=new Controller(view,model);
	}
} 

