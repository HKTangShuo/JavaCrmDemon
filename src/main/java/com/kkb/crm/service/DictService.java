package com.kkb.crm.service;

import com.kkb.crm.pojo.CrmDict;

import java.util.List;

public interface DictService {
    List<CrmDict> selectDictByTypeCode(String code);
}
