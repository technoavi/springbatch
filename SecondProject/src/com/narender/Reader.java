package com.narender;

import java.io.Serializable;

public class Reader implements Serializable {
    private String pdfText;
    private String wordText;

    public String getPdfText() {
        return pdfText;
    }

    public void setPdfText(String pdfText) {
        this.pdfText = pdfText;
    }

    public String getWordText() {
        return wordText;
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "pdfText='" + pdfText + '\'' +
                ", wordText='" + wordText + '\'' +
                '}';
    }

    public String pdfReader(String pdf) {
        return "PDF text is: "+ pdf;
    }

    public String wordReader(String word) {
        return "Word text is: "+word;
    }
}
