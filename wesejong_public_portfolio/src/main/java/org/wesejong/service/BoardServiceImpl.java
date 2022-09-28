package org.wesejong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.wesejong.domain.BoardAttachImageVO;
import org.wesejong.domain.BoardDisLikeVO;
import org.wesejong.domain.BoardLikeVO;
import org.wesejong.domain.BoardManageVO;
import org.wesejong.domain.BoardReplyVO;
import org.wesejong.domain.BoardVO;
import org.wesejong.domain.Criteria;
import org.wesejong.domain.MemberVO;
import org.wesejong.mapper.BoardAttachImageMapper;
import org.wesejong.mapper.BoardDisLikeMapper;
import org.wesejong.mapper.BoardLikeMapper;
import org.wesejong.mapper.BoardManageMapper;
import org.wesejong.mapper.BoardMapper;
import org.wesejong.mapper.BoardReplyMapper;
import org.wesejong.security.domain.CustomUser;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_=@Autowired)
	private BoardMapper boardmapper;

	@Setter(onMethod_=@Autowired)
	private BoardManageMapper boardmanagemapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardAttachImageMapper boardattachimagemapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardReplyMapper boardreplymapper;

	@Setter(onMethod_=@Autowired)
	private BoardLikeMapper boardlikemapper;

	@Setter(onMethod_=@Autowired)
	private BoardDisLikeMapper boarddislikemapper;
	
	@Override
	public void register_without_boardattachimage(BoardVO boardvo) {
		// TODO Auto-generated method stub
		log.info("register...."+boardvo);
		boardmapper.insertSelectKey(boardvo);
	}
	
	
	@Override
	public void register_with_boardattachimage(BoardVO boardvo) {
		// TODO Auto-generated method stub
		log.info("register...."+boardvo);
		
		boardmapper.insertSelectKey(boardvo);
		
		BoardAttachImageVO boardattachimagevo = new BoardAttachImageVO();
		//img_prefix:스캐닝 과정중에 <img 태그를 찾기 위한 과정입니다.
		//img_suffix:스캐닝 과정중에 <img_prefix가 나온 이후에 다음 "를 찾기 위한 변수입니다.
		//style_css:스캐닝 과정중에 img_prefix가 돌면서 outofarray에러가 나올까봐
	    //img태그 맨 마지막의 부분은 필요가 없으니 빼줍니다.

		String img_prefix="<img alt=\"\" src=";
		String img_suffix="\"";
		String style_css =" style=\"height:198px; width:496px\" ";
		String boardvo_content=boardvo.getContent();
		String compare="";
		
		//img_prefix_end_position === <img alt=\"\" src= 에서 마지막 위치를 뜻합니다.
		int img_prefix_end_position=0;
		
		
//		boardattachimage_url : URL입니다.
//		start_quotes_position : 따음표 시작지점 position 변수
//		end_quotes_position : 따음표 종료지점 position 변수
		String boardattachimage_url="";
		int start_quotes_position = 0;
		int end_quotes_position =0;
		
//		start_uuid_position : uuid 시작지점 position 변수
//		end_uuid_position : uuid 종료지점 position 변수
		String boardattachimage_uuid="";
		int start_uuid_position =0;
		int end_uuid_position = 0;
		
//		start_uploadpath_position : uuid 시작지점 position 변수
//		start_uploadpath_position : uuid 종료지점 position 변수
		String boardattachimage_uploadpath="";
		int start_uploadpath_position =0;
		int end_uploadpath_position = 0;		
		
		for(int i=0;i<boardvo_content.length()-style_css.length();i++) {
			compare="";
			for(int j=i;j<i+img_prefix.length();j++) {
				compare+=boardvo_content.charAt(j);
				if(j==i+img_prefix.length()-1) img_prefix_end_position = j;
			}
			
//			boardvo_content === img_prefix
//			compare:<img alt="" src=
//			img_prefix_end_position:23
//			=
//			형태로 나오는데 보니깐 공백은 charAt으로 포함안합니다.
			if(compare.equals(img_prefix)) {
				System.out.println("boardvo_content === img_prefix");
				System.out.println("compare:"+compare);
				System.out.println("img_prefix_end_position:"+img_prefix_end_position);
				System.out.println(boardvo_content.charAt(img_prefix_end_position));
				
				start_quotes_position = img_prefix_end_position+1;
				end_quotes_position = 0;
				
				for(int j=start_quotes_position+1;j<boardvo_content.length();j++) {
					if(boardvo_content.charAt(j) == '"') {
						end_quotes_position = j;
						break;
					}
				}
				
//				boardattachimage_url:/ckupload/2021/08/16/89687916-7f63-4161-a761-f455a00b4006_notice.PNG
				boardattachimage_url = boardvo_content.substring(start_quotes_position+1, end_quotes_position);
				System.out.println("boardattachimage_url:"+boardattachimage_url);
				
				
				start_uuid_position = 0;
				end_uuid_position = boardattachimage_url.length();
				
				
//				boardattachimage_uuid:89687916-7f63-4161-a761-f455a00b4006_notice.PNG
//				로 나오는데 
//				uuid는 파일이름과 같은것
				for(int j=boardattachimage_url.length()-1;j>=0;j--) {
					if(boardattachimage_url.charAt(j)=='/') {
						start_uuid_position = j+1;
						
						System.out.println("boardattachimage_uuid:"+boardattachimage_url.substring(start_uuid_position, end_uuid_position));
						boardattachimage_uuid = boardattachimage_url.substring(start_uuid_position, end_uuid_position);
						
						
//						boardattachimage_uploadpath:/ckupload/2021/08/16
//						reference책 확인결과 마지막에 슬래쉬는 제거되어있습니다.
						start_uploadpath_position = 0;
						end_uploadpath_position = j;
						System.out.println("boardattachimage_uploadpath:"+boardattachimage_url.substring(start_uploadpath_position, end_uploadpath_position));
						boardattachimage_uploadpath = boardattachimage_url.substring(start_uploadpath_position, end_uploadpath_position);

						
//						| boardattachimage_seq | boardattachimage_uploadPath | boardattachimage_uuid                           | bno |
//						+----------------------+-----------------------------+-------------------------------------------------+-----+
//						|                    1 | /ckupload/2021/08/16        | 89687916-7f63-4161-a761-f455a00b4006_notice.PNG | 230 |
//						+----------------------+-----------------------------+-------------------------------------------------+-----+
						boardattachimagevo.setBoardattachimage_uploadpath(boardattachimage_uploadpath);
						boardattachimagevo.setBoardattachimage_uuid(boardattachimage_uuid);
						boardattachimagevo.setBno(boardvo.getBno());
						boardattachimagemapper.insertSelectKey(boardattachimagevo);
						break;
					}
				}
				
				
			}
			
		}
//<img alt="" src="/ckupload/2021/08/16/89687916-7f63-4161-a761-f455a00b4006_notice.PNG" style="height:198px; width:496px" />
//		<img alt="" src="
	}
	
	@Override
	public void register_with_boardmanage_boardattachimage(BoardManageVO boardmanagevo, BoardVO boardvo, Authentication authentication) {
		// TODO Auto-generated method stub
		
		MemberVO membervo = new MemberVO();
		membervo.setMem_nickname("test");
		membervo.setMem_seq((long) 36);
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			membervo = customuser.getMember();			
		}

				
		log.info("register...."+boardvo);
		boardvo.setMem_seq(membervo.getMem_seq());
		boardvo.setWriter(membervo.getMem_nickname());		
		if(boardvo.getAnonymous() == null) {
			boardvo.setAnonymous((long) 0);
		}
		boardmapper.insertSelectKey_with_boardmanage(boardmanagevo, boardvo);
//			<selectKey keyProperty="meetmatchteam_seq" order="BEFORE" resultType="long">
//				select max(meetmatchteam_seq) from meetmatchteam
//			</selectKey> 를 통해서 boardvo에 자동으로 입력됩니다.
		log.info("register...."+boardvo);
		System.out.println(boardvo);
		System.out.println("lastinsertid:"+boardvo.getBno());
//		카페24에서는 boardvo.setBno(boardvo.getBno()+1)) 로 할시 에러가나와서 아래방식으로 해보겠습니다.
		Long boardvobnovariable = boardvo.getBno()+1;
		boardvo.setBno(boardvobnovariable);
		BoardAttachImageVO boardattachimagevo = new BoardAttachImageVO();
		//img_prefix:스캐닝 과정중에 <img 태그를 찾기 위한 과정입니다.
		//img_suffix:스캐닝 과정중에 <img_prefix가 나온 이후에 다음 "를 찾기 위한 변수입니다.
		//style_css:스캐닝 과정중에 img_prefix가 돌면서 outofarray에러가 나올까봐
	    //img태그 맨 마지막의 부분은 필요가 없으니 빼줍니다.

//		<img alt="" src="/ckupload/2021/12/18/353e9c2b-5f85-406d-8c1f-a6212bd5084b_notice.PNG" />
//		이전에 img alt=''이런식으로 진행했지만, alt값에 값이 들어갈시 에러 발생가능
//		String img_prefix="<img alt=\"\" src="; 
		String img_prefix="<img";
		String style_css =" style=\"height:198px; width:496px\" ";
		String boardvo_content=boardvo.getContent();
		String compare="";
		
		String src_prefix="src=\"";
		String src_compare="";
		
		//img_prefix_end_position === <img alt=\"\" src= 에서 마지막 위치를 뜻합니다.
		int img_prefix_start_position=0;
		int img_prefix_end_position=0;
		
		int src_prefix_start_position=0;
		int src_prefix_end_position=0;
		
		
//		boardattachimage_url : URL입니다.
//		start_quotes_position : 따음표 시작지점 position 변수
//		end_quotes_position : 따음표 종료지점 position 변수
		String boardattachimage_url="";
		int start_quotes_position = 0;
		int end_quotes_position =0;
		
//		start_uuid_position : uuid 시작지점 position 변수
		String boardattachimage_uuid="";
		int start_uuid_position =0;
		int end_uuid_position = 0;
		
//		start_uploadpath_position : uuid 시작지점 position 변수
//		start_uploadpath_position : uuid 종료지점 position 변수
		String boardattachimage_uploadpath="";
		int start_uploadpath_position =0;
		int end_uploadpath_position = 0;		
		
//		String str = "ABCDEFG"; //대상 문자열
//		A=0 B=1 C=2 D=3 E=4 F=5 G=6의 index를 가진다.
//		str.substring(3, 6); 
//		substring(시작위치,끝위치) 결과값 = DEF
//		abcdefg
//		0123456
//		
//		def
//		
//		abcd
//		substring(0,4);
		
		for(int i=0;i<boardvo_content.length()-img_prefix.length()-1;i++) {
			compare="";
			
			img_prefix_start_position = i;
			img_prefix_end_position = i+img_prefix.length();			
			compare = boardvo_content.substring(img_prefix_start_position,img_prefix_end_position);
			
//			여기까지 '<img' 를 찾아내는 과정입니다. 
			
//			for(int j=i;j<i+img_prefix.length();j++) {
//				compare+=boardvo_content.charAt(j);
//				if(j==i+img_prefix.length()-1) img_prefix_end_position = j;
//			}
			
//			boardvo_content === img_prefix
//			compare:<img
//			compare:<img alt="" src=
//			img_prefix_end_position:23
//			=
//			형태로 나오는데 보니깐 공백은 charAt으로 포함안합니다.
//			img_prefix == <img
			if(compare.equals(img_prefix)) {
				System.out.println("img_prefix_start_position:"+img_prefix_start_position);
				System.out.println("img_prefix_end_position:"+img_prefix_end_position);
				System.out.println(boardvo_content.charAt(img_prefix_end_position));
//				<img alt="" src="/ckupload/2021/12/18/4b28d1ce-0683-4e3a-8303-66ce06d8392f_notice.PNG" />
												
//				src_prefix = src="
				for(int j=img_prefix_end_position;j<boardvo_content.length()-src_prefix.length()-1;j++) {
					src_compare = "";
					src_prefix_start_position = j;
					src_prefix_end_position = j + src_prefix.length();
					src_compare = boardvo_content.substring(src_prefix_start_position,src_prefix_end_position);

					if(src_compare.equals(src_prefix)) {
						start_quotes_position = src_prefix_end_position;
						end_quotes_position = 0;
						
						for(int k=start_quotes_position+1;k<boardvo_content.length();k++) {
							if(boardvo_content.charAt(k) == '"') {
								end_quotes_position = k;
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}
				
//		boardattachimage_url:/ckupload/2021/08/16/89687916-7f63-4161-a761-f455a00b4006_notice.PNG
		boardattachimage_url = boardvo_content.substring(start_quotes_position, end_quotes_position);
		System.out.println("boardattachimage_url:"+boardattachimage_url);
		
		
		start_uuid_position = 0;
		end_uuid_position = boardattachimage_url.length();
		
		
//		boardattachimage_uuid:89687916-7f63-4161-a761-f455a00b4006_notice.PNG
//		로 나오는데 
//		uuid는 파일이름과 같은것
		for(int j=boardattachimage_url.length()-1;j>=0;j--) {
			if(boardattachimage_url.charAt(j)=='/') {
				start_uuid_position = j+1;
				
				System.out.println("boardattachimage_uuid:"+boardattachimage_url.substring(start_uuid_position, end_uuid_position));
				boardattachimage_uuid = boardattachimage_url.substring(start_uuid_position, end_uuid_position);
				
				
//				boardattachimage_uploadpath:/ckupload/2021/08/16
//				reference책 확인결과 마지막에 슬래쉬는 제거되어있습니다.
				start_uploadpath_position = 0;
				end_uploadpath_position = j;
				System.out.println("boardattachimage_uploadpath:"+boardattachimage_url.substring(start_uploadpath_position, end_uploadpath_position));
				boardattachimage_uploadpath = boardattachimage_url.substring(start_uploadpath_position, end_uploadpath_position);

				
//				| boardattachimage_seq | boardattachimage_uploadPath | boardattachimage_uuid                           | bno |
//				+----------------------+-----------------------------+-------------------------------------------------+-----+
//				|                    1 | /ckupload/2021/08/16        | 89687916-7f63-4161-a761-f455a00b4006_notice.PNG | 230 |
//				+----------------------+-----------------------------+-------------------------------------------------+-----+
				boardattachimagevo.setBoardattachimage_uploadpath(boardattachimage_uploadpath);
				boardattachimagevo.setBoardattachimage_uuid(boardattachimage_uuid);
				
				log.info(boardattachimagevo);
				boardattachimagemapper.insertSelectKey_with_boardmanage(boardattachimagevo, boardvo);
				break;
			}
		}
//<img alt="" src="/ckupload/2021/08/16/89687916-7f63-4161-a761-f455a00b4006_notice.PNG" style="height:198px; width:496px" />
//		<img alt="" src="
	}
	
	public void modify_with_boardmanage_boardattachimage(BoardManageVO boardmanagevo, BoardVO boardvo, Authentication authentication) {
		// TODO Auto-generated method stub
		boardattachimagemapper.delete_by_bno(boardvo);
		MemberVO membervo = new MemberVO();
		if(authentication != null) {
			CustomUser customuser = (CustomUser) authentication.getPrincipal();
			membervo = customuser.getMember();			
		}
		membervo.setMem_nickname(membervo.getMem_nickname());
		membervo.setMem_seq(membervo.getMem_seq());
				
		log.info("register...."+boardvo);
		boardvo.setMem_seq(membervo.getMem_seq());
		boardvo.setWriter(membervo.getMem_nickname());		
		if(boardvo.getAnonymous() == null) {
			boardvo.setAnonymous((long) 0);
		}
		boardmapper.update_title_content_updatedate(boardvo);
//			<selectKey keyProperty="meetmatchteam_seq" order="BEFORE" resultType="long">
//				select max(meetmatchteam_seq) from meetmatchteam
//			</selectKey> 를 통해서 boardvo에 자동으로 입력됩니다.
		log.info("modify...."+boardvo);
		System.out.println(boardvo);
		System.out.println("lastinsertid:"+boardvo.getBno());
//		카페24에서는 boardvo.setBno(boardvo.getBno()+1)) 로 할시 에러가나와서 아래방식으로 해보겠습니다.
		BoardAttachImageVO boardattachimagevo = new BoardAttachImageVO();
		//img_prefix:스캐닝 과정중에 <img 태그를 찾기 위한 과정입니다.
		//img_suffix:스캐닝 과정중에 <img_prefix가 나온 이후에 다음 "를 찾기 위한 변수입니다.
		//style_css:스캐닝 과정중에 img_prefix가 돌면서 outofarray에러가 나올까봐
	    //img태그 맨 마지막의 부분은 필요가 없으니 빼줍니다.

//		<img alt="" src="/ckupload/2021/12/18/353e9c2b-5f85-406d-8c1f-a6212bd5084b_notice.PNG" />
//		이전에 img alt=''이런식으로 진행했지만, alt값에 값이 들어갈시 에러 발생가능
//		String img_prefix="<img alt=\"\" src="; 
		String img_prefix="<img";
		String style_css =" style=\"height:198px; width:496px\" ";
		String boardvo_content=boardvo.getContent();
		String compare="";
		
		String src_prefix="src=\"";
		String src_compare="";
		
		//img_prefix_end_position === <img alt=\"\" src= 에서 마지막 위치를 뜻합니다.
		int img_prefix_start_position=0;
		int img_prefix_end_position=0;
		
		int src_prefix_start_position=0;
		int src_prefix_end_position=0;
		
		
//		boardattachimage_url : URL입니다.
//		start_quotes_position : 따음표 시작지점 position 변수
//		end_quotes_position : 따음표 종료지점 position 변수
		String boardattachimage_url="";
		int start_quotes_position = 0;
		int end_quotes_position =0;
		
//		start_uuid_position : uuid 시작지점 position 변수
		String boardattachimage_uuid="";
		int start_uuid_position =0;
		int end_uuid_position = 0;
		
//		start_uploadpath_position : uuid 시작지점 position 변수
//		start_uploadpath_position : uuid 종료지점 position 변수
		String boardattachimage_uploadpath="";
		int start_uploadpath_position =0;
		int end_uploadpath_position = 0;		
		
//		String str = "ABCDEFG"; //대상 문자열
//		A=0 B=1 C=2 D=3 E=4 F=5 G=6의 index를 가진다.
//		str.substring(3, 6); 
//		substring(시작위치,끝위치) 결과값 = DEF
//		abcdefg
//		0123456
//		
//		def
//		
//		abcd
//		substring(0,4);
		
		for(int i=0;i<boardvo_content.length()-img_prefix.length()-1;i++) {
			compare="";
			
			img_prefix_start_position = i;
			img_prefix_end_position = i+img_prefix.length();			
			compare = boardvo_content.substring(img_prefix_start_position,img_prefix_end_position);
			
//			여기까지 '<img' 를 찾아내는 과정입니다. 
			
//			for(int j=i;j<i+img_prefix.length();j++) {
//				compare+=boardvo_content.charAt(j);
//				if(j==i+img_prefix.length()-1) img_prefix_end_position = j;
//			}
			
//			boardvo_content === img_prefix
//			compare:<img
//			compare:<img alt="" src=
//			img_prefix_end_position:23
//			=
//			형태로 나오는데 보니깐 공백은 charAt으로 포함안합니다.
//			img_prefix == <img
			if(compare.equals(img_prefix)) {
				System.out.println("img_prefix_start_position:"+img_prefix_start_position);
				System.out.println("img_prefix_end_position:"+img_prefix_end_position);
				System.out.println(boardvo_content.charAt(img_prefix_end_position));
//				<img alt="" src="/ckupload/2021/12/18/4b28d1ce-0683-4e3a-8303-66ce06d8392f_notice.PNG" />
												
//				src_prefix = src="
				for(int j=img_prefix_end_position;j<boardvo_content.length()-src_prefix.length()-1;j++) {
					src_compare = "";
					src_prefix_start_position = j;
					src_prefix_end_position = j + src_prefix.length();
					src_compare = boardvo_content.substring(src_prefix_start_position,src_prefix_end_position);

					if(src_compare.equals(src_prefix)) {
						start_quotes_position = src_prefix_end_position;
						end_quotes_position = 0;
						
						for(int k=start_quotes_position+1;k<boardvo_content.length();k++) {
							if(boardvo_content.charAt(k) == '"') {
								end_quotes_position = k;
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}
				
//		boardattachimage_url:/ckupload/2021/08/16/89687916-7f63-4161-a761-f455a00b4006_notice.PNG
		boardattachimage_url = boardvo_content.substring(start_quotes_position, end_quotes_position);
		System.out.println("boardattachimage_url:"+boardattachimage_url);
		
		
		start_uuid_position = 0;
		end_uuid_position = boardattachimage_url.length();
		
		
//		boardattachimage_uuid:89687916-7f63-4161-a761-f455a00b4006_notice.PNG
//		로 나오는데 
//		uuid는 파일이름과 같은것
		for(int j=boardattachimage_url.length()-1;j>=0;j--) {
			if(boardattachimage_url.charAt(j)=='/') {
				start_uuid_position = j+1;
				
				System.out.println("boardattachimage_uuid:"+boardattachimage_url.substring(start_uuid_position, end_uuid_position));
				boardattachimage_uuid = boardattachimage_url.substring(start_uuid_position, end_uuid_position);
				
				
//				boardattachimage_uploadpath:/ckupload/2021/08/16
//				reference책 확인결과 마지막에 슬래쉬는 제거되어있습니다.
				start_uploadpath_position = 0;
				end_uploadpath_position = j;
				System.out.println("boardattachimage_uploadpath:"+boardattachimage_url.substring(start_uploadpath_position, end_uploadpath_position));
				boardattachimage_uploadpath = boardattachimage_url.substring(start_uploadpath_position, end_uploadpath_position);

				
//				| boardattachimage_seq | boardattachimage_uploadPath | boardattachimage_uuid                           | bno |
//				+----------------------+-----------------------------+-------------------------------------------------+-----+
//				|                    1 | /ckupload/2021/08/16        | 89687916-7f63-4161-a761-f455a00b4006_notice.PNG | 230 |
//				+----------------------+-----------------------------+-------------------------------------------------+-----+
				boardattachimagevo.setBoardattachimage_uploadpath(boardattachimage_uploadpath);
				boardattachimagevo.setBoardattachimage_uuid(boardattachimage_uuid);
				
				log.info(boardattachimagevo);
				boardattachimagemapper.insertSelectKey_with_boardmanage(boardattachimagevo, boardvo);
				break;
			}
		}
//<img alt="" src="/ckupload/2021/08/16/89687916-7f63-4161-a761-f455a00b4006_notice.PNG" style="height:198px; width:496px" />
//		<img alt="" src="		
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		
		log.info("get......"+bno);
		return boardmapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO boardvo) {
		// TODO Auto-generated method stub
		log.info("modify......"+boardvo);
		return boardmapper.update(boardvo) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove......"+bno);
		return boardmapper.delete(bno) == 1;
	}
	
	@Override
	public boolean remove_by_bno(BoardVO boardvo) {
		// TODO Auto-generated method stub
		log.info("remove......"+boardvo);
		return boardmapper.delete_by_bno(boardvo) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList...........");
		
		return boardmapper.getList();
	}
	
	@Override
	public List<BoardVO> getList_by_bno_limit_0_5(Long board_id) {
		// TODO Auto-generated method stub
		return boardmapper.getList_by_bno_limit_0_5(board_id);
	}
	
	@Override
	public List<BoardVO> getList_by_bno_and_boardlikecount_bigger_than_ten_limit_0_5(Long board_id) {
		// TODO Auto-generated method stub
		return boardmapper.getList_by_bno_and_boardlikecount_bigger_than_ten_limit_0_5(board_id);
	}
	
	@Override
	public List<BoardVO> getList_by_bno_limit_0_5_get_allpost() {
		// TODO Auto-generated method stub
		return boardmapper.getList_by_bno_limit_0_5_get_allpost();
	}


	
	@Override
	public List<BoardVO> getList_without_boardattachimage(Criteria cri){
		log.info("get List with Criteria:"+ cri);
		
		cri.setFirst((cri.getPageNum()-1)*cri.getAmount());
		cri.setSecond((cri.getPageNum())*cri.getAmount());
		
		System.out.println(cri.getAmount());
		System.out.println(cri.getFirst());
		System.out.println(cri.getSecond());
		return boardmapper.getListWithPaging_without_boardattachimage(cri);
	}

	@Override
	public List<BoardVO> getList_with_boardattachimage(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get List with Criteria:"+ cri);
		
		cri.setFirst((cri.getPageNum()-1)*cri.getAmount());
		cri.setSecond((cri.getPageNum())*cri.getAmount());
		System.out.println(cri.getAmount());
		System.out.println(cri.getFirst());
		System.out.println(cri.getSecond());
		return boardmapper.getListWithPaging_with_boardattachimage(cri);		
	}
	
	@Override
	public List<BoardVO> getList_with_boardmanage_boardattachimage(BoardManageVO boardmanagevo, Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get List with Criteria:"+ cri);
		
		cri.setFirst((cri.getPageNum()-1)*cri.getAmount());
		cri.setSecond((cri.getPageNum())*cri.getAmount());
//		System.out.println(boardmanagevo.getBoard_id());
//		System.out.println(cri);
//		System.out.println(cri.getTypeArr());
//		System.out.println(cri.getAmount());
//		System.out.println(cri.getFirst());
//		System.out.println(cri.getSecond());
		return boardmapper.getListWithPaging_with_boardmanage_boardattachimage(boardmanagevo, cri);		
	}
	
	@Override
	public List<BoardVO> getList_with_boardmanage_boardattachimage_by_bno_and_boardlikecount_bigger_than_ten(
			BoardManageVO boardmanagevo, Criteria cri) {
		// TODO Auto-generated method stub
		cri.setFirst((cri.getPageNum()-1)*cri.getAmount());
		cri.setSecond((cri.getPageNum())*cri.getAmount());
		return boardmapper.getListWithPaging_with_boardmanage_boardattachimage_by_bno_and_boardlikecount_bigger_than_ten(boardmanagevo, cri);	
	}

	@Override
	public List<BoardVO> getList_with_boardmanage_boardattachimage_get_allpost(BoardManageVO boardmanagevo,
			Criteria cri) {
		// TODO Auto-generated method stub
		cri.setFirst((cri.getPageNum()-1)*cri.getAmount());
		cri.setSecond((cri.getPageNum())*cri.getAmount());
		return boardmapper.getListWithPaging_with_boardmanage_boardattachimage_get_allpost(boardmanagevo, cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return boardmapper.getTotalCount(cri);
	}
	
	@Override
	public int getTotalCount_with_boardmanage(BoardManageVO boardmanagevo, Criteria cri) {
		log.info("getTotalCount_with_boardmanage");
		return boardmapper.getTotalCount_with_boardmanage(boardmanagevo, cri);
	}

	@Override
	public int getTotalCount_with_boardmanage_by_bno_and_boardlikecount_bigger_than_ten(BoardManageVO boardmanagevo,
			Criteria cri) {
		// TODO Auto-generated method stub
		return boardmapper.getTotalCount_with_boardmanage_by_bno_and_boardlikecount_bigger_than_ten(boardmanagevo, cri);
	}


	@Override
	public int getTotalCount_with_boardmanage_boardattachimage_get_allpost(BoardManageVO boardmanagevo, Criteria cri) {
		// TODO Auto-generated method stub
		return boardmapper.getTotalCount_with_boardmanage_boardattachimage_get_allpost(boardmanagevo, cri);
	}
	
	
//	리스트로 boardmanagevo를 받아온뒤 , board_id만 getCount_by_board_id_andreg 이 함수를 돌려서
//	각 값마다 
	@Override
	public int getExists_by_board_id_and_regdate_yesterday_to_today(BoardManageVO boardmanagevo) {
		// TODO Auto-generated method stub
		
		return boardmapper.getExists_by_board_id_and_regdate_yesterday_to_today(boardmanagevo.getBoard_id());
	}
	
	@Override
	public int getExists_by_board_id_and_regdate_yesterday_to_today_allpost() {
		// TODO Auto-generated method stub
		
		return boardmapper.getExists_by_board_id_and_regdate_yesterday_to_today_allpost();
	}


	@Override
	public void update_boardreply_count(BoardReplyVO boardreplyvo) {
		// TODO Auto-generated method stub
		Long totalreplycount_of_board = boardreplymapper.getTotalReplyCount_of_board_by_bno(boardreplyvo);
		BoardVO boardvo = new BoardVO();
		boardvo.setBno(boardreplyvo.getBno());
		boardvo.setBoardreply_count(totalreplycount_of_board);
		boardmapper.update_boardreply_count_by_bno(boardvo);
	}


	@Override
	public void update_boardlikecount(BoardLikeVO boardlikevo) {
		// TODO Auto-generated method stub
		Long totalboardlikecount_of_board = boardlikemapper.getTotalBoardLikeCount_of_post_by_bno(boardlikevo);
		BoardVO boardvo = new BoardVO();
		boardvo.setBno(boardlikevo.getBno());
		boardvo.setBoardlikecount(totalboardlikecount_of_board);
		boardmapper.update_boardlikecount_by_bno(boardvo);
	}
	
	@Override
	public void update_boarddislikecount(BoardDisLikeVO boarddislikevo) {
		// TODO Auto-generated method stub
		Long totalboarddislikecount_of_board = boarddislikemapper.getTotalBoardDisLikeCount_of_post_by_bno(boarddislikevo);
		BoardVO boardvo = new BoardVO();
		boardvo.setBno(boarddislikevo.getBno());
		boardvo.setBoarddislikecount(totalboarddislikecount_of_board);
		boardmapper.update_boarddislikecount_by_bno(boardvo);		
	}


	@Override
	public void update_boardviewcount(BoardVO boardvo) {
		// TODO Auto-generated method stub
		boardmapper.update_viewcount_by_bno(boardvo);
	}


/////////////////////
//AdminBoard용    //
/////////////////////

	@Override
	public List<BoardVO> AdminBoard_getList_limit_0_300() {
		// TODO Auto-generated method stub
		return boardmapper.getList_limit_0_300();
	}
	
	@Override
	public List<BoardVO> AdminBoard_getboardnoticeList_limit_0_300() {
		// TODO Auto-generated method stub
		return boardmapper.getboardnoticeList_limit_0_300();
	}


	@Override
	public boolean AdminBoard_modify_board_id_title_content_notice(BoardVO boardvo) {
		// TODO Auto-generated method stub
		return boardmapper.update_board_id_title_content_notice(boardvo) == 1;
	}


	

}
