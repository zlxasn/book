package org.itzxs.dto;

/**
 * Created by Itzxs on 2018/4/20.
 */
public class ChapterDTO {
    private String title;
    private String url;

    public ChapterDTO() {
    }

    public ChapterDTO(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
