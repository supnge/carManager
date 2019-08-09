
import com.carManager.domain.TAdmin;
import com.carManager.service.TAdminService;
import com.carManager.service.impl.TAdminServiceImpl;
import org.junit.Test;

import java.sql.SQLException;

public class TAdminTest {
    @Test
    public void adminTest() throws SQLException {
        TAdminService tAdminService = new TAdminServiceImpl();
        TAdmin tAdmin = tAdminService.findAdminByConditions("admin", "admin", "chaoji");
        System.out.println(tAdmin.getUsername());
    }
}
