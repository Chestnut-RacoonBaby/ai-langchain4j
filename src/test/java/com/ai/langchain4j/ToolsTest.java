package com.ai.langchain4j;

import com.ai.langchain4j.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Function Calling函数，也叫tools工具
 *
 * @author: qiaohaojie
 * @date: 2025-07-22 22:18:51
 */
@SpringBootTest
public class ToolsTest {

    @Autowired
    private SeparateChatAssistant separateChatAssistant;

    @Test
    public void testCalculatorTools() {
        String answer = separateChatAssistant.chat(9, "请帮我计算2+2等于几，顺便计算一下2334343的平方根是多少？");
        System.out.println(answer);

        String answer2 = separateChatAssistant.chat(11, "请帮我计算2*2等于几？");
        System.out.println(answer2);
    }
}
