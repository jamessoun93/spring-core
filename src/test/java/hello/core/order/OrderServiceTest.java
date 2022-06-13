package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "Tom", Grade.VIP);
        memberService.join(member);

        //when
        Order createdOrder = orderService.createOrder(memberId, "item A", 10000);

        //then
        Assertions.assertThat(createdOrder.getDiscountPrice()).isEqualTo(1000);
    }
}
