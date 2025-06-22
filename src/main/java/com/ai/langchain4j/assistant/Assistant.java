package com.ai.langchain4j.assistant;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

/**
 * @author: qiaohaojie
 * @date: 2025-06-22 21:57:13
 */
// 如果配置文件里配置了多个大语言模型，这里需要指明使用个哪个模型
@AiService(wiringMode = AiServiceWiringMode.EXPLICIT, chatModel = "qwenChatModel")
public interface Assistant {

    String chat(String userMessage);
}
