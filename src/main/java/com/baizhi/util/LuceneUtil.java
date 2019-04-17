package com.baizhi.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class LuceneUtil {

    private static Directory dir;
    private static IndexWriterConfig conf;
    private static Version version;
    private static Analyzer analyzer;
    static {
        try {
            version = Version.LUCENE_44;
            analyzer = new IKAnalyzer();
            dir = FSDirectory.open(new File("E:/lucene"));
            conf = new IndexWriterConfig(version,analyzer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static IndexWriter getIndexWriter(){
        IndexWriter indexWriter = null;
        try {
            indexWriter = new IndexWriter(dir,conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexWriter;
    }
    public static IndexSearcher getIndexSearcher(){
        IndexSearcher indexSearcher = null;
        try {
            IndexReader reader = DirectoryReader.open(dir);
            indexSearcher = new IndexSearcher(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexSearcher;
    }

    public static void commit(IndexWriter indexWriter){
        try {
            indexWriter.commit();
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void rollback(IndexWriter indexWriter){
        try {
            indexWriter.rollback();
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
