package com.ctd.services.impl;

import com.ctd.model.Article;
import com.ctd.services.CheckQuality;

public class PackagingValidate extends CheckQuality {

    @Override
    public void validate(Article article) {

        if (article.getPackaging().equalsIgnoreCase("saudável") || article.getPackaging().equalsIgnoreCase("quase saudável")){
            System.out.println("package accepted!");
            if (this.nextCheckQuality != null) this.nextCheckQuality.validate(article);
        }else {
            System.out.println("Reject, Package does not meet requirements!");
        }

    }
}
