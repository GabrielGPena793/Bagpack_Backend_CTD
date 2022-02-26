package com.ctd.services.impl;

import com.ctd.model.Article;
import com.ctd.services.CheckQuality;

public class BatchValidate extends CheckQuality {

    @Override
    public void validate(Article article) {

        if (article.getBatch() >= 1000 && article.getBatch() <= 2000){
            System.out.println("Batch: OK!");
            if (this.nextCheckQuality != null) this.nextCheckQuality.validate(article);
        }else {
            System.out.println("Reject, Batch does not meet requirements!");
        }
    }
}
