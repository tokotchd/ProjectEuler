package projecteuler;

public class Test {
	public static abstract class Rule{
		public String toString() {
			String thisClass = this.getClass().toString();
			int indexOf$ = this.getClass().toString().indexOf("$");
			return thisClass.substring(indexOf$ + 1, thisClass.length());
		}
	}
	
	public static class RuleThing extends Rule{
		
	}
	
	public static void main(String[] args){
		RuleThing thing = new RuleThing();
		System.out.println(thing.toString());
	}
}
