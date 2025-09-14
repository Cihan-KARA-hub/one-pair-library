package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.penalty.*;
import org.springframework.data.domain.Page;

public interface PenaltyService {
    PenaltyCreateRes createPenalty(PenaltyCreateReq penalty);
    Page<PagePenaltyRes> getPenalties(int page, int size);
    DeletePenaltyRes deleteId(Integer id);
    PenaltyUpdateRes updatePenalty(PenaltyCreateReq penalty);
}
