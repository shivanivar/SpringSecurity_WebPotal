package com.cisco.dao;

import java.util.List;

import com.cisco.models.QualificationMaster;

public interface QualificationMasterDAO {
	public long addQualificationMaster(QualificationMaster p);

	public void updateQualificationMaster(QualificationMaster p);

	public List<QualificationMaster> listQualificationMaster();

	public QualificationMaster getQualificationMasterById(int id);

	public void removeQualificationMaster(int id);
}
