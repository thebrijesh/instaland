package com.example.instaland.model;

public class DashboardModel {
    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getPostimg() {
        return postimg;
    }

    public void setPostimg(int postimg) {
        this.postimg = postimg;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    int profile,postimg,save;
    String name, about, like, comment, share;

    public DashboardModel(int profile, int postimg, int save, String name, String about, String like, String comment, String share) {
        this.profile = profile;
        this.postimg = postimg;
        this.save = save;
        this.name = name;
        this.about = about;
        this.like = like;
        this.comment = comment;
        this.share = share;
    }
}
