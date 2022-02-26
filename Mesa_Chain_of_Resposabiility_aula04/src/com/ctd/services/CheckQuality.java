package com.ctd.services;

import com.ctd.model.Article;

public abstract class CheckQuality {

    protected CheckQuality nextCheckQuality;

    public CheckQuality setNextCheckQuality(CheckQuality nextCheckQuality) {
        this.nextCheckQuality = nextCheckQuality;
        return this;
    }

    public abstract void validate(Article article);
}
