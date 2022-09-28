package org.wesejong.mapper;

import java.util.List;

import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.TableVO;

public interface TableManageMapper {
	
	public List<String> getTableList();
	
	public List<TableVO> descTable(TableVO tablevo);
	
}
