package com.ctd.services.impl;

import com.ctd.services.DownloadMusic;

public class DownloadMusicService implements DownloadMusic {

    @Override
    public void download(String typeUser) {
        System.out.println( "User: " + typeUser + ", Musica retornada");
    }
}
