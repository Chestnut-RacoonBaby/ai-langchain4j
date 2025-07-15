package com.ai.langchain4j;

import com.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * MongoDB测试类
 *
 * @author: qiaohaojie
 * @date: 2025-07-15 22:07:25
 */
@SpringBootTest
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入文档，指定id
     */
    @Test
    public void testInsert() {
//        mongoTemplate.insert(new ChatMessages(1L, "聊天记录"));
    }

    /**
     * 插入文档，自动生成id
     */
    @Test
    public void testInsert2() {
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表...");
        mongoTemplate.insert(chatMessages);
    }

    /**
     * 根据id查询
     */
    @Test
    public void testFindById() {
        ChatMessages chatMessages = mongoTemplate.findById(1L, ChatMessages.class);
        System.out.println(chatMessages);
    }

    /**
     * 新增或更新操作
     */
    @Test
    public void testUpdate() {
        Criteria criteria = Criteria.where("_id").is(1L);
        Query query = Query.query(criteria);
        Update update = new Update();
        update.set("content", "(新)聊天记录列表...");
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    /**
     * 删除操作
     */
    @Test
    public void testDelete() {
        Criteria criteria = Criteria.where("_id").is(1L);
        Query query = Query.query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
