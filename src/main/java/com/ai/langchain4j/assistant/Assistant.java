package com.ai.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * AIService：使用面向接口和动态代理的方式完成程序的编写，更灵活的实现高级功能。底层组件将由AIService进行组装。
 *
 * @author: qiaohaojie
 * @date: 2025-06-22 21:57:13
 */
// 如果配置文件里配置了多个大语言模型，这里需要指明使用个哪个模型
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel")
public interface Assistant {

    String chat(String userMessage);
}
