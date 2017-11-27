package example.com.sayougi.model;

import java.util.List;

/**
 * Created by mansu on 2017-11-27.
 */

public class RecommendCourse {
    private String imageUrl;
    private String courseName;
    private float basePointX;
    private float basePointY;
    private List<Location> locations;

    public RecommendCourse() {}

    public RecommendCourse(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public float getBasePointX() {
        return basePointX;
    }

    public void setBasePointX(float basePointX) {
        this.basePointX = basePointX;
    }

    public float getBasePointY() {
        return basePointY;
    }

    public void setBasePointY(float basePointY) {
        this.basePointY = basePointY;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
