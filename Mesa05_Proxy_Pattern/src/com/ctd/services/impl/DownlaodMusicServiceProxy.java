package com.ctd.services.impl;

import com.ctd.services.DownloadMusic;

public class DownlaodMusicServiceProxy implements DownloadMusic {

    private DownloadMusicService downloadMusicService;

    @Override
    public void download(String typeUser) {
        if(typeUser.equalsIgnoreCase("Premium")){
            downloadMusicService = new DownloadMusicService();
            downloadMusicService.download(typeUser);
        }
        else {
            System.out.println("Este serviço é apenas para usuários Premium " + "User: " + typeUser);
        }
    }
}
