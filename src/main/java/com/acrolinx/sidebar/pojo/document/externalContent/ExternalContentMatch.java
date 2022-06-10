/**
 *  Copyright (c) 2022-present Acrolinx GmbH
 */
package com.acrolinx.sidebar.pojo.document.externalContent;

import com.acrolinx.sidebar.pojo.document.IntRange;
import com.google.gson.Gson;

import java.util.List;

public class ExternalContentMatch {

    private final String id;
    private final String type;
    private final int originalBegin;
    private final int originalEnd;
    private List<ExternalContentMatch> externalContentMatches;


    public ExternalContentMatch(String id, String type, int originalBegin, int originalEnd, List<ExternalContentMatch> externalContentMatches) {
        this(id, type, originalBegin, originalEnd);
        this.externalContentMatches = externalContentMatches;
    }

    public ExternalContentMatch(String id, String type, int originalBegin, int originalEnd) {
        this.id = id;
        this.type = type;
        this.originalBegin = originalBegin;
        this.originalEnd = originalEnd;
        this.externalContentMatches = null;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public IntRange getRange()
    {
        return new IntRange(this.originalBegin, this.originalEnd);
    }

    public ExternalContentMatch setRange(final IntRange range)
    {
        if(this.externalContentMatches != null) {
            return new ExternalContentMatch(this.id, this.type, range.getMinimumInteger(), range.getMaximumInteger(), this.getExternalContentMatches());
        }
        return new ExternalContentMatch(this.id, this.type, range.getMinimumInteger(), range.getMaximumInteger());
    }

    public List<ExternalContentMatch> getExternalContentMatches() {
        return externalContentMatches;
    }

    public void setExternalContentMatches( List<ExternalContentMatch> newList) {
        externalContentMatches = newList;
    }

    @Override
    public String toString()
    {
        return new Gson().toJson(this);
    }

}
