package com.ai.langchain4j;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

/**
 * @author: qiaohaojie
 * @date: 2025-07-24 22:53:38
 */
@SpringBootTest
public class RAGTest {

    @Test
    public void testReadDocument() {
        // 使用FileSystemDocumentLoader读取指定目录下的知识库文档
        // 并使用默认的文档解析器TextDocumentParser对文档进行解析
        Document document = FileSystemDocumentLoader
                .loadDocument("E:/knowledge/测试.txt");
        System.out.println(document.text());

        // 加载单个文档
        Document document2 = FileSystemDocumentLoader
                .loadDocument("E:/knowledge/file.txt", new TextDocumentParser());
        // 从一个目录中加载所有文档
        List<Document> documents = FileSystemDocumentLoader
                .loadDocuments("E:/knowledge", new TextDocumentParser());
        // 从一个目录中加载所有的.txt文档
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        List<Document> documents2 = FileSystemDocumentLoader
                .loadDocuments("E:/knowledge", pathMatcher, new TextDocumentParser());
        // 从一个目录及其子目录中加载所有文档
        List<Document> documents3 = FileSystemDocumentLoader
                .loadDocumentsRecursively("E:/knowledge", new TextDocumentParser());
    }

    /**
     * 解析PDF
     */
    @Test
    public void testParsePDF() {
        Document document = FileSystemDocumentLoader.loadDocument(
                "E:/knowledge/医院信息.pdf",
                new ApachePdfBoxDocumentParser()
        );
        System.out.println(document);
    }
}
