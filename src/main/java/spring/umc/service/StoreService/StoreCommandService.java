package spring.umc.service.StoreService;

import spring.umc.domain.Store;
import spring.umc.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store saveStore(StoreRequestDTO.storeDTO request);
}

