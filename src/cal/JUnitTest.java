package cal;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test() {
		View view=new View();
		Model model=new Model();	
		Controller cont=new Controller(view,model);
		//testcase 1
		model.input(view.getB(14), 14);
        model.input(view.getB(15), 15);
        model.input(view.getB(14), 14);
        model.input(view.getB(39), 39);
        //assertEquals(model.getResult(),"1.0");
        model.input(view.getB(13), 13);
        model.input(view.getB(15), 15);
        model.input(view.getB(13), 13);
        model.input(view.getB(39), 39);
        assertEquals(model.getResult(),"1.0");
        ////////////	
	}

}
   
   
   
        
