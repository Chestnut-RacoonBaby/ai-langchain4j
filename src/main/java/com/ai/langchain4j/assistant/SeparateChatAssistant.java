package com.ai.langchain4j.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
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
     * 使用@SystemMessage设置系统提示词，设定角色描述。其内容会在后台转换为SystemMessage对象，并与UserMessage一起发送给大语言模型。
     * SystemMessage的内容只会发送给大模型一次。如果修改了SystemMessage的内容，新的SystemMessage会被发送给大模型，之前的聊天记忆会失效。
     *
     * @param memoryId    聊天id
     * @param userMessage 用户消息
     * @return
     */
    @SystemMessage(fromResource = "my-prompt-template.txt")
//    @SystemMessage("你是我的好朋友，请用东北话回答问题。今天是{{current_date}}")
    String chat(@MemoryId int memoryId, @UserMessage String userMessage);

    /**
     * 隔离聊天消息
     * 如果有多个参数，且没有使用@UserMessage，则必须显式用@V来绑定参数。
     * 如果只有一个参数，则可以不指定，使用默认的it即可。
     *
     * @param memoryId    聊天id
     * @param userMessage 用户消息
     * @return
     */
    @UserMessage("你是我的好朋友，请用粤语回答我的问题哦。{{message}}")
    String chat2(@MemoryId int memoryId, @V("message") String userMessage);

    /**
     * @param memoryId    聊天id
     * @param userMessage 用户消息，直接参与对话流程。用于构建与大模型交互的UserMessage对象。
     * @param username    模板绑定参数，用于替换提示词模板中的{{userName}}
     * @param age         模板绑定参数，用于替换提示词模板中的{{age}}
     * @return
     */
    @SystemMessage(fromResource = "my-prompt-template2.txt")
    String chat3(@MemoryId int memoryId,
                 @UserMessage String userMessage,
                 @V("username") String username,
                 @V("age") int age);
}
