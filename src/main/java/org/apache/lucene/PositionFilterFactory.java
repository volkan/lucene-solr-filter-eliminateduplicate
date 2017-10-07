package org.apache.lucene;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.util.Map;

public class PositionFilterFactory extends TokenFilterFactory {
    private int positionIncrement;

    public PositionFilterFactory(Map<String, String> args) {
        super(args);
        positionIncrement = getInt(args,"positionIncrement", 0);
    }

    public PositionFilter create(TokenStream input) {
        return new PositionFilter(input, positionIncrement);
    }
}