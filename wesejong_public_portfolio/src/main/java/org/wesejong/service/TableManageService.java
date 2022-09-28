package org.wesejong.service;

import java.util.List;

import org.wesejong.domain.TableVO;

public interface TableManageService {

	public List<String> getTableList();
	
	public List<TableVO> descTable(TableVO tablevo);
	
}
