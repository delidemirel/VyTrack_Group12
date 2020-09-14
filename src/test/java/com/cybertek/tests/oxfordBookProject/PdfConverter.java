package com.cybertek.tests.oxfordBookProject;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;


public class PdfConverter {
    public static void main(String[] args) throws URISyntaxException, IOException, DocumentException {

        Document document =new Document(PageSize.LETTER,0,0,0,0);
//        Path path= Paths.get(ClassLoader.getSystemResource("/Users/haticedeli/IdeaProjects/seleniumprojecthdB20/International PEA Book 2/test-0.png").toURI());
        PdfWriter.getInstance(document,new FileOutputStream("/Users/haticedeli/IdeaProjects/seleniumprojecthdB20/International PEA Book 2/denemeL.pdf"));
        document.open();
        Image img= Image.getInstance("/Users/haticedeli/IdeaProjects/seleniumprojecthdB20/International PEA Book 2/biz.png");
        img.scaleToFit(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
        document.add(img);
        document.close();


    }
}
