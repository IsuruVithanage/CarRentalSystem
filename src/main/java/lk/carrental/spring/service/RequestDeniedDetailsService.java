package lk.carrental.spring.service;

import lk.carrental.spring.dto.RequestDeniedDetailsDTO;

public interface RequestDeniedDetailsService {
    void saveDeniedReq(RequestDeniedDetailsDTO dto);
}
