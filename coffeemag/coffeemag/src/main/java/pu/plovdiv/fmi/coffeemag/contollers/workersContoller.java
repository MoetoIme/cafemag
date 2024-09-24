package pu.plovdiv.fmi.coffeemag.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pu.plovdiv.fmi.coffeemag.Entity.workers;
import pu.plovdiv.fmi.coffeemag.Service.workersService;

import java.util.List;

/**
 * Controller for managing customer-related operations.
 */
@RestController
@RequestMapping("/customers")
public class workersContoller {

    private final workersService WorkersService;
    @Autowired
    public workersContoller(workersService workersService) {
        WorkersService = workersService;
    }
    @GetMapping
    public List<workers> getAllWorkers() {
        return WorkersService.getAllWorkers();
    }
    @GetMapping("/{id}")
    public workers getWorkerById(@PathVariable Long id) {
        return WorkersService.getWorkerById(id);
    }
    @PostMapping
    public workers createWorker(@RequestBody workers workerEntity) {
        return WorkersService.createWorker(workerEntity);
    }
    @PutMapping("/{id}")
    public workers updateWorker(@PathVariable Long id, @RequestBody workers workerEntity) {
        return WorkersService.updateWorker(id, workerEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id) {
        WorkersService.deleteWorker(id);
    }
}

