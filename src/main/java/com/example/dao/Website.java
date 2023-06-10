package com.example.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Website {
    private UUID id;
    private String website_name;
    URL url;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime download_start_date_time;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime download_end_date_time;
    private Long  total_elapsed_time;
    private Long  total_downloaded_kilobytes;
}
