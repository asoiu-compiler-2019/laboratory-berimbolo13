package edu.shulikov.cmm;

import edu.shulikov.cmm.parser.Lexer;
import edu.shulikov.cmm.parser.Parser;
import edu.shulikov.cmm.parser.Token;
import edu.shulikov.cmm.parser.ast.Statement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class Main {

    public static void main(String[] args) throws IOException {
        final String input = new String(Files.readAllBytes(Paths.get("program.txt")), "UTF-8");
        final List<Token> tokens = new Lexer(input).tokenize();
        for (Token token : tokens) {
            System.out.println(token);
        }

        final Statement program = new Parser(tokens).parse();
        System.out.println(program.toString());
        program.execute();
    }
}
