package com.ctd.services.impl;

import com.ctd.model.Article;
import com.ctd.services.CheckQuality;

public class WeightValidate extends CheckQuality {


    @Override
    public void validate(Article article) {

        if (article.getWeight() >= 1200 && article.getWeight() <= 1300){
            System.out.println("Weight: OK!");
            if (this.nextCheckQuality != null) this.nextCheckQuality.validate(article);
        }else {
            System.out.println("Reject, Weight does not meet requirements!");
        }
    }
}
