package com.solvd.readtext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextManipulator {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/solvd/readtext/JavaWikipedia.txt");
        String wordCounter;
        String fileContent = readLinesFromFile(file.getPath());

        System.out.println(fileContent);

        wordCounter = String.valueOf(StringUtils.split(fileContent, " ").length);

        try {
            FileUtils.writeStringToFile(file, fileContent + wordCounter, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        fileContent = readLinesFromFile(file.getPath());
    }
    public static String readLinesFromFile(String path){
        File file = new File(path);
        List<String> lines = new ArrayList<>();
        try {
            lines = FileUtils.readLines(file, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        return lines.toString();
    }
}
