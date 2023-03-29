package com.kaiburr.task1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "servers")
public class Server {

    @Id
    private String idserv;
    private String name;
    private String lang;
    private String frame;

    public Server(String idserv, String nm, String lang, String frame) {
        this.idserv = idserv;
        this.nm = nm;
        this.lang = lang;
        this.frame = frame;
    }

    public String getId() {
        return id;
    }

    public void setId(String idserv) {
        this.idserv = idserv;
    }

    public String getName() {
        return nm;
    }

    public void setName(String nm) {
        this.nm = nm;
    }

    public String getLanguage() {
        return lang;
    }

    public void setLanguage(String lang) {
        this.lang = lang;
    }

    public String getFramework() {
        return frame;
    }

    public void setFramework(String frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "Server [framework=" + frame + ", id=" + idserv + ", language=" + lang + ", name=" + nm + "]";
    }

}