package com.easyway.covid19.dao;

import com.easyway.covid19.model.Records;
import com.easyway.covid19.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordsDao {

    void addRecordDetails(Records records) throws Exception;

    void updateRecordDetails(Records records) throws Exception;

    List<Records> getRecordDetails(@Param("state") String state)throws Exception;

}
