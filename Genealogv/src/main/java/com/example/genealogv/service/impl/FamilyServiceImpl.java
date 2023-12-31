package com.example.genealogv.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.genealogv.entity.Family;
import com.example.genealogv.mapper.FamilyMapper;
import com.example.genealogv.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl extends ServiceImpl<FamilyMapper,Family>implements FamilyService {

    @Autowired
    FamilyMapper familyMapper;

    @Override
    public Family getMaxId() {
        return familyMapper.getMaxId();
    }

    @Override
    public boolean delete(int familyId) {
        return familyMapper.delete(familyId);
    }

    @Override
    public Family getById(int familyId) {
        return familyMapper.getById(familyId);
    }
}
