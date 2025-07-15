package com.ai.langchain4j.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: qiaohaojie
 * @date: 2025-07-15 22:00:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 应用程序自动在chat_memory_db数据库下创建chat_messages集合
@Document("chat_messages")
public class ChatMessages {

    /**
     * 唯一标识，映射到 MongoDB 文档的 _id 字段
     * 如果想自动生成id，则需要 ObjectId 类型
     */
    @Id
    private ObjectId messageId;
//    private Long messageId;

    /**
     * 存储当前聊天记录列表的json字符串
     * 包含：客户端发送给大模型的 userMessage、大模型响应给客户端的 assistantMessage
     */
    private String content;
}
