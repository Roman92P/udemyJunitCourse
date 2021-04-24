package pl.devfoundry.unit_testing_java;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        testCalcAdd();
    }

	private static void testCalcAdd() {
		Calc calc = new Calc();
		
		int result = calc.sum(2, 2);
		
		if(result !=4) {
			throw new IllegalStateException();
		}else {
			System.out.print("OK");
		}
		
	}
}
