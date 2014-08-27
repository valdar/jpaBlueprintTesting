package com.redhat.dao;

import java.sql.SQLException;

import com.redhat.model.TestModel;

public interface TestDAOService {

	public abstract void persistTestModel(TestModel tm) throws SQLException;

}