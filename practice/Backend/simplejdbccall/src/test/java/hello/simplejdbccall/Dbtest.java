package hello.simplejdbccall;

import hello.simplejdbccall.dao.TestDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class Dbtest {

    @Autowired
    DataSource dataSource;

    @Autowired
    TestDao testDao;

    @Test
    public void connection() throws SQLException {
        try (Connection connection = dataSource.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            log.info("URL : {}", metaData.getURL());
            log.info("DriverName : {}", metaData.getDriverName());
            log.info("UserName : {}", metaData.getUserName());
        }

        testDao.printJobInfo1();
        testDao.printJobInfo2();
    }
}
