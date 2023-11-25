package spring.umc.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc.repository.StoreRepository;
import spring.umc.converter.StoreConverter;
import spring.umc.domain.Store;
import spring.umc.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService{
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public Store saveStore(StoreRequestDTO.storeDTO request) {
        Store newStore = StoreConverter.toStore(request);
        return storeRepository.save(newStore);
    }
}
