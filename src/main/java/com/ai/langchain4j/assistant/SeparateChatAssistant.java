package com.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * 隔离聊天记忆智能体
 *
 * @author: qiaohaojie
 * @date: 2025-07-13 21:34:08
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        // 这个beanName是从配置类（MemoryChatAssistantConfig）中获取的
        chatMemory = "chatMemory",
        // 这个beanName是从配置类（SeparateChatAssistantConfig）中获取的
        chatMemoryProvider = "chatMemoryProvider"
)
public interface SeparateChatAssistant {

    /**
     * 隔离聊天消息
     *
     * @param memoryId    聊天id
     * @param userMessage 用户消息
     * @return
     */
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);
}
