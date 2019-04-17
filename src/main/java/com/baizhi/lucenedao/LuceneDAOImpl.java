package com.baizhi.lucenedao;

import com.baizhi.entity.Product;
import com.baizhi.util.LuceneUtil;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class LuceneDAOImpl implements LuceneDAO {
    @Override
    public List<Product> selectProduct(String context) {

        List<Product> list = new ArrayList<>();
        IndexSearcher indexSearcher = LuceneUtil.getIndexSearcher();
        try {
            TopDocs topDocs = indexSearcher.search(new TermQuery(new Term("name",context)), 100);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (int i = 0; i < scoreDocs.length; i++) {
                ScoreDoc scoreDoc = scoreDocs[i];
                int doc = scoreDoc.doc;
                Document document = indexSearcher.doc(doc);
                Product p = new Product();
                /*String id = document.get("id");
                int x = Integer.parseInt(id);*/
                p.setId(1);
                p.setName(document.get("name"));

                p.setPrice(Double.valueOf(document.get("price")));

                p.setDescription(document.get("description"));

                //p.setPath(document.get("path"));
                p.setState(Integer.parseInt(document.get("state")));
                p.setAddress(document.get("address"));

                list.add(p);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void add(Product product) {

        IndexWriter indexWriter = LuceneUtil.getIndexWriter();
        Document document = new Document();
        document.add(new IntField("id",1, Field.Store.YES));
        document.add(new StringField("name",product.getName(), Field.Store.YES));
        document.add(new DoubleField("price",product.getPrice(), Field.Store.YES));
        document.add(new StringField("description",product.getDescription(), Field.Store.YES));
        //document.add(new StringField("path",product.getPath(), Field.Store.YES));
        document.add(new IntField("state",product.getState(), Field.Store.YES));
       // document.add(new DateField("bir",product.getBir(), Field.Store.YES));
        document.add(new StringField("address",product.getAddress(), Field.Store.YES));

        try {
            indexWriter.addDocument(document);
            LuceneUtil.commit(indexWriter);

        } catch (IOException e) {
            LuceneUtil.rollback(indexWriter);
            e.printStackTrace();
        }
    }
}
