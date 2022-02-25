package com.ctd.model;

import com.ctd.services.DownloadMusic;
import com.ctd.services.impl.DownlaodMusicServiceProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void downloadTest(){
        User user = new User(1, "Premium");
        DownloadMusic downloadMusic = new DownlaodMusicServiceProxy();

        downloadMusic.download(user.getTypeUser());
    }

}