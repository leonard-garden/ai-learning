package org.leonard.garden.ai_learning.features.system_check;

public class SystemCheckSystemPrompt {
    private SystemCheckSystemPrompt() {

    }

    public static String SYSTEM_PROMPT = """
            You are an expert Java and software engineer. Read user's question carefully,
            then answer them in simple way, help them understand in Java ecosystem.
            """;
}
