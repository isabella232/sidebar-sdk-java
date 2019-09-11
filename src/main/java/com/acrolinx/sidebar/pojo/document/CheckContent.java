/**
 * Copyright (c) 2019-present Acrolinx GmbH
 */

package com.acrolinx.sidebar.pojo.document;

import javax.annotation.Nullable;

import com.acrolinx.sidebar.pojo.document.externalContent.ExternalContent;
import com.acrolinx.sidebar.utils.GsonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CheckContent
{

    private String content;
    private ExternalContent externalContent;

    public CheckContent(String content, @Nullable ExternalContent externalContent)
    {
        this.content = content;
        this.externalContent = externalContent;
    }

    public String getContent()
    {
        return this.content;
    }

    public ExternalContent getExternalContent()
    {
        return this.externalContent;
    }

    @Override
    public String toString()
    {
        return GsonUtils.getJsonFormObject(this);
    }
}
