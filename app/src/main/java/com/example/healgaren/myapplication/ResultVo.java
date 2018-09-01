package com.example.healgaren.myapplication;

import java.util.List;

public class ResultVo {
    private Profile myProfile;
    private List<Profile> friends;

    public ResultVo(Profile myProfile, List<Profile> friends) {
        this.myProfile = myProfile;
        this.friends = friends;
    }

    public Profile getMyProfile() {
        return myProfile;
    }

    public void setMyProfile(Profile myProfile) {
        this.myProfile = myProfile;
    }

    public List<Profile> getFriends() {
        return friends;
    }

    public void setFriends(List<Profile> friends) {
        this.friends = friends;
    }
}
