package example.com.sayougi.model;

import java.util.List;

/**
 * Created by mansu on 2017-11-27.
 */

public class Theme {
    private String name;
    private List<String> imageUrls;

    public Theme() {}

    public Theme(String name, List<String> imageUrls) {
        this.name = name;
        this.imageUrls = imageUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
