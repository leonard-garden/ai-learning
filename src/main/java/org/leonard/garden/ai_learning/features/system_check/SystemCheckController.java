package org.leonard.garden.ai_learning.features.system_check;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SystemCheckController {
    private final SystemCheckService systemCheckService;

    @PostMapping("/api/v1/system-check")
    @ResponseStatus(HttpStatus.OK)
    public SystemCheckResponse callSystemCheck(@RequestBody SystemCheckRequest request) {
        return systemCheckService.execute(request);
    }
}
