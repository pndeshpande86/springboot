package com.ss.saga.recordsmanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ss.saga.general.logic.base.AbstractComponentFacade;
import com.ss.saga.recordsmanagement.dataaccess.api.DailyRecordsEntity;
import com.ss.saga.recordsmanagement.dataaccess.api.dao.DailyRecordsDao;
import com.ss.saga.recordsmanagement.logic.api.Recordsmanagement;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsCto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsEto;
import com.ss.saga.recordsmanagement.logic.api.to.DailyRecordsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.common.api.to.PaginationResultTo;

/**
 * Implementation of component interface of recordsmanagement
 */
@Named
@Transactional
public class RecordsmanagementImpl extends AbstractComponentFacade implements Recordsmanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(RecordsmanagementImpl.class);

  /**
   * @see #getDailyRecordsDao()
   */
  @Inject
  private DailyRecordsDao dailyRecordsDao;

  /**
   * The constructor.
   */
  public RecordsmanagementImpl() {

    super();
  }

  @Override
  public DailyRecordsEto findDailyRecords(Long id) {

    LOG.debug("Get DailyRecords with id {} from database.", id);
    return getBeanMapper().map(getDailyRecordsDao().findOne(id), DailyRecordsEto.class);
  }

  @Override
  public PaginatedListTo<DailyRecordsEto> findDailyRecordsEtos(DailyRecordsSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<DailyRecordsEntity> dailyrecordss = getDailyRecordsDao().findDailyRecordss(criteria);
    return mapPaginatedEntityList(dailyrecordss, DailyRecordsEto.class);
  }

  @Override
  public boolean deleteDailyRecords(Long dailyRecordsId) {

    DailyRecordsEntity dailyRecords = getDailyRecordsDao().find(dailyRecordsId);
    getDailyRecordsDao().delete(dailyRecords);
    LOG.debug("The dailyRecords with id '{}' has been deleted.", dailyRecordsId);
    return true;
  }

  @Override
  public DailyRecordsEto saveDailyRecords(DailyRecordsEto dailyRecords) {

    Objects.requireNonNull(dailyRecords, "dailyRecords");
    DailyRecordsEntity dailyRecordsEntity = getBeanMapper().map(dailyRecords, DailyRecordsEntity.class);

    // initialize, validate dailyRecordsEntity here if necessary
    DailyRecordsEntity resultEntity = getDailyRecordsDao().save(dailyRecordsEntity);
    LOG.debug("DailyRecords with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, DailyRecordsEto.class);
  }

  /**
   * Returns the field 'dailyRecordsDao'.
   *
   * @return the {@link DailyRecordsDao} instance.
   */
  public DailyRecordsDao getDailyRecordsDao() {

    return this.dailyRecordsDao;
  }

  @Override
  public DailyRecordsCto findDailyRecordsCto(Long id) {

    LOG.debug("Get DailyRecordsCto with id {} from database.", id);
    DailyRecordsEntity entity = getDailyRecordsDao().findOne(id);
    DailyRecordsCto cto = new DailyRecordsCto();
    cto.setDailyRecords(getBeanMapper().map(entity, DailyRecordsEto.class));

    return cto;
  }

  @Override
  public PaginatedListTo<DailyRecordsCto> findDailyRecordsCtos(DailyRecordsSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<DailyRecordsEntity> dailyrecordss = getDailyRecordsDao().findDailyRecordss(criteria);
    List<DailyRecordsCto> ctos = new ArrayList<>();
    for (DailyRecordsEntity entity : dailyrecordss.getResult()) {
      DailyRecordsCto cto = new DailyRecordsCto();
      cto.setDailyRecords(getBeanMapper().map(entity, DailyRecordsEto.class));
      ctos.add(cto);

    }
    PaginationResultTo pagResultTo = new PaginationResultTo(criteria.getPagination(), (long) ctos.size());
    PaginatedListTo<DailyRecordsCto> pagListTo = new PaginatedListTo(ctos, pagResultTo);
    return pagListTo;
  }

}
