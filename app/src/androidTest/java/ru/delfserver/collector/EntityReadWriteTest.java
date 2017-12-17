package ru.delfserver.collector;

import static org.junit.Assert.assertEquals;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.delfserver.collector.dao.ExportChanelDao;
import ru.delfserver.collector.dao.SmsFilterDao;
import ru.delfserver.collector.dao.SmsFilterDestinationDao;
import ru.delfserver.collector.entity.SmsFilter;

/**
 * Created by delf on 12/16/17.
 */

@RunWith(AndroidJUnit4.class)
public class EntityReadWriteTest {

  private ExportChanelDao exportChanelDao;
  private SmsFilterDao smsFilterDao;
  private SmsFilterDestinationDao smsFilterDestinationDao;
  private AppDatabase mDb;

  @Before
  public void initDb() {
    mDb = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
        AppDatabase.class).build();
    exportChanelDao = mDb.exportChanelDao();
    smsFilterDao = mDb.smsFilterDao();
    smsFilterDestinationDao = mDb.smsFilterDestinationDao();

  }

  @After
  public void closeDb() throws IOException {
    mDb.close();
  }

  @Test
  public void writeFiltersAndReadInList() throws Exception {
    List<SmsFilter> filterList = new LinkedList<>();
    for (int i = 0; i < 100; ++i) {
      filterList.add(
          new SmsFilter("simpleFromPattern" + i, "simpleToPattern" + i, "simpleTextPattern" + i,
              "simpleResultPattern" + i));
    }

    smsFilterDao.insertFilters(filterList);

    assertEquals(filterList.size(), smsFilterDao.getFilters().size());

  }
}
