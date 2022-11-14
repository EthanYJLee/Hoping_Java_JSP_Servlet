<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
/* pc 화면 */
@media (min-width: 768px) {
    #kakao-talk-channel-chat-button {
    position: fixed;
    z-index: 999;
    right: 30px; /* 화면 오른쪽으로부터의 거리, 숫자만 변경 */
    bottom: 30px; /* 화면 아래쪽으로부터의 거리, 숫자만 변경 */
    }
}
/* 모바일 화면 */
@media (max-width:767px) {
    #kakao-talk-channel-chat-button {
    position: fixed;
    z-index: 999;
    right: 15px; /* 화면 오른쪽으로부터의 거리, 숫자만 변경 */
    bottom: 30px; /* 화면 아래쪽으로부터의 거리, 숫자만 변경 */
    }
}
</style>

	<!-- 
	2022-11-08 Hosik - 우측하단 카카오톡 1:1 채팅 DIV 추가 
		 11-11 Hosik - 강사님이 빼라고 하셔서 뺌 
	 -->
<!-- 	
<div id="kakao-talk-channel-chat-button"></div>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('8d20a512bea587bcc64da4d1d6a184b3');
    // 카카오톡 채널 1:1채팅 버튼을 생성합니다.
    Kakao.Channel.createChatButton({
      container: '#kakao-talk-channel-chat-button',
      channelPublicId: '_cxfgGxj' // 카카오톡 채널 홈 URL에 명시된 ID
    });
  //]]>
</script>
 -->

<!-- Start Footer -->
     <footer class="my-5 pt-5 text-muted text-center text-small album py-5 bg-light">
    <p class="mb-1">&copy; 2022–Team Bootcamp </p>
    <p>Hoping은 통신판매 중개자로서 통신판매의 당사자가 아니며 <br>
    고객지원을 제외한 상품의 예약, 이용 등과 관련한 의무와 책임 등 모든 거래에 대한 책임은 가맹점에게 있습니다.
    </p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="TermsHomepage.jsp">이용약관</a></li>
      <li class="list-inline-item"><a href="support.jsp">Support</a></li>
      <li class="list-inline-item"><a href="#">Contact Us</a></li>
    </ul>
  </footer>
    <!-- End Footer -->
    
    
    </html>