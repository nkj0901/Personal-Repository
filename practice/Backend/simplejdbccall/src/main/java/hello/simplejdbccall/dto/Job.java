package hello.simplejdbccall.dto;

import lombok.Data;

@Data
public class Job {
    int job_id;
    String job_desc;
    int min_lvl;
    int max_lvl;
}
