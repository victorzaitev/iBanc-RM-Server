/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC01017745
 */
public class MailProperties {

    private final String filePatch;

    private final Properties propFile = new Properties();
    private InputStream input = null;

    private String host;

    private String port;

    private String from;

    private String user;

    private String pass;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getFrom() {
        return from;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "MailProperties{" + "host=" + host + ", port=" + port + ", from=" + from + ", user=" + user + ", pass=" + pass + '}';
    }

    public MailProperties(String filePatch) {
        this.filePatch = filePatch;
        readProperties();
    }

    private void readProperties() {
        String filename = "systemParms.properties";
        try {
            input = new FileInputStream(filePatch + "WEB-INF" + System.getProperty("file.separator") + filename);
            propFile.load(input);
            host = propFile.getProperty("host");
            port = propFile.getProperty("port");
            from = propFile.getProperty("from");
            user = propFile.getProperty("user");
            pass = propFile.getProperty("pass");
            
            
            
            

        } catch (IOException ex) {
            Logger.getLogger(MailProperties.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
