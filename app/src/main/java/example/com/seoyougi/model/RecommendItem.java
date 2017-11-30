package example.com.seoyougi.model;

/**
 * Created by icns on 2017-11-24.
 */

public class RecommendItem {
    private String imageUrl;
    private String detail;

    public RecommendItem(String imageUrl, String detail) {
        this.imageUrl = imageUrl;
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
