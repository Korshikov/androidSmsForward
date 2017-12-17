package ru.delfserver.collector.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;
import ru.delfserver.collector.entity.SmsFilter;

/**
 * Created by delf on 12/16/17.
 */

@Dao
public interface SmsFilterDao {

  @Query("SELECT * FROM SmsFilter")
  List<SmsFilter> getFilters();

  @Query("SELECT * FROM SmsFilter WHERE id = :id")
  List<SmsFilter> getFilterById(final int id);

  @Insert
  void insertFilters(SmsFilter... filters);

  @Insert
  void insertFilters(List<SmsFilter> filterList);

  @Update
  void updateFilters(SmsFilter... filters);

  @Delete
  void deleteFilters(SmsFilter... filters);

}
