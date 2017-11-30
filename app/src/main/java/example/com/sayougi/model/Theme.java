package example.com.sayougi.model;

import java.io.Serializable;

/**
 * Created by mansu on 2017-11-27.
 */

public class Theme implements Serializable {
    private String id;
    private String lang;
    private String name;
    private String countPlace;
    private String description;
    private String updatedAt;

    public Theme(String id, String lang, String name, String countPlace, String description, String updatedAt) {
        this.id = id;
        this.lang = lang;
        this.name = name;
        this.countPlace = countPlace;
        this.description = description;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountPlace() {
        return countPlace;
    }

    public void setCountPlace(String countPlace) {
        this.countPlace = countPlace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
