package texteditor;

import java.io.File;
import java.util.Stack;

public class ClosedFiles {
    private Stack<File> closedFiles;
    
    public ClosedFiles() {
        closedFiles = new Stack<>();
    }
    
    public boolean isEmpty() {
        return closedFiles.isEmpty();
    }
    
    public void push(File newFile) {
        closedFiles.push(newFile);
    }
    
    public File peek() {
        return closedFiles.peek();
    }
    
    public File pop() {
        return closedFiles.pop();
    }
    
}
