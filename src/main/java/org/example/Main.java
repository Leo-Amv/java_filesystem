package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Tree.print(new File("."), "", true);
        Backup.backup("./backup");
    }
}