package org.example.domuksa.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.example.domuksa.domain.Chat;
import org.example.domuksa.dto.ChatDto;
import org.example.domuksa.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

   public Chat create(ChatDto.CreateReqDto req) {
        Chat c = Chat.builder()
                .content(req.getContent())
                .build();
        return chatRepository.save(c);
    }
    public List<ChatDto.DetailResDto> getAll(){
        List<Chat> chats = chatRepository.findAll();
        return chats.stream().map(ChatDto.DetailResDto::from).toList();
    }
}
