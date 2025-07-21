package com.ai.langchain4j.bean;

import lombok.Data;

/**
 * @author: qiaohaojie
 * @date: 2025-07-21 22:39:10
 */
@Data
public class ChatForm {

    /**
     * 聊天记录id
     */
    private Long memoryId;
    /**
     * 用户问题
     */
    private String message;
}
