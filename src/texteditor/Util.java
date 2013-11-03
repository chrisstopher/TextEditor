package texteditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Util {
    public static final char NEWLINE = '\n';
    
    public static ArrayList<String> readFrom(String file) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                strings.add(str);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            //System.out.println(ex.getMessage());
        }
        return strings;
    }
    
    public static void writeTo(File file, String string) {
        writeTo(file.toString(), string);
    }
    
    public static void writeTo(String file, String string) {
        File newFile = new File(file);
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                return;
            }
        }
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            printWriter.print(string);
            printWriter.close();
        } catch (IOException e) {
            //System.out.println(e.getMessage());
        }
    }
    
    public static void writeTo(String file, ArrayList<String> strings, boolean onNewLine) {
        File newFile = new File(file);
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                return;
            }
        }
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            if (onNewLine) {
                for (String s : strings) {
                    printWriter.println(s);
                }
            } else {
                for (String s : strings) {
                    printWriter.print(s);
                }
            }
            printWriter.close();
        } catch (IOException e) {
            //System.out.println(e.getMessage());
        }
    }
}
