package com.ravi;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by RaviA on 15-12-2015.
 */
public class FirstLambda {
    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        File dir = new File("D:/javaFiles");
        File[] files = dir.listFiles(fileFilter);
        for (File file : files) {
            System.out.println(file);
        }

        FileFilter fileFilterLambda = (File pathname) -> pathname.getName().endsWith(".java");

        File dirLambda = new File("D:/javaFiles");
        File[] filesLambda = dirLambda.listFiles(fileFilterLambda);
        for (File file : filesLambda) {
            System.out.println(file);
        }
    }
}
