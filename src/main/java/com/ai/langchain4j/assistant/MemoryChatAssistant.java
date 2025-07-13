package com.ai.langchain4j.assistant;

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

    String chat(String userMessage);
}
