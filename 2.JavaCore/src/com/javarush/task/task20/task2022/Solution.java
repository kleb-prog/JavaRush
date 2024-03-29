package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\test1.txt");
        solution.writeObject("Test");

        OutputStream fos = new FileOutputStream("C:\\test2.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);

        out.writeObject(solution);

        InputStream fis = new FileInputStream("C:\\test2.txt");
        ObjectInputStream in = new ObjectInputStream(fis);

        Solution loadSolution = (Solution) in.readObject();
        loadSolution.writeObject("Test2");
    }
}
