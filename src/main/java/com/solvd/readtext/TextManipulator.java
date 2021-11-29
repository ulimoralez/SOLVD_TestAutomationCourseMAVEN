package com.solvd.readtext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

public class TextManipulator {
    public static void main(String[] args) {
        final File FILE = new File("src/main/java/com/solvd/readtext/AlanTuringWikipedia.txt");
        Logger LOGGER = Logger.getLogger(TextManipulator.class.getName());
        String wordCounter;
        String fileContent = readLinesFromFile(FILE.getPath());

        LOGGER.info("Original content"+fileContent);

        HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(fileContent.split(" ")));

        try {
            LOGGER.info("Unique words in the text: "+uniqueWords.size());
            FileUtils.writeStringToFile(FILE, fileContent + uniqueWords.size(), StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        fileContent = readLinesFromFile(FILE.getPath());
        //Task 2
        //StringUtils methods
        LOGGER.severe("\nReverse content: "+StringUtils.reverse(fileContent));
        LOGGER.info("\nRemove the letter a: "+StringUtils.remove(fileContent, "a"));
        LOGGER.info("\nCount every time a appears: "+StringUtils.countMatches(fileContent, "a"));
        LOGGER.info("\nDelete whitespaces: "+StringUtils.deleteWhitespace(fileContent));
        LOGGER.info("\nUppercase content: "+ StringUtils.upperCase(fileContent));

        //FileUtils Methods
        File copyText = new File("src/main/java/com/solvd/readtext/copytext.txt");
        File newPackage = new File("src/main/java/com/solvd/readtext/newpackage");
        try {
            FileUtils.copyFile(FILE, copyText);
            FileUtils.forceMkdir(newPackage);
            FileUtils.lastModified(copyText);
            LOGGER.info(""+FileUtils.getUserDirectoryPath());
            LOGGER.info(""+FileUtils.sizeOf(FILE));
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
