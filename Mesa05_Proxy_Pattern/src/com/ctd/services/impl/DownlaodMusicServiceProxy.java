package com.ctd.services.impl;

import com.ctd.services.DownloadMusic;

public class DownlaodMusicServiceProxy implements DownloadMusic {

    private DownloadMusicService downloadMusicService = new DownloadMusicService();

    @Override
    public void download(String typeUser) {
        if(typeUser.equalsIgnoreCase("Premium")){
            downloadMusicService.download(typeUser);
        }
        else {
            System.out.println( "User: " + typeUser + ", Este serviço é apenas para usuários Premium.");
        }
    }
}
