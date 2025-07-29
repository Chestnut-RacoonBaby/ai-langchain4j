package com.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * xiaozhi智能体
 *
 * @author: qiaohaojie
 * @date: 2025-07-21 22:30:42
 */
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
//        chatModel = "qwenChatModel",
        streamingChatModel = "qwenStreamingChatModel",
        // 这个beanName是从配置类（XiaozhiAgentConfig）中获取的
        chatMemoryProvider = "chatMemoryProviderXiaozhi",
        // 配置工具
        tools = "appointmentTools",
        // 配置向量数据库
//        contentRetriever = "contentRetrieverXiaozhi"
        contentRetriever = "contentRetrieverXiaozhiPincone"
)
public interface XiaozhiAgent {

//    @SystemMessage(fromResource = "xiaozhi-prompt-template.txt")
//    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

    /**
     * 流式输出
     * 大模型的流式输出是指大模型在生成文本或其他类型的数据时，不是等到整个生成过程完成后再一次性
     * 返回所有内容，而是生成一部分就立即发送一部分给用户或下游系统，以逐步、逐块的方式返回结果。
     * 这样，用户就不需要等待整个文本生成完成再看到结果。通过这种方式可以改善用户体验，因为用户不
     * 需要等待太长时间，几乎可以立即开始阅读响应。
     *
     * @param memoryId    memoryId
     * @param userMessage userMessage
     * @return
     */
    @SystemMessage(fromResource = "zhaozhi-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
