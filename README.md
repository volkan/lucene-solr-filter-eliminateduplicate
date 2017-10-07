## Eliminate duplicate words components for Apache Lucene/Solr
[![Build Status](https://travis-ci.org/volkan/lucene-solr-filter-eliminateduplicate.svg?branch=master)](https://travis-ci.org/volkan/lucene-solr-filter-eliminateduplicate)


Please use the following field type definitions.
### Remove duplicate words
``` xml
<fieldType name="text" class="solr.TextField" positionIncrementGap="100">
  <analyzer>
    <tokenizer class="solr.StandardTokenizerFactory"/>
      <filter class="org.apache.lucene.EliminateDuplicateFilterFactory" />
  </analyzer>
</fieldType>
```

#### Result

Input | Output
--- | ---
`text word word text word word` | **text word**

### Custom PositionFilterFactory
``` xml
<fieldType name="text" class="solr.TextField" positionIncrementGap="100">
  <analyzer>
    <tokenizer class="solr.StandardTokenizerFactory"/>
	  <filter class="org.apache.lucene.PositionFilterFactory" />
	  <filter class="solr.RemoveDuplicatesTokenFilterFactory"/>
  </analyzer>
</fieldType>
```
#### Result

Input | Output
--- | ---
`text word word text word word` | **text word**
