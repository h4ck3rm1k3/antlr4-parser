package xyz.introspetor.antlr;
import xyz.introspetor.antlr.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      String script="";
      try 
        {
          
          FileReader fileReader = new FileReader(args[0]);
          String line = null;
          BufferedReader bufferedReader = new BufferedReader(fileReader);
           while ((line = bufferedReader.readLine()) != null)
             {
               script = script + line;        
             }
           
           bufferedReader.close();
          
          System.out.println( script );
        }
      catch(java.io.FileNotFoundException e) 
        {
          System.out.println( e );
        }
      
      catch(  java.io.IOException e) 
        {
          System.out.println( e );
        }
      

      CharStream charStream = new ANTLRInputStream(script);
      
      ANTLRv4Lexer lexer = new ANTLRv4Lexer(charStream);
      TokenStream tokenStream = new BufferedTokenStream(lexer);
      
      ANTLRv4Parser parser = new ANTLRv4Parser(tokenStream);      
      parser.grammarSpec();
    }
}
