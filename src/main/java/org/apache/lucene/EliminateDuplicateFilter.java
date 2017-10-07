package org.apache.lucene;


import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.FilteringTokenFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.util.*;

public final class EliminateDuplicateFilter extends FilteringTokenFilter {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    List<String> myList = new ArrayList<String>();

    public EliminateDuplicateFilter(TokenStream in) {
        super(in);
    }

    private boolean checkStatus() {
        if(!myList.contains(termAtt.toString())) {
            myList.add(termAtt.toString());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean accept() {
        return (checkStatus());
    }
}