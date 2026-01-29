package org.example.domuksa.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.domuksa.domain.Chat;

import java.time.LocalDateTime;

public class ChatDto {
    @Getter
    public static class CreateReqDto {
        private String content;
    }

    @Getter
    @Builder
    public static class DetailResDto{
        private String content;

        public static ChatDto.DetailResDto from(Chat chat) {
            return builder()
                    .content(chat.getContent())
                    .build();
        }
    }
}
