package com.ai.langchain4j.config;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: qiaohaojie
 * @date: 2025-07-13 21:22:39
 */
@Configuration
public class MemoryChatAssistantConfig {

    /**
     * 注入bean，名字叫做chatMemory
     *
     * @return
     */
    @Bean
    public ChatMemory chatMemory() {
        //设置聊天记忆记录的message数量
        return MessageWindowChatMemory.withMaxMessages(10);
    }
}
