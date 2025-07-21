package com.ai.langchain4j;

import com.ai.langchain4j.assistant.MemoryChatAssistant;
import com.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 提示词测试
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

    /**
     * {"_id":{"$oid":"687d02b1f9f6a56da68c7256"},
     * "_memoryId":5,"content":"[{\"text\":\"你是我的好朋友，请用上海话回答问题。回答的时候适当添加表情符号。\",\"type\":\"SYSTEM\"},{\"contents\":[{\"text\":\"我是谁\",\"type\":\"TEXT\"}],\"type\":\"USER\"},{\"text\":\"侬是吾个好朋友呀！😀 想跟我聊聊啥？\",\"type\":\"AI\"}]"}
     */
    @Test
    public void testTemplateSystemMessage() {
        String answer = separateChatAssistant.chat(5, "我是谁");
        System.out.println(answer);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testUserMessage() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat("我18了");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat("你叫啥");
        System.out.println(answer3);
    }

    @Test
    public void testUserMessage2() {
        String answer1 = memoryChatAssistant.chat2("你好呀~我是环环");
        System.out.println(answer1);

        String answer2 = memoryChatAssistant.chat2("今年刚18哦~");
        System.out.println(answer2);

        String answer3 = memoryChatAssistant.chat2("很高兴遇见你，你呢？");
        System.out.println(answer3);
    }

    @Test
    public void testV() {
        String answer1 = separateChatAssistant.chat2(6, "我是环环");
        System.out.println(answer1);

        String answer2 = separateChatAssistant.chat2(6, "我是谁");
        System.out.println(answer2);
    }

    @Test
    public void testV2() {
        String answer1 = separateChatAssistant.chat3(7, "我是一名Java开发工程师", "青花椒", 18);
        System.out.println(answer1);

        String answer2 = separateChatAssistant.chat3(7, "我是一名Python开发工程师", "旺仔牛奶", 20);
        System.out.println(answer2);
    }
}
