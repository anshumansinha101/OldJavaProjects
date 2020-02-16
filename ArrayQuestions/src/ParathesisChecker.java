
import java.util.Stack;

/**
 * 
 * @author anshuman
 *
 */
public class ParathesisChecker {

	private static Stack s = new Stack();
	
	private static boolean checkParathesis(char[] val)
	{
		
		for (int i = 0; i < val.length; i++) {
			char ch =	 val[i]; 
			System.out.println("" + ch);
			switch(ch)
			{
				case '{' :
				case '(' :
				case '[' :
					{
						System.out.println("Pushing " + ch);
						s.push(Character.toString(ch));break;
					}
				case '}' :
				{
					System.out.println("..." + ch);
					String str = (String)s.pop();
					if(!str.equals("}"))
					{
						return false;
					}
				}
				break;
				case ']' :
				{
					System.out.println("..." + ch);
					String str = (String)s.pop();
					if(!str.equals("["))
					{
						return false;
					}
				}
				break;
				case ')' :
					{
						System.out.println("..." + ch);
						String str = (String)s.pop();
						if(!str.equals("("))
						{
							return false;
						}
					}
					break;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String testString = "[()]{}{[()()]()}";
		char[] stringToCharArray = testString. toCharArray();
		System.out.println(checkParathesis(stringToCharArray));
	}
	
}
