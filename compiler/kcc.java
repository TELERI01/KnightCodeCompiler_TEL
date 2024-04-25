/**
* Description of this class.
* @author Tyler Lericos
* @version 1.0
* Assignment 5
* CS322 - Compiler Construction
* Spring 2024
**/

package compiler;

import java.io.IOException;
//ANTLR packages
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import lexparse.*;

 public class kcc
 {
    public static void main(String[] args) 
    {
        
        CharStream input;
        KnightCodeLexer lexer;
        CommonTokenStream tokens;
        KnightCodeParser parser;

        try
        {
            input = CharStreams.fromFileName(args[0]);  //get the input
            lexer = new KnightCodeLexer(input); //create the lexer
            tokens = new CommonTokenStream(lexer); //create the token stream
            parser = new KnightCodeParser(tokens); //create the parser
            String outputName = args[1]; // the name of the output file read from command line arguments

            ParseTree tree = parser.file();  //set the start location of the parser
            
            kccVisitor visitor = new kccVisitor(outputName); // Creates a new CustomVisitor
            visitor.visit(tree); // Traverses tree and writes bytecode
            visitor.writeFooter(); // Writes the bytecode generation footer instead of passing it here

            // Write bytes created by above code to the specified output file; writeFile credits to Dr. Kelley
            byte[] b = visitor.getByteArray();
            Utilities.writeFile(b, outputName + ".class");

        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    } // end main


 } // end class
 