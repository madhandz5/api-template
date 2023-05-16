package com.app.domain.member.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.app.domain.member.entity.Member;
import com.app.domain.member.repository.MemberRepository;
import com.app.global.error.ErrorCode;
import com.app.global.error.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MemberService.class})
@ExtendWith(SpringExtension.class)
class MemberServiceTest {
    @MockBean
    private MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    /**
     * Method under test: {@link MemberService#registerMember(Member)}
     */
    @Test
    void testRegisterMember() {
        Member member = new Member();
        when(memberRepository.save(Mockito.<Member>any())).thenReturn(member);
        assertSame(member, memberService.registerMember(new Member()));
        verify(memberRepository).save(Mockito.<Member>any());
    }

    /**
     * Method under test: {@link MemberService#registerMember(Member)}
     */
    @Test
    void testRegisterMember2() {
        when(memberRepository.save(Mockito.<Member>any())).thenThrow(new BusinessException(ErrorCode.TOKEN_EXPIRED));
        assertThrows(BusinessException.class, () -> memberService.registerMember(new Member()));
        verify(memberRepository).save(Mockito.<Member>any());
    }
}

