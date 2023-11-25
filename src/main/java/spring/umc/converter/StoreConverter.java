package spring.umc.converter;

import spring.umc.domain.Review;
import spring.umc.domain.Store;
import spring.umc.web.dto.ReviewRequestDTO;
import spring.umc.web.dto.ReviewResponseDTO;
import spring.umc.web.dto.StoreRequestDTO;
import spring.umc.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.saveStoreResultDTO toSaveStoreResultDTO(Store store){
        return StoreResponseDTO.saveStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.storeDTO request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .info(request.getInfo())
                .rate(request.getRate())
                .build();
    }
}
