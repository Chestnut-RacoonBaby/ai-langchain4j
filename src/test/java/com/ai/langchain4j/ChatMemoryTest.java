package com.ai.langchain4j;

import com.ai.langchain4j.assistant.Assistant;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author: qiaohaojie
 * @date: 2025-07-13 15:36:13
 */
@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;

    /**
     * 这个聊天是无记忆的，每次会话都会被清空
     */
    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }
}
