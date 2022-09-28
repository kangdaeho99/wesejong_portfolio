package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesejong.domain.TableVO;
import org.wesejong.mapper.TableManageMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class TableManageServiceImpl implements TableManageService{
	
	@Setter(onMethod_=@Autowired)
	private TableManageMapper tablemanagemapper;

	@Override
	public List<String> getTableList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		return tablemanagemapper.getTableList();
	}

	@Override
	public List<TableVO> descTable(TableVO tablevo) {
		// TODO Auto-generated method stub
		log.info("descTable....."+tablevo);
		return tablemanagemapper.descTable(tablevo);		
	}

}
