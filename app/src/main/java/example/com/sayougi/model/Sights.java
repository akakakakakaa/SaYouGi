package example.com.sayougi.model;

import java.io.Serializable;

/**
 * Created by mansu on 2017-11-27.
 */

public class Sights implements Serializable {
    private String id;
    private String lang;
    private String name;
    private String coordX;
    private String coordY;
    private String addrNew;
    private String addrOld;
    private String addrRegion;
    private String contact;
    private String description;
    private String content;
    private String updatedAt;

    public Sights(String id, String lang, String name, String coordX, String coordY, String addrNew, String addrOld, String addrRegion, String contact, String description, String content, String updatedAt) {
        this.id = id;
        this.lang = lang;
        this.name = name;
        this.coordX = coordX;
        this.coordY = coordY;
        this.addrNew = addrNew;
        this.addrOld = addrOld;
        this.addrRegion = addrRegion;
        this.contact = contact;
        this.description = description;
        this.content = content;
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

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public String getAddrNew() {
        return addrNew;
    }

    public void setAddrNew(String addrNew) {
        this.addrNew = addrNew;
    }

    public String getAddrOld() {
        return addrOld;
    }

    public void setAddrOld(String addrOld) {
        this.addrOld = addrOld;
    }

    public String getAddrRegion() {
        return addrRegion;
    }

    public void setAddrRegion(String addrRegion) {
        this.addrRegion = addrRegion;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
