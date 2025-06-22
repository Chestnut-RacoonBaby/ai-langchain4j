package com.ai.langchain4j;

import com.ai.langchain4j.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * AIService使用面向接口和动态代理的方式完成程序的编写，更灵活的实现高级功能
 *
 * @author: qiaohaojie
 * @date: 2025-06-22 21:58:48
 */
@SpringBootTest
public class AIServiceTest {

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void testChat() {
        Assistant assistant = AiServices.create(Assistant.class, qwenChatModel);
        String answer = assistant.chat("请给我一段自我介绍");
        System.out.println(answer);
    }
}
