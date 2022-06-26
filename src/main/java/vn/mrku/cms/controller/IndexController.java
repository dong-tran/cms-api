package vn.mrku.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok("OK");
    }
}
