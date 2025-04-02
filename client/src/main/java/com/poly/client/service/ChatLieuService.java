package com.poly.client.service;


import com.poly.client.dto.ChatLieuDTO;
import com.poly.client.entity.ChatLieuEntity;
import com.poly.client.repository.ChatLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuService {

    @Autowired
    ChatLieuRepository chatLieuRepository;

    public List<ChatLieuDTO> getAllChatLieu() {
        List<ChatLieuEntity> chatLieuEntities = chatLieuRepository.findAll();
        return chatLieuEntities.stream().map(x -> {
            ChatLieuDTO dto = new ChatLieuDTO();
            dto.setId(x.getId());
            dto.setTen(x.getTen());
            dto.setTrangThai(x.getTrangThai());
            return dto;
        }).toList();
    }

}
