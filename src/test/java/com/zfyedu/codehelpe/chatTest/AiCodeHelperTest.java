package com.zfyedu.codehelpe.chatTest;

import com.zfyedu.codehelpe.service.AiCodeHelper;
import com.zfyedu.codehelpe.service.AiCodeHelperService;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiCodeHelperTest {

    @Resource
    private AiCodeHelper aiCodeHelper;

    @Resource
    AiCodeHelperService aiCodeHelperService;

    @Test
    void chat() {
        aiCodeHelper.chat("你好，我是程序员张");
    }

    @Test
    void chatWithMessage() {
        UserMessage userMessage = UserMessage.from(TextContent.from("描述图片"),
                    ImageContent.from("https://cn.bing.com/images/search?q=%e8%a1%a8%e6%83%85%e5%8c%85&id=4CC361B0B914DF2077C2F2FC4C2843E02066B663&FORM=IACFIR"));
        aiCodeHelper.chatWithMessage(userMessage);
    }

    @Test
    void chat2() {
        String chat = aiCodeHelperService.chat("你好，我是程序员张");
        System.out.println(chat);
    }
    @Test
    void chatWithMemory() {
        String result = aiCodeHelperService.chat("你好，我是程序员张");
        System.out.println(result+"===========");
        result = aiCodeHelperService.chat("你好，我是谁来着？");
        System.out.println(result);
    }

}
