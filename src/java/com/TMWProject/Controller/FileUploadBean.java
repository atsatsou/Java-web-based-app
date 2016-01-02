
package com.TMWProject.Controller;

import javax.faces.bean.RequestScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Μάχη
 */
@Named(value = "fileUploadBean")
@RequestScoped
public class FileUploadBean {
private Part uploadedFile;
private String text;
    public FileUploadBean() {
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void upload() {

        if (null != uploadedFile) {
            try {
                InputStream is = uploadedFile.getInputStream();
                text = new Scanner(is).useDelimiter("\\A").next();
            } catch (IOException ex) {
            }
        }
    }
}
