package com.ai.langchain4j;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 大语言模型测试类
 *
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

    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Test
    public void testSpringBoot() {
//        String answer = openAiChatModel.chat("我是谁?");
//        System.out.println(answer);

//        String answer2 = chatLanguageModel.chat("我是谁?");
//        System.out.println(answer2);
    }


    /**
     * ollama
      */
    @Autowired
    private OllamaChatModel ollamaChatModel;

    @Test
    private void testOllama() {
        String answer = ollamaChatModel.chat("我是谁?");
        System.out.println(answer);
    }

    /**
     * 通义千问大模型
     */
    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    private void testDashScopeQwen() {
        // 向模型提问
        String answer = qwenChatModel.chat("你是谁?");
        System.out.println(answer);
    }

    @Test
    public void testTongyiWanxiang(){
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .modelName("wanx2.1-t2i-plus")
                .apiKey(System.getenv("BAILIAN_API_KEY"))
                .build();
        Response<Image> imageResponse = wanxImageModel.generate("一个笑脸的猫");
        // https://dashscope-result-wlcb-acdr-1.oss-cn-wulanchabu-acdr-1.aliyuncs.com/1d/b8/20250622/87e37dbe/e4ad2522-65a2-445b-a038-4f85ef3448352849665775.png?Expires=1750663399&OSSAccessKeyId=LTAI5tKPD3TMqf2Lna1fASuh&Signature=YDLEl%2FuQDifztR2cgZtJ7xKrOCY%3D
        System.out.println(imageResponse.content().url());
    }
}
