package com.ctd;

import com.ctd.model.Article;
import com.ctd.services.CheckQuality;
import com.ctd.services.impl.BatchValidate;
import com.ctd.services.impl.PackagingValidate;
import com.ctd.services.impl.WeightValidate;

public class Main {

    public static void main(String[] args) {
        Article article = new Article("artigo1", 1000, 1200, "saudável");

        CheckQuality checkQuality = new BatchValidate().setNextCheckQuality(new WeightValidate().setNextCheckQuality(new PackagingValidate()));

        checkQuality.validate(article);
    }
}
