package com.ai.langchain4j;

import com.ai.langchain4j.assistant.Assistant;
import com.ai.langchain4j.assistant.MemoryChatAssistant;
import com.ai.langchain4j.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;


/**
 * @author: qiaohaojie
 * @date: 2025-07-13 15:36:13
 */
@SpringBootTest
public class ChatMemoryTest {

    @Autowired
    private Assistant assistant;

    /**
     * 这个聊天是无记忆的，每次会话都会被清空
     */
    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }


    @Autowired
    private QwenChatModel qwenChatModel;

    /**
     * 这个聊天是有记忆的，实现对话
     */
    @Test
    public void testChatMemory2() {
        // 第一轮对话
        UserMessage userMessage1 = UserMessage.userMessage("我是环环");
        ChatResponse chatResponse1 = qwenChatModel.chat(userMessage1);
        AiMessage aiMessage1 = chatResponse1.aiMessage();
        // 输出大语言模型的回复
        System.out.println(aiMessage1.text());

        // 第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("你知道我是谁吗");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage1, aiMessage1, userMessage2));
        AiMessage aiMessage2 = chatResponse2.aiMessage();
        // 输出大语言模型的回复
        System.out.println(aiMessage2.text());
    }

    @Test
    public void testChatMemory3() {
        // 创建一个消息窗口，最多保留10条对话信息
        MessageWindowChatMemory messageWindowChatMemory = MessageWindowChatMemory.withMaxMessages(10);

        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(messageWindowChatMemory)
                .build();

        String answer1 = assistant.chat("我是环环");
        // 你好，环环！很高兴见到你。有什么我可以帮助你的吗？
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁？");
        // 你是环环。如果你还有其他问题或需要进一步的帮助，请告诉我！
        System.out.println(answer2);
    }

    @Autowired
    private MemoryChatAssistant memoryChatAssistant;

    @Test
    public void testChatMemory4() {
        String answer1 = memoryChatAssistant.chat("我是环环");
        // 你好，环环！很高兴见到你。有什么我可以帮助你的吗？如果你有任何问题或需要讨论某些话题，随时告诉我哦。
        System.out.println(answer1);
        String answer2 = memoryChatAssistant.chat("我是谁");
        // 你是环环。有什么我可以帮你的吗？或者你想聊些什么？
        System.out.println(answer2);
    }

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testChatMemory5() {
        String answer1 = separateChatAssistant.chat(1, "我是环环");
        // 你好，环环！很高兴见到你。有什么我可以帮助你的吗？或者你想聊些什么呢？
        System.out.println(answer1);
        String answer2 = separateChatAssistant.chat(1, "我是谁");
        // 你刚刚告诉我，你是环环。如果你是在问更深层次的身份或角色信息，可以给我更多的背景或者你想了解的具体方面，我会尽力帮助你！
        System.out.println(answer2);
        String answer3 = separateChatAssistant.chat(2, "我是谁？");
        // 您好！您是在询问您的身份，但从您的问题中我无法直接得知您是谁。如果您是想通过这个问题了解自己，可能需要提供更多的信息或者换个角度提问。例如，您可以告诉我一些关于您的事情，比如兴趣爱好、工作或者是您想要了解的特定方面，这样我或许能够更好地帮助到您。如果这是一个哲学意义上的提问，那它就涉及到自我认知和个人身份的问题了，每个人对于“我是谁”都有不同的理解和答案。希望我的回答对您有所帮助！如果有更具体的内容想要探讨，请随时告诉我。
        System.out.println(answer3);
    }
}
