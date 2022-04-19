package com.example.instaland.model;

public class story {

    int story,storylive,profile_image;
    String storyname;

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getStorylive() {
        return storylive;
    }

    public story(int story, int storylive, int profile_image, String storyname) {
        this.story = story;
        this.storylive = storylive;
        this.profile_image = profile_image;
        this.storyname = storyname;
    }

    public void setStorylive(int storylive) {
        this.storylive = storylive;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getStoryname() {
        return storyname;
    }

    public void setStoryname(String storyname) {
        this.storyname = storyname;
    }


}
