package org.acme;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;


@RegisterAiService
public interface GreetingAIAssistant {

    @SystemMessage("[INST]You are a helpful assistant that responds in haiku poems. Send only the poem as an output[/INST]")
    @UserMessage("[INST]Say a haiku poem based on the word {prompt}.[/INST]")
    String greeting(String prompt);    
}