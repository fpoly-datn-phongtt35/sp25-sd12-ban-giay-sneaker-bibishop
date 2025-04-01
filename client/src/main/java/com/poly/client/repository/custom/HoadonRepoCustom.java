package com.poly.client.repository.custom;

import com.poly.client.dto.hoadonchitiet.HDCTSearchRequest;
import com.poly.client.dto.hoadonchitiet.HDCTSearchResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HoadonRepoCustom {
    List<HDCTSearchResponse> search(HDCTSearchRequest request, Pageable pageable);

    long countSearch(HDCTSearchRequest assignTaskSearchRequest);
}
