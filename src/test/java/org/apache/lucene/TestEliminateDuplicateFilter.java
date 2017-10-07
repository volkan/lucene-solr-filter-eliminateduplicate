package org.apache.lucene;

import org.apache.lucene.analysis.BaseTokenStreamTestCase;
import org.apache.lucene.analysis.TokenStream;

public class TestEliminateDuplicateFilter extends BaseTokenStreamTestCase {

    public void testEliminate() throws Exception {
        TokenStream stream = whitespaceMockTokenizer("mağaza mağaza ayakkabı kalem");
        stream = new EliminateDuplicateFilter(stream);
        assertTokenStreamContents(stream, new String[]{"mağaza", "ayakkabı", "kalem"});
    }
}