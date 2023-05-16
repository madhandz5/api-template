package com.app.domain.member.repository;

import com.app.domain.member.entity.Member;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {MemberRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.app.domain.member.entity"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    /**
     * Method under test: {@link MemberRepository#findByEmail(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFindByEmail() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint [null]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
        //       at com.sun.proxy.$Proxy135.save(null)
        //   org.hibernate.exception.ConstraintViolationException: could not execute statement
        //       at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:59)
        //       at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:37)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:113)
        //       at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:99)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:200)
        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3914)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:329)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:286)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:192)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:122)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
        //       at com.sun.proxy.$Proxy132.persist(null)
        //       at com.sun.proxy.$Proxy135.save(null)
        //   org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: NULL not allowed for column "EMAIL"; SQL statement:
        //   insert into member (member_id, created_at, modified_at, created_by, modified_by, email, member_name, member_type, password, profile, refresh_token, role, token_expiration_time) values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) [23502-214]
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:508)
        //       at org.h2.message.DbException.getJdbcSQLException(DbException.java:477)
        //       at org.h2.message.DbException.get(DbException.java:223)
        //       at org.h2.message.DbException.get(DbException.java:199)
        //       at org.h2.table.Column.validateConvertUpdateSequence(Column.java:365)
        //       at org.h2.table.Table.convertInsertRow(Table.java:926)
        //       at org.h2.command.dml.Insert.insertRows(Insert.java:167)
        //       at org.h2.command.dml.Insert.update(Insert.java:135)
        //       at org.h2.command.CommandContainer.executeUpdateWithGeneratedKeys(CommandContainer.java:242)
        //       at org.h2.command.CommandContainer.update(CommandContainer.java:163)
        //       at org.h2.command.Command.executeUpdate(Command.java:252)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdateInternal(JdbcPreparedStatement.java:209)
        //       at org.h2.jdbc.JdbcPreparedStatement.executeUpdate(JdbcPreparedStatement.java:169)
        //       at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:197)
        //       at org.hibernate.dialect.identity.GetGeneratedKeysDelegate.executeAndExtract(GetGeneratedKeysDelegate.java:58)
        //       at org.hibernate.id.insert.AbstractReturningDelegate.performInsert(AbstractReturningDelegate.java:43)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3279)
        //       at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3914)
        //       at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:84)
        //       at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:645)
        //       at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:282)
        //       at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:263)
        //       at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:317)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:329)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:286)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:192)
        //       at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:122)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:185)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:128)
        //       at org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)
        //       at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:107)
        //       at org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:756)
        //       at org.hibernate.internal.SessionImpl.persist(SessionImpl.java:742)
        //       at com.sun.proxy.$Proxy132.persist(null)
        //       at com.sun.proxy.$Proxy135.save(null)
        //   See https://diff.blue/R013 to resolve this issue.

        memberRepository.save(new Member());
        memberRepository.save(new Member());
        memberRepository.findByEmail("foo");
    }
}

