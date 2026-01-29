package org.example.domuksa.controller;

import lombok.RequiredArgsConstructor;
import org.example.domuksa.domain.Chat;
import org.example.domuksa.dto.ChatDto;
import org.example.domuksa.service.ChatService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    private final SimpMessagingTemplate template;

    @PostMapping()
    public void create(@RequestBody ChatDto.CreateReqDto req) {

        Chat chat = chatService.create(req);

        ChatDto.DetailResDto res = ChatDto.DetailResDto.from(chat);

        template.convertAndSend("/topic/chat", res);
    }

    @GetMapping()
    public List<ChatDto.DetailResDto> getAll(){
        return chatService.getAll();
    }
}
