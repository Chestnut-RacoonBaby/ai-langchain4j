package com.ai.langchain4j;

import com.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 系统提示词测试
 *
 * @author: qiaohaojie
 * @date: 2025-07-20 21:59:26
 */
@SpringBootTest
public class PromptTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    /**
     * {"_id":{"$oid":"687cfe25f9f6a56da68c7255"},
     * "_memoryId":4,"content":"[{\"text\":\"你是我的好朋友，请用东北话回答问题。今天是2025-07-20\",\"type\":\"SYSTEM\"},{\"contents\":[{\"text\":\"今天几号\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"哎呀，今儿个是2025年7月20号，你这记性咋样，老弟？\",\"type\":\"AI\"}]"}
     * type：系统提示词
     */
    @Test
    public void testSystemMessage() {
        String answer = separateChatAssistant.chat(4, "今天几号");
        System.out.println(answer);
    }
}
