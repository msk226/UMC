package spring.umc.web.dto;

import lombok.Getter;
import spring.umc.domain.Address;

public class StoreRequestDTO {

    @Getter
    public static class storeDTO{
        String name;
        Address address;
        String info;
        Float rate;

    }
}
