package spring.umc.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc.apiPayload.code.status.ErrorStatus;
import spring.umc.apiPayload.exception.handler.ReviewHandler;
import spring.umc.repository.MissionRepository;
import spring.umc.repository.StoreRepository;
import spring.umc.converter.MissionConverter;
import spring.umc.domain.Mission;
import spring.umc.domain.Store;
import spring.umc.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    @Override
    @Transactional
    public Mission makeMission(MissionRequestDTO.makeMissionDTO request, Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new ReviewHandler(ErrorStatus._BAD_REQUEST));
        Mission newMission = MissionConverter.toMission(request, store);
        store.addMission(newMission);
        return missionRepository.save(newMission);
    }
}
