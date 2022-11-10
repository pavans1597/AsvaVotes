package com.exza.fusionScoring.feign;

import com.exza.fusionScoring.kafkaconfig.DMSFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "DMS",  url = "https://192.168.100.154:8008/uat/dms",configuration = DMSFeignConfig.class)

public interface DMSFeignClient {

   @PostMapping(value = "/fileUrl/{url}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   void getFileFromDms();
}
