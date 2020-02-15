package com.example.temphackathon;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

import java.net.MalformedURLException;
import java.net.URL;

public class IBMdatabase {


    private CloudantClient client = ClientBuilder.account(String.valueOf(new URL("https://02500b08-bfdc-4667-b601-6b0a5b839c3f-bluemix:413b3611ae250a9fbad099ce5f6857279d7aa4c8e8f943d50bbfc1c9fe714f16@02500b08-bfdc-4667-b601-6b0a5b839c3f-bluemix.cloudantnosqldb.appdomain.cloud")))
            .username("02500b08-bfdc-4667-b601-6b0a5b839c3f-bluemix")
            .password("413b3611ae250a9fbad099ce5f6857279d7aa4c8e8f943d50bbfc1c9fe714f16")
            .build();

    public IBMdatabase() throws MalformedURLException {
    }

    public void createIBMDatabase(){
        client.createDB("conversationRecord");
    }

    public void insertIntoIBMDatabse(){
        Database db = client.database("chatbot", false);
        class ExampleDocument {
            private String _id = "123";
            private String _rev = "haha";
            private boolean isExample;

            public ExampleDocument(boolean isExample) {
                this.isExample = isExample;
            }

            public String toString() {
                return "{ id: " + _id + ",\nrev: " + _rev + ",\nisExample: " + isExample + "\n}";
            }
        }

        db.save(new ExampleDocument(true));
        System.out.println("You have inserted the document");

// Get an ExampleDocument out of the database and deserialize the JSON into a Java type
        ExampleDocument doc = db.find(ExampleDocument.class,"123");
        System.out.println(doc);
    }
}
