
package com.acrolinx.sidebar.pojo.document.externalContent;

import com.google.gson.Gson;

public class DitaReference
{
    private String id;
    private String content;

    DitaReference(String id, String content)
    {
        this.id = id;
        this.content = content;
    }

    public String getId()
    {
        return id;
    }

    public String getContent()
    {
        return content;
    }

    @Override
    public String toString()
    {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }
}
