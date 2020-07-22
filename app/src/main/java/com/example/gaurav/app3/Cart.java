package com.example.gaurav.app3;

public class Cart {
    private String name;
    private String id,price, itemid,url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String  getUrl()
    {
        return  url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemid() {
        return itemid;
    }//interchange  itemid and url

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }



}
