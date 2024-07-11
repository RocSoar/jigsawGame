package com.roc.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {
    public static List<String> readLines(String path) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null)
            lines.add(line);
        br.close();
        return lines;
    }

    public static <T> void writeLines(List<T> list, String path) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(path);
        list.forEach(e -> pw.println(e.toString()));
        pw.close();
    }

    public static void writeObject(Serializable obj, String path) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(obj);
        oos.close();
    }

    public static void writeObject(Serializable obj, File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(obj);
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static <T> T readObject(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object o = ois.readObject();
        ois.close();
        return (T) o;
    }
}
