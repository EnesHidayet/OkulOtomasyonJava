package com.enes.service;

import com.enes.entity.BaseEntity;
import com.enes.entity.Ebeveyn;
import com.enes.entity.enums.State;
import com.enes.repository.EbeveynRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EbeveynService {
    private final EbeveynRepository ebeveynRepository;

    public void save(Ebeveyn ebeveyn){
        ebeveyn.setBaseEntity(BaseEntity.builder()
                .state(State.Aktif)
                .createAt(System.currentTimeMillis())
                .updateAt(System.currentTimeMillis())
                .build());
        ebeveynRepository.save(ebeveyn);
    }
    public List<Ebeveyn> findAll (){
        return ebeveynRepository.findAll();
    }
}
