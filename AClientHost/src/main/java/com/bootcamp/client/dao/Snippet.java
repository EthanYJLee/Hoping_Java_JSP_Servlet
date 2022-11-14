package com.bootcamp.client.dao;

public class Snippet {
	case ("/wish_write.do"): //wish리스트에 등록
				command = new wish_write_Command();
			command.execute(request, response);
			  break; //위시리스트 등록
			  
			  
			  
			case ("/wish_delete.do")://wish리스트에서 삭제
				command = new wish_delete_Command();
			command.execute(request, response);
			break;//위시리스트 삭제
	
			
			case ("/count.do"): // 먼저 wish리스트에 해당 캠핑장이 등록되어 있는지 확인
				   command = new count_Command();
				  Boolean check = command.execute1(request, response);
				   
				  	//만약 wish리스트에 등록이 되어있지 않다면 check값이 false가 되어 등록이 됨
					if (check == false) {
						JOptionPane.showInternalMessageDialog(null, "위시리스트에 등록됐습니다.", "위시리스트", 0, null);
						viewPage = "wish_write.do";
					} else {//만ㅇ냑 wish리스트에 등록이 되어있으면 check값이 true가 되어 삭제가 됨
						JOptionPane.showInternalMessageDialog(null, "위시리스트에서 삭제되었습니다 ", "위시리스트", 0, null);
						viewPage = "wish_delete.do";
					}
					break;// 위시리스트에 있는지 없는지 확인 후 등록 or 삭제 결정
}

