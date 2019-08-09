import com.carManager.dao.TSijiDao;
import com.carManager.dao.impl.TSijiDaoImpl;
import com.carManager.domain.TSiji;
import org.junit.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertTest
{
    @Test
    public void insertDriver() throws SQLException {
        TSijiDaoImpl tSijiDao = new TSijiDaoImpl();

        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        TSiji tSiji = new TSiji(null, "测试", "女", "26", "18009782345",
                "上海世界中心", "897887799767","5779789","1");

        tSiji.setInsertDate(sp.format(new Date()));

        tSiji.setUpdateDate(sp.format(new Date()));

        tSijiDao.insertDriver(tSiji);
    }
}
