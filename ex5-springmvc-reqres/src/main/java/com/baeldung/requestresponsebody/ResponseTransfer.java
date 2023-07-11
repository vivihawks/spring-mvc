package com.baeldung.requestresponsebody;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseTransfer {

    private String text;

    public ResponseTransfer(String text) {
        this.setText(text);
    }
    public ResponseTransfer() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}