package com.ai.langchain4j.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 智能体
 *
 * @author: qiaohaojie
 * @date: 2025-07-13 21:21:24
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        // 这个beanName是从配置类（MemoryChatAssistantConfig）中获取的
        chatMemory = "chatMemory"
)
public interface MemoryChatAssistant {

    /**
     * 用户提示词，it表示唯一的参数的占位符。
     * 注意：必须是it，否则就报错。
     *
     * @param userMessage userMessage
     * @return
     */
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{it}}")
    String chat(String userMessage);

    /**
     * 用户提示词，使用@V来指定占位符的名字。。
     * 注意：占位符的名字必须和指定的名字一样，否则就报错。
     *
     * @param userMessage userMessage
     * @return
     */
    @UserMessage("你是我的好朋友，请用上海话回答问题，并且添加一些表情符号。 {{message}}")
    String chat2(@V("message") String userMessage);
}
