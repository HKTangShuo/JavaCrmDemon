package com.kkb.crm.service.impl;

import com.kkb.crm.dao.CrmDictMapper;
import com.kkb.crm.pojo.CrmDict;
import com.kkb.crm.pojo.CrmDictExample;
import com.kkb.crm.service.DictService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private CrmDictMapper mapper;

    @Override
    public List<CrmDict> selectDictByTypeCode(String code) {
        CrmDictExample dictExample = new CrmDictExample();
        CrmDictExample.Criteria criteria = dictExample.createCriteria();
        criteria.andDictTypeCodeEqualTo(code);
        return mapper.selectByExample(dictExample);
    }
}
