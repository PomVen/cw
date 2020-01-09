package com.hallth.utils;

import com.hallth.domain.OaSeq;
import com.hallth.mapper.OaSeqMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SeqUtils {
    @Resource
    private OaSeqMapper seqMapper;

    public int getNextId(String seqType){
        int nextId = seqMapper.getNextId(seqType);
        OaSeq record = new OaSeq(nextId+1, seqType);
        seqMapper.updateSeq(record);
        return nextId;
    }
}
