package spring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.umc.apiPayload.ApiResponse;
import spring.umc.converter.StoreConverter;
import spring.umc.domain.Store;
import spring.umc.service.StoreService.StoreCommandService;
import spring.umc.web.dto.StoreRequestDTO;
import spring.umc.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/store")
    public ApiResponse<StoreResponseDTO.saveStoreResultDTO> save(@RequestBody @Valid StoreRequestDTO.storeDTO request){
        Store store = storeCommandService.saveStore(request);
        return ApiResponse.onSuccess(StoreConverter.toSaveStoreResultDTO(store));
    }
}
