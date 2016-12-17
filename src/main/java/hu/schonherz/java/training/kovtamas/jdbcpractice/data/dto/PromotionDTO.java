package hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto;

import java.sql.Date;

public class PromotionDTO {

    private int id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String url;

    public PromotionDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PromotionDTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", startDate="
                + startDate + ", endDate=" + endDate + ", url=" + url + '}';
    }

}
