package com.poly.admin.service.impl;


import com.poly.admin.dto.ChatLieuDTO;
import com.poly.admin.entity.ChatLieuEntity;
import com.poly.admin.repository.impl.ChatLieuRepository;
import com.poly.admin.service.ChatLieuService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatLieuIMPL implements ChatLieuService {
    private final ChatLieuRepository chatLieuRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<ChatLieuDTO> getAllChatLieu() {
        List<ChatLieuEntity>chatLieuEntities = chatLieuRepository.findAll();
        return chatLieuEntities.stream()
                .map(entity -> modelMapper.map(entity, ChatLieuDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChatLieuDTO addChatLieu(ChatLieuDTO chatLieuDTO) {
        ChatLieuEntity chatLieu = ChatLieuEntity.builder()
                .ten(chatLieuDTO.getTen())
                .build();
        chatLieu.setCreateDate(LocalDate.now());
        chatLieu.setUpdateDate(LocalDateTime.now());
        chatLieuRepository.save(chatLieu);

        return modelMapper.map(chatLieu,ChatLieuDTO.class);
    }

    @Override
    public ChatLieuDTO updateChatLieu(ChatLieuDTO chatLieuDTO) {
        Optional<ChatLieuEntity> chatLieu = chatLieuRepository.findById(chatLieuDTO.getId());
        ChatLieuEntity chatLieu1 = new ChatLieuEntity();
        chatLieu1.setId(chatLieu.get().getId());
        chatLieu1.setTen(chatLieuDTO.getTen());
        chatLieu1.setCreateDate(LocalDate.now());
        chatLieu1.setUpdateDate(LocalDateTime.now());
        chatLieuRepository.save(chatLieu1);
        return modelMapper.map(chatLieu1,ChatLieuDTO.class);
    }
}
