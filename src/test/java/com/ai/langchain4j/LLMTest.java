package com.ai.langchain4j;

import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: qiaohaojie
 * @date: 2025-06-21 19:11:57
 */
@SpringBootTest
public class LLMTest {

    @Test
    public void testGPTDemo() {
        // 初始化模型，LangChain4j提供的代理服务器，该代理服务器会将演示密钥替换成真实密钥，再将请求转发给OpenAI API
        OpenAiChatModel model = OpenAiChatModel.builder()
                // LangChain4j提供的代理服务器，该代理服务器会将演示密钥替换成真实密钥，再将请求转发给OpenAI API
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                // 设置模型apiKey，只有gpt-4o-mini模型才有使用配额限制
                .apiKey("demo")
                // 设置模型名称
                .modelName("gpt-4o-mini")
                .build();
        // 向模型提问
        String answer = model.chat("你知道 彬彬有氧运动 这个博主吗？他运动的有效过吗？");
        // 输出结果
        System.out.println(answer);
    }
}
