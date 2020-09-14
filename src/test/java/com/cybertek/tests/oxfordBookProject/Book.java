package com.cybertek.tests.oxfordBookProject;

public class Book {
    String link;
    int numOfPages;
    String folderName;

    public Book(String link, int numOfPages, String folderName) {
        this.link = link;
        this.numOfPages = numOfPages;
        this.folderName = folderName;
    }

    public String getLink() {
        return link;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public String getFolderName() {
        return folderName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "link='" + link + '\'' +
                ", numOfPages=" + numOfPages +
                ", folderName='" + folderName + '\'' +
                '}';
    }
}
