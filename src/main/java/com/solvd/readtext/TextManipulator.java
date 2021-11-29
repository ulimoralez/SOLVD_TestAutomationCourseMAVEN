package com.solvd.readtext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextManipulator {
    public static void main(String[] args) {
        File file = new File("src/main/java/com/solvd/readtext/AlanTuringWikipedia.txt");
        String wordCounter;
        String fileContent = readLinesFromFile(file.getPath());

        System.out.println("Original content"+fileContent);

        wordCounter = String.valueOf(StringUtils.split(fileContent, " ").length);

        //try {
        //    FileUtils.writeStringToFile(file, fileContent + wordCounter, StandardCharsets.UTF_8);
        //}catch (IOException e){
        //    e.printStackTrace();
        //}
        fileContent = readLinesFromFile(file.getPath());
        //Task 2
        //StringUtils methods
        System.out.println("\nReverse content: "+StringUtils.reverse(fileContent));
        System.out.println("\nRemove the letter a: "+StringUtils.remove(fileContent, "a"));
        System.out.println("\nCount every time a appears: "+StringUtils.countMatches(fileContent, "a"));
        System.out.println("\nDelete whitespaces: "+StringUtils.deleteWhitespace(fileContent));
        System.out.println("\nUppercase content: "+ StringUtils.upperCase(fileContent));

        //FileUtils Methods
        File copyText = new File("src/main/java/com/solvd/readtext/copytext.txt");
        File newPackage = new File("src/main/java/com/solvd/readtext/newpackage");
        try {
            FileUtils.copyFile(file, copyText);
            FileUtils.forceMkdir(newPackage);
            FileUtils.lastModified(copyText);
            System.out.println(FileUtils.getUserDirectoryPath());
            System.out.println(FileUtils.sizeOf(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
