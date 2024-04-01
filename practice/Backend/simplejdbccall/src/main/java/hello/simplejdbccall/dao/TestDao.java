package hello.simplejdbccall.dao;

import hello.simplejdbccall.dto.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource datasource;

    public void printJobInfo1() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(datasource).withProcedureName("select_user_by_name").returningResultSet("Jobs", BeanPropertyRowMapper.newInstance(Job.class));
        Map<String, Object> param = new HashMap<>();
        param.put("username", "kim");

        Map<String, Object> result = jdbcCall.execute(param);
        List<Job> jobs = (List<Job>) result.get("Jobs");
        log.info("메소드 첫 번째꺼 {}", jobs.toString());

    }

    public void printJobInfo2() {
        //jdbcTemplate을 사용하면 데이터베이스와의 상호작용을 단순화하고, 코드를 간경하게 유지할 수 있도록 도와준다.
        //또한, 스프링 'JdbcTemplate'은 데이터베이스 연결 관리, 예오 처리 등을 자동으로 처리하여 개발자가 직접 처리할 필요가 없게 한다.
        //따라서, 대부분의 경우에 'jdbcTemplate'을 사용하는 것이 더 편리하고 안정적이라고 한다.
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("select_user_by_name").returningResultSet("Jobs", BeanPropertyRowMapper.newInstance(Job.class));
        Map<String, Object> param = new HashMap<>();
        param.put("username", "kim");

        Map<String, Object> result = jdbcCall.execute(param);
        List<Job> jobs = (List<Job>) result.get("Jobs");
        log.info("메소드 두 번째꺼 {}", jobs.toString());
    }
}
