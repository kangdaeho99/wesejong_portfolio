package org.wesejong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wesejong.domain.BoardAttachImageVO;
import org.wesejong.domain.BoardVO;

public interface BoardAttachImageMapper {
	
	public void insert(BoardAttachImageVO boardattachimagevo);
	
	public void insertSelectKey(BoardAttachImageVO boardattachimagevo);
	
	public void insertSelectKey_with_boardmanage(@Param("boardattachimagevo") BoardAttachImageVO boardattachimagevo,@Param("boardvo") BoardVO boardvo);
	
	public int delete(String boardattachimage_uuid);
	
	public int delete_by_bno(BoardVO boardvo);

	public int update(BoardAttachImageVO boardattachimagevo);
	
	public List<BoardAttachImageVO> findByBno(Long bno);
	
}
