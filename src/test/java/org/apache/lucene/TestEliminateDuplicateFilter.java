package org.apache.lucene;

import org.apache.lucene.analysis.BaseTokenStreamTestCase;
import org.apache.lucene.analysis.TokenStream;

public class TestEliminateDuplicateFilter extends BaseTokenStreamTestCase {

    public void testEliminate() throws Exception {
        TokenStream stream = whitespaceMockTokenizer("text word word text word word");
        stream = new EliminateDuplicateFilter(stream);
        assertTokenStreamContents(stream, new String[]{"text", "word"});
    }
}