package com.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * xiaozhi智能体
 *
 * @author: qiaohaojie
 * @date: 2025-07-21 22:30:42
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "qwenChatModel",
        // 这个beanName是从配置类（XiaozhiAgentConfig）中获取的
        chatMemoryProvider = "chatMemoryProviderXiaozhi",
        // 配置工具
        tools = "appointmentTools",
        // 配置向量数据库
//        contentRetriever = "contentRetrieverXiaozhi"
        contentRetriever = "contentRetrieverXiaozhiPincone"
)
public interface XiaozhiAgent {

    @SystemMessage(fromResource = "xiaozhi-prompt-template.txt")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
