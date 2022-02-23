package com.ctd.tests;

import com.ctd.entities.Document;
import com.ctd.services.Congressperson;
import com.ctd.services.GovermmentMember;
import com.ctd.services.Minister;
import com.ctd.services.President;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GovermmentMemberTest {

    @Test
    public void shouldReturnMembersPermissionWhenTypeOne(){

        GovermmentMember member = new Congressperson().setNextGovermmentMember(new Minister().setNextGovermmentMember(new President()));
        Document document = new Document("All read", 1);

        member.readDocument(document);
    }


    @Test
    public void shouldReturnMembersPermissionWhenTypeTwo(){

        GovermmentMember member = new Congressperson().setNextGovermmentMember(new Minister().setNextGovermmentMember(new President()));
        Document document = new Document("All read", 2);

        member.readDocument(document);
    }


    @Test
    public void shouldReturnMembersPermissionWhenTypeThree(){

        GovermmentMember member = new Congressperson().setNextGovermmentMember(new Minister().setNextGovermmentMember(new President()));
        Document document = new Document("All read", 3);

        member.readDocument(document);
    }
}