package in.ts.icad.leagal.util;

import java.util.Stack;

public class EvaluateInfixExpression {
	/*
	public static String evaluate(String expression) 
    { 
        char[] tokens = expression.toCharArray(); 
  
         // Stack for numbers: 'values' 
        Stack<Integer> values = new Stack<Integer>(); 
        
        Stack<String> chars = new Stack<String>(); 
  
        // Stack for Operators: 'ops' 
        Stack<Character> ops = new Stack<Character>(); 
  
        for (int i = 0; i < tokens.length; i++) 
        { 
             // Current token is a whitespace, skip it 
            if (tokens[i] == ' ') 
                continue; 
  
            // Current token is a number, push it to stack for numbers 
            if (tokens[i] >= '0' && tokens[i] <= '9') 
            { 
                StringBuffer sbuf = new StringBuffer(); 
                // There may be more than one digits in number 
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
                    sbuf.append(tokens[i++]); 
                values.push(Integer.parseInt(sbuf.toString())); 
                
                System.out.println("values"+values);
            } else if (tokens[i] >= 'a' && tokens[i] <= 'z' || tokens[i] >= 'A' && tokens[i] <= 'Z'){
            	StringBuffer sbaf = new StringBuffer(); 
            	
            	  while (i < tokens.length && tokens[i] >= 'a' && tokens[i] <= 'z' || tokens[i] >= 'A' && tokens[i] <= 'Z' ) {
                      sbaf.append(tokens[i++]); 
            	  
            	  System.out.println("sbaf.charAt(i)"+sbaf.charAt(0));
            	  chars.push(sbaf.toString());
            	  
            	  System.out.println("chars"+chars);
            	  }
            }
  
            // Current token is an opening brace, push it to 'ops' 
            else   if (tokens[i] == '(') 
            {
            	
          	  System.out.println("1"+1);
                ops.push(tokens[i]); 
                
                System.out.println("ops"+ops);
                
                
            }
  
            // Closing brace encountered, solve entire brace 
            else   if (tokens[i] == ')') 
            { 
                while (ops.peek() != '(') 
                { System.out.println("2"+2);
                	chars.push(applyOp(ops.pop(), values.pop(), values.pop(),chars.pop(),chars.pop())); 
                ops.pop(); 
                
                }
            } 
  
            // Current token is an operator. 
            else  if (tokens[i] == '+' || tokens[i] == '-' || 
                     tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '=') 
            { 
            	  System.out.println("3"+3);
                // While top of 'ops' has same or greater precedence to current 
                // token, which is an operator. Apply operator on top of 'ops' 
                // to top two elements in values stack 
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
                {
                	  System.out.println("4"+4);
                  applyOp(ops.pop(), values.pop(), values.pop(),chars.pop(),chars.pop()); 
  
                // Push current token to 'ops'. 
                ops.push(tokens[i]); 
                }
            } 
        } 
  
        // Entire expression has been parsed at this point, apply remaining 
        // ops to remaining values 
        while (!ops.empty()) 
        	
        {  System.out.println("5"+5);
            applyOp(ops.pop(), values.pop(), values.pop(),chars.pop(),chars.pop()); 
        }
  
        System.out.println("6"+6);
        // Top of 'values' contains result, return it 
        
        String char1=null;
        String char2=null;
     for (int j=0; j<chars.size();j++){
        	char1=chars.get(j);
           
        	
            System.out.println("char1"+char1);
        	
        
        }
        Integer val1=0;
        for (int k=0; k<values.size();k++){
        	val1=values.get(k);
           
        	
            System.out.println("val1"+val1);
        	
        
        }
        
        String output= char1+"="+val1+","+char1+"="+val1;
        return output ; 
    } 
  
    // Returns true if 'op2' has higher or same precedence as 'op1', 
    // otherwise returns false. 
    public static boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-') ||  (op2 == '=')) 
            return false; 
        else
            return true; 
    } 
  
    // A utility method to apply an operator 'op' on operands 'a'  
    // and 'b'. Return the result. 
    public static String applyOp(char op, int b, int a,String ep,String ep2) 
    { 
    	
    	
    	System.out.println("op"+op+"b"+b+"a"+a+"ep"+ep+"ep2");
    	String result=null;
    	
    	int output=0;
        switch (op) 
        { 
        case '+': output=(a + b); result=Integer.toString(output);
            return  result; 
        case '-': output=(a - b); result=Integer.toString(output);
            return result; 
        case '*': output=(a*b) ; result=Integer.toString(output);
            return result; 
            
        case '=': ep=Integer.toString(a) ;
                          ep2=Integer.toString(a) ;result=ep+","+ep2;
            return result; 
        case '/': 
            if (b == 0)                 
            	throw new                 UnsupportedOperationException("Cannot divide by zero");

            output=(a/b) ; result=Integer.toString(output);
            return result; 
        } 
        return result; 
        
    }*/

}
