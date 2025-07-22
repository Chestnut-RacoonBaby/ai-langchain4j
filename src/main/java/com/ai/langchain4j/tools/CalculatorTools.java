package com.ai.langchain4j.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import org.springframework.stereotype.Component;

/**
 * @author: qiaohaojie
 * @date: 2025-07-22 22:26:06
 */
@Component
public class CalculatorTools {

    /**
     * 加法运算
     * name：工具名称
     * value: 工具描述
     *
     * @param a a
     * @param b b
     * @return
     */
    @Tool(name = "加法运算", value = "将两个参数a和b相加并返回运算结果")
    double sum(double a, double b) {
        System.out.println("调用加法运算");
        return a + b;
    }

    @Tool(name = "平方根运算", value = "计算给定参数的平方根并返回结果")
    double squareRoot(double x) {
        System.out.println("调用平方根运算");
        return Math.sqrt(x);
    }

    /**
     * 乘法运算
     * @P 注解
     * value: 参数的描述
     * required: 参数是否必填
     *
     * @ToolMemoryId 注解：提供给AIService的方法memoryId也会进行传递
     *
     * @param memoryId memoryId
     * @param x        x
     * @param y        y
     * @return
     */
    @Tool(name = "乘法运算", value = "计算给定参数的乘积并返回结果")
    double mul(
            @ToolMemoryId int memoryId,
            @P(value = "乘数", required = true) int x,
            @P(value = "被乘数", required = true) int y) {
        System.out.println("调用乘法运算 memoryId=" + memoryId);
        return Math.multiplyExact(x, y);
    }
}
